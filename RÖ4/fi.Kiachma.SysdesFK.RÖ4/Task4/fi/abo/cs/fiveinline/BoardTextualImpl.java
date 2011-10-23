// -*- java -*-
package fi.abo.cs.fiveinline;

public class BoardTextualImpl implements Board {
	StringBuffer marks;
	int width;
	int height;
	BoardDisplay boarddisplay = new BoardDisplayTextualImpl();
	char has_won;

	public BoardTextualImpl(int w, int h) {
		width = w;
		height = h;
		marks = new StringBuffer();
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				marks.append(" ");
			}
		}
		has_won = ' ';
	}

	/* (non-Javadoc)
	 * @see fi.abo.cs.fiveinline.Board#getWidth()
	 */
	@Override
	public int getWidth() {
		return width;
	}

	/* (non-Javadoc)
	 * @see fi.abo.cs.fiveinline.Board#getHeight()
	 */
	@Override
	public int getHeight() {
		return height;
	}

	/* (non-Javadoc)
	 * @see fi.abo.cs.fiveinline.Board#boardWonBy()
	 */
	@Override
	public char boardWonBy() {
		return has_won;
	}

	/* (non-Javadoc)
	 * @see fi.abo.cs.fiveinline.Board#is_valid_move(int, int, char)
	 */
	@Override
	public boolean is_valid_move(int x, int y, char type) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return false;
		}
		if (is_set(x, y) != ' ') {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see fi.abo.cs.fiveinline.Board#is_set(int, int)
	 */
	@Override
	public char is_set(int x, int y) {
		assert x >= 0;
		assert y >= 0;
		assert x < width;
		assert y < height;
		int idx = y * width + x;
		return marks.charAt(idx);
	}

	/* (non-Javadoc)
	 * @see fi.abo.cs.fiveinline.Board#set(int, int, char)
	 */
	@Override
	public void set(int x, int y, char type) {
		char old = is_set(x, y);
		if (old != ' ') {
			throw new RuntimeException("Location is already reserved.");
		}
		if (type != 'X' && type != 'O') {
			throw new RuntimeException("Invalid type.");
		}

		int idx = y * width + x;
		marks.setCharAt(idx, type);

		checkForVictory(x, y);
	}

	/* (non-Javadoc)
	 * @see fi.abo.cs.fiveinline.Board#displayBoard()
	 */
	@Override
	public void displayBoard() {
		boarddisplay.DisplayBoard(this);
		/*// Clear screen
		System.out.print((char)27 + "[2J");

		System.out.print("--------------------\n");
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				char c = is_set(x, y);
				System.out.print(c);
			}
			System.out.print("\n");
		}
		System.out.print("--------------------\n\n\n");*/
	}

	private char checkOne(int startx,
			      int starty,
			      int dx,
			      int dy) {
		final int MARKS = 5;
		if (startx < 0) return ' ';
		if (starty < 0) return ' ';
		if (startx >= width) return ' ';
		if (starty >= height) return ' ';

		if (startx + dx * (MARKS-1) < 0) return ' ';
		if (starty + dy * (MARKS-1) < 0) return ' ';
		if (startx + dx * (MARKS-1) >= width) return ' ';
		if (starty + dy * (MARKS-1) >= height) return ' ';

		char type = '-';
		int x = startx;
		int y = starty;
		for (int i = 0; i < MARKS; ++i) {
			char t = is_set(x, y);
			if (type == '-') {
				type = t;
			} else {
				if (t != type) {
					return ' ';
				}
			}
			x += dx;
			y += dy;
		}
		assert type != '-';
		assert type != ' ';
		return type;
	}

	private void checkForVictory(int x, int y) {
		// Going right/down
		char victory;
		for (int i = -4; i <= 0; ++i) {
			victory = checkOne(x + i, y + i, 1, 1);
			if (victory != ' ') {
				has_won = victory;
			}
		}

		// Going right
		for (int i = -4; i <= 0; ++i) {
			victory = checkOne(x + i, y, 1, 0);
			if (victory != ' ') {
				has_won = victory;
			}
		}

		// Going right / up
		for (int i = -4; i <= 0; ++i) {
			victory = checkOne(x + i, y - i, 1, -1);
			if (victory != ' ') {
				has_won = victory;
			}
		}

		// Going down
		for (int i = -4; i <= 0; ++i) {
			victory = checkOne(x, y + i, 0, 1);
			if (victory != ' ') {
				has_won = victory;
			}
		}
	}
}
