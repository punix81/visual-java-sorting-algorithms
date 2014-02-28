package ch.mas.ict.model;

import java.awt.Graphics;
import java.util.Random;

import ch.mas.ict.sort.business.controller.DrawSort;
import ch.mas.ict.sort.business.model.ObjetToSortBM;
import ch.mas.ict.sort.business.model.SynchronizerBM;
import ch.mas.ict.view.visual.object.IntegerVO;
import ch.mas.ict.view.visual.object.ReelVO;
import ch.mas.ict.view.visual.object.StickVO;

/**
 * 
 * @file    	TabObjetToSortBC.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:46:12
 * @mail 		lopespaulo18@gmail.com
 * @Description
 */
public class TabObjetToSortModel {

	private ObjetToSortBM tab[] = null;  
	private ObjetToSortBM objetTemp = null; 
	private int nombreElement; 
	private int selectChoixObjet;  
	private DrawSort dessin = null; 
	private SynchronizerBM sync = null;  
	static private Random aleatoire;  
	private int width = 0; 
	private int height = 0;

	/**
	 * Constructeur 
	 * @param dessin met dans les attributs de la classe l'objet dessin qui 
	 * 	etait en parametre
	 * @param sync met dans les attributs de la classe l'objet sync qui etait 
	 * en parametre met dans les attributs le nombre d'elements qui etait en 
	 * parametre
	 * @param nombreElement met dans les attributs le choix qui etait en parametre
	 * @param selectChoixObjet
	 */
	public TabObjetToSortModel(DrawSort dessin, SynchronizerBM sync , 
			int nombreElement , int selectChoixObjet,  int width,int height){ 
		aleatoire = new Random (); 
		this.dessin = dessin; 
		this.sync = sync; 
		this.nombreElement = nombreElement; 
		this.selectChoixObjet = selectChoixObjet; 
		this.width = width; 
		this.height = height;
		tab = new ObjetToSortBM [nombreElement];  
		remplir(); 
	}

	/**
	 * Méthode qui permet de remplir le tableau en focntion du type d'objet a trier
	 */
	private void remplir(){
		int i;
		for ( i=0 ; i<nombreElement ; i++ ){
			if ( selectChoixObjet == 0 )  // Cas ou l'utilisateur a selectionne Entiers
				tab[i] = new IntegerVO (aleatoire.nextInt(20));
			if ( selectChoixObjet == 1 )  // Cas ou l'utilisateur a selectionne Reels
				tab[i] = new ReelVO (aleatoire.nextFloat()); 
			if ( selectChoixObjet == 2 )  // Cas ou l'utilisateur a selectionne batons
				tab[i] = new StickVO (aleatoire.nextInt(height) , nombreElement, width , height);
		}
	}

	/**
	 * 
	 * @return renvoi la longueur du tableau d'objets
	 */
	public int getLength(){
		return tab.length;
	}

	/**
	 * Fonction qui retroune l'objet contenu dans le tableau à un indice introduit 
	 * en paramètre. 
	 * @param numCase indice du tableau 
	 * @return renvoi l'objet se trouvant dans cette case du tableau
	 */
	public ObjetToSortBM getTab ( int numCase ){
		return tab[numCase];
	}

	/**
	 * Methode qui permet de modifier un objet du tableau
	 * @param numCase
	 * @param objet
	 */
	public void setTab ( int numCase , ObjetToSortBM objet ){
		tab[numCase] = objet;
	}



	/**
	 * Methode qui permet de dessiner sur g tous les objet à trier
	 * @param g
	 */
	public void afficheTout(Graphics g) {
		int i;
		for ( i=0 ; i<nombreElement ; i++ ){
			tab[i].setGraphics(g);
			tab[i].afficheToi(i);
		}
	}

	/**
	 * Methode qui permet de dessiner les elements du tableau en mettant en 
	 * attente le tri le temps que le dessin soit fait
	 */
	public void redessine() {
		sync.attend(dessin);
	}

	/**
	 * Methode qui permet de permutter deux elements du tableau 
	 * @param objet1
	 * @param objet2
	 */
	public void permutation (int objet1, int objet2) {
		objetTemp = tab[objet1];
		tab[objet1] = tab[objet2];
		tab[objet2] = objetTemp;  
		objetTemp = null;
	}
}
