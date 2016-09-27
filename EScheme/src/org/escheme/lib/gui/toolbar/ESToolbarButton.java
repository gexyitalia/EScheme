package org.escheme.lib.gui.toolbar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ESToolbarButton extends JButton{
	public ESToolbarButton(String _iconPath,String _toolTipText){
		setIcon(new ImageIcon(_iconPath));
		setBorderPainted(false);
		setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(2,2,2,2),new EmptyBorder(2,2,2,2)));
	}
}
