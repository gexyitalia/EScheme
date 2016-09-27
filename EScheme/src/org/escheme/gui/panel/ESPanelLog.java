package org.escheme.gui.panel;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.escheme.lib.gui.panel.ESPanel;

public class ESPanelLog extends ESPanel{
	private static final long serialVersionUID = 660973348476781544L;
	private static JScrollPane scroller;
	private static JTable table;
	private DefaultTableModel tableModel; 
	
	public static  final int LEVEL_DEBUG = 0;
	public static final int LEVEL_INFO = 1;
	public static final int LEVEL_WORNING = 2;
	public static final int LEVEL_ERROR = 3;
	public static final int LEVEL_CUSTOM = 4;
	
	public ESPanelLog(){
		super("Log viewer");
		table = new JTable();
		
		tableModel = new DefaultTableModel(new String[] {"ID", "Data", "Livello","Messaggio"  },0);
		table.setModel(tableModel);

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
	 * Scrive un messaggio al log
	 * @param _level
	 * @param _message
	 */
	public void writeMessage(int _level, String _message){
		tableModel.addRow(new Object[] { 0,"data", _level,_message });
	}
	
	/**
	 * Scrive un messaggio nel pannello log
	 * @param _message
	 */
	public void writeMessage(String _message){
		tableModel.addRow(new Object[] { 0,"data", LEVEL_CUSTOM,_message });
	}
	
	/**
	 * Restituisce il totale dei messaggi visualizzati nella tabella di log(non quelli effettivamente esistenti nel log)
	 * @return Integer
	 */
	public int getTotalVisibleRows(){
		return tableModel.getRowCount();
	}
}
