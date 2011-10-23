package fi.abo.cs.fiveinline;

public class ReadOnlyBoard implements Board {
	Board b;
	public ReadOnlyBoard(Board b) {
		this.b=b;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return b.getWidth();
	}

	@Override
	public int getHeight() {
		return b.getHeight();
	}

	@Override
	public char boardWonBy() {
		// TODO Auto-generated method stub
		return b.boardWonBy();
	}

	@Override
	public boolean is_valid_move(int x, int y, char type) {
		// TODO Auto-generated method stub
		return b.is_valid_move(x, y, type);
	}

	@Override
	public char is_set(int x, int y) {
		// TODO Auto-generated method stub
		return b.is_set(x, y);
	}

	@Override
	public void set(int x, int y, char type) {
		// TODO Auto-generated method stub
		throw new RuntimeException("player tried to set the board.");

	}

	@Override
	public void displayBoard() {
		// TODO Auto-generated method stub
		b.displayBoard();

	}

}
