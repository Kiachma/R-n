package src;

public class AddLadyBird extends AbstractCommand {
	private LadyBird ladyBird;
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		ladyBird = LadyBirdManager.instance().createLadyBird();

	}

	@Override
	public void Unexecute() {
		if (ladyBird!=null) {
			LadyBirdManager.instance().removeLadyBird(ladyBird);
		}

	}

}
