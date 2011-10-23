package fi.abo.cs.fiveinline;

public class Move {
	private int x,y;
	private char type;
	public Move(int x, int y, char type) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.type=type;
		
		
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public char getType() {
		return type;
	}

}
