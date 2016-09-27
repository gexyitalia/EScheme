package org.escheme.lib.gui.panel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.management.relation.Role;
import javax.swing.JScrollPane;

import org.escheme.Escheme;
import org.escheme.component.ESComponentResistor;
import org.escheme.lib.gui.component.ESDrawComponent;
import org.escheme.lib.gui.workspace.ESMouseTracker;

public class ESDrawPanel extends JScrollPane{ 
	protected static ArrayList<ESDrawComponent> components;
	private Point mousePosition;
	
	private boolean rpLeft,rpRight,rpTop,rpBottom; //flag puntatori righelli per il mouse
	
	private int UID; //ID univoco pannello
	
	public ESMouseTracker mouseTracker;
	
	
	public ESDrawPanel(){
		UID=Escheme.esdm.generateDrawPanelUID(); //genero UID univoco del pannello
		Escheme.esdm.addDrawPanel(this);//aggiungo il pannello a ESDM
		
		components = new ArrayList<ESDrawComponent>();
		components.add(new ESComponentResistor());
		
		mouseTracker=new ESMouseTracker(this);
		mouseTracker.start();
		
		makeRulersPointer(true,true,true,true);
		
		
	}
	
	/**
	 * Restituisce l'ID univoco del pannello
	 * @return integer
	 */
	public int getUID(){
		return UID;
	}
	
	/**
	 * Disegna i puntatori hai righelli per il mouse
	 * @param _left	boolean
	 * @param _right	boolean
	 * @param _top	boolean
	 * @param _bottom	boolean
	 */
	public void makeRulersPointer(boolean _left,boolean _right,boolean _top,boolean _bottom){
		rpLeft=_left;
		rpRight=_right;
		rpTop=_top;
		rpBottom=_bottom;
		addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				repaint();		
			}

		});
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		drawRulersPointersMouse(g);
		drawRulersPointersMouseTrackerMarker(g);
		drawRulersPointersMouseTrackerDistances(g);
		
	}
	
	/**
	 * Disegna i puntatori righelli per il mouse tracker quando è bloccato
	 */
	private void drawRulersPointersMouseTrackerMarker(Graphics g){
		if(mouseTracker.isStoped()){
			g.setColor(Color.RED);
			g.drawLine(mouseTracker.getFollowerPosition().x, mouseTracker.getFollowerPosition().y-10, mouseTracker.getFollowerPosition().x, 0); //puntatore righello verticale superiore(mouse)
			g.drawLine(mouseTracker.getFollowerPosition().x, mouseTracker.getFollowerPosition().y+10, mouseTracker.getFollowerPosition().x, this.getHeight()); //puntatore righello verticale inferiore(mouse)
			g.drawLine(mouseTracker.getFollowerPosition().x-10, mouseTracker.getFollowerPosition().y, 0, mouseTracker.getFollowerPosition().y); //puntatore righello orizzontale sinistro (mouse)
			g.drawLine(mouseTracker.getFollowerPosition().x+10, mouseTracker.getFollowerPosition().y, this.getWidth(), mouseTracker.getFollowerPosition().y); //puntatore righello orizzontale destro(mouse)
		}
	}
	
	/**
	 * Disegna i puntatori righelli per il mouse 
	 */
	private void drawRulersPointersMouse(Graphics g){
		g.setColor(Color.GREEN);
		if(rpTop){
			g.drawLine(mouseTracker.getMousePosition().x, mouseTracker.getMousePosition().y-10, mouseTracker.getMousePosition().x, 0); //puntatore righello verticale superiore(mouse)
		}
		if(rpBottom){
			g.drawLine(mouseTracker.getMousePosition().x, mouseTracker.getMousePosition().y+10, mouseTracker.getMousePosition().x, this.getHeight()); //puntatore righello verticale inferiore(mouse)
		}
		if(rpLeft){
			g.drawLine(mouseTracker.getMousePosition().x-10, mouseTracker.getMousePosition().y, 0, mouseTracker.getMousePosition().y); //puntatore righello orizzontale sinistro (mouse)
		}
		if(rpRight){
			g.drawLine(mouseTracker.getMousePosition().x+10, mouseTracker.getMousePosition().y, this.getWidth(), mouseTracker.getMousePosition().y); //puntatore righello orizzontale destro(mouse)
		}
	}
	
	private void drawRulersPointersMouseTrackerDistances(Graphics g){
		if(mouseTracker.isStoped()){
			g.setColor(Color.ORANGE);
			//linea x
			//linea Y
			//diagonale
			g.drawLine(mouseTracker.getFollowerPosition().x, mouseTracker.getFollowerPosition().y, mouseTracker.getMousePosition().x, mouseTracker.getMousePosition().y);
		}
	}


	//
	//	private Point startPoint, endPoint;
	//
	//	private List<Point[]> lines;
	//
	//	public ESDrawPanel() {
	//		setBackground(Color.WHITE);
	//		
	//		
	//
	//		lines = new ArrayList<>(25);
	//
	//		MouseAdapter ma = new MouseAdapter() {
	//
	//			@Override
	//			public void mousePressed(MouseEvent e) {
	//				startPoint = e.getPoint();
	//			}
	//
	//			@Override
	//			public void mouseReleased(MouseEvent e) {
	//				endPoint = e.getPoint();
	//				Point[] points = new Point[]{startPoint, endPoint};
	//				lines.add(points);
	//				startPoint = null;
	//				endPoint = null;
	//				repaint();
	//			}
	//
	//			@Override
	//			public void mouseDragged(MouseEvent e) {
	//				endPoint = e.getPoint();
	//				repaint();
	//			}
	//
	//		};
	//
	//		addMouseListener(ma);
	//		addMouseMotionListener(ma);
	//	}
	//
	//	@Override
	//	public Dimension getPreferredSize() {
	//		return new Dimension(200, 200);
	//	}
	//
	//	protected void paintComponent(Graphics g) {
	//		super.paintComponent(g);
	//		Graphics2D g2d = (Graphics2D) g.create();
	//		g2d.setColor(Color.BLACK);
	//		//ciclo componenti
	//		for (ESDrawComponent c : components){
	//			int a;
	//			for (ESDrawComponentObject o :c.schematicComponentObjects){
	//				for (int a=0;a<o.areaPoints.size();a+2) {
	//					g2d.drawLine(o.a, o.a, o.a+1, o.a+1);
	//				}
	//			}
	//		}
	//		//		if (startPoint != null && endPoint != null) {
	//		//			g2d.setColor(Color.RED);
	//		//			g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	//		//		}
	//		g2d.dispose();
	//	}
	//	



}

