package gameActions;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class UserGame extends Control implements PlayerInterface {

	/*
	 * int deltaX int deltaY int movementVar
	 * 
	 * int playerX int playerY
	 * 
	 * boolean startGame boolean playing boolean endGame boolean nameEnter
	 * boolean highScores
	 */
	public UserGame() {
		// TODO Auto-generated constructor stub

		super();
	}
	

	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.CYAN);
		g.fillRect(20, 30, playerX, playerY);

	}
	
	public void moves() {

		playerX++;
		playerY++;

		super.repaint();

	}

	
	public void reset() {

		setup();

	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub

		playerX = 100;
		playerY = 100;

	}

}
