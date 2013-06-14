package map;

public abstract class Location {

	public boolean passable; 
	public Location () {
		passable = false;
	}
	public boolean isPass() {
		return passable;
	}
}
