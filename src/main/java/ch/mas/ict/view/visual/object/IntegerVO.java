package ch.mas.ict.view.visual.object;

import java.awt.Color;

import ch.mas.ict.sort.business.model.ObjetToSortBM;

/**
 * 
 * @file    	IntegerVO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	17 déc. 2010 15:59:42
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui décrit un objet entier à trier.
 */
public class IntegerVO extends ObjetToSortBM {

	private int valeur;

	/**
	 * Constructeur de l'objet entier
	 * @param valeur
	 */
	public IntegerVO (int valeur){  
		this.valeur=valeur;
	}

	/**
	 * Methode permettant de renvoyer la valeur de l'entier
	 */
	@Override
	public float toFloat(){ 
		return valeur; 
	}

	/**
	 * Methode qui permet d'afficher la valeur de l'objet en fonction de la 
	 * place qu'il a dans le tableau
	 */
	@Override
	public  void afficheToi( int place){ 
		myGraph.setColor(Color.black);
		myGraph.drawString(""+valeur ,  50 , place * 20 +20 ); 
	}

}
