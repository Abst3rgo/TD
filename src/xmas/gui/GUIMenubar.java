package xmas.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUIMenubar extends JMenuBar implements ActionListener {
	
	private JMenu close, submenuSize;
	private JMenuItem closeItem;
	
	public GUIMenubar() {
		
//		Menuelements
		close = new JMenu("Game");
		close.setMnemonic(KeyEvent.VK_G);
		add(close);
		
		
//		In-Menuelements
		closeItem = new JMenuItem("Close");
		closeItem.addActionListener(this);
		closeItem.setMnemonic(KeyEvent.VK_C);
		
//		SubMenu Size
		submenuSize = new JMenu("Select Size");
		submenuSize.setMnemonic(KeyEvent.VK_S);
		
//		add In-Menuelements
		close.add(submenuSize);
		close.addSeparator();
		close.add(closeItem);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == closeItem) {
			System.exit(0);
		}
	}

}
