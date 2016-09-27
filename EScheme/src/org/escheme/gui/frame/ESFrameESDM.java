package org.escheme.gui.frame;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.escheme.Escheme;
import org.escheme.lib.gui.frame.ESFrame;

/**
 * Questo Frame crea una finestra per la gestione dell'interfaccia utente
 */
public class ESFrameESDM extends ESFrame{
	private static final long serialVersionUID = -2400723583701L;
	
	private JTree tree;
	public ESFrameESDM(){
		setTitle("ESDM");
		
		
		
		createUI();
		pack();
		setVisible(true);
		
	}
	
	private void createUI(){
		
		//create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        DefaultMutableTreeNode ESFramesNode = new DefaultMutableTreeNode("Finestre");
 
        root.add(ESFramesNode);
        
        /*
         * ESFrames
         */
        ArrayList<ESFrame> frames = Escheme.esdm.getFrames();
        for(int a=0;a<frames.size();a++){
        	ESFramesNode.add(new DefaultMutableTreeNode("UID: "+frames.get(a).getUID()+
        			" Titolo: "+frames.get(a).getTitle()));
        }
        
        //create the tree by passing in the root node
        tree = new JTree(root);
        tree.setRootVisible(false);
        getContentPane().add(new JScrollPane(tree));
	}
	
	@Override
	protected void frameClosing(){
		close();
	}
	
	
}
