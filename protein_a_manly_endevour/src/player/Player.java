package player;

import portal.AbstractPortal;
import event_handler.InteractionEvent;

public class Player extends AbstractPortal {

	@Override
	public boolean acceptInteraction(InteractionEvent e) {
		// TODO Auto-generated method stub
		return super.acceptInteraction(e);
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

