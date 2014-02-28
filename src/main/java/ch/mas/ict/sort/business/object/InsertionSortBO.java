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
 * @create  	11 déc. 2010 00:50:32
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri par Insertion.
 * Le tri par insertion est un autre algorithme que l’on peut qualifier de naïf.
 * Cet algorithme consiste à piocher une à une les valeurs du tableau et à les 
 * insérer, au bon endroit, dans le tableau trié constitué des valeurs 
 * précédemment piochées et triées. Les valeurs sont piochées dans l’ordre où 
 * elles apparaissent dans le tableau. Soit p l’indice de la valeur piochée, 
 * les (p-1) premières valeurs du tableau constituent le tableau trié dans 
 * lequel va être inséré la pième valeur. Au début de l’algorithme, il faut 
 * considérer que la liste constituée du seul premier élément est trié : c’est 
 * vrai puisque cette liste ne comporte qu’un seul élément. Ensuite, on insère 
 * le second élément (p=2), puis le troisième (p=3) etc. Ainsi, p varie 
 * de 2 à n, où n est le nombre total d’éléments du tableau.
 * 
 * Le problème de cet algorithme est qu’il faut parcourir le tableau trié pour 
 * savoir à quel endroit insérer le nouvel élément, puis décaler d’une case 
 * toutes les valeurs supérieures à l’élément à insérer. En pratique, le tableau
 * classé est parcouru de droite à gauche, c’est à dire dans l’ordre 
 * décroissant. Les éléments sont donc décalés vers la droite tant que l’élément
 * à insérer est plus petit qu’eux.. Dés que l’élément à insérer est plus grand 
 * qu’un des éléments du tableau triée il n’y a plus de décalage, et l’élément 
 * est inséré dans la case laissée vacante par les éléments qui ont été décalés.
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