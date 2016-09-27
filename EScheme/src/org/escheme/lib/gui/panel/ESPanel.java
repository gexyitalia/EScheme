package org.escheme.lib.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import org.escheme.Escheme;


public class ESPanel extends ESPanelRaw{
	private static final long serialVersionUID = 4769392063765741099L;

	JPanel container = new JPanel(new BorderLayout());
	JButton optBtn;


	/**
	 * Crea un pannello con barra del titolo
	 * @param _title
	 */
	public ESPanel(String _title){

		JPanel boxTop = new JPanel();
		super.add(boxTop,BorderLayout.NORTH);

		JLabel title = new JLabel(_title);
		Font fnt=new Font(title.getFont().getName(), Font.PLAIN, 11);
		title.setFont(fnt);
		boxTop.add(title,BorderLayout.PAGE_START);



		optBtn = new JButton("^");


		optBtn.setOpaque(false);
		optBtn.setContentAreaFilled(false);
		optBtn.setBorderPainted(false);


		boxTop.add(optBtn,BorderLayout.PAGE_END);
		createPopupMenu();
		
		/*-----------------------
		 * UI
		 ----------------------*/
	}

	/**
	 * Crea un pannello senza barra del titolo, il nome del pannello(titolo non visualizzato)
	 * può essere impostato con setTitle
	 */
	public ESPanel(){
		
	}
	
	public void addContent(Component _c){
		container.add(_c,BorderLayout.CENTER);
	}

	/*
	 * Popoup menu
	 */
	private JPopupMenu pmenu;
	private void createPopupMenu() {

		pmenu = new JPopupMenu();

		JMenuItem btnDetach = new JMenuItem("Stacca");
		btnDetach.addActionListener((ActionEvent e) -> {
			//            if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
			//                setExtendedState(JFrame.MAXIMIZED_BOTH);
			//            }
		});

		JMenuItem btnIconize = new JMenuItem("Riduci");
		btnIconize.addActionListener((ActionEvent e) -> {
			//            if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
			//                setExtendedState(JFrame.MAXIMIZED_BOTH);
			//            }
		});

		JMenuItem btnClose = new JMenuItem("Chiudi");
		btnClose.addActionListener((ActionEvent e) -> {
			//            if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
			//                setExtendedState(JFrame.MAXIMIZED_BOTH);
			//            }
		});

		pmenu.add(btnDetach);
		pmenu.add(btnIconize);
		pmenu.add(btnClose);

		optBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				pmenu.show(optBtn, optBtn.getX(), optBtn.getY());
			}
		});
	}
	
	
}
