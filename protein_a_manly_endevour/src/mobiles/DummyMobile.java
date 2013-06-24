package mobiles;

import java.util.Random;

import map.Location;
import map.Map;

public class DummyMobile extends AbstractMobile{
	Random rand;
	public DummyMobile(int x, int y, Map map) {
		super(x, y, map);
		icon = "+";
		passable = false;
		rand = new Random();
	}
	@Override
	public boolean doMaMove() {
		Location[] adj = getAdj();
		Location loc = adj[rand.nextInt(adj.length)];
		return move(loc.getX(),loc.getY());

	}	

}
