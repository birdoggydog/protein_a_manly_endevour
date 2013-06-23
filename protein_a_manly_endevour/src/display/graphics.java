package display;

import map.Location;

public class graphics {
	
	public static void drawMap(Location[][] map){
		int height, width;
		height = map.length;
		width = map[0].length;
		new DisplayWindow(width, height);
	}

}
