package org.escheme.gui.frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import org.escheme.lib.gui.frame.ESFrame;
import org.escheme.lib.gui.menu.ESMenu;
import org.escheme.lib.gui.menu.ESMenuBar;
import org.escheme.lib.gui.menu.ESMenuItem;

/**
 * Questo Frame serve per la progettazione degli schemi
 * @author eugenio
 *
 */
public class ESFrameLoading extends ESFrame{
	private static final long serialVersionUID = -2400721423473583701L;

	public ESFrameLoading(){
		setTitle("EScheme - Schematic");
		setVisible(true);
		setDefaultCloseOperation(ESFrame.EXIT_ON_CLOSE);
		setExtendedState(ESFrame.MAXIMIZED_BOTH);

		//menu
		super.setJMenuBar(createMenuBar());
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

		ESMenuItem miPlugin = new ESMenuItem("Plugin");
		ESMenuItem miLibrary = new ESMenuItem("Librerie");
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
		menuFile.add(miPlugin);
		menuFile.add(miLibrary);
		menuFile.add(miOptions);
		menuFile.addSeparator();
		menuFile.add(miExit);

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

		menuPrj.add(miPrjClose);
		menuPrj.addSeparator();
		menuPrj.add(miPrjDocumentation);
		menuPrj.addSeparator();
		menuPrj.add(miPrjProperty);

		//-----------------------------------------
		ESMenu menuWorkspace = new ESMenu("Workspace");

		ESMenu menuWorkspacePanels = new ESMenu("Pannelli");

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

		menuWorkspace.add(menuWorkspacePanels);

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

}
