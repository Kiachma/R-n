// -*- java -*-
package fi.abo.cs.fiveinline;

public class HumanPlayer implements Player {

	private char type;
	private Move move;

	public HumanPlayer(char t) {
		this.type = t;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Move move(ReadOnlyBoard b) {
		int x = 0;
		int y = 0;
		// input for move
		if (b.is_set(x, y) == ' ') {
			move = new Move(x, y, type);
			return move;
		} else {
			//tryagain, for now just stop program
			System.exit(0);
		}
		return move;

	}

}
