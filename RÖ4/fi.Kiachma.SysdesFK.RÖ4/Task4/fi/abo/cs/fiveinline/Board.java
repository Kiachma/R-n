package fi.abo.cs.fiveinline;

public interface Board {

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract char boardWonBy();

	public abstract boolean is_valid_move(int x, int y, char type);

	public abstract char is_set(int x, int y);

	public abstract void set(int x, int y, char type);

	public abstract void displayBoard();

}