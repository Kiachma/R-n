package src;

public class MoveCommand extends AbstractCommand  {
	LadyBird l;
	int oldX,oldY,x,y;
	
	public MoveCommand(LadyBird l, int x, int y){
		l.setGoal(x, y);
		this.l=l;
		this.x =x;
		this.y=y;
	
	
	}
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		oldX=l.getX();
		oldY=l.getY();
		l.setGoal(x, y);
		l.setState(new TurnState());
	}
	@Override
	public void Unexecute() {
		// TODO Auto-generated method stub
		l.setGoal(oldX,oldY);	
		l.setState(new TurnState());
		
	}

}
