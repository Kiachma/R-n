package src;

public class RemoveLadyBird extends AbstractCommand {
	private LadyBird l;
	
	public RemoveLadyBird(LadyBird l) {
		this.l = l;
	}
	@Override
	public void Execute() {
		if (l != null) {	//checks that the bird exists
			LadyBirdManager.instance().removeLadyBird(l);
		}
	}

	@Override
	public void Unexecute() {	//puts the bird back
		LadyBirdManager.instance().addLadyBird(l);
	}
}
