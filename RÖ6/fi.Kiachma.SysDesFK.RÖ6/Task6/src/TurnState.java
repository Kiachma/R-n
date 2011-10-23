package src;

public class TurnState extends AbstractState {

	@Override
	public void nextAction(LadyBird l) {
		while(!l.turn()){
			l.turn();
		}
		l.setState(new GoState());

	}

}
