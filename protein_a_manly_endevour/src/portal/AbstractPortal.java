package portal;

import event_handler.InteractionEvent;
import game_world.GameWorld;

public class AbstractPortal implements Portal{
	// reference to gameWorld
	GameWorld game;
	@Override
	public boolean acceptInteraction(InteractionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	void setGameWorld(GameWorld game) {
		this.game = game;
	}

	
}
