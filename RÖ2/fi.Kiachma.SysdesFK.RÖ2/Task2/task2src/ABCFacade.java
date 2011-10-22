package task2src;

import java.awt.Color;
import java.util.AbstractList;
import java.util.ArrayList;

// YOUR CODE HERE
// extends? implements?
public class ABCFacade implements Renderer {
    private ModuleA a;
    private ModuleB b;
    private ModuleC c;

    public ABCFacade() {
	a = new ModuleA();
	b = new ModuleB();
	c = new ModuleC();
	new Thread(a).start();
    }

	@Override
	public void putBackground() {
		a.drawBackground();
		
	}

	@Override
	public void putBody(AbstractList body) {
		b.drawSnake(body);
	}

	@Override
	public void setSnakeColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putBonus(AbstractList bonus) {
		c.putBonus((ArrayList)bonus);
		
	}

	@Override
	public void outside() {
		// TODO Auto-generated method stub
		
	}

    // YOUR CODE HERE
    // overwrite some methods that you inherit/implement
}
