package map;

import java.util.Stack;

public class RandomMazeMap extends Map {

	// algorithim stole from http://foothills.wjduquette.com/archives/001000.html
	Stack<Location> locs;
	Location startRoom;
	Location[] adj;
	Location[] walls;
	int nextRm;
	int RIGHT = 0;
	int LEFT = 1;
	int UP = 2;
	int DOWN =3;

	public RandomMazeMap(int wid, int hei, int spaDen, int porDen) {
		super(wid, hei, spaDen, porDen);
		startRoom = pickStart();
		locs = new Stack<Location>();
		locs.push(startRoom);
		generate();
	}
	public Location pickStart() {
		int x = rand.nextInt(width);
		int y = rand.nextInt(height);
		Location start = new Space(x, y);
		map[y][x] = start;
		return start;
	}
	public void generate() {
		boolean foundWall;
		while(locs.size()>0) {
			foundWall = false;
			adj = getAdjacent(startRoom);
			walls = getWalls(adj);
			for(Location w: walls) {
				if(getWalls(getAdjacent(w)).length==3) {
					nextRm = rand.nextInt(walls.length);
					locs.push(startRoom);
					map[walls[nextRm].getY()][walls[nextRm].getX()] = new Space(walls[nextRm].getX(),walls[nextRm].getY());
					startRoom = map[walls[nextRm].getY()][walls[nextRm].getX()];
					foundWall = true;
					spaces.add((Space) map[startRoom.getY()][startRoom.getX()]);
				}
			} if(!foundWall) {
				startRoom = locs.pop();
			}
		}
	}
}