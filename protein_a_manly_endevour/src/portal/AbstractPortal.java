package portal;

import game_world.GameWorld;

public class AbstractPortal implements Portal{
	// do yo shit niggaaa
	// reference to gameWorld
	GameWorld game;
	@Override
	public boolean acceptInteraction() {
		// TODO Auto-generated method stub
		return false;
	}
	
	void setGameWorld(GameWorld game) {
		this.game = game;
	}

	
}
