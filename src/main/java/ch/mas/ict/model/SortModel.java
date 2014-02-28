package ch.mas.ict.model;

import javax.swing.event.EventListenerList;

import ch.mas.ict.events.SortListener;

/**
 * 
 * @file    	SortModel.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	12 déc. 2010 17:31:10
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe Model. Cette classe définie les chois de l'utilisateur.
 */
public class SortModel {
	private int selectChoixTri;
	private int selectChoixObjet;
	private int selectNombre ;
	private int width ; 
	private int height; 


	private EventListenerList listeners;

	/**
	 * Constructeur qui instancier les valeur à 0;
	 */
	public SortModel(){
		this(0, 0, 0);
	}

	/**
	 * Constructeur qui permet de déclarer les choix et les valeur que l'
	 * utilisateur à introduit dans le view.
	 * @param selectChoixTri Chois de l'algorithme de tri.
	 * @param selectChoixObjet Type d'objet a afficher.
	 * @param selectNombre Nombre d'élement que l'on souhaite trier.
	 */
	public SortModel( int selectChoixTri, int selectChoixObjet, int selectNombre ){
		super();	
		this.selectChoixObjet=selectChoixObjet;
		this.selectChoixTri=selectChoixTri;
		this.selectNombre = selectNombre; 
		listeners = new EventListenerList();
	}

	public int getSelectChoixTri() {
		return selectChoixTri;
	}

	public void setSelectChoixTri(int selectChoixTri) {
		this.selectChoixTri = selectChoixTri;
	}

	public int getSelectChoixObjet() {
		return selectChoixObjet;
	}

	public void setSelectChoixObjet(int selectChoixObjet) {
		this.selectChoixObjet = selectChoixObjet;
	}

	public int getSelectNombre() {
		return selectNombre;
	}

	public void setSelectNombre(int selectNombre) {
		this.selectNombre = selectNombre;
	}

	public void addVolumeListener(SortListener listener){
		listeners.add(SortListener.class, listener);
	}

	public void removeVolumeListener(SortListener l){
		listeners.remove(SortListener.class, l);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}