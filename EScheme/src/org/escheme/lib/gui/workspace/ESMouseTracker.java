package org.escheme.lib.gui.workspace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.escheme.lib.gui.panel.ESDrawPanel;
import org.escheme.lib.utils.Pitagora;

public class ESMouseTracker {
	private boolean mouseTracking;
	private Point followerPosition;
	private Point mousePosition;
	private ESDrawPanel drawPanel;
	
	private Pitagora pitagora;
	
	/**
	 * 
	 * @param _drawPanel ESDrawPanel
	 */
	public ESMouseTracker(ESDrawPanel _drawPanel) {
		drawPanel=_drawPanel;
		followerPosition=new Point();
		mousePosition=new Point();
		
		pitagora = new Pitagora();
		
		
		mouseTracker();
	}
	
	
	
	/**
	 * Abilita il tracking del mouse
	 */
	public void start(){
		mouseTracking=true;
		
	}
	
	/**
	 * Disabilita il tracking del mouse
	 */
	public void stop(){
		mouseTracking=false;
	}
	
	/**
	 * Restituisce true se il trackong del mouse è disabilitato, false se è abilitato
	 * @return boolean
	 */
	public boolean isStoped(){
		if(mouseTracking){return false;}else{return true;}
	}
	
	/**
	 * Restituisce la posizione attuale del mouse
	 * @return Point
	 */
	public Point getMousePosition(){
		return mousePosition;
	}
	
	/**
	 * Restituisce la posizione attuale del mouse follower
	 * @return
	 */
	public Point getFollowerPosition(){
		return followerPosition;
	}
	
	/**
	 * traccia la posizione del mouse
	 */
	private void mouseTracker(){
		/*
		 * Controllo posizione del mouse
		 */
		drawPanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				
				mousePosition.x=e.getX();
				mousePosition.y=e.getY();
				
				if(mouseTracking){
					followerPosition.x=e.getX();
					followerPosition.y=e.getY();
					System.out.println(String.valueOf(calcDiagonalSize()));
				}
//				
			}

		});
	}
	
	/**
	 * Calcola la lunghezza della diagonale
	 * @return double
	 */
	private double calcDiagonalSize(){
		
		return Math.abs(
				pitagora.getIpotenusa(
						(double)(followerPosition.x-mousePosition.x), 
						(double)(followerPosition.y-mousePosition.y)
						)
				);
	}
	
}
