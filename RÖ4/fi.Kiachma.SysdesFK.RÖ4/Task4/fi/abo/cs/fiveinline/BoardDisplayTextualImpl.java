package fi.abo.cs.fiveinline;

public class BoardDisplayTextualImpl implements BoardDisplay {

	@Override
	public void DisplayBoard(Board b) {
		int height = b.getHeight();
		int width = b.getWidth();

		System.out.print((char) 27 + "[2J");

		System.out.print("--------------------\n");
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				char c = b.is_set(x, y);
				System.out.print(c);
			}
			System.out.print("\n");
		}
		System.out.print("--------------------\n\n\n");

	}

}


