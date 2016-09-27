/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escheme.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.escheme.lib.gui.component.ESTextBoxValues;
import org.escheme.lib.gui.panel.ESPanel;

import info.clearthought.layout.TableLayout;


/**
 *
 */
public class ESPanelWorkspaceInfo extends ESPanel {
	
	private static final long serialVersionUID = 8774819911591971746L;
	private static JScrollPane scroller;
	private JLayeredPane panelLayers;
	private JPanel lyPositions;
	
	/*
	 * Box valori
	 */
	public ESTextBoxValues valMousePosX,valMousePosY,valMouseTrackerPosY,valMouseTrackerPosX,valMouseTrackerDiagonal;
	
    public ESPanelWorkspaceInfo() {
    	super();
    	createUI();
    }
    
    /**
	 * Setta le dimensioni del pannello
	 */
	public void setSize(Dimension _dimension){
		super.setSize(_dimension);
		super.setPreferredSize(_dimension);
		
//		scroller.setPreferredSize(_dimension);
//		scroller.setSize(getPreferredSize());
//		panelLayers.setPreferredSize(_dimension);
	}
	
	private void createUI(){
		setBorder(new EmptyBorder(0,0,0,0));
		//creo i layers standard
    	/*
    	 * layer distanze e posizioni
    	 */
    	createUILayerPosition();
//		scroller = new JScrollPane(panelLayers); //scroller per il pannello layer
//		add(scroller);
	}
	
	private void createUILayerPosition(){
		

	       setLayout(new FlowLayout(FlowLayout.LEFT));
	        
	        JPanel pMouse = new JPanel();
	        
	        double pMouseSize[][] = {{25, 25}, // Columns
		            {17, 17}}; // Rows
	        
	        pMouse.setLayout(new TableLayout(pMouseSize));
	        pMouse.setBackground(Color.BLUE);
//	        pMouse.setBorder(new EmptyBorder(0,0,0,0));
	        add(pMouse);

	        //mouse posizione X
	        JLabel lblMousePosX=new JLabel("<html>Ms<sub>x</sub></html>");
	        ESTextBoxValues valMousePosX=new ESTextBoxValues("0",false);
	        
	        //mouse posizione Y
	        JLabel lblMousePosY=new JLabel("<html>Ms<sub>y</sub></html>");
	        ESTextBoxValues valMousePosY=new ESTextBoxValues("0",false);

	        
	        pMouse.add(lblMousePosX, "0, 0");
	        pMouse. add(valMousePosX, "1, 0");
	        pMouse. add(lblMousePosY, "0, 1");
	        pMouse. add(valMousePosY, "1, 1");
	        
	        /*
	         * ---------------------------------
	         */
	        
	        JPanel pMouseTracker = new JPanel();
	        
	        double pMouseTrackerSize[][] = {{25, 25,25,25}, // Columns
		            {17, 17}}; // Rows
	        
	        pMouseTracker.setLayout(new TableLayout(pMouseTrackerSize));
	        pMouseTracker.setBorder(new EmptyBorder(5, 5, 5, 0));
	        add(pMouseTracker);

	        //mouse tracker X
	        JLabel lblMouseTrackerPosX=new JLabel("<html>Mst<sub>x</sub></html>");
	        ESTextBoxValues valMouseTrackerPosX=new ESTextBoxValues("0",false);
	        
	        //mouse tracker Y
	        JLabel lblMouseTrackerPosY=new JLabel("<html>Mst<sub>y</sub></html>");
	        ESTextBoxValues valMouseTrackerPosY=new ESTextBoxValues("0",false);
	        
	      //mouse tracker diagonale
	        JLabel lblMouseTrackerDiagonal=new JLabel("<html>Mst<sub>d</sub></html>");
	        ESTextBoxValues valMouseTrackerDiagonal=new ESTextBoxValues("0",false);
	        
	        

	        
	        pMouseTracker.add(lblMouseTrackerPosX, "0,0");
	        pMouseTracker.add(valMouseTrackerPosX, "1, 0");
	        pMouseTracker.add(lblMouseTrackerPosY, "0, 1");
	        pMouseTracker.add(valMouseTrackerPosY, "1, 1");
	        pMouseTracker.add(lblMouseTrackerDiagonal, "2, 0");
	        pMouseTracker.add(valMouseTrackerDiagonal, "3, 0");
	}
}
