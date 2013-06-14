package game_world;
import java.util.ArrayList;

import portal.Portal;

public class PortalManager {

     // maintain some lists of portals, provice getters, adders etc...
    //
	
	private ArrayList portalList = new ArrayList<Portal>();
	public PortalManager() {
		
	}
	
	public void addPortal(ArrayList<Portal> t, Portal p) {
		t.add(p);
	}
	public void removePortal(ArrayList<Portal> t, Portal p) {
		t.remove(p);
	}
	public ArrayList<Portal> getPortalList() {
		return portalList;
	}
	
	
}
