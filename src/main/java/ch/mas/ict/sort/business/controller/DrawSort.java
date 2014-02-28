package ch.mas.ict.sort.business.controller;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.sort.business.model.SynchronizerBM;

/**
 * 
 * @file    	DrawSort.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 d�c. 2010 00:45:46
 * @mail 		lopespaulo18@gmail.com
 * @Description
 */
public class DrawSort extends JPanel {

	private static final long serialVersionUID = 1L;
	TabObjetToSortModel tabObj = null; // le tableau a trier
	private SynchronizerBM sync = null; // l'objet de synchronisation

	/**
	 * COnstructeur qui permet d'instancier la syncronization.
	 * @param sync objet a syncronizer.
	 */
	public DrawSort(SynchronizerBM sync) {
		this.sync = sync;
	}

	/**
	 * cette m�thode est obligatoire et permet de sp�cifier ce qui s'affiche 
	 * dans le panneau lorsqu'on appel ou repaint().
	 */
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.black);
		if ( tabObj != null ){ // s'il y a un tableau d'objets a affiche
			tabObj.afficheTout(g);  // affiche tous les objets du tableau
		}
		sync.reveille();
	}

	/**
	 * Methode permet de donner au panneau de dessin une r�f�rence au tableau 
	 * d'objet � trier. A appeler obligatoirement apr�s la (re)cr�ation du 
	 * tableau.
	 */
	public void setTabObjet(TabObjetToSortModel tab) {
		tabObj = tab;
	}
}


