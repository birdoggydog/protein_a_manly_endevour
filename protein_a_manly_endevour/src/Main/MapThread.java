package Main;

import map.Location;
import map.Space;
import map.Wall;
import player.Player;
import portal.Portal;

public class MapThread implements Runnable {

	Portal[][] map;
	String wall = "#";
	String space = " "; 
	String player = "O";
	boolean shouldDraw = true;
	public synchronized void setShouldDraw(boolean b) {
		shouldDraw = b;
	}
	public synchronized void setMap(Portal[][] portals) {
		this.map= portals;
		if(portals!= null) 
			shouldDraw = true;
		else shouldDraw = false;
	}

	@Override
	public void run() {
		while(true) {
			if(this.map!= null) {
				printMap();
				if(!shouldDraw) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					printMap();
					shouldDraw = false;
				}
			}
		}
	}

	public void printMap() {
		for (int i = 0; i<map.length; i++) {
			for (int j = 0; j<map[0].length; j++) {
				if(map[i][j]!= null) {
					if(map[i][j] instanceof Wall) {
						System.out.print(wall);
					} else if (map[i][j] instanceof Space){
						System.out.print(space);		
					} else if(map[i][j] instanceof Player) {
						System.out.println(player);
					}
				} 
			}
			System.out.println();
		}
	}


}
