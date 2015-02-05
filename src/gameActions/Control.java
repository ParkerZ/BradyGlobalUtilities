package gameActions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import utilityClasses.*;
import gameFolder.*;

public class Control extends JPanel implements Screen {

	/**
	 * When start screen is showing
	 * Paint checks this variable for whether or not draw the start screen
	 */
	public boolean startGame = true;
	/**
	 * When game is being played
	 * Paint checks this variable for whether or not draw playing field
	 */
	public boolean playing = false;
	/**
	 * When game is paused
	 * Paint checks this variable for whether or not draw the pause screen
	 */
	public boolean paused = false;
	/**
	 * When end screen is showing
	 * Paint checks this variable for whether or not draw the game over screen
	 */
	public boolean endGame = false;
	/**
	 * When entering name screen is showing
	 * Paint checks this variable for whether or not draw the enter name screen
	 */
	public boolean nameEnter = false;
	/**
	 * When high scores are listed on screen
	 * Paint checks this variable for whether or not draw the high score screen
	 */
	public boolean highScores = false;

	/**
	 * The value for the upKey
	 * This can be changed to suit the user of player
	 * 
	 */
	public int upKey = KeyEvent.VK_UP;
	/**
	 * The value for the downKey
	 * This can be changed to suit the user of player
	 * 
	 */
	public int downKey = KeyEvent.VK_DOWN;
	/**
	 * The value for the leftKey
	 * This can be changed to suit the user of player
	 * 
	 */
	public int leftKey = KeyEvent.VK_LEFT;
	/**
	 * The value for the rightKey
	 * This can be changed to suit the user of player
	 * 
	 */
	public int rightKey = KeyEvent.VK_RIGHT;

	public boolean upPressed = false;
	public boolean downPressed = false;
	public boolean leftPressed = false;
	public boolean rightPressed = false;

	/**
	 * keyMap - modify this to change key locations
	 * Gets modified when on the start screen and keys are pressed
	 * Assigned in order of when pressed
	 * then the key are mapped when the game starts
	 */
	public int[] keyMap = { KeyEvent.VK_UP, KeyEvent.VK_RIGHT,
			KeyEvent.VK_DOWN, KeyEvent.VK_LEFT };

	public int keyIndex = 0;

	/**
	 * The value that deltaX and deltaY will change player position by
	 */
	public int movementVar = 10;
	/**
	 * How much a player moves in the x direction
	 */
	public int deltaX = movementVar;
	/**
	 * How much a player moves in the y direction
	 */
	public int deltaY = 0;
	public String pName;

	/**
	 * player x position
	 */
	public int playerX;
	/**
	 * player y position
	 */
	public int playerY;

	public Timer timer;
	public int origSpeed = movementVar;
	public double speed = origSpeed;

	public int score;
	public Character letter;

	public double startTime;
	public double totalTime = 0;

	public UserGame sub = (UserGame) this;

	public Control() {

		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);

		sub.setup();

		timer = new Timer((int) (1000 / speed), this);
		// reset();
		timer.start();

	}

	public void setBackgroundColor(Color c) {

		this.setBackground(c);

	}

	/**
	 * can be called to set the direction keys if they have been modified
	 * and sets the keyMap when the game starts
	 */
	public void setKeys() {

		upKey = keyMap[0];
		rightKey = keyMap[1];
		downKey = keyMap[2];
		leftKey = keyMap[3];

	}

	/**
	 * This paintComponent checks which state the game is in using the startGame, endGame, etc.
	 * to know what to paint. Attempts to call methods in the UserGame class, which override methods in this class
	 * so that is the user has not defined a custom method, a default one is drawn
	 * 
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		sub.draw(g);

		if (startGame) {

			sub.drawStart(g);

		} else if (playing || paused) {

			sub.drawPlaying(g);

			if (paused) {

				sub.drawPaused(g);

			}

		} else if (endGame) {

			drawEnd(g);

		} else if (nameEnter) {

			ScoreInfo.enterName(g, score, pName);

		} else if (highScores) {

			ScoreInfo.drawScores(g, GameInfo.TXT_FILE);

		}

	}
	/**
	 * Draws the start screen.
	 * gets game name from Window class
	 * 
	 * @param g
	 */
	public void drawStart(Graphics g) {

		g.setColor(Color.WHITE);
		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.TITLE_SIZE));
		CenteredText.draw(GameInfo.NAME, Window.TITLE_Y, g);
		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.ENTER_TO_START_SIZE));

		CenteredText.draw("Press Enter to", Window.ENTER_Y, g);
		CenteredText.draw("Start", Window.START_Y, g);

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, 12));

		CenteredText.draw("Press keys Up, Right, Down, Left to map new keys",
				30, g);

	}
	/**
	 * Draws the screen when playing
	 * 
	 * @param g
	 */

	public void drawPlaying(Graphics g) {

		g.setColor(Color.CYAN);
		g.fillRect(20, 30, playerX, playerY);

	}

	/**
	 * draws the word "Paused" in the middle of the screen
	 * @param g
	 */
	public void drawPaused(Graphics g) {

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.PAUSE_SIZE));
		g.setColor(Color.WHITE);
		CenteredText.draw("Paused", Window.PAUSE_Y, g);

	}
	
/**
 * Draws the end game screen
 * @param g
 */
	public void drawEnd(Graphics g) {

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.END_SCORE_SIZE));
		g.setColor(Color.WHITE);
		CenteredText.draw(String.valueOf(score), Window.END_SCORE_Y, g);

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.YOU_LOSE_SIZE));

		CenteredText.draw("You Lose!", Window.YOU_LOSE_Y, g);

		g.setFont(new Font(Window.FONT_NAME, Font.BOLD, Window.RESTART_SIZE));

		CenteredText.draw("Enter to Restart", Window.RESTART_Y, g);

	}
	/**
	 * starts the timer that can be displayed on screen.
	 * Use getTime() to get the number seconds that have passed
	 */
	public void startTime() {

		startTime = System.currentTimeMillis();
		
	}
	/**
	 * Pauses the timer
	 */
	public void stopTime() {

		totalTime += System.currentTimeMillis() - startTime;
		startTime = System.currentTimeMillis();

	}
	/**
	 * gets the number of seconds that have passed since the timer was started
	 * @return
	 */
	public int getTime() {

		return (int) ((totalTime + System.currentTimeMillis() - startTime) / 1000);

	}
	/**
	 * resets the time passed and sets the start time to the current time
	 */
	public void resetTime() {
		totalTime = 0;
		startTime = System.currentTimeMillis();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (startGame && e.getKeyCode() != KeyEvent.VK_ENTER) {

			keyMap[keyIndex] = e.getKeyCode();
			keyIndex++;
			if (keyIndex > 3)
				keyIndex = 0;

		} else if (e.getKeyCode() == upKey) {

			up();

		} else if (e.getKeyCode() == downKey) {

			down();

		} else if (e.getKeyCode() == leftKey) {

			left();

		} else if (e.getKeyCode() == rightKey) {

			right();

		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (startGame) {

				playing = true;
				startGame = false;
				setKeys();
				startTime();

			} else if (endGame) {

				sub.reset();
				stopTime();
				startGame = false;
				playing = true;
				nameEnter = false;
				highScores = false;
				endGame = false;
				pName = "";
				speed = 10;
				score = 0;

			} else if (nameEnter) {
				nameEnter = false;
				highScores = true;
				ScoreInfo.setScores(score, pName, Window.FOLDER_PATH
						+ GameInfo.NAME);
			} else if (highScores) {

				highScores = false;
				endGame = true;
			} else {
				startGame = false;
				playing = true;

			}

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE && !nameEnter) {

			playing = !playing;
			paused = !paused;

			if (timer.isRunning()) {
				timer.stop();
				stopTime();
			} else {
				timer.start();
				startTime();
			}
			repaint();

		} else if (e.getKeyLocation() == KeyEvent.KEY_LOCATION_STANDARD
				&& nameEnter) {

			if (pName.length() < 10) {
				letter = e.getKeyChar();

				letter = Character.toUpperCase(letter);
				pName = pName.concat(letter.toString());
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == upKey) {

			upReleased();

		} else if (e.getKeyCode() == downKey) {

			downReleased();

		} else if (e.getKeyCode() == leftKey) {

			leftReleased();

		} else if (e.getKeyCode() == rightKey) {

			rightReleased();

		}

	}

	/**
	 * Gets called when timer activates an action, and the timer fires very quickly.
	 * Calls the moves method in the UserGame class if the playing variable is true
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (playing) {

			// if (upPressed) up();
			// if (downPressed) down();
			// if (leftPressed) left();
			// if (rightPressed) right();

			sub.moves();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * What to set variables to when upKey is pressed.
	 * Called by keyPressed
	 */
	@Override
	public void up() {
		// TODO Auto-generated method stub

		deltaY = -movementVar;

	}
	/**
	 * What to set variables to when upKey is pressed
	 * Called by keyPressed
	 */

	@Override
	public void down() {
		// TODO Auto-generated method stub

		deltaY = movementVar;

	}
	/**
	 * What to set variables to when upKey is pressed
	 * Called by keyPressed
	 */

	@Override
	public void left() {
		// TODO Auto-generated method stub
		deltaX = -movementVar;

	}
	/**
	 * What to set variables to when upKey is pressed
	 * Called by keyPressed
	 */

	@Override
	public void right() {
		// TODO Auto-generated method stub

		deltaX = movementVar;

	}
	/**
	 * What to set variables to when upKey is released
	 * Called by keyReleased
	 */

	@Override
	public void upReleased() {
		// TODO Auto-generated method stub
		deltaY = 0;
	}
	/**
	 * What to set variables to when downKey is released
	 * Called by keyReleased
	 */

	@Override
	public void downReleased() {
		// TODO Auto-generated method stub
		deltaY = 0;
	}
	/**
	 * What to set variables to when leftKey is released
	 * Called by keyReleased
	 */

	@Override
	public void leftReleased() {
		// TODO Auto-generated method stub
		deltaX = 0;
	}
	/**
	 * What to set variables to when rightKey is released
	 * Called by keyReleased
	 */

	@Override
	public void rightReleased() {
		// TODO Auto-generated method stub
		deltaX = 0;
	}

}
