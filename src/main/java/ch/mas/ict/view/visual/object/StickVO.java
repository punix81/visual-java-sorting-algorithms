package ch.mas.ict.view.visual.object;

import java.awt.Color;

import ch.mas.ict.sort.business.model.ObjetToSortBM;

/**
 * 
 * @file    	StickVO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	12 déc. 2010 17:05:47
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui décrit un objet visuelle de type Graphique.
 */
public class StickVO extends ObjetToSortBM {

	private int taille; 
	private float largeur; 
	private int height;
	private int nb; 
	private float rest;

	/**
	 * Constructeur 
	 */
	public StickVO (int taille , int nbreElement, float width, int height ){ 
		this.taille=taille;  
		this.largeur =width/nbreElement ;
		this.height = height;
		this.setNb(nbreElement);
		rest = largeur/nbreElement;
		System.out.println("largeur = "+largeur); 
		System.out.println("nbreElement = "+nbreElement); 
		System.out.println("rest = "+rest);
	}

	/**
	 * Méthode permettant de renvoyer la taille du baton. On retourne la taile 
	 * du baton castee en reel car les tris comparent des reels.
	 */
	@Override
	public float toFloat(){
		return taille;
	}

	/**
	 * Méthode qui permet d'afficher le baton en focntion de la place qu 'il a 
	 * dans le tableau 
	 */
	@Override
	public  void afficheToi( int place){  
		myGraph.setColor(Color.gray);
		place = (int)(place*(largeur)+rest);
		myGraph.fill3DRect(place  , height - taille , (int) largeur , 
				taille, false);
//		myGraph.fill3DRect(place*(largeur)+rest  , height - taille , largeur , 
//				taille, false);
		
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public int getNb() {
		return nb;
	}
}
