package ch.mas.ict;

import ch.mas.ict.controller.SortController;
import ch.mas.ict.model.SortModel;

/**
 * 
 * @file    	Sort.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:42:03
 * @mail 		lopespaulo18@gmail.com
 * @Description
 */
public class Sort {
	
	/**
	 * Methode point d'entrée de l'application
	 * @param args de point d'entrée
	 */
	public static void main(String[] args) {
		SortModel model = new SortModel(0, 0, 0);
		SortController controller = new SortController(model);
		controller.displayViews();
	}
}