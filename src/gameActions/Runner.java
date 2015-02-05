package gameActions;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import utilityClasses.Window;

public class Runner {

	public static void main(String[] args) {
		
		run();
		
	}
	/**
	 * Runs the game. Makes a new JFrame and adds the UserGame to the frame
	 */
	public static void run() {
		
		
		JFrame frame = new JFrame(Window.GAME_NAME + "!");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		//so doesn't flicker
		frame.setResizable(Window.RESIZEABLE);
		frame.setAlwaysOnTop(Window.ALWAYS_ON_TOP);
		
//		frame.setAlwaysOnTop(true);

		UserGame game = new UserGame();
		frame.add(game, BorderLayout.CENTER);

		frame.setSize(Window.WIDTH, Window.HEIGHT);
		frame.setVisible(true);
		
	}

	public Runner() {
		// TODO Auto-generated constructor stub
	
	run();
	}

}
