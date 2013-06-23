package player;

import java.awt.event.KeyEvent;

import portal.AbstractPortal;
import event_handler.InteractionEvent;

public class Player extends AbstractPortal {

	int health;
	int fat;
	int environment;
	public Player(int ex, int why){
		super();
		x = ex;
		y = why;
	}
 	@Override
	public boolean acceptInteraction(InteractionEvent e) {
		// TODO Auto-generated method stub
 		int ex = getDelX(e.getKeyEvent());
 		int yy = getDelY(e.getKeyEvent());
 		this.x+=ex;
 		this.y+=yy;
		return super.acceptInteraction(e);
	}
	private int getDelY(KeyEvent keyEvent) {
		if(keyEvent.getKeyCode() ==KeyEvent.VK_KP_DOWN) {
			return -1;
		} else if (keyEvent.getKeyCode() ==KeyEvent.VK_KP_UP) {
			return 1;
		}
		return 0;
	}
	private int getDelX(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		if(keyEvent.getKeyCode() ==KeyEvent.VK_KP_LEFT) {
			return -1;
		} else if (keyEvent.getKeyCode() ==KeyEvent.VK_KP_RIGHT) {
			return 1;
		}
		return 0;
	}
	public boolean eat() {
		return false;
	}
	public boolean finger() {
		return false;
	}
	public boolean die() {
		return false;
	}


}

