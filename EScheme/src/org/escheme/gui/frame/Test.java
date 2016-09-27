package org.escheme.gui.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.escheme.lib.gui.component.ESTextBoxValues;

import info.clearthought.layout.TableLayout;

public class Test extends JFrame{
	public Test(){
//        setSize(450, 450);

		double size[][] = {{10, 25, 25, 10}, // Columns
	            {10, 17, 17, 10}}; // Rows

	       setLayout(new FlowLayout());
	        
	        JPanel pMouse = new JPanel();
	        pMouse.setLayout(new TableLayout(size));
	        pMouse.setBorder(new EmptyBorder(5, 5, 5, 0));
	        add(pMouse);

	        //mouse posizione X
	        JLabel lblMousePosX=new JLabel("<html>Ms<sub>x</sub></html>");
	        ESTextBoxValues valMousePosX=new ESTextBoxValues("0",false);
	        
	        //mouse posizione Y
	        JLabel lblMousePosY=new JLabel("<html>Ms<sub>y</sub></html>");
	        ESTextBoxValues valMousePosY=new ESTextBoxValues("0",false);

	        
	        pMouse.add(lblMousePosX, "1, 1");
	        pMouse. add(valMousePosX, "2, 1");
	        pMouse. add(lblMousePosY, "1, 2");
	        pMouse. add(valMousePosY, "2, 2");
	        
	        /*
	         * ---------------------------------
	         */
	        
	        JPanel pMouseTracker = new JPanel();
	        pMouseTracker.setLayout(new TableLayout(size));
	        pMouseTracker.setBorder(new EmptyBorder(5, 5, 5, 0));
	        add(pMouseTracker);

	        //mouse posizione X
	        JLabel lblMouseTrackerPosX=new JLabel("<html>Mst<sub>x</sub></html>");
	        ESTextBoxValues valMouseTrackerPosX=new ESTextBoxValues("0",false);
	        
	        //mouse posizione Y
	        JLabel lblMouseTrackerPosY=new JLabel("<html>Mst<sub>y</sub></html>");
	        ESTextBoxValues valMouseTrackerPosY=new ESTextBoxValues("0",false);
	        
	        

	        
	        pMouseTracker.add(lblMouseTrackerPosX, "1, 1");
	        pMouseTracker.add(valMouseTrackerPosX, "2, 1");
	        pMouseTracker.add(lblMouseTrackerPosY, "1, 2");
	        pMouseTracker.add(valMouseTrackerPosY, "2, 2");
        
        
    	pack();
		setVisible(true);
	}
}
