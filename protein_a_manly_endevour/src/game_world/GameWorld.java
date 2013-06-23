package game_world;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import map.Location;
import map.Map;
import map.MapThread;
import map.RandomMazeMap;
import mobiles.AbstractMobile;
import mobiles.DummyMobile;
import player.Player;
import portal.Portal;
import event_handler.EventManager;
import event_handler.InteractionEvent;

/**
 * Manages the map, catches all input events, bundles them off to to
 * the event manager.
 * 
 * Also instantiates the portal manager - is the gameplay manager.
 * @author Nathaiel, Snean
 *
 */
public class GameWorld implements KeyListener, MouseListener {

	Player player;
	EventManager eventManager;
	PortalManager portalManager;
	static GameWorld instance;
	MapThread r;
	InteractionEvent ie;
	ArrayList<AbstractMobile> mobiles;
	AbstractMobile[] mobs;
	Map map;
	int maxMobs = 40;
	// sean insisted.
	/**
	 * GameWorld - this guy is in charge of everything.
	 * Catches events (key, mouse), Manages the map, and layers, all listeners.
	 * Orders them.
	 * @return
	 */
	public static GameWorld getInstance() {
		if (instance == null) {
			instance = new GameWorld();
		}
		return instance;
	}
	
	private GameWorld() {
	//	Graphics graphics = new Graphics();
		eventManager = new EventManager();
		portalManager = new PortalManager();
		mobiles = new ArrayList<AbstractMobile>();

		map = new RandomMazeMap(30, 30, 10, 10);
		for(int i = 0; i<maxMobs; i++) {
			Location loc = map.getPlaceableLocation();
			if(loc!=null) {
				mobiles.add(new DummyMobile(loc.getX(),loc.getY(), map));
			}
		}
		Location pS = map.getPlayerStart();
		player = new Player(pS.getX(), pS.getY(), map);
		r = new MapThread();
//		Portal[][] copyMap = map.getCopyMap();
//		map.addPortals(new Portal[]{player}, copyMap);
		
//		map.addPortals(mobiles.toArray(new Portal[mobiles.size()]), copyMap);
		r.setMap(map);
		r.setPlayer(player);
		r.setMobiles(mobiles);
		Thread t= new Thread(r);
		t.start();
		eventManager.setPlayer(player);
		
		//map.printMap();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		handleEvent( e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		handleEvent( e);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		handleEvent( e);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		handleEvent( e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		handleEvent( e);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		handleEvent( e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		handleEvent( e);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		handleEvent( e);
		
	}
// i am adding a comment cuz I love to do that.
	private void handleEvent(MouseEvent toHandle) {
		// TODO Auto-generated method stub
		ie = new InteractionEvent(0, toHandle, null);
		eventManager.handleEvent(ie);
		refresh();
	}
	private void handleEvent(KeyEvent toHandle) {
		// TODO Auto-generated method stub
		ie = new InteractionEvent(0, null, toHandle);
		player.acceptInteraction(ie);
		eventManager.handleEvent(ie);
		refresh();
	}
	public void refresh() {
//		r.setMap(map.addPortals(new Portal[]{player}, map.getCopyMap()));
	}
}
