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

	ArrayList<AbstractMobile> mobs;
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
					ArrayList<Integer> toremove = new ArrayList<Integer>();
					oldMap = copyMap;
					copyMap = (AbstractPortal[][]) map.getCopyMap();
					player.setDrawnMap(oldMap);
					player.shouldUpdate();
					map.setFingerablePorts(mobs);
				//	map.setFingerablePorts(player);

					map.addPortals(new Portal[]{player}, copyMap);						
//					map.addPortals(mobs.toArray(new Portal[mobs.size()]), copyMap);
					for(int i = 0; i<mobs.size(); i++) {
						AbstractMobile mob = mobs.get(i);
						if(mob!=null && mob.isAlive()){
							mob.setDrawnMap(copyMap);
							if(mob.shouldUpdate())
								mob.doMaMove();
						} else {
							toremove.add(i);
						}
					}
					for(Integer j: toremove) {
						System.out.println("removing dead things");
						AbstractPortal mob = mobs.get(j);
						mobs.remove(mob);
					}
					
					map.addPortals(mobs.toArray(new Portal[mobs.size()]), copyMap);
					mGraphics.drawMap(copyMap);
					shouldDraw = false;

				}
			}
		}
	}
	public void setMobiles(ArrayList<AbstractMobile> mobiles) {
		mobs = mobiles;
	}
	public void setPlayer(Player play) {
		player = play;
	}
	public void setGraphics(Graphics graphics) {
		mGraphics = graphics;// TODO Auto-generated method stub
	}

}
