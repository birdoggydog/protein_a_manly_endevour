package mobiles;

import map.Location;
import map.Map;

public class DummyMobile extends AbstractMobile{

	public DummyMobile(int x, int y, Map map) {
		super(x, y, map);
	}
	public void doMahMove() {
		Location[] adj = getAdj();
		for (Location loc: adj) {
			if(move(loc.getX(),loc.getY())) {
				break;
			}
		}
	}

}
