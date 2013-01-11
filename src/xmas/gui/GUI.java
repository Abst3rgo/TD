package xmas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI extends JFrame {
	
	private GUIMenubar menu;
	private JPanel mainpanel, playerpanel, towerpanel, gamepanel, intowerpanel,
		lowpanel;
	private JButton nuss, lametta, kugel;
	private JLabel towerlabel, playerlife, gametime;
	private JTextArea gametext;
	
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
		playerpanel.setLayout(new GridLayout(1, 2));
		playerpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		playerlife = new JLabel("Life:");
		gametime = new JLabel("Time:");
		playerpanel.add(playerlife);
		playerpanel.add(gametime);
		
//		InTowerPanel
		intowerpanel = new JPanel();
		towerlabel = new JLabel("Select Tower:");
		intowerpanel.add(towerlabel);
		
//		Towerpanel
		towerpanel = new JPanel();
		towerpanel.setLayout(new GridLayout(1, 3));
//		towerpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		nuss = new JButton("Nut");
		towerpanel.add(nuss);
		lametta = new JButton("Tinsel");
		towerpanel.add(lametta);
		kugel = new JButton("Ball");
		towerpanel.add(kugel);
		
//		Lowpanel
		lowpanel = new JPanel();
		lowpanel.setLayout(new GridLayout(2, 1));
		lowpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lowpanel.add(intowerpanel);
		lowpanel.add(towerpanel);
		
		
//		Gamepanel
		gamepanel = new JPanel();
		gamepanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
//		gamepanel.setBackground(Color.RED);
		gamepanel.setSize(800, 600);
		gametext = new JTextArea(8, 40);
		gamepanel.add(gametext);
		
		
//		Mainpanel
		mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(playerpanel, BorderLayout.NORTH);
		mainpanel.add(gamepanel, BorderLayout.CENTER);
		mainpanel.add(lowpanel, BorderLayout.SOUTH);
		
		
		add(mainpanel);
		pack();
		
	}

	
	public static void main(String[] args) {
		new GUI();
	}
}
