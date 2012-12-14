package xmas.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	
	private GUIMenubar menu;
	private JPanel mainpanel, playerpanel, towerpanel, gamepanel;
	
	public GUI() {
		
//		Mainwindow
		setTitle("X-Mas Defense");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
//		Menubar
		menu = new GUIMenubar();
		setJMenuBar(menu);
		
		
//		Toppanel/Playerpanel
		playerpanel = new JPanel();
		
		
//		Lowpanel/Towerpanel
		towerpanel = new JPanel();
		
//		Gamepanel
		gamepanel = new JPanel();
		gamepanel.setSize(800, 600);
		
		
//		Mainpanel
		mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(playerpanel, BorderLayout.NORTH);
		mainpanel.add(towerpanel, BorderLayout.SOUTH);
		
		
		add(mainpanel);
		pack();
		
	}

	
	public static void main(String[] args) {
		new GUI();
	}
}
