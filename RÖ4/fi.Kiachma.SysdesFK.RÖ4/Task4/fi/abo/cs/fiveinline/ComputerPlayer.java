// -*- java -*-
package fi.abo.cs.fiveinline;

import java.util.Random;

public class ComputerPlayer implements Player {

	char type;
	private Move move;

	public ComputerPlayer(char t) {
		type = t;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Move move(ReadOnlyBoard b) {
		Random r = new Random();
		while (true) {
			int x = r.nextInt(b.getWidth());
			int y = r.nextInt(b.getHeight());
			if (b.is_set(x, y) == ' ') {
				move = new Move(x,y,type);
				return move;
			}
		}
	}

}