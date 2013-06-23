package portal;

import event_handler.InteractionEvent;
import game_world.GameWorld;

public class AbstractPortal implements Portal{
	// reference to gameWorld
	protected int x;
	protected int y;
	GameWorld game;
	@Override
	public boolean acceptInteraction(InteractionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	void setGameWorld(GameWorld game, int x, int y) {
		this.game = game;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
