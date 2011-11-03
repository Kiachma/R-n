package src;

public class SmallerCommand extends AbstractCommand {
	LadyBird l;
	public SmallerCommand(LadyBird l) {
		this.l = l;
	}
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		l.setSize(l.getSize()-1);

	}

	@Override
	public void Unexecute() {
		// TODO Auto-generated method stub
		l.setSize(l.getSize()+1);

	}

}
