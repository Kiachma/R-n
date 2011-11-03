package src;

import java.awt.Color;

public class ChangeColorCommand extends AbstractCommand {
	LadyBird l;
	Color oldBaseC,oldDotC;
	Color c;
	public ChangeColorCommand(LadyBird l) {
		this.l = l;
	}
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		oldBaseC=l.getColor();
		oldDotC=l.getDotColor();
		
		l.setColors(Color.black, Color.red);
	}

	@Override
	public void Unexecute() {
		// TODO Auto-generated method stub
		l.setColors(oldBaseC, oldDotC);

	}

}
