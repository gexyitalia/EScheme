package org.escheme.lib.gui.component;

import java.awt.Point;
import java.util.ArrayList;

public class ESDrawComponentObjectPin extends ESDrawComponentObject{
	//Contengono le coordinate per disegnare l'oggetto
	private static ArrayList<Point> areaPoints = new ArrayList<Point>();
	
	private static int type; //contiene il tipo di oggetto
	private static String note; //note
	private static String text; //Stringa associata(da stampare nel desk)
	
	/*
	 * Tipo di oggetto
	 * TYPE_CONNECTOR 	PIN/Connettore
	 */
	public static final int TYPE_CONNECTOR=0;
	
	public ESDrawComponentObjectPin(ArrayList<Point> _areaPoints,int _type,String _text){
		areaPoints=_areaPoints;
		text=_text;
		type=_type;
	}
	
	public ESDrawComponentObjectPin(){}
	
	/**
	 * restituisce il numero di punti
	 * @return
	 */
	public int getPointsSize(){
		return areaPoints.size();
	}
	
	/**
	 * Restituisce un punto in base all'indice
	 * @param _index
	 * @return
	 */
	public Point getPoint(int _index){
		return areaPoints.get(_index);
	}
	
	/**
	 * Setta le coordinate dell'oggetto
	 * @param _index
	 * @param _x
	 * @param _y
	 * @return
	 */
	protected boolean setPoint(int _index,int _x,int _y){
		if(areaPoints.size()>=_index){
			areaPoints.add(new Point(_x,_y));
		}else if(_index<0){
			return false;
		}
		return true;
	}
	
	/**
	 * Crea un nuovo punto
	 * @param _x1	Integer
	 * @param _y1	Integer
	 * @param _x2	Integer
	 * @param _y2	Integer
	 */
	protected void addPoint(int _x1, int _y1, int _x2, int _y2){
		areaPoints.add(new Point(_x1,_y1));
		areaPoints.add(new Point(_x2,_y2));
	}
	
	/**
	 * Setta il tipo di oggetto del componente
	 * @param _type
	 * @return
	 */
	protected boolean setType(int _type){
		type=_type;
		return true;
	}
	
	/**
	 * Restituisce il tipo di oggetto del comonente
	 * @return
	 */
	public int getType(){
		return type;
	}
	
	/**
	 * restituisce la stringa associata all'oggetto
	 * @return String
	 */
	public String getText(){
		return text;
	}
	
	/**
	 * Setta la string associata all'oggetto
	 * @param _text String 
	 */
	public void setText(String _text){
		text=_text;
	}
	
	/**
	 * Restituisce le note per l'oggetto
	 * @return String 
	 */
	public String getNote(){
		return note;
	}
	
	/**
	 * Setta le note per l'oggetto
	 * @param _text String
	 */
	public void setNote(String _text){
		note=_text;
	}
	
	
}
