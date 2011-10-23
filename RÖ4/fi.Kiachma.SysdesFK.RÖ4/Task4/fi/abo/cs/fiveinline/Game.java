package fi.abo.cs.fiveinline;

public class Game {
	private Board b;
	private Player p1,p2;
	private Move move;
	private ReadOnlyBoard RoB;
	public  Game(Board b, Player p1,Player p2){
		this.b=b;
		this.p1=p1;
		this.p2=p2;
		RoB = new ReadOnlyBoard(this.b);
	}
	public void playGame(){
		int marks = 0;
		while (b.boardWonBy() == ' ') {
			b.displayBoard();
			move = p1.move(RoB);
			b.set(move.getX(), move.getY(), move.getType());
			move = p2.move(RoB);
			b.set(move.getX(), move.getY(), move.getType());
			marks += 2;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.exit(2);
			}
			if (marks >= b.getWidth() * b.getHeight()) {
			}
		}
		b.displayBoard();
		if (b.boardWonBy() == ' ') {
			System.out.println("The game is a draw!");
		} else {
			System.out.println("The game was won by "
					   + b.boardWonBy()
					   + "!");
		}
	}
	
}
