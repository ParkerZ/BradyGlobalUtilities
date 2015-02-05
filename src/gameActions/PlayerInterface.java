package gameActions;

import java.awt.Graphics;
/**
 * Methods that UserGame needs to have, the draw methods are in control, so only need of you want a custom
 * screen
 * 
 * @author Brady
 *
 */
public interface PlayerInterface {

	public void moves();
	public boolean checkIfDead();
	public void reset();
	public void draw(Graphics g);
	public void setup();
	
	public void drawStart(Graphics g);
	public void drawPlaying(Graphics g);
	public void drawEnd(Graphics g);
	
}
