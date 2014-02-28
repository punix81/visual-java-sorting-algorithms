package ch.mas.ict.view.visual.object;

import java.awt.Color;

import ch.mas.ict.sort.business.model.ObjetToSortBM;

/**
 * 
 * @file    	ReelVO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	12 déc. 2010 17:38:18
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui décrit un objet real à trier.
 */
public class ReelVO extends ObjetToSortBM {  // objet heritant de la classe ObjetATrier

	private float valeur;

	/**
	 * constructeur de l'objet reel
	 * @param valeur valeur a l'attribut valeur de l'objet
	 */
	public ReelVO (float valeur){
		this.valeur=valeur;
	}

	/**
	 * Methode permettant de renvoyer la valeur du reel
	 */
	@Override
	public float toFloat(){
		return valeur;
	}

	/**
	 * methode qui permet d'afficher la valeur de l'objet en fonction de la place
	 * qu'il a dans le tableau
	 */
	@Override
	public  void afficheToi( int place){
		myGraph.setColor(Color.black);
		myGraph.drawString(""+valeur , 50 , place * 20 +20);
	}


}
