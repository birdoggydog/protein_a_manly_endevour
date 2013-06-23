package mobiles;

import map.Location;
import map.Map;
import portal.AbstractPortal;

public abstract class AbstractMobile extends AbstractPortal {
	String icon;
	Map mMap;
	/**
	 * Basic implementation for all moving things.  Not just living ones!
	 * @param x
	 * @param y
	 */
	public AbstractMobile(int x, int y, Map map) {
		this.x = x;
		this.y = y;
		mMap = map;
	}
	/**
	 * Update the to the new location, stract implementions will handle
	 * how to determine and validity etc... of new locs
	 * @param newX
	 * @param newY
	 */
	public boolean move(int newX, int newY) {
		if(canMove(newX, newY)) {
			this.x = newX;
			this.y = newY;
			return true;
		}
		return false;
	}
	public boolean canMove(int ex, int yy) {
		return mMap.canPlace(ex, yy);
	}
	public Location[] getAdj() {
		return mMap.getAdjacent(mMap.getLocation(x, y));
	}
	/**
	 * Send out your interaction
	 * @return
	 */
	public boolean finger() {
		return false;
	}
	/**
	 * Terminte mobile.
	 * @return
	 */
	public boolean die() {
		return false;
	}
	public String getIcon() {
		return this.icon;
	}
	public abstract boolean doMaMove();
}
