package gameActions;

import java.awt.Graphics;

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
