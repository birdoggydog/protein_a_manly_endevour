package map;

import event_handler.InteractionEvent;

public class Wall extends Location{
	/**
	 *  a location which is not passable
	 */
	public Wall(int x, int y) {
		super(x, y);
		passable = false;
	}

	@Override
	public boolean acceptInteraction(InteractionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}
