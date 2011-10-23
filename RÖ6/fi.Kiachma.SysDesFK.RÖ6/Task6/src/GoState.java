package src;

public class GoState extends AbstractState {

	@Override
	public void nextAction(LadyBird l) {
		while(!l.go()){
			l.go();
		}
		l.setState(new StandState());
	}

}
