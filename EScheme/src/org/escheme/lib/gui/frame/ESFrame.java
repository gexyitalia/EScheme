package org.escheme.lib.gui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.escheme.Escheme;


public class ESFrame extends JFrame{
	private static final long serialVersionUID = -2455826387473530762L;

	public ESFrameAttributes frameInitAttr; //settaggio iniziale del frame
	private int UID=-1; //id univoco del frame

	public Font font; //font

	protected JPanel container; //contenitore globale
	ESFrameTitleBar winTitleBar; //titolo e controlli finestra

	public ESFrame(){
		frameInitAttr=new ESFrameAttributes();
		init();
	}
	public ESFrame(ESFrameAttributes attr){
		frameInitAttr=attr;
		init();


	}



	/**
	 * Applica la configurazione iniziale per il frame
	 */
	private void init(){
		UID=Escheme.esdm.generateFrameUID(); //genero UID univoco del frame
		Escheme.esdm.addFrame(this);//aggiungo il frame a ESDM
		

		//collegamento al metodo per la chiusura delle finestre
		//le classi estese da questa implementano il metodo frameClosing 
		//per le azioni della chhiusura della finestra
		//chiusura finestra
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				//manca rimozione del frame da ESDM
				frameClosing();
			}
		});

		/*---------------------------------
		 * UI
		 * ------------------------------*/
		setPreferredSize(new Dimension(frameInitAttr.width,frameInitAttr.height)); //dimensione iniziale
		setTitle(frameInitAttr.title);
		/*
		 * ---------------------------------
		 */
	}

	/**
	 * Setta il frame al centro dello schermo
	 */
	public void setPositionCenter(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width - 500) / 2,(screen.height - 300)/2);
	}

	/**
	 * Implementa l'azione di chiusura della finestra
	 */
	protected void frameClosing(){}

	/**
	 * Distrugge il frame
	 */
	public void close(){
		Escheme.esdm.removeFrame(UID);
		dispose();
	}

	/**
	 * Va utilizzata dall'utente per implementare la finestra e le sue parti
	 */
	protected void createGUI(){}

	/**
	 * Restituisce l'ID univoco del frame
	 * @return int
	 */
	public int getUID(){return UID;}
}
