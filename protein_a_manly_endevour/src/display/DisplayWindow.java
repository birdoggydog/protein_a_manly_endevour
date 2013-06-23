package display;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import map.Space;
import map.Wall;
import player.Player;

public class DisplayWindow extends JFrame {
	
	JPanel textWindow = new JPanel();
	JTextArea dungeonArea = new JTextArea();
	String title = "Protein: A Manly Endevour";
	Font courier= new Font("Courier New", Font.PLAIN, 10);

	public DisplayWindow(int width, int height){

		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textWindow = new JPanel();
		dungeonArea = new JTextArea(height,width);
		dungeonArea.setEditable(false);
		dungeonArea.setFont(courier);
//		dungeonArea.setForeground(Color.BLACK);
//		dungeonArea.setBackground(Color.BLUE);
		textWindow.add(dungeonArea);
		add(textWindow);
		setVisible(true);
		pack();

	}

	public void renderMap(String processDisplay) {
		dungeonArea.setText(processDisplay);
	}
}
