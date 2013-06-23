package display;
import player.Player;
import portal.Portal;
import map.Location;
import map.Space;
import map.Wall;

public class Graphics {

	String wall = "#";
	String space = " "; 
	String player = "O";
	DisplayWindow d;
	
	public Graphics(Portal[][] map){
		int height, width;
		height = map.length;
		width = map[0].length;

		d = new DisplayWindow(width, height);
	}

	public void drawMap(Portal[][] map){
		
		
		d.renderMap(processDisplay(map));
	}
	
	private String processDisplay(Portal[][] map) {
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
					}
				} 
			}
			display += "\n";
		}
		return display;
	}

}
