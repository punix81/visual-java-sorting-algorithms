package ch.mas.ict.sort.business.controller;

import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;

/**
 * 
 * @file    	ToSortBC.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 d�c. 2010 00:47:02
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
	 * processus) qui va appeler automatiquement la m�thode run().
	 * C'est un peu comme le clone() du C : on d�finit un bout de code puis on 
	 * cr�e un processus fils qui va entre autre contenir ce bout de code et 
	 * l'ex�cuter. En java, le bout de code est carr�ment une classe mais 
	 * l'ex�cution commence uniquement si l'on appelle la m�thode start() qui 
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
	 * M�thode principale : permet d'executer l'algorithme de trii. 
	 */
	public abstract void tri();
	
}