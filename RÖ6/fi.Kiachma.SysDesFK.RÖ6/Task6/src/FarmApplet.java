package src;
/*
 * Created on 2005-apr-26
 *
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JApplet;

/**
 * This is the class that present the farm of ladybird an to screen. It does double buffering and can bee used as an invoker. 
 * @author Peter Sunnergren
 */
public class FarmApplet extends JApplet implements MouseListener, KeyListener {

	private Vector commands;
	private Graphics offScreenGraphics;
	private Image offScreenImage;
	
	public void init() {
		this.setSize(400, 400);
		
		commands = new Vector();
				
		offScreenImage = createImage(getWidth(), getHeight());
		offScreenGraphics = offScreenImage.getGraphics();

		LadyBirdManager.setApplet(this);
		LadyBirdManager.instance().start();
		
		addMouseListener(this);
		addKeyListener(this);
		
		setFocusable(true);
		requestFocus();
	}
	
	/**
	 * Draws the farm.
	 * @param g Graphics.
	 */
	public void paint(Graphics g)
	{
		super.paint(offScreenGraphics);
		offScreenGraphics.setColor(new Color(189, 183, 107));
		offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());
		
		LadyBirdManager.instance().paint(offScreenGraphics);
		g.drawImage(offScreenImage, 0, 0, this);
	}
	
	private void addCommand(AbstractCommand c) {
		commands.add(c);
		c.Execute();
	}
	
	private void undoCommand() {
		if (!commands.isEmpty()) {
			((AbstractCommand)commands.lastElement()).Unexecute();
			commands.removeElement(commands.lastElement());
		}
	}
	
	/**
	 * If the mouse is clicked on a ladybird it marks it. If the mouse is not clicked on a ladybird but a ladybird is marked, it tells the marked ladybird to move to the clicked position.
	 * @param evt Contains the position of the mouse click.
	 */
	public void mousePressed(MouseEvent evt) {
		if (null == LadyBirdManager.instance().getMarkedLadyBird()) {
			LadyBirdManager.instance().markLadyBirdAt(evt.getX(), evt.getY());		
		} else {
			if (LadyBirdManager.instance().isLadyBirdAt(evt.getX(), evt.getY())) {
				LadyBirdManager.instance().markLadyBirdAt(evt.getX(), evt.getY());						
			} else {
				AbstractCommand move = new MoveCommand(LadyBirdManager.instance().getMarkedLadyBird(), evt.getX(), evt.getY());
				addCommand(move);
			}
		}
		repaint();
	}
	
	/**
	 * Creates commands depending on which key that was pressed.
	 * @param evt Contains the key that was pressed.
	 */
	public void keyPressed(KeyEvent evt) {
		if ('a' == evt.getKeyChar()) {
			/**
			 * Write code use the add another ladybird command here.
			 */
			AbstractCommand addBird= new AddLadyBird();
			addCommand(addBird);
		} else if ('r' == evt.getKeyChar()) {
			/**
			 * Write code to remove a ladybird here.
			 */
			if (LadyBirdManager.instance().getMarkedLadyBird() != null) {	
				AbstractCommand removebird = new RemoveLadyBird(LadyBirdManager.instance().getMarkedLadyBird());
				addCommand(removebird);
			} else {
				System.out.println("no bird selected");
			}
		} else if ('b' == evt.getKeyChar()) {
			/**
			 * Write code to use the commad to make the ladybirds bigger here..
			 */
			if (LadyBirdManager.instance().getMarkedLadyBird() != null) {	
				AbstractCommand biggerbird = new BiggerCommand(LadyBirdManager.instance().getMarkedLadyBird());
				addCommand(biggerbird);
			} else {
				System.out.println("no bird selected");
			}
		} else if ('s' == evt.getKeyChar()) {
			/**
			 * Write code to use the commad to make the ladybirds smaller here..
			 */
			if (LadyBirdManager.instance().getMarkedLadyBird() != null) {	
				AbstractCommand smallerbird = new SmallerCommand(LadyBirdManager.instance().getMarkedLadyBird());
				addCommand(smallerbird);
			} else {
				System.out.println("no bird selected");
			}
		} else if ('c' == evt.getKeyChar()) {
			/**
			 * Write code to change to colors of the ladybirds.
			 */
			if (LadyBirdManager.instance().getMarkedLadyBird() != null) {	
				AbstractCommand colorbird = new ChangeColorCommand(LadyBirdManager.instance().getMarkedLadyBird());
				addCommand(colorbird);
			} else {
				System.out.println("no bird selected");
			}
		} else if ('u' == evt.getKeyChar()) {
			undoCommand();
		}
		repaint();
	}
	
	/**
	 * Only exists to fill the KeyListener interface
	 */
	public void keyTyped(KeyEvent evt) { }
	
	/**
	 * Only exists to fill the KeyListener interface
	 */
	public void keyReleased(KeyEvent evt) {	}
	
	/**
	 * Only exists to fill the MouseListener interface
	 */
	public void mouseReleased(MouseEvent evt) { }

	/**
	 * Only exists to fill the MouseListener interface
	 */
	public void mouseClicked(MouseEvent evt) { }
	
	/**
	 * Only exists to fill the MouseListener interface
	 */
	public void mouseEntered(MouseEvent evt) { } 

	/**
	 * Only exists to fill the MouseListener interface
	 */
	public void mouseExited(MouseEvent evt) { }   	
}
