package xmas.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUIMenubar extends JMenuBar implements ActionListener {
	
	private JMenu game, submenuSize;
	private JMenuItem closeItem, newGameItem;
	
	public GUIMenubar() {
		
//		Menuelements
		game = new JMenu("Game");
		game.setMnemonic(KeyEvent.VK_G);
		add(game);
		
		
//		In-Menuelements
		closeItem = new JMenuItem("Close");
		closeItem.addActionListener(this);
		closeItem.setMnemonic(KeyEvent.VK_C);
		newGameItem = new JMenuItem("new Game");
		newGameItem.addActionListener(this);
		newGameItem.setMnemonic(KeyEvent.VK_N);
		
//		SubMenu Size
		submenuSize = new JMenu("Select Size");
		submenuSize.setMnemonic(KeyEvent.VK_S);
		
//		add In-Menuelements
//		close.add(submenuSize);
		game.add(newGameItem);
		game.addSeparator();
		game.add(closeItem);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == closeItem) {
			System.exit(0);
		}
	}

}
