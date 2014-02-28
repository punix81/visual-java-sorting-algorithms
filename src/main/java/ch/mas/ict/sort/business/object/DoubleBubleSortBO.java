package ch.mas.ict.sort.business.object;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.ressources.Message;
import ch.mas.ict.sort.business.controller.ToSortBC;

/**
 * 
 * @file    	Trieur2BullesBO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:48:39
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri à deux Bulle.
 */
public class DoubleBubleSortBO extends ToSortBC  {

	private JProgressBar progressBar;
	
	/**
	 * Constructeur
	 */
	public DoubleBubleSortBO(TabObjetToSortModel tab, JProgressBar progressBar){
		super(tab); 
		this.progressBar = progressBar; 
	}

	/**
	 *  Methode qui va executer le tri
	 */
	@Override
	public void tri(){ 

		int gauche = 0; 
		int droite = tailleTableau - 1; 
		char sens = 'G'; 
		boolean permut = true; 
		int j;


		while(gauche < droite && permut == true){  
			permut = false; 

			switch(sens){  
			case 'G' :  
				for(j = droite;j > gauche;j --){  
					if( tab.getTab(j).isGreaterThan(tab.getTab(j-1)) == false ){  
						tab.permutation(j-1,j); 
						permut = true;  
						tab.redessine();  
					}
				}
				gauche = gauche + 1;  
				sens = 'D'; 
				break;

			case 'D' :
				for(j = gauche;j < droite;j ++){ 
					if(tab.getTab(j).isGreaterThan(tab.getTab(j+1)) == true ){  
						tab.permutation(j,j+1);  
						permut = true; 
						tab.redessine();  
					}
				}
				droite = droite -1;  
				sens = 'G';
			}
		}
		progressBar.setIndeterminate(false);
	     JOptionPane.showMessageDialog(progressBar.getParent().getParent().getParent(), 
	    		 Message.getMessageResourceString("popup_finished"), 
	    		 "Finished",
	    		 JOptionPane.INFORMATION_MESSAGE);	
	}
	
}




