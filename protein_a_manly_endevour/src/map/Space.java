package map;

import event_handler.InteractionEvent;

public class Space extends Location{
	public Space(int x, int y) {
		super(x, y);
		passable= true;
	}

	@Override
	public boolean acceptInteraction(InteractionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}
