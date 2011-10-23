// -*- java -*-
package fi.abo.cs.fiveinline;

import fi.abo.cs.fiveinline.*;

public class NoSpringMain {
	public static void main(String[] args) {
		
		Board b = new BoardTextualImpl(20, 10);

		Player p1 = new ComputerPlayer('X');
		Player p2 = new ComputerPlayer('O');
		
		
		Game game = new Game(b,p1,p2);
		game.playGame();
	}
}