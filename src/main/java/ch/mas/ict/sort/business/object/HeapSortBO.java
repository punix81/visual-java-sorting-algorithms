package ch.mas.ict.sort.business.object;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.ressources.Message;
import ch.mas.ict.sort.business.controller.ToSortBC;

/**
 * 
 * @file    	TrieurTasBO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:51:44
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri par tas.
 */
public class HeapSortBO extends ToSortBC {

	private JProgressBar progressBar;

	/**
	 * Constructeur
	 */
	public HeapSortBO(TabObjetToSortModel tab,	JProgressBar progressBar) { 
		super(tab);  // lance le tri
		this.progressBar = progressBar; 
	}

	/**
	 *  Methode qui va executer le tri
	 */
	@Override
	public void tri(){  // methode qui va executer le tri
		ConstruireTas(tailleTableau);
		TriParTas(tailleTableau);
	    JOptionPane.showMessageDialog(progressBar.getParent().getParent().getParent(), 
	    		Message.getMessageResourceString("popup_finished"), 
	    		"Finished",
	    		JOptionPane.INFORMATION_MESSAGE);	
	}

	/**
	 * Méthode qui construi un tas 
	 * @param taille valeur de la taille du tas
	 */
	public void ConstruireTas(int taille){
		int i;
		for(i=(taille/2);i>0;i --){
			Entasser(i,taille);
		}
	}

	/**
	 * Méthode qui fait le tri le tas
	 * @param taille valeur de la taille du tas
	 */
	public void TriParTas(int taille){
		while(taille > 1){
			tab.permutation(0 , taille-1);
			tab.redessine();  // on redessine pour voir les modifications
			taille = taille -1;
			ConstruireTas(taille);
		}
		progressBar.setIndeterminate(false);
	}
	
	/**
	 * Méthodequi permet d'entasser les tas. 
	 * @param i indice du tableau. 
	 * @param taille valeur de la taille du tas.
	 */
	public void Entasser(int i,int taille){

		int gauche, droit, max;
		gauche = i*2;
		droit = i*2+1;

		if(gauche <= taille){
			if(tab.getTab(i-1).isGreaterThan(tab.getTab(gauche-1)) == false){
				max = gauche;
			}else{
				max = i;
			}
		}else{
			max = i;
		}

		if(droit <= taille){
			if(tab.getTab(max-1).isGreaterThan(tab.getTab(droit-1)) == false){
				max = droit;
			}
		}

		if(max-1 != i-1){
			tab.permutation(i-1 , max-1);
			Entasser(max,taille);
		}
	}
}