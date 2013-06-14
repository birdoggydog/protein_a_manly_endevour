package game_world;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import player.Player;
import event_handler.EventManager;

public class GameWorld implements KeyListener, MouseListener {

	Player player;
	EventManager eventManager;
	PortalManager portalManager;
	static GameWorld instance;
	// sean insisted.
	public static GameWorld getInstance() {
		if (instance == null) {
			instance = new GameWorld();
		}
		return instance;
	}
	private GameWorld() {
		eventManager = new EventManager();
		portalManager = new PortalManager();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
// i am adding a comment cuz I love to do that.
}
