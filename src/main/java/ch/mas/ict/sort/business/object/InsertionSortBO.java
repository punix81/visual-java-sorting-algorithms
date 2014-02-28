package ch.mas.ict.sort.business.object;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.ressources.Message;
import ch.mas.ict.sort.business.controller.ToSortBC;
import ch.mas.ict.sort.business.model.ObjetToSortBM;

/**
 * 
 * @file    	TrieurInsertionBO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 d�c. 2010 00:50:32
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri par Insertion.
 * Le tri par insertion est un autre algorithme que l�on peut qualifier de na�f.
 * Cet algorithme consiste � piocher une � une les valeurs du tableau et � les 
 * ins�rer, au bon endroit, dans le tableau tri� constitu� des valeurs 
 * pr�c�demment pioch�es et tri�es. Les valeurs sont pioch�es dans l�ordre o� 
 * elles apparaissent dans le tableau. Soit p l�indice de la valeur pioch�e, 
 * les (p-1) premi�res valeurs du tableau constituent le tableau tri� dans 
 * lequel va �tre ins�r� la pi�me valeur. Au d�but de l�algorithme, il faut 
 * consid�rer que la liste constitu�e du seul premier �l�ment est tri� : c�est 
 * vrai puisque cette liste ne comporte qu�un seul �l�ment. Ensuite, on ins�re 
 * le second �l�ment (p=2), puis le troisi�me (p=3) etc. Ainsi, p varie 
 * de 2 � n, o� n est le nombre total d��l�ments du tableau.
 * 
 * Le probl�me de cet algorithme est qu�il faut parcourir le tableau tri� pour 
 * savoir � quel endroit ins�rer le nouvel �l�ment, puis d�caler d�une case 
 * toutes les valeurs sup�rieures � l��l�ment � ins�rer. En pratique, le tableau
 * class� est parcouru de droite � gauche, c�est � dire dans l�ordre 
 * d�croissant. Les �l�ments sont donc d�cal�s vers la droite tant que l��l�ment
 * � ins�rer est plus petit qu�eux.. D�s que l��l�ment � ins�rer est plus grand 
 * qu�un des �l�ments du tableau tri�e il n�y a plus de d�calage, et l��l�ment 
 * est ins�r� dans la case laiss�e vacante par les �l�ments qui ont �t� d�cal�s.
 * 
 * @Reference Author : Nicolas DAILLY http://www.dailly.info/Tri-bulle
 */
public class InsertionSortBO extends ToSortBC{

	private JProgressBar progressBar;
	
	/**
	 * Constructeur
	 */
	public InsertionSortBO (TabObjetToSortModel tab, JProgressBar progressBar) { 
		super(tab); 
		this.progressBar = progressBar; 
	}


	/**
	 *  Methode qui va executer le tri
	 */
	@Override
	public void tri(){
		int limTrie;
		boolean placeTrouver;
		int j;
		ObjetToSortBM objetTemp = null;

		for(limTrie=1;limTrie < tailleTableau;limTrie++){
			objetTemp = tab.getTab(limTrie);
			j = limTrie-1;
			if(tab.getTab(j).isGreaterThan(objetTemp) == false ){ 
				placeTrouver = true;
			}else{
				placeTrouver = false;
			}
			while(j >= 0 && placeTrouver == false){
				tab.setTab( j+1 , tab.getTab(j));
				j = j-1;

				if(j >= 0){
					if(tab.getTab(j).isGreaterThan(objetTemp) == false ) 
						placeTrouver = true;
				}else{
					placeTrouver = true;
				}
			}
			tab.setTab(j+1, objetTemp );
			tab.redessine(); 
		}
		progressBar.setIndeterminate(false);
	     JOptionPane.showMessageDialog(progressBar.getParent().getParent().getParent(), 
	    		 Message.getMessageResourceString("popup_finished"), 
	    		 "Finished",
	    		 JOptionPane.INFORMATION_MESSAGE);	
	 	
	}
}