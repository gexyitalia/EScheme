package org.escheme.lib.gui.component;

import java.awt.Dimension;
import java.util.ArrayList;

import org.escheme.lib.gui.panel.ESDrawPanel;

public class ESDrawComponent {
	Dimension objArea; //area occupata dall'oggetto
	public static ArrayList<ESDrawComponentObject> schematicComponentObjects = new ArrayList<ESDrawComponentObject>(); //cmponenti dell'oggetto nello schema
	public static ArrayList<ESDrawComponentObject> boardComponentObjects = new ArrayList<ESDrawComponentObject>(); //componenti dell'oggetto nella board
	
	private String name;
	
	public ESDrawComponent(){
		
	}
	
	public String getName(){
		return name;
	}
	
	protected void setName(String _name){
		name=_name;
	}
	
	public void drawESComponent(ESDrawPanel _panel){
		
	}
	
	
}
