package org.escheme.gui.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import org.escheme.lib.gui.frame.ESFrame;
import org.escheme.lib.gui.frame.ESFrameAttributes;
import org.escheme.lib.gui.menu.ESMenu;
import org.escheme.lib.gui.menu.ESMenuBar;
import org.escheme.lib.gui.menu.ESMenuItem;

/**
 * Questo Frame serve serve per gestire le impostazioni della parte di progettazione schemi
 */
public class ESFrameRpjSchemeOptions extends ESFrame{
	private static final long serialVersionUID = -2400721423473583701L;
	
	private JTree tree;
	public ESFrameRpjSchemeOptions(){
		ESFrameAttributes frameAttr = new ESFrameAttributes();
		frameAttr.title="Opzioni";
		setTitle("Opzioni");
		
		
		createTree();
		pack();
		setVisible(true);
		
	}
	
	private void createTree(){
		//create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        DefaultMutableTreeNode generalNode = new DefaultMutableTreeNode("Generale");
        
 
        //add the child nodes to the root node
        root.add(generalNode);
        
        /*
         * generale
         */
        generalNode.add(new DefaultMutableTreeNode("Cartella"));
        generalNode.add(new DefaultMutableTreeNode("File vuoto"));
         
        
        
        //create the tree by passing in the root node
        tree = new JTree(root);
        tree.setRootVisible(false);
        getContentPane().add(new JScrollPane(tree),BorderLayout.CENTER);
	}
	
	
}
