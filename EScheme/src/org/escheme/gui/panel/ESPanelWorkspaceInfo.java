/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escheme.gui.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		lyPositions.setPreferredSize(_dimension);
	}
	
	private void createUI(){
		//creo i layers standard
    	panelLayers = new JLayeredPane();
    	
    	/*
    	 * layer distanze e posizioni
    	 */
    	createUILayerPosition();
    	add(lyPositions);
//		scroller = new JScrollPane(panelLayers); //scroller per il pannello layer
//		add(scroller);
	}
	
	private void createUILayerPosition(){
		lyPositions= new JPanel();
		lyPositions.setBackground(Color.BLUE);
//    	panelLayers.add(lyPositions, 1);
    	
		double size[][] =
            {{10, 10},
             {20,20}};

		lyPositions.setLayout (new TableLayout(size));
        
    	lyPositions.add(new JLabel("X"),"1,1");
    	lyPositions.add(new JLabel("Y"),"1,2");
    	lyPositions.add(new JLabel("ciao"),"2,1");
	}
}
