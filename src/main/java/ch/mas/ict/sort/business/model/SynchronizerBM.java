package ch.mas.ict.sort.business.model;

import javax.swing.JProgressBar;

import ch.mas.ict.sort.business.controller.DrawSort;

/**
 * 
 * @file    	SynchronizerBM.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 d�c. 2010 00:48:17
 * @mail 		lopespaulo18@gmail.com
 * @Description
 */
public class SynchronizerBM {
	
	private int i =0;
	private JProgressBar sortProgressBar;
	
	/**
	 * Constructeur
	 * @param sortProgressBar 
	 */
	public SynchronizerBM(JProgressBar sortProgressBar) {
		this.sortProgressBar = sortProgressBar; 
	}

	/**
	 * le processus d'affichage appelle cette fonction qui r�veille
	 * le processus de tri qui s'est endormi 
	 */
	public synchronized void reveille() {
		notify();
	}

	/**
	 * le processus de tri appelle cette fonction pour d�clencher la mise � jour
	 * du dessin puis s'endormir en attendant que le processus d'affichage ait 
	 * fini de repeindre la fenetre
	 * @param dessin
	 */
	public synchronized void attend( DrawSort dessin) {
		try {
			dessin.repaint();
			wait();
		}
		catch(InterruptedException e) {
			System.out.println("pb : "+e);
		}
	}


}
