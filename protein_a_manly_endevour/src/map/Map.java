package map;

import java.util.ArrayList;
import java.util.Random;

import mobiles.AbstractMobile;

import portal.AbstractPortal;
import portal.Portal;

public abstract class Map {
	Random rand;
	int width;
	int height;
	int space_density;
	int portal_density;
	ArrayList<Portal> portals;
	ArrayList<AbstractPortal>[][] fingerablePorts;
	Location[][] map;
	AbstractPortal[][] copyMap;

	ArrayList<Space> spaces;

	public Map(int wid, int hei, int spaDen, int porDen) {
		width = wid;
		height=hei;
		space_density=spaDen;
		porDen=portal_density;
		map = new Location[height][width];
		fingerablePorts = new ArrayList[height][width];
		setUpFingerables();
		rand = new Random();		
		spaces = new ArrayList<Space>();
		fill();
	}
	public void setUpFingerables() {
		for(int h = 0; h<height; h++) {
			for(int j = 0; j<width; j++) {
				fingerablePorts[h][j] = new ArrayList<AbstractPortal>();
			}
		}
	}
	/**
	 * create a blank map.
	 */
	public void fill() {
		for (int i =0; i < height; i++) {
			for (int j = 0; j<width; j++) {
				Wall w = new Wall(j,i);
				map[i][j] = w;				
			}
		}
	}
	/**
	 * get alll adjacent tiles 
	 * @param loc
	 * @return
	 */
	public void setFingerablePorts(ArrayList<AbstractMobile> mobs) {
		setUpFingerables();
		for(AbstractPortal port:mobs) {
			fingerablePorts[port.getY()][port.getX()].add(port);
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
	/** create a list of all walls in the map.
	 *
	 */
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
	/**
	 * create a deep copy of the map for manipulation.
	 * @return
	 */
	public AbstractPortal[][] getCopyMap() {		
		AbstractPortal[][] funkytown = new AbstractPortal[height][width];
		for (int i = 0; i<height; i++) {
			for (int j = 0; j<width; j++) {
				funkytown[i][j]= map[i][j];
			}
		}
		return funkytown;
	}
	/**
	 * generate a start location for the player.
	 * @return
	 */
	public  Location getPlayerStart() {

		Location playerStart = spaces.get(rand.nextInt(spaces.size()));
		return playerStart;
	}
	/**
	 * add some collection of portals to a copy of the actual map.
	 * @param toDraw
	 * @param cpM
	 * @return
	 */
	public Portal[][] addPortals(Portal[] toDraw, Portal[][] cpM) {
		for(Portal p : toDraw) {
			cpM[p.getY()][p.getX()] = p;
		}
		return cpM;
	}
	public boolean canPlace(int x, int y) {
		return map[y][x].passable;
	}
	public boolean canPlace(int x, int y, AbstractPortal[][] tmpMap) {
		return canPlace(x,y)&&tmpMap[y][x].passable;
	}
	public Location getLocation(int x, int y) {
		
		Location ret = map[y][x];
		return ret;
	}
	public Location getPlaceableLocation() 	{
		boolean notFound = true;
		int i = 0;
		Location loc = null;
		while(notFound && i< 50){
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			if(map[y][x].passable) {
				loc = map[y][x];
				notFound = false;
			}
			i++;
		}
		return loc;
	}
	public AbstractPortal[] getFingerables(int x, int y) {
			ArrayList<AbstractPortal> ports = new ArrayList<AbstractPortal>();
//
			ports.add(map[y][x]);
			ports.addAll(fingerablePorts[y][x]);
			return ports.toArray(new AbstractPortal[ports.size()]);
	}
	public void setCpMap(AbstractPortal[][] copyMap) {
		this.copyMap = copyMap;// TODO Auto-generated method stub
		
	}
	public void setFingerablePorts(AbstractMobile[] mobs) {
		for(AbstractPortal port: mobs) {
			fingerablePorts[port.getY()][port.getX()].add(port);
		}
		
	}
}
