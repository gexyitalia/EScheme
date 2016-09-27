package org.escheme.lib.utils;

public class Pitagora {
	/**
	 * Calcola l'ipotenusa avendo i due cateti
	 * @param _catetoA double
	 * @param _catetoB double
	 * @return double
	 */
	public double getIpotenusa(double _catetoA,double _catetoB){
		double A = Math.pow(_catetoA, 2.0); 
		double B = Math.pow(_catetoB, 2.0); 
		return Math.sqrt(A+B);
	}
	
	/**
	 * Calcola un cateto avendo i ipotenusa e un cateto
	 * @param _catetoA double
	 * @param _catetoB double
	 * @return double
	 */
	public double getCateto(double _cateto,double _ipotenusa){
		double I = Math.pow(_ipotenusa, 2.0); 
		double C = Math.pow(_cateto, 2.0); 
		return Math.sqrt(I-C);
	}
	
	
}
