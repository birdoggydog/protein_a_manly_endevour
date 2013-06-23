package map;

import java.util.ArrayList;

import mobiles.AbstractMobile;
import display.Graphics;
import player.Player;
import portal.Portal;

public class MapThread implements Runnable {

	Map map;
	Portal[][] copyMap;
	AbstractMobile[] mobs;
	boolean shouldDraw = true;
	Player player;
	public synchronized void setShouldDraw(boolean b) {
		shouldDraw = b;
	}
	public synchronized void setMap(Map mapin) {
		this.map= mapin;
		if(map!= null) 
			shouldDraw = true;
		else shouldDraw = false;
	}

	@Override
	public void run() {
		Graphics g = new Graphics(map.map);
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
					Portal[][] copyMap = map.getCopyMap();
					map.addPortals(new Portal[]{player}, copyMap);	
					for(AbstractMobile mob: mobs) {
						mob.doMaMove();
					}
					map.addPortals(mobs, copyMap);

					g.drawMap(copyMap);
					shouldDraw = false;

				}
			}
		}
	}
	public void setMobiles(ArrayList<AbstractMobile> mobiles) {
		mobs = mobiles.toArray(new AbstractMobile[mobiles.size()]);
		
	}
	public void setPlayer(Player play) {
		player = play;
	}

}
