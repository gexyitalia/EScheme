/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escheme.gui.panel;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.escheme.lib.gui.panel.ESPanel;

/**
 *
 * @author eugenio
 */
public class ESPanelProperties extends ESPanel {
	
	private static final long serialVersionUID = 8774819911591971746L;
	private static JScrollPane scroller;
	private static JTable table;
	private DefaultTableModel tableModel; 
    public ESPanelProperties() {
    	super("Proprietà");
    	table = new JTable();
		
		tableModel = new DefaultTableModel(new String[] {"ID", "Data"  },0);
		table.setModel(tableModel);
		table.setTableHeader(null);
		scroller = new JScrollPane(table);
		add(scroller);

    }
    
    /**
	 * Setta le dimensioni del pannello
	 */
	public void setSize(Dimension _dimension){
		super.setSize(_dimension);
		super.setPreferredSize(_dimension);
		scroller.setPreferredSize(_dimension);
		scroller.setSize(getPreferredSize());
	}


	/**
	 * Aggiunge una nuova proprietà all'elenco
	 * @param _name	String Nome della proprietà(lato sinistro)
	 * @param _value String Valore della proprietà(lato destro)
	 */
	public void addProperty(String _name, String _value){
		tableModel.addRow(new Object[] { _name,_value});
	}
    
}
