package org.escheme;

import org.escheme.gui.frame.ESFramePrjScheme;
import org.escheme.lib.gui.ESDM;

import com.gexy.config.Config;
import com.gexy.config.exception.ConfigFileContextNotFound;
import com.gexy.config.exception.ConfigFileParameterTooManyContext;
import com.gexy.config.exception.ConfigFilePathException;

public class Escheme {
	public static Config conf;
	public static ESDM esdm;
	public static void main(String[] args) {
		//carico configurazione
		conf = new Config();
		try {
			conf.readConfigFromXml("config.xml","escheme");
	 	} catch (ConfigFilePathException | ConfigFileContextNotFound | ConfigFileParameterTooManyContext e) {
	 		System.err.println("Fatal error: Is not possile load config from XML file ./config.xml");
	 		System.exit(1);
	 	}
		
		//carico gestore UI
		esdm = new ESDM();
		
		ESFramePrjScheme frame = new ESFramePrjScheme();
		  

	}

}
