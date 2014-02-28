package ch.mas.ict.sort.business.controller;

import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;

/**
 * 
 * @file    	ToSortBC.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:47:02
 * @mail 		lopespaulo18@gmail.com
 * @Description
 */
public abstract class ToSortBC implements Runnable{

	private Thread mySelf = null;
	protected TabObjetToSortModel tab = null;
	public int tailleTableau;
	private JProgressBar progressBar ;

	/**
	 * Permet de transformer cet objet (this) en un Thread (= plus ou moins un 
	 * processus) qui va appeler automatiquement la méthode run().
	 * C'est un peu comme le clone() du C : on définit un bout de code puis on 
	 * crée un processus fils qui va entre autre contenir ce bout de code et 
	 * l'exécuter. En java, le bout de code est carrément une classe mais 
	 * l'exécution commence uniquement si l'on appelle la méthode start() qui 
	 * elle meme appelle run().
	 * @param tab
	 */
	public ToSortBC (TabObjetToSortModel tab) {
		this.tab = tab;
		this.tailleTableau = tab.getLength();
		if (mySelf == null) {
			mySelf = new Thread(this,"Trieur");
			mySelf.start();
		}
	}

	@Override
	public void run() {
		tri();
	}

	/**
	 * Méthode principale : permet d'executer l'algorithme de trii. 
	 */
	public abstract void tri();
	
}