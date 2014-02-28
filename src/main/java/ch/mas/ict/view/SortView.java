package ch.mas.ict.view;

import java.awt.event.ActionEvent;

import javax.swing.JProgressBar;

import ch.mas.ict.controller.SortController;
import ch.mas.ict.events.SortListener;
import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.sort.business.controller.DrawSort;
import ch.mas.ict.sort.business.model.SynchronizerBM;

/**
 * 
 * @file    	SortView.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:52:29
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe abstaite du View cette classe contient les valeur qui 
 * 				seront utliser pour les tri.
 *
 */
public abstract class SortView implements SortListener{
	
	private SortController controller = null;
	private DrawSort dessin = null; 
	private TabObjetToSortModel tab=null; 
	private SynchronizerBM sync; 
	
	private JProgressBar progressBar = null; 
	
	
	/**
	 * Constructeur
	 * @param controller
	 */
	public SortView(SortController controller){
		super();
		this.controller = controller;
	}

	public final SortController getController(){
		return controller;
	}

	public DrawSort getDessin() {
		return dessin;
	}

	public void setDessin(DrawSort dessin) {
		this.dessin = dessin;
	}

	public TabObjetToSortModel getTab() {
		return tab;
	}

	public void setTab(TabObjetToSortModel tab) {
		this.tab = tab;
	}

	public SynchronizerBM getSync() {
		return sync;
	}

	public void setSync(SynchronizerBM sync) {
		this.sync = sync;
	}

	
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public abstract void display();
	
	public abstract void close();
	
	public abstract void displayPerformed (ActionEvent arg0);
	
	public abstract void clearPerformed(ActionEvent arg0);
	
	public abstract void sortPerformed(ActionEvent arg0) ;
	
}