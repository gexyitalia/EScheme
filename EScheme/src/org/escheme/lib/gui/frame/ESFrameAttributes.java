package org.escheme.lib.gui.frame;

import org.escheme.lib.gui.frame.ESFrame;

/**
 * Questa classe serve da contenitore per gli attributi e le impostazioni da passare
 * hai frame
 */
public class ESFrameAttributes {
	/**
	 * Altezza iniziale finestra
	 * default:600px
	 */
	public int height=600;
	/**
	 * Larghezza iniziale finestra
	 * default:800px
	 */
	public int width=800;
	/**
	 * Titolo finestra
	 * default: stringa vuota
	 */
	public String title=""; 
	
	/**
	 * Rende ridimensionabile la finestra
	 * default:false
	 */
	public boolean resizeable=false; 
	/**
	 * Rende massimizabile la finestra e visibile il bottone
	 * default:true
	 */
	public boolean maximizeable=true;
	/**
	 * rende riducibile ad icona la finestra e visibile i bottone
	 * default:true
	 */
	public boolean iconizeable=true; 
	/**
	 * rende la finestra spostabile
	 * default:true
	 */
	public boolean dragable=true; 
	
	/**
	 * rende chiudibile la finestra con il bottone X
	 * default: true
	 */
	public boolean closeable=true;
	
	/**
	 * Inizia la finestra massimizzata
	 * default: false
	 */
	public boolean maximixed=false;
	/**
	 * Inizia la finestra iconizzata
	 * default: false
	 */
	public boolean iconize=false;
	/**
	 * Inizia la finestra in modalità fullscreen
	 * default: false
	 */
	public boolean fullScreen=false;
	
	/**
	 * Blocca le altre finestre finché questa è visibile
	 * default: false
	 */
	public boolean exclusive=false;
	/**
	 * Blocca la finestre genitore finché questa è visibile
	 * deve essere settato l'attributo parentFrame
	 * default: false
	 */
	public boolean exclusiveFrameParent=false;
	/**
	 * Fonza la finestra ad essere sempre in primo piano
	 * default: false
	 */
	public boolean alwaysOnTop=false;
	/**
	 * Setta la finestra genitore
	 */	
	public ESFrame parentFrame;
	/**
	 * Rende il contenuto della finestra scorrevole
	 * default: false
	 */
	public boolean scrollable=false;
	/**
	 * Abilita la modifica automatica della finestra in base alle dimensioni del contenuto
	 * default: false
	 */
	public boolean autoResizeFromContent=false;
	
}
