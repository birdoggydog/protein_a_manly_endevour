package portal;

import event_handler.InteractionEvent;
import game_world.GameWorld;

public abstract class AbstractPortal implements Portal{
	// reference to gameWorld
	protected int x;
	protected int y;
	public boolean passable = true;
	GameWorld game;
	@Override
	public abstract boolean acceptInteraction(InteractionEvent e);
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
