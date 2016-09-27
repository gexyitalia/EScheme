package org.escheme.gui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import org.escheme.Escheme;
import org.escheme.gui.panel.ESPanelLog;
import org.escheme.gui.panel.ESPanelProperties;
import org.escheme.gui.panel.ESPanelToolbar;
import org.escheme.gui.panel.ESPanelWorkspaceInfo;
import org.escheme.lib.gui.frame.ESFrame;
import org.escheme.lib.gui.menu.ESMenu;
import org.escheme.lib.gui.menu.ESMenuBar;
import org.escheme.lib.gui.menu.ESMenuItem;
import org.escheme.lib.gui.panel.ESDrawPanel;
import org.escheme.lib.gui.panel.ESPanelContainer;
import org.escheme.lib.gui.panel.ESTaddedPane;

/**
 * Questo Frame serve per la progettazione degli schemi
 * @author eugenio
 *
 */
public class ESFramePrjScheme extends ESFrame{
	private static final long serialVersionUID = -2400721423473583701L;

	public static ESTaddedPane desk; //tabs per i file aperti
	public static ESPanelContainer panelContainerLeft; //cotenutore dei pannelli sx
	public static ESPanelContainer panelContainerRight; //cotenutore dei pannelli dx
	public static ESPanelContainer panelContainerBottom; //cotenutore dei pannelli bottom
	public static ESPanelContainer panelContainerTop; //cotenutore dei pannelli top


	//costruttore
	public ESFramePrjScheme(){
		setTitle("EScheme - Schematic IDE");


		setPreferredSize(new Dimension(800,600)); //dimensione predefinita

		setExtendedState(ESFrame.MAXIMIZED_BOTH); //apre finestra massimizzata

		//menu top
		super.setJMenuBar(createMenuBar());

		//tabs dei file aperti
		desk = new ESTaddedPane();
		//UI
		desk.setFont(new Font(desk.getFont().getName(), Font.PLAIN, 11));
		UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0));
		UIManager.getDefaults().put("TabbedPane.tabsOverlapBorder", true);
		getContentPane().add( desk, BorderLayout.CENTER );


		loadWorkspace(); //configura i pannelli e altri componenti della finestra

		addFileToDesk("Nuovo");


		pack();
		setVisible(true);
		
		Test tt = new Test();
	} 

	/**
	 * Chiusura finestra
	 */
	@Override
	protected void frameClosing(){
		//uso un altro metodo per poterlo richiamare anche, ad esempio, dal menu file>exit
		miExitAct();
	}

	/**
	 * Crea la barra menu
	 * 
	 * usare Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()) per il tasto WIN o equivalente del mac
	 * fare riferimento a questo url per i tasti http://docs.oracle.com/javase/7/docs/api/javax/swing/KeyStroke.html#getKeyStroke%28int,%20int%29
	 */
	protected ESMenuBar createMenuBar() {
		//Costruzione della menuBar
		ESMenuBar menuBar = new ESMenuBar();
		ESMenu menuFile = new ESMenu("File");

		ESMenuItem miNew = new ESMenuItem("Nuovo");
		miNew.setAccelerator(KeyStroke.getKeyStroke('N', ActionEvent.CTRL_MASK));

		ESMenuItem miOpen = new ESMenuItem("Apri");
		miOpen.setAccelerator(KeyStroke.getKeyStroke('O', ActionEvent.CTRL_MASK));

		ESMenu menuOpenRecent = new ESMenu("Apri recenti");
		ESMenuItem miOpenRecentLastFile = new ESMenuItem("Apri l'ultimo file");
		miOpenRecentLastFile.setAccelerator(KeyStroke.getKeyStroke('F', ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK+ActionEvent.SHIFT_MASK));
		menuOpenRecent.add(miOpenRecentLastFile);
		menuOpenRecent.addSeparator();

		ESMenuItem miClose = new ESMenuItem("Chiudi");
		miClose.setAccelerator(KeyStroke.getKeyStroke('W', ActionEvent.CTRL_MASK));

		ESMenuItem miCloseAll = new ESMenuItem("Chiudi tutti");

		ESMenuItem miSave = new ESMenuItem("Salva");
		miSave.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));

		ESMenuItem miSaveAs = new ESMenuItem("Salva con nome");
		miSaveAs.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK));

		ESMenuItem miSaveCopy = new ESMenuItem("Salva copia");
		miSaveCopy.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));

		ESMenuItem miSaveAll = new ESMenuItem("Salva tutti");
		ESMenuItem miImport = new ESMenuItem("Importa");
		ESMenuItem miExport = new ESMenuItem("Esporta");

		ESMenuItem miPrint = new ESMenuItem("Stampa");
		miPrint.setAccelerator(KeyStroke.getKeyStroke('P', ActionEvent.CTRL_MASK));

		ESMenuItem miProperies = new ESMenuItem("Proprietà");
		ESMenuItem miOptions = new ESMenuItem("Opzioni");
		ESMenuItem miExit = new ESMenuItem("Esci");

		menuFile.add(miNew);
		menuFile.add(miOpen);
		menuFile.add(menuOpenRecent);
		menuFile.addSeparator();
		menuFile.add(miClose);
		menuFile.add(miCloseAll);
		menuFile.addSeparator();
		menuFile.add(miProperies);
		menuFile.addSeparator();
		menuFile.add(miSave);
		menuFile.add(miSaveAs);
		menuFile.add(miSaveCopy);
		menuFile.add(miSaveAll);
		menuFile.addSeparator();
		menuFile.add(miImport);
		menuFile.add(miExport);
		menuFile.addSeparator();
		menuFile.add(miPrint);
		menuFile.addSeparator();
		menuFile.add(miOptions);
		menuFile.addSeparator();
		menuFile.add(miExit);

		//nuovo
		miNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miNewAct();
			}
		});

		//esci
		miExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miExitAct();
			}
		});

		//-----------------------------------------
		ESMenu menuEdit = new ESMenu("Edit");

		ESMenuItem miUndo = new ESMenuItem("Indietro");
		miUndo.setAccelerator(KeyStroke.getKeyStroke('Z', ActionEvent.CTRL_MASK));

		ESMenuItem miRedo = new ESMenuItem("Avanti");
		miRedo.setAccelerator(KeyStroke.getKeyStroke('Z', ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));

		ESMenuItem miHistory = new ESMenuItem("Storico");
		miHistory.setAccelerator(KeyStroke.getKeyStroke('H', ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));

		ESMenuItem miCut = new ESMenuItem("Taglia");
		miCut.setAccelerator(KeyStroke.getKeyStroke('X', ActionEvent.CTRL_MASK));

		ESMenuItem miCopy = new ESMenuItem("Copia");
		miCopy.setAccelerator(KeyStroke.getKeyStroke('C', ActionEvent.CTRL_MASK));

		ESMenuItem miPaste = new ESMenuItem("Incolla");
		miPaste.setAccelerator(KeyStroke.getKeyStroke('V', ActionEvent.CTRL_MASK));

		ESMenuItem miPasteSpecial = new ESMenuItem("Incolla speciale");
		miPasteSpecial.setAccelerator(KeyStroke.getKeyStroke('V', ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));

		ESMenuItem miSelectAll= new ESMenuItem("Seleziona tutto");
		miSelectAll.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK));

		ESMenuItem miSelectIvert = new ESMenuItem("Seleziona inverso");
		miSelectIvert.setAccelerator(KeyStroke.getKeyStroke('I', ActionEvent.CTRL_MASK));

		ESMenuItem miSelectSpecial = new ESMenuItem("Seleziona speciale");
		miSelectSpecial.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));

		ESMenuItem miFindSost = new ESMenuItem("Cerca/Sostituisci");
		miFindSost.setAccelerator(KeyStroke.getKeyStroke('F', ActionEvent.CTRL_MASK));

		ESMenuItem miRefactoring = new ESMenuItem("Refactoring");

		ESMenuItem miZoomPlus = new ESMenuItem("Zoom +");
		miZoomPlus.setAccelerator(KeyStroke.getKeyStroke('+', ActionEvent.CTRL_MASK));

		ESMenuItem miZoomMinus = new ESMenuItem("Zoom -");
		miZoomMinus.setAccelerator(KeyStroke.getKeyStroke('-', ActionEvent.CTRL_MASK));

		menuEdit.add(miUndo);
		menuEdit.add(miRedo);
		menuEdit.add(miHistory);
		menuEdit.addSeparator();
		menuEdit.add(miCut);
		menuEdit.add(miCopy);
		menuEdit.add(miPaste);
		menuEdit.add(miPasteSpecial);
		menuEdit.addSeparator();
		menuEdit.add(miSelectAll);
		menuEdit.add(miSelectIvert);
		menuEdit.add(miSelectSpecial);
		menuEdit.addSeparator();
		menuEdit.add(miFindSost);
		menuEdit.add(miRefactoring);
		menuEdit.addSeparator();
		menuEdit.add(miZoomPlus);
		menuEdit.add(miZoomMinus);

		//-----------------------------------------
		ESMenu menuPrj = new ESMenu("Progetto");

		ESMenuItem miPrjClose = new ESMenuItem("Chiudi");
		//            miUndo.setAccelerator(KeyStroke.getKeyStroke('Z', ActionEvent.CTRL_MASK));

		ESMenuItem miPrjDocumentation = new ESMenuItem("Documentazione");

		ESMenuItem miPrjProperty= new ESMenuItem("Proprietà");

		ESMenuItem miPrjComponents= new ESMenuItem("Componenti");

		menuPrj.add(miPrjClose);
		menuPrj.addSeparator();
		menuPrj.add(miPrjDocumentation);
		menuPrj.addSeparator();
		menuPrj.add(miPrjProperty);
		menuPrj.addSeparator();
		menuPrj.add(miPrjComponents);

		//-----------------------------------------
		ESMenu menuWorkspace = new ESMenu("Workspace");

		ESMenu menuWorkspacePanels = new ESMenu("Finestre e pannelli");

		ESMenuItem miWSPProjectExplorer = new ESMenuItem("Project explorer");
		menuWorkspacePanels.add(miWSPProjectExplorer);

		ESMenuItem miWSPLog = new ESMenuItem("Log");
		menuWorkspacePanels.add(miWSPLog);

		ESMenuItem miWSPBlocnote = new ESMenuItem("Blocnote");
		menuWorkspacePanels.add(miWSPBlocnote);

		ESMenuItem miWSPTools = new ESMenuItem("Strumenti");
		menuWorkspacePanels.add(miWSPTools);

		ESMenuItem miWSPComponents = new ESMenuItem("Componenti");
		menuWorkspacePanels.add(miWSPComponents);

		ESMenuItem miWSPProperty = new ESMenuItem("Proprietà");
		menuWorkspacePanels.add(miWSPProperty);

		ESMenuItem miWSPClipbopard= new ESMenuItem("Clipboard");
		menuWorkspacePanels.add(miWSPClipbopard);

		ESMenuItem miWSPESDM= new ESMenuItem("ESDM");
		menuWorkspacePanels.add(miWSPESDM);

		menuWorkspace.add(menuWorkspacePanels);

		menuWorkspace.addSeparator();

		//gestore interfaccia
		miWSPESDM.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miWSPESDMAct();
			}
		});

		/*
		 * puntatore righelli
		 */
		ESMenu menuWorkspaceRulersPointers = new ESMenu("Puntatori righelli");
		JCheckBoxMenuItem miWSPRPRight= new JCheckBoxMenuItem("Destro",true);
		menuWorkspaceRulersPointers.add(miWSPRPRight);
		JCheckBoxMenuItem miWSPRPLeft= new JCheckBoxMenuItem("Sinistro",true);
		menuWorkspaceRulersPointers.add(miWSPRPLeft);
		JCheckBoxMenuItem miWSPRPTop= new JCheckBoxMenuItem("Superiore",true);
		menuWorkspaceRulersPointers.add(miWSPRPTop);
		JCheckBoxMenuItem miWSPRPBottom= new JCheckBoxMenuItem("Inferiore",true);
		menuWorkspaceRulersPointers.add(miWSPRPBottom);

		menuWorkspaceRulersPointers.addSeparator();

		ESMenuItem miWSPRPAll= new ESMenuItem("Attiva/disattiva tutti");
		miWSPRPAll.setAccelerator(KeyStroke.getKeyStroke('P', ActionEvent.ALT_MASK+ActionEvent.SHIFT_MASK));
		menuWorkspaceRulersPointers.add(miWSPRPAll);


		menuWorkspace.add(menuWorkspaceRulersPointers);

		//miWSPRPRight
		miWSPRPRight.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miWSPRPAct(miWSPRPLeft,miWSPRPRight,miWSPRPTop,miWSPRPBottom);
			}
		});
		//miWSPRPLeft
		miWSPRPLeft.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miWSPRPAct(miWSPRPLeft,miWSPRPRight,miWSPRPTop,miWSPRPBottom);
			}
		});

		//miWSPRPTop
		miWSPRPTop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miWSPRPAct(miWSPRPLeft,miWSPRPRight,miWSPRPTop,miWSPRPBottom);
			}
		});

		//miWSPRPBottom
		miWSPRPBottom.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miWSPRPAct(miWSPRPLeft,miWSPRPRight,miWSPRPTop,miWSPRPBottom);
			}
		});
		/*
		 * miWSPRPAll
		 * 
		 * Se sono tutti attivi li disattiva tutti
		 * Se sono tutti disattivi li attiva tutti
		 * Se ce ne è uno o più disattivi, li riattiva tutti
		 */
		miWSPRPAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if((miWSPRPLeft.isSelected())&&(miWSPRPRight.isSelected())&&(miWSPRPTop.isSelected())&&(miWSPRPBottom.isSelected())){
					miWSPRPLeft.setSelected(false);
					miWSPRPRight.setSelected(false);
					miWSPRPTop.setSelected(false);
					miWSPRPBottom.setSelected(false);
				}else{
					miWSPRPLeft.setSelected(true);
					miWSPRPRight.setSelected(true);
					miWSPRPTop.setSelected(true);
					miWSPRPBottom.setSelected(true);
				}
				miWSPRPAct(miWSPRPLeft,miWSPRPRight,miWSPRPTop,miWSPRPBottom);
			}
		});

		/*
		 * Righelli 
		 */
		ESMenu menuWorkspaceRulers = new ESMenu("Righelli");
		menuWorkspace.add(menuWorkspaceRulers);


		ESMenuItem miWSPRulersTypesMetric= new ESMenuItem("Metrico");
		menuWorkspaceRulers.add(miWSPRulersTypesMetric);

		ESMenuItem miWSPRulersTypesSectorial= new ESMenuItem("Settoriale");
		menuWorkspaceRulers.add(miWSPRulersTypesSectorial);

		menuWorkspaceRulers.addSeparator();

		ESMenuItem miWSPRulersShowLeft= new ESMenuItem("Sinistro");
		menuWorkspaceRulers.add(miWSPRulersShowLeft);

		ESMenuItem miWSPRulersShowRight= new ESMenuItem("Destro");
		menuWorkspaceRulers.add(miWSPRulersShowRight);

		ESMenuItem miWSPRulersShowHide= new ESMenuItem("Attiva/disattiva righelli");
		miWSPRulersShowHide.setAccelerator(KeyStroke.getKeyStroke('R', ActionEvent.ALT_MASK+ActionEvent.SHIFT_MASK));
		menuWorkspaceRulers.add(miWSPRulersShowHide);

		menuWorkspaceRulers.addSeparator();

		
		/*
		 * Tracciatore mouse 
		 */
		ESMenu menuWSPMouseTracker = new ESMenu("Tracciatore mouse");
		menuWorkspace.add(menuWSPMouseTracker);

		JCheckBoxMenuItem miWSPMouseTrackerOn= new JCheckBoxMenuItem("Attiva",false);
		miWSPMouseTrackerOn.setAccelerator(KeyStroke.getKeyStroke(' '));
		menuWSPMouseTracker.add(miWSPMouseTrackerOn);

		JCheckBoxMenuItem miWSPMouseTrackerDiagonalOn= new JCheckBoxMenuItem("Mostra diagonale",true);
		menuWSPMouseTracker.add(miWSPMouseTrackerDiagonalOn);

		JCheckBoxMenuItem miWSPMouseTrackerValuesOn= new JCheckBoxMenuItem("Mostra valori",true);
		menuWSPMouseTracker.add(miWSPMouseTrackerValuesOn);
		
		//miWSPMouseFollower
		miWSPMouseTrackerOn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miWSPMouseTrackerOnAct(miWSPMouseTrackerOn);
			}
		});


		//-----------------------------------------
		ESMenu menuHelp = new ESMenu("Aiuto");

		ESMenuItem miInfo = new ESMenuItem("Informazioni");
		ESMenuItem miCheckUpdates = new ESMenuItem("Controlla aggiornamenti");
		ESMenuItem miHeloOnLine = new ESMenuItem("Guida in linea");

		menuHelp.add(miInfo);
		menuHelp.add(miCheckUpdates);
		menuHelp.add(miHeloOnLine);



		//-------------------------------------------
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuPrj);
		menuBar.add(menuWorkspace);
		menuBar.add(menuHelp);
		return menuBar;
	}

	//menuFile>nuovo
	private static void miNewAct(){
		ESFrameNew winNew = new ESFrameNew();
	}

	//menuFile>Esci
	public static void miExitAct(){
		int confirm = JOptionPane.showOptionDialog(
				null, "Sicuro di voler uscire?", 
				"Esci", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (confirm == 0) {
			System.exit(0);
		}
	}

	//menuWorkspace>gestore interfaccia
	private static void miWSPESDMAct(){
		ESFrameESDM winESDM = new ESFrameESDM();
	}

	//menuWorkspace>righelli
	private static void miWSPRPAct(JCheckBoxMenuItem checkLeft,JCheckBoxMenuItem checkRight,JCheckBoxMenuItem checkTop,JCheckBoxMenuItem checkBottom){
		boolean rpLeft=false,
				rpRight=false,
				rpTop=false,
				rpBottom=false;
		if(checkLeft.isSelected()){rpLeft=true;}
		if(checkRight.isSelected()){rpRight=true;}
		if(checkTop.isSelected()){rpTop=true;}
		if(checkBottom.isSelected()){rpBottom=true;}
		for(int a=0;a<Escheme.esdm.getDrawPanels().size();a++){
			Escheme.esdm.getDrawPanels().get(a).makeRulersPointer(rpLeft,rpRight,rpTop,rpBottom);
		}
	}

	//menuWorkspace>mouse tracker
	private static void miWSPMouseTrackerOnAct(JCheckBoxMenuItem _checkbox){
		
		if(_checkbox.isSelected()){
			Escheme.esdm.getDrawPanels().get(0).mouseTracker.start();
		}else{
			Escheme.esdm.getDrawPanels().get(0).mouseTracker.stop();
		}
			
	}
	
	/**
	 * Aggiunge un file al desk
	 * crea un nuovo tab per visializzare il file
	 * aggiunge il file nella lista dei file aperti e in quella dei recenti
	 * 
	 * @arg	String	_title	Titolo del tab, dovrebbe essere il nome del file
	 */
	public static void addFileToDesk(String _title){
		ESDrawPanel tab = new ESDrawPanel();

		desk.addTab( _title, tab);
		//scrivi il file nella lista file
		//avidenzia il file visualizzato nel project explorer
	}


	/**
	 * Carica il workspace
	 */
	public void loadWorkspace(){
		//contenitore pannelli sx
		panelContainerLeft = new ESPanelContainer();
		panelContainerLeft.setPreferredSize(new Dimension(50,(int)getSize().getHeight()));
		getContentPane().add( panelContainerLeft, BorderLayout.WEST);

		//contenitore pannelli dx
		panelContainerRight = new ESPanelContainer();
		panelContainerRight.setPreferredSize(new Dimension(200,(int)getSize().getHeight()));
		panelContainerRight.setLayout(new FlowLayout());
		getContentPane().add( panelContainerRight, BorderLayout.EAST);

		//contenitore pannelli bottom
		panelContainerBottom = new ESPanelContainer();
		panelContainerBottom.setPreferredSize(new Dimension((int)getPreferredSize().getWidth(),50));
		getContentPane().add( panelContainerBottom, BorderLayout.SOUTH);

		//contenitore pannelli top
		panelContainerTop = new ESPanelContainer();
		panelContainerTop.setPreferredSize(new Dimension((int)getPreferredSize().getWidth(),55));
		getContentPane().add( panelContainerTop, BorderLayout.NORTH);

		/*
		 * Pannelli
		 */
		ESPanelLog panelLog = new ESPanelLog();
		panelLog.setSize(new Dimension((int)panelContainerRight.getPreferredSize().getWidth(),250));
		panelContainerRight.add(panelLog);
		panelLog.writeMessage("ciao");

		ESPanelProperties panelProperty = new ESPanelProperties();
		panelProperty.setSize(new Dimension((int)panelContainerRight.getPreferredSize().getWidth(),250));
		panelContainerRight.add(panelProperty);
		panelProperty.addProperty("ciao2","jkdgfhdgdj");
		panelProperty.addProperty("ciao2","jkdgfhdgdj");
		panelProperty.addProperty("ciao2","jkdgfhdgdj");
		panelProperty.addProperty("ciao2","jkdgfhdgdj");
		panelProperty.addProperty("ciao2","jkdgfhdgdj");
		panelProperty.addProperty("ciao2","jkdgfhdgdj");


		ESPanelToolbar panelToolbar = new ESPanelToolbar();
		panelToolbar.setSize(panelContainerTop.getPreferredSize());
		panelContainerTop.add(panelToolbar);
		//		panelContainerTop.setBackground(Color.blue);
		
		ESPanelWorkspaceInfo panelWorkspaceInfo = new ESPanelWorkspaceInfo();
		panelWorkspaceInfo.setSize(panelContainerTop.getPreferredSize());
		panelContainerBottom.add(panelWorkspaceInfo);

	}

}
