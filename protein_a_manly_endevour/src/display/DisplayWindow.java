package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayWindow extends JFrame {
	
	JPanel textWindow, healthPanel;
	JTextArea dungeonArea;
	String title = "Protein: A Manly Endevour";
	JTextField healthStat;
	JLabel health;
	Font courier= new Font("Courier New", Font.PLAIN, 10);
	Font arielBold = new Font("Ariel Black", Font.BOLD, 10);

	public DisplayWindow(int width, int height){

		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		textWindow = new JPanel();

		dungeonArea = new JTextArea(height,width);
		dungeonArea.setEditable(false);
		dungeonArea.setFont(courier);
//		dungeonArea.setForeground(Color.BLACK);
//		dungeonArea.setBackground(Color.BLUE);
		
		textWindow.add(dungeonArea);

		healthPanel = new JPanel();
		healthStat = new JTextField(10);
		healthStat.setEditable(false);
		healthStat.setFont(arielBold);
		healthStat.setForeground(Color.RED);
		health = new JLabel("Health: ");
		healthPanel.add(health);
		healthPanel.add(healthStat);
		
		add(textWindow, BorderLayout.CENTER);
		add(healthPanel, BorderLayout.SOUTH);
		
		setVisible(true);
		pack();

	}

	public void renderMap(String processDisplay) {
		dungeonArea.setText(processDisplay);
	}
	
	public void setHealth(String health){
		healthStat.setText(health);
	}
}
