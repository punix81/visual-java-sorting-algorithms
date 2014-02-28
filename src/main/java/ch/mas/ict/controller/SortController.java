package ch.mas.ict.controller;

import ch.mas.ict.model.SortModel;
import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.sort.business.controller.ToSortBC;
import ch.mas.ict.sort.business.object.BubbleSortBO;
import ch.mas.ict.sort.business.object.DoubleBubleSortBO;
import ch.mas.ict.sort.business.object.HeapSortBO;
import ch.mas.ict.sort.business.object.InsertionSortBO;
import ch.mas.ict.sort.business.object.MergeSortBO;
import ch.mas.ict.sort.business.object.PermutationSortBO;
import ch.mas.ict.sort.business.object.QuickSortBO;
import ch.mas.ict.view.SortView;
import ch.mas.ict.view.visual.Window;

/**
 * 
 * @file    	SortController.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 d�c. 2010 00:42:39
 * @mail 		lopespaulo18@gmail.com
 * @Description Cette classe permet de  faire la connection entre le view et le 
 * 				Model.
 */
public class SortController {

	private SortView window = null;
	private SortModel model = null;

	/**
	 * Constructeur de l application 
	 * @param model
	 */
	public SortController (SortModel model){
		this.model = model;
		window = new Window(this);
		addListenersToModel();

	}

	/**
	 * M�thode qui permet de rajouter les infomation de windows au model
	 */
	private void addListenersToModel() {
		model.addVolumeListener(window);
	}

	/**
	 * Methode qui permet d'afficher la fen�tre principale
	 */
	public void displayViews(){
		window.display(); 
	}

	/**
	 *M�thode qui ferme la fen�tre principale. 
	 *ATTENTION c'est m�thode n'arr�te pas le processuse. 
	 */
	public void closeViews(){
		window.close(); 
	}

	/**
	 * M�thode qui suprimer l'ensemble du canvas. 
	 */
	public void displayCanvas (){
		window.setTab( new TabObjetToSortModel(window.getDessin() ,  
				window.getSync() ,model.getSelectNombre() , 
				model.getSelectChoixObjet(),
				model.getWidth(),
				model.getHeight())); 
		window.getDessin().setTabObjet(window.getTab());  
		window.getDessin().repaint();
	}

	/**
	 * M�thode qui va creer le tableau d'�lement avec les valeurs qu'a d�finie 
	 * l'utilisateur. Puis va executer le processu de tri
	 */
	public void displayAndSorTCanvas (){
		window.setTab( new TabObjetToSortModel(window.getDessin() ,  
				window.getSync() ,model.getSelectNombre() , 
				model.getSelectChoixObjet(),
				model.getWidth(),
				model.getHeight())); 
		window.getDessin().setTabObjet(window.getTab());  
		window.getDessin().repaint();
		ToSortBC modeTri;

		window.setTab( new TabObjetToSortModel(window.getDessin() ,  
				window.getSync() ,model.getSelectNombre() , 
				model.getSelectChoixObjet(), 
				model.getWidth(),
				model.getHeight())); 
		window.getDessin().setTabObjet(window.getTab());
		if ( model.getSelectChoixTri() == 0 )
			modeTri = new    InsertionSortBO (window.getTab(),window.getProgressBar());

		if ( model.getSelectChoixTri() == 1 )
			modeTri = new    PermutationSortBO(window.getTab(),window.getProgressBar());

		if ( model.getSelectChoixTri() == 2 )
			modeTri = new BubbleSortBO(window.getTab(),window.getProgressBar());

		if ( model.getSelectChoixTri() == 3 )
			modeTri = new   DoubleBubleSortBO(window.getTab(),window.getProgressBar());

		if ( model.getSelectChoixTri() == 4 )
			modeTri = new HeapSortBO(window.getTab(),window.getProgressBar());

		if ( model.getSelectChoixTri() == 5 )
			modeTri = new MergeSortBO(window.getTab(),window.getProgressBar());

		if ( model.getSelectChoixTri() == 6 )
			modeTri = new QuickSortBO(window.getTab(),window.getProgressBar());

	}

	/**
	 * Methode qui efface le canevas en le repaignant avec des valeur vide.
	 */
	public void cancelCanvas (){
		window.setTab( new TabObjetToSortModel(window.getDessin(), 
				window.getSync() ,0 , 0,
				model.getWidth(),
				model.getHeight())); 
		window.getDessin().setTabObjet(window.getTab());  
		window.getDessin().repaint();	
	}



	/**
	 * Methode qui recupper les informations de l'utilisateur et qui les set dans
	 * le model. 
	 * @param selectChoixTri type d'algorithme de tri
	 * @param selectChoixObjet type d'objet a afficher
	 * @param selectNombre nombre d'element a trier
	 * @param width Largeur du panel 
	 * @param height Hauteur du panel 
	 */
	public void notifyVolumeChanged(int selectChoixTri, int selectChoixObjet,
			int selectNombre , int width ,int height) {
		model.setSelectChoixObjet(selectChoixObjet);
		model.setSelectChoixTri(selectChoixTri);
		model.setSelectNombre(selectNombre);
		model.setWidth(width);
		model.setHeight(height);
	}

	/**
	 * Methode qui ferme l'application. Conparer la m�thode closeViews cette 
	 * m�thode arr�tre le processus. 
	 */
	public void shutDownAll(){
		System.exit(0);
	}
}