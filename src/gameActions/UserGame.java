package gameActions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Timer;

import utilityClasses.CenteredText;

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

		super();

	}

	public void draw(Graphics g) {

	}

	@Override
	public void drawPlaying(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(20, 30, playerX, playerY);

	}

	public void moves() {

		playerX += deltaX;
		playerY += deltaY;

		super.repaint();

	}

	public void reset() {

		setup();

	}

	@Override
	public void setup() {

		deltaX = 2;
		deltaY = 2;
		playerX = 100;
		playerY = 100;

	}

}
