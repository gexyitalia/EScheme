package org.escheme.component;

import java.awt.Point;
import java.util.ArrayList;

import org.escheme.lib.gui.component.ESDrawComponent;
import org.escheme.lib.gui.component.ESDrawComponentObject;

/**
 * Implementa un componente Resistore ideale
 */
public class ESComponentResistor extends ESDrawComponent{
	public ESComponentResistor() {
		ArrayList<Point> points = new ArrayList<Point>();
		//pin1
		points.add(new Point(0,5));
		points.add(new Point(10,5));
		schematicComponentObjects.add(new ESDrawComponentObject(points,ESDrawComponentObject.TYPE_CONNECTOR,"P1"));
		
		points.clear();
		
		//pin2
		points.add(new Point(50,5));
		points.add(new Point(60,5));
		schematicComponentObjects.add(new ESDrawComponentObject(points,ESDrawComponentObject.TYPE_CONNECTOR,"P2"));
		
	}
}
