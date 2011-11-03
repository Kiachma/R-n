package src;

public class BiggerCommand extends AbstractCommand {
	LadyBird l;
	public BiggerCommand(LadyBird l) {
		this.l = l;
	}
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		l.setSize(l.getSize()+1);

	}

	@Override
	public void Unexecute() {
		// TODO Auto-generated method stub
		l.setSize(l.getSize()-1);

	}

}
