package map;

import display.Graphics;
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
		Graphics g = new Graphics(map);
		while(true) {
			if(this.map!= null) {
				//		/		printMap();
				if(!shouldDraw) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					shouldDraw = true;
				} else {
					g.processDisplay(map);
					shouldDraw = false;

				}
			}
		}
	}

}
