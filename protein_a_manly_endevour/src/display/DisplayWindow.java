package display;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DisplayWindow extends JFrame {

	public DisplayWindow(int width, int height){

		JPanel textWindow = new JPanel();
		JTextArea dungeonArea = new JTextArea();
		String title = "Protein: A Manly Endevour";
		Font courier= new Font("Courier New", Font.PLAIN, 10);

		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textWindow = new JPanel();
		dungeonArea = new JTextArea(height,width);
		dungeonArea.setEditable(false);
		dungeonArea.setFont(courier);
		dungeonArea.setForeground(Color.BLACK);
		dungeonArea.setBackground(Color.BLUE);
		textWindow.add(dungeonArea);
		add(textWindow);
		setVisible(true);
		pack();

	}
}
