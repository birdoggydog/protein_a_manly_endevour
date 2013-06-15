package game_world;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import map.Location;
import map.Map;
import map.RandomMazeMap;
import player.Player;
import portal.Portal;
import Main.MapThread;
import event_handler.EventManager;
import event_handler.InteractionEvent;

public class GameWorld implements KeyListener, MouseListener {

	Player player;
	EventManager eventManager;
	PortalManager portalManager;
	static GameWorld instance;
	MapThread r;
	InteractionEvent ie;
	Map map;
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
		eventManager = new EventManager();
		portalManager = new PortalManager();
		map = new RandomMazeMap(30, 30, 10, 10);
		Location pS = map.getPlayerStart();
		player = new Player(pS.getY(), pS.getX());
		r = new MapThread();
		r.setMap(map.addPortals(new Portal[]{player}, map.getCopyMap()));
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
	}
	private void handleEvent(KeyEvent toHandle) {
		// TODO Auto-generated method stub
		ie = new InteractionEvent(0, null, toHandle);
		player.acceptInteraction(ie);
		eventManager.handleEvent(ie);
	}
	public void refresh() {
		r.setMap(map.addPortals(new Portal[]{player}, map.getCopyMap()));
	}
}
