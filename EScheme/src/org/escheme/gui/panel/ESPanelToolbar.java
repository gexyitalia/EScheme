package org.escheme.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import org.escheme.lib.gui.panel.ESTaddedPane;
import org.escheme.lib.gui.panel.ESTaddedPaneUI;
import org.escheme.lib.gui.toolbar.ESToolbarButton;
import org.escheme.Escheme;
import org.escheme.lib.gui.panel.ESPanel;

public class ESPanelToolbar extends JPanel {
	private ESTaddedPane desk;
	public ESPanelToolbar(){
		//tabs dei file aperti
		desk = new ESTaddedPane();
		//		desk.setUI(new ESTaddedPaneUI());

		//UI
		desk.setFont(new Font(Escheme.esdm.getFont().getName(), Font.PLAIN, 11));
		UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0));
		UIManager.getDefaults().put("TabbedPane.tabsOverlapBorder", true);
		

		add( desk, new FlowLayout());

		/*
		 * toolbar generale
		 */
		JToolBar tbGeneral = new JToolBar("Generale", JToolBar.HORIZONTAL);
		tbGeneral.setFloatable( false);
		desk.addTab("Generale",tbGeneral );

		//salva copia
		ESToolbarButton btnSaveCopy = new ESToolbarButton("icons/savecopy.png", "Salva copia");
		tbGeneral.add(btnSaveCopy);

		//blocca oggetto
		ESToolbarButton btnLockObj= new ESToolbarButton("icons/lock.png", "Sposta");
		tbGeneral.add(btnLockObj);

		//Zoom +
		ESToolbarButton btnZoomPlus= new ESToolbarButton("icons/magnifier-zoom-in.png", "Zoom +");
		tbGeneral.add(btnZoomPlus);

		//Zoom -
		ESToolbarButton btnZoomMinus= new ESToolbarButton("icons/magnifier-zoom-out.png", "Zoom -");
		tbGeneral.add(btnZoomMinus);

		//Zoom default
		ESToolbarButton btnZoomDefault= new ESToolbarButton("icons/magnifier-zoom-actual.png", "Zoom default");
		tbGeneral.add(btnZoomDefault);

		//Zoom + su oggetto selezionato
		ESToolbarButton btnZoomObject= new ESToolbarButton("icons/magnifier-zoom-actual-equal.png", "Zoom su oggetto selezionato");
		tbGeneral.add(btnZoomObject);

		//Zoom + selezione
		ESToolbarButton btnZoomSelection= new ESToolbarButton("icons/magnifier-zoom-fit.png", "Zoom con selezione");
		tbGeneral.add(btnZoomSelection);

		//marcatore oggetto
		ESToolbarButton btnObjMarker= new ESToolbarButton("icons/marker.png", "Zoom con selezione");
		tbGeneral.add(btnObjMarker);


		//Clipboard
		ESToolbarButton btnClipboardManage= new ESToolbarButton("icons/clipboard--pencil.png", "Clipboard");
		tbGeneral.add(btnClipboardManage);

		//calcolatrice
		ESToolbarButton btnCalc= new ESToolbarButton("icons/calculator.png", "Calcolatrice");
		tbGeneral.add(btnCalc);

		/*
		 * toolbar maneggia
		 */
		JToolBar tbManage = new JToolBar("Maneggia", JToolBar.HORIZONTAL);
		tbManage.setFloatable( false);
		desk.addTab("Maneggia",tbManage );

		//sposta/ruota
		ESToolbarButton btnMove = new ESToolbarButton("icons/arrow-move.png", "Muovi");
		tbManage.add(btnMove);

		//sposta/ruota speciale
		ESToolbarButton btnMoveSpecial = new ESToolbarButton("icons/arrow-step.png", "Muovi speciale");
		tbManage.add(btnMoveSpecial);

		//Aggiungi Oggetto
		ESToolbarButton btnObjAdd = new ESToolbarButton("icons/block--plus.png", "Aggiungi oggetto");
		tbManage.add(btnObjAdd);

		//Clona Oggetto
		ESToolbarButton btnObjClone = new ESToolbarButton("icons/block--arrow.png", "Aggiungi oggetto");
		tbManage.add(btnObjClone);

		//raggruppa
		ESToolbarButton btnGroupAdd = new ESToolbarButton("icons/jar--plus.png", "Sposta");
		tbManage.add(btnGroupAdd);

		//Separa
		ESToolbarButton  btnGroupDel= new ESToolbarButton("icons/jar--minus.png", "Sposta");
		tbManage.add(btnGroupDel);

		//link curvo
		ESToolbarButton btnLinkCurve = new ESToolbarButton("icons/layer-shape-curve.png", "Sposta");
		tbManage.add(btnLinkCurve);

		//link dritto
		ESToolbarButton btnLinkLine= new ESToolbarButton("icons/layer-shape-line.png", "Sposta");
		tbManage.add(btnLinkLine);

		//link angolato
		ESToolbarButton btnLinkPolyline= new ESToolbarButton("icons/layer-shape-polyline.png", "Sposta");
		tbManage.add(btnLinkPolyline);



		/*
		 * toolbar storia
		 */
		JToolBar tbHistory = new JToolBar("Storia", JToolBar.HORIZONTAL);
		tbHistory.setFloatable( false);
		desk.addTab("Storia",tbHistory );

		//indietro
		ESToolbarButton btnUndo = new ESToolbarButton("icons/arrow-curve-180.png", "Indietro");
		tbHistory.add(btnUndo);

		//avanti
		ESToolbarButton btnRedo = new ESToolbarButton("icons/arrow-curve-000-left.png", "Avanti");
		tbHistory.add(btnRedo);

		//ripeti ultimo
		ESToolbarButton btnRepeteLast = new ESToolbarButton("icons/arrow-repeat-once.png", "Ripeti ultimo evento");
		tbHistory.add(btnRepeteLast);

		/*
		 * toolbar documentazione
		 */
		JToolBar tbDocumentation = new JToolBar("Documentazinoe", JToolBar.HORIZONTAL);
		tbDocumentation.setFloatable( false);
		desk.addTab("Documentazine",tbDocumentation );

		//Commenti
		ESToolbarButton btnNotes = new ESToolbarButton("icons/balloon-left.png", "Commenti");
		tbDocumentation.add(btnNotes);


	}

	/**
	 * Setta le dimensioni del pannello
	 */
	public void setSize(Dimension _dimension){
		desk.setPreferredSize(_dimension);
		desk.setSize(_dimension);
		super.setSize(_dimension);
		super.setPreferredSize(_dimension);
	}
}