package org.escheme.gui.frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import info.clearthought.layout.TableLayout;

public class Test extends JFrame{
	private JPanel lyPositions;
	public Test(){
		
		lyPositions= new JPanel();
		add(lyPositions);
		lyPositions.setBackground(Color.BLUE);
//    	panelLayers.add(lyPositions, 1);
    	
		double size[][] =
            {{10, 10},
             {20,20}};

		lyPositions.setLayout (new TableLayout(size));
        
    	lyPositions.add(new JLabel("X"),"1,1");
    	lyPositions.add(new JLabel("Y"),"1,2");
    	lyPositions.add(new JLabel("ciao"),"2,1");
    	
    	pack();
		setVisible(true);
	}
}
