package task2src;

import java.util.AbstractList;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Iterator;


class Graphics3DAdapter implements Renderer {
	Graphics3D graphics3d;
	Rectangle R;
	Box b;
	Color c;
	
	public Graphics3DAdapter (Graphics3D graphics3d) {
		this.graphics3d = graphics3d;
	}

	@Override
	public void putBackground() {
		graphics3d.printBase(Color.lightGray);
		
	}

	@Override
	public void putBody(AbstractList body) {
		Iterator iterator = body.iterator();
		while (iterator.hasNext()) {
		    R = (Rectangle)iterator.next();
		    b = new Box(R.x, R.y, R.width+R.x, R.height+R.y);
		    graphics3d.printBox(b, c);
		}
		
		
	}

	@Override
	public void setSnakeColor(Color color) {
		c=color;
		
	}

	@Override
	public void putBonus(AbstractList bonus) {
		Iterator iterator = bonus.iterator();
		while (iterator.hasNext()) {
		    R = (Rectangle)iterator.next();
		    b = new Box(R.x, R.y, R.width+R.x, R.height+R.y);
		    graphics3d.printBox(b, c);
		}
		
	}

	@Override
	public void outside() {
		// TODO Auto-generated method stub
		
	}
    // YOUR CODE HERE
    // overwrite some of the inherited/implemented methods
}
