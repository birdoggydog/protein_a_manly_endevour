package display;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import map.Space;
import map.Wall;
import mobiles.AbstractMobile;
import player.Player;
import portal.Portal;

public class Graphics {

	String wall = "#";
	String space = " "; 
	String player = "@";
	DisplayWindow d;
	
	public Graphics(Portal[][] map){
		int height, width;
		height = map.length;
		width = map[0].length;

		d = new DisplayWindow(width, height);
		d.setFocusable(true);
	}

	/**
	 * Processes a portal[][] and sends it to displayWindow
	 * @param map	
	 */
	public void drawMap(Portal[][] map){
		String display = "";
		for (int i = 0; i<map.length; i++) {
			for (int j = 0; j<map[0].length; j++) {
				if(map[i][j]!= null) {
					if(map[i][j] instanceof Wall) {
						display += wall;
					} else if (map[i][j] instanceof Space){
						display += space;
					} else if(map[i][j] instanceof Player) {
						display += player;
					} else if (map[i][j] instanceof AbstractMobile) {
						display+=((AbstractMobile) map[i][j]).getIcon();
					}
				} 
			}
			display += "\n";
		}
		d.renderMap(display);
	}
	
	public String renderStat(int stat){
		char barCh = '#';
		String statBar = "";
		for (int i = 0; i < stat; i++){
			statBar+=barCh;
		}
		return statBar;
	}

	public void setKeyListener(KeyListener gameWorld) {
		d.addKeyListener(gameWorld);
	}
	public void setMouseListener(MouseListener gameWorld) {
		d.addMouseListener(gameWorld);
		}
	
	public void setHealth(int health){
		d.setHealth((renderStat(health)));
	}
	
}
