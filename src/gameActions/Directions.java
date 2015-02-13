package gameActions;

import java.util.ArrayList;

public abstract class Directions extends Control {

	public enum Direction {
		
		up, down, left, right;
	}
	
	public Directions() {
		
		super();
		
	}
	public abstract void up();
	public abstract void down();
	public abstract void left();
	public abstract void right();
	
	public abstract void upReleased();
	public abstract void downReleased();
	public abstract void leftReleased();
	public abstract void rightReleased();
	
	public ArrayList<Direction> nextDirection = new ArrayList<Direction>();
	
	public void addDirection(Direction d) {

		nextDirection.add(d);

		// lastDirection = d;

	}

	
	public void executeDirection() {

		
		Direction d = nextDirection.get(0);
		nextDirection.remove(0);

		switch (d) {

		case up:

			up();

			break;
		case down:
			down();

			break;
		case left:

			left();

			break;
		case right:

			right();

		}

	}
	
	
}
