package xmas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import xmas.controller.impl.*;

public class GUI extends JFrame implements MouseListener {
	
	private GUIMenubar menu;
	private JPanel mainpanel, playerpanel, towerpanel;
	private static JPanel gamepanel;
	private JPanel intowerpanel;
	private JPanel lowpanel;
	private JLabel towerlabel, playerlife;
	private JRadioButton nuttower, balltower, tinseltower;
	private JTextField displaylife;
	private JLabel[][] felder = new JLabel[24][24];
	private int width, height;
	private String[][] fieldarray;
	
	public GUI() {
				
//		Mainwindow
		setTitle("X-Mas Defense");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
//		Menubar
		menu = new GUIMenubar();
		setJMenuBar(menu);

		width = 24;
		height = 24;
//		width = xmas.controller.impl.Controller.getSpielfeldX();
//		height = xmas.controller.impl.Controller.getSpielfeldY();
		
		
//		Toppanel/Playerpanel
		playerpanel = new JPanel();
		playerpanel.setLayout(new GridLayout(1, 4));
		playerpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
//		Life/Leben
		playerlife = new JLabel("Life:");
		displaylife = new JTextField("3"); //TODO player.getlife() usw.
		displaylife.setEditable(false);
		playerpanel.add(playerlife);
		playerpanel.add(displaylife);
		
		
		
//		Select TowerPanel/Auswahl Tower
		intowerpanel = new JPanel();
		towerlabel = new JLabel("Select Tower:");
		intowerpanel.add(towerlabel);
		
//		Towerpanel/Auswahl Tower
		towerpanel = new JPanel();
		towerpanel.setLayout(new GridLayout(1, 3));
//		TowerButtonGroup/Gruppe von Tower
		nuttower = new JRadioButton("Nut");
		balltower = new JRadioButton("Ball");
//		tinseltower = new JRadioButton("Tinsel");
		ButtonGroup towerselect = new ButtonGroup();
		
		towerselect.add(nuttower);
		towerselect.add(balltower);
//		towerselect.add(tinseltower);
		
		towerpanel.add(nuttower);
		nuttower.setSelected(true);
		towerpanel.add(balltower);
//		towerpanel.add(tinseltower);
		
		
//		Lowpanel/unteres Panel
		lowpanel = new JPanel();
		lowpanel.setLayout(new GridLayout(2, 1));
		lowpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lowpanel.add(intowerpanel);
		lowpanel.add(towerpanel);
		
		
//		Gamepanel/Spielfeld
		gamepanel = new JPanel();
		gamepanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		gamepanel.setPreferredSize(new Dimension(800, 800));
		gamepanel.setBackground(Color.white);
		gamepanel.setLayout(new GridLayout(width, height));
	
//		Schachbrett mit Jlabels
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				felder[x][y] = new JLabel();
				felder[x][y].addMouseListener(this);
				felder[x][y].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				gamepanel.add(felder[x][y]);
			}
		}
//		Start+End
//		felder[0][10].setText("Start");
//		felder[19][10].setText("End");
		
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
		
//	TODO	Controller.startGame();
//	TODO	xmas.controller.impl.Controller.setSpielFeld("3");
//	TODO	fieldarray = xmas.parts.impl.Spielfeld.getfieldArray();
		
//		Spielfeld zeichnet sich pro Sekunde 1 mal neu
		javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
			    gamepanel.repaint();
			}
			});
			t.start();
	}


	@Override
	public void mouseClicked(MouseEvent me) {
		
	}


	@Override
	public void mouseEntered(MouseEvent me) {
		
	}


	@Override
	public void mouseExited(MouseEvent me) {
		
	}


	@Override
	public void mousePressed(MouseEvent me) {

		JLabel label = (JLabel) me.getSource();
		
//		Icon für NussTower als JLabelIcon
		BufferedImage nutimage = null;
		try {
			nutimage = ImageIO.read(new File("images/palmfinal.gif"));
		} catch (IOException e) { System.exit(0); }
		
//		Icon für Kugeltower als JLabelIcon
		BufferedImage ballimage = null;
		try {
			ballimage = ImageIO.read(new File("images/xmastreefinal.png"));
		} catch (IOException e) { System.exit(0); }
		
//		schaut welches JLabel ausgewählt wurde und setzt das Icon für das Label
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				if (felder[x][y] == label && nuttower.isSelected()) {
					
//					TODO erstelleTower(int art, x, y);
					label.setIcon(new ImageIcon(nutimage));
					mainpanel.repaint();
					
				} else if (felder[x][y] == label && balltower.isSelected()) {
					
//					TODO erstelleTower(int art, x, y);
					label.setIcon(new ImageIcon(ballimage));
					mainpanel.repaint();
					
				}
			}
		}
		
		
	}


	@Override
	public void mouseReleased(MouseEvent me) {
		
	}


}
