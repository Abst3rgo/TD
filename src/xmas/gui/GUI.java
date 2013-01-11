package xmas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GUI extends JFrame implements MouseListener, ActionListener {
	
	private GUIMenubar menu;
	private JPanel mainpanel, playerpanel, towerpanel, gamepanel, intowerpanel,
		lowpanel;
	private JButton nuss, lametta, kugel;
	private JLabel towerlabel, playerlife, gametime;
	private JRadioButton nuttower, balltower, tinseltower;
	
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
	/*	nuss = new JButton("Nut");
		nuss.addActionListener(this);
		towerpanel.add(nuss);
		lametta = new JButton("Tinsel");
		lametta.addActionListener(this);
		towerpanel.add(lametta);
		kugel = new JButton("Ball");
		kugel.addActionListener(this);
		towerpanel.add(kugel); */
		
		nuttower = new JRadioButton("Nut");
		balltower = new JRadioButton("Ball");
		tinseltower = new JRadioButton("Tinsel");
		ButtonGroup towerselect = new ButtonGroup();
		
		towerselect.add(nuttower);
		towerselect.add(balltower);
		towerselect.add(tinseltower);
		
		towerpanel.add(nuttower);
		towerpanel.add(balltower);
		towerpanel.add(tinseltower);
		
		
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
		gamepanel.setPreferredSize(new Dimension(800, 600));
		gamepanel.setBackground(Color.white);
		gamepanel.setLayout(null);
		gamepanel.addMouseListener(this);
		
		
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


	@Override
	public void mouseClicked(MouseEvent me) {
		int x = me.getX();
		int y = me.getY();
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		JLabel test1 = new JLabel("test");
		test1.setBounds(x-10, y-5, 30, 15);
		gamepanel.add(test1);
		mainpanel.repaint();
	}


	@Override
	public void mouseEntered(MouseEvent me) {
		
	}


	@Override
	public void mouseExited(MouseEvent me) {
		
	}


	@Override
	public void mousePressed(MouseEvent me) {
		
	}


	@Override
	public void mouseReleased(MouseEvent me) {
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
