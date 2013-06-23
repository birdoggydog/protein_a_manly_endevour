package map;

public class Wall extends Location{
	/**
	 *  a location which is not passable
	 */
	public Wall(int x, int y) {
		super(x, y);
		passable = false;
	}
}
