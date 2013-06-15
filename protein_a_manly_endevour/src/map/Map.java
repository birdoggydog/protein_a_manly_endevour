package map;

import java.util.ArrayList;
import java.util.Random;

import portal.Portal;

public abstract class Map {
	Random rand;
	int width;
	int height;
	int space_density;
	int portal_density;
	ArrayList<Portal> portals;
	Location[][] map;
	
	ArrayList<Space> spaces;
	
	public Map(int wid, int hei, int spaDen, int porDen) {
		width = wid;
		height=hei;
		space_density=spaDen;
		porDen=portal_density;
		map = new Location[height][width];
		rand = new Random();		
		spaces = new ArrayList<Space>();
		fill();
	}
	public void fill() {
		for (int i =0; i < height; i++) {
			for (int j = 0; j<width; j++) {
				Wall w = new Wall(j,i);
				map[i][j] = w;				
			}
		}
	}
	public Location[] getAdjacent(Location loc) {
		int x= loc.getX();
		int y= loc.getY();
		ArrayList<Location> adjs = new ArrayList<Location>();
		for(int i = -1; i<2; i+=2) {
			if(y+i < height && y+i>=0)
				adjs.add(map[y+i][x]);
			if(x+i < width && x+i>=0) 
				adjs.add(map[y][x+i]);
		}

		return adjs.toArray(new Location[adjs.size()]);		
	}
	public Location[] getWalls(Location[] adj) { 
		ArrayList<Location> walls = new ArrayList<Location>();
		for(Location x : adj) {
			if(x!= null && x instanceof Wall) {
					walls.add(x);				
			}
		}

		return  walls.toArray(new Location[walls.size()]);
	}

	public Location[] getSpaces(Location[] adj) { 
		ArrayList<Location> spaces = new ArrayList<Location>();
		for(Location x : adj) {
			if(x!= null && x instanceof Space) {
					spaces.add(x);				
			}
		}

		return  spaces.toArray(new Location[spaces.size()]);
	}

	public Location[][] getMap() {
		return map;
	}
	public Portal[][] getCopyMap() {
		return map.clone();

	}
	public  Location getPlayerStart() {
		
		Location playerStart = spaces.get(rand.nextInt(spaces.size()));
		return playerStart;
	}
	public Portal[][] addPortals(Portal[] toDraw, Portal[][] cpM) {
		for(Portal p : toDraw) {
			cpM[p.getY()][p.getX()] = p;
		}
		return cpM;
	}
}
