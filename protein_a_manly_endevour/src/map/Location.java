package map;

import portal.AbstractPortal;

public abstract class Location extends AbstractPortal {

	public boolean passable; 
	private int x;
	private int y;
	/**
	 * knows its location in a map,
	 * says wether or not it is passable
	 * @param ex
	 * @param why
	 */
	public Location (int ex, int why) {
		passable = false;
		x = ex;
		y = why;
	}
	public boolean isPass() {
		return passable;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}
