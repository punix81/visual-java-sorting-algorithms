package ch.mas.ict.sort.business.model;

import java.awt.Graphics;

/**
 * 
 * @file    	ObjetToSortBM.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:47:40
 * @mail 		lopespaulo18@gmail.com
 * @Description classe abtraite de laquelle vont heriter les differents objets 
 * 				qui ne sont pas limites seulement au batons, reels ou entier, 
 * 				on peut ainsi trier n'importe quoi, du moment que cette objet 
 * 				herite de cette classe).
 */
public abstract class ObjetToSortBM { 

	protected Graphics myGraph = null; 
	
	/**
	 * Fonction qui permet determine si elle est plus grande ou égalt a un 
	 * autre objet contenu dans le tableau.
	 * @param autre Objet du tableau a comparer
	 * @return true si l'objet et plus grand ou égal si non retourne false.
	 */
	public boolean isGreaterThan(ObjetToSortBM other){
		if ( toFloat() >= other.toFloat() )
			return true;
		else
			return false;
	}
	
	/**
	 * Methode abstraite permettant de renvoyer la valeur sur lequel est base 
	 * le tri.
	 * @return
	 */
	public abstract float toFloat(); 

	/**
	 * Methode abstraite permettant d'afficher l'objet.
	 * @param place
	 */
	public abstract void afficheToi( int place); 

	/**
	 * Méthode permet d'indiquer à l'objet courant le graphics sur lequel il 
	 * doit se dessiner.
	 * @param g
	 */
	public void setGraphics(Graphics g) {
		myGraph = g;
	}

}
