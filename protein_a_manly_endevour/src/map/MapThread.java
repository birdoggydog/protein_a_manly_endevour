package map;

import java.util.ArrayList;

import mobiles.AbstractMobile;
import display.Graphics;
import player.Player;
import portal.AbstractPortal;
import portal.Portal;

public class MapThread implements Runnable {
	Map map;
	Graphics mGraphics;
	AbstractPortal[][] copyMap;
	AbstractPortal[][] oldMap;

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
		AbstractPortal[][] copyMap = (AbstractPortal[][]) map.getCopyMap();

		while(true) {
			if(this.map!= null) {
				//		/		printMap();
				if(!shouldDraw) {
					
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					shouldDraw = true;
				} else {
					oldMap = copyMap;
					copyMap = (AbstractPortal[][]) map.getCopyMap();
					player.setDrawnMap(oldMap);
					player.shouldUpdate();
					map.addPortals(new Portal[]{player}, copyMap);						
					for(AbstractMobile mob: mobs) {
						mob.setDrawnMap(copyMap);
						if(mob.shouldUpdate())
							mob.doMaMove();						
					}
					map.addPortals(mobs, copyMap);
					mGraphics.drawMap(copyMap);
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
	public void setGraphics(Graphics graphics) {
		mGraphics = graphics;// TODO Auto-generated method stub
	}

}
