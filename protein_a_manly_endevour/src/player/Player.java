package player;

import java.awt.event.KeyEvent;

import map.Map;
import mobiles.AbstractMobile;
import event_handler.InteractionEvent;

public class Player extends AbstractMobile {

	int health;
	int fat;
	int environment;
	public Player(int x, int y, Map map){
		super(x, y, map);	
		health = 100;
		fat = 25;
		environment = 10;
		passable = false;
	
	}
	/**
	 * Currently always returning true. (i.e. eat event).
	 */
	@Override
	public boolean acceptInteraction(InteractionEvent e) {
		// TODO Auto-generated method stub
		
		if(shouldUpdate) {
			int ex = getDelX(e.getKeyEvent());
			int yy = getDelY(e.getKeyEvent());
			move(x+ex,y+yy);
		}
		return true;
	}
	private int getDelY(KeyEvent keyEvent) {
		System.out.println(keyEvent.getKeyCode());
		if(keyEvent.getKeyCode() ==KeyEvent.VK_DOWN) {
			return 1;
		} else if (keyEvent.getKeyCode() ==KeyEvent.VK_UP) {
			return -1;
		}
		return 0;
	}
	private int getDelX(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		if(keyEvent.getKeyCode() ==KeyEvent.VK_LEFT) {
			return -1;
		} else if (keyEvent.getKeyCode() ==KeyEvent.VK_RIGHT) {
			return 1;
		}
		return 0;
	}
	@Override
	public boolean finger() {
		return false;
	}
	@Override
	public boolean die() {
		return false;
	}
	@Override
	public boolean doMaMove() {
		// TODO Auto-generated method stub
		return false;
	}


}

