package ch.mas.ict.sort.business.object;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.ressources.Message;
import ch.mas.ict.sort.business.controller.ToSortBC;

/**
 * 
 * @file    	TrieurPermutationBO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:50:55
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri par Permutation.
 */
public class PermutationSortBO extends ToSortBC{  
	
	private JProgressBar progressBar;
	
	/**
	 * Constructeur
	 */
	public PermutationSortBO(TabObjetToSortModel tab,JProgressBar progressBar) {
		super(tab); 
		this.progressBar = progressBar; 
	}

	/**
	 * Methode qui va executer le tri
	 */
	@Override
	public void tri(){
		int limTrie,j;
		int iMinNonTrie;

		for(limTrie=0;limTrie < tailleTableau;limTrie ++){ 
			iMinNonTrie = limTrie;
			for(j=limTrie+1;j < tailleTableau;j ++){
				if(tab.getTab(iMinNonTrie).isGreaterThan(tab.getTab(j)) == true )
					iMinNonTrie = j; 
			}
			tab.permutation( iMinNonTrie , limTrie ); 
			tab.redessine();
		}
		progressBar.setIndeterminate(false);
	     JOptionPane.showMessageDialog(progressBar.getParent().getParent().getParent(), Message.getMessageResourceString("popup_finished"), "Finished",JOptionPane.INFORMATION_MESSAGE);	
	 	
	}
}