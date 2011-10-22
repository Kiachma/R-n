package task2src;

import java.util.AbstractList;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Rectangle;

// YOUR CODE HERE
// extends? implements?
class Decorator implements Renderer {
    private Renderer decorated;

    public Decorator(Renderer r) {
	decorated = r;
    }

    private void decorateRectangle(Rectangle r) {
	java.awt.Graphics g = GamePanel.getBuffer();
	g.drawLine(r.x + 2, r.y - 2, r.x + r.width + 2, r.y - 2);
	g.drawLine(r.x + r.width + 2, r.y - 2,
		   r.x + r.width + 2, r.y - 2 + r.height);
    }

	@Override
	public void putBackground() {
		// TODO Auto-generated method stub
		decorated.putBackground();
		
	}

	@Override
	public void putBody(AbstractList body) {
		Iterator iterator =body.iterator();
		while (iterator.hasNext()){
			decorated.putBody(body);
			decorateRectangle((Rectangle)iterator.next());
		}
		
	}

	@Override
	public void setSnakeColor(Color color) {
		decorated.setSnakeColor(color);
		
	}

	@Override
	public void putBonus(AbstractList bonus) {
		Iterator iterator = bonus.iterator();
		while (iterator.hasNext()){
			decorated.putBonus(bonus);
			decorateRectangle((Rectangle)iterator.next());
		}
		
	}

	@Override
	public void outside() {
		// TODO Auto-generated method stub
		
	}

    // YOUR CODE HERE
    // overwrite some of the inherited/implemented methods
}
