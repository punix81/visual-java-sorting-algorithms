package ch.mas.ict.sort.business.object;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.ressources.Message;
import ch.mas.ict.sort.business.controller.ToSortBC;


/**
 * 
 * @file    	TrieurBulleBO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:49:14
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri à Bulle. 
 * L’algorithme du tri bulle - ou bubble sort - consiste à regarder les 
 * différentes valeurs adjacentes d’un tableau, et à les permuter si le premier 
 * des deux éléments est supérieur au second. L’algorithme se déroule ainsi : 
 * les deux premiers éléments du tableau sont comparés, si le premier élément 
 * est supérieur au second, une permutation est effectuée. Ensuite, sont 
 * comparés et éventuellement permutés les valeurs 2 et 3, 3 et 4 jusque (n-1) 
 * et n. Une fois cette étape achevée, il est certain que le dernier élément du 
 * tableau est le plus grand. L’algorithme reprend donc pour classer les (n-1) 
 * éléments qui précédent. L’algorithme se termine quand il n’y a plus de 
 * permutations possibles. Pour classer les n valeurs du tableau, il faut, 
 * au pire, effectuer l’algorithme n fois.
 * 
 * Cet algorithme porte le nom de tri bulle car, petit à petit, les plus grands 
 * éléments du tableau remontent, par le jeu des permutations, en fin de 
 * tableau. Dans un aquarium il en va de même : les plus grosses bulles 
 * remontent plus rapidement à la surface que les petites qui restent collés 
 * au fond.
 * 
 * Il existe plusieures variantes de cet algorithme :
 * - La première consiste à n’effectuer les comparaisons que sur les éléments du
 * tableau qui ne sont pas remontés à la surface. Ainsi, si n est le nombre 
 * d’éléments du tableau et p le nombre de fois où le parcours complet du 
 * tableau a été effectué, a chaque itération, seul les (n-p) premiers éléments 
 * sont comparés. Le gain de temps apporté par cette otimisation est d’ailleurs 
 * loin d’être négligeable, c’est pourquoi une version de ce tri bulle optimisé 
 * est également présentée.
 * - Une autre variante du tri bulle, qui n’est pas très différente, consiste à 
 * faire descendre les plus petites valeurs au début du tableau. Dans ce cas, 
 * le tableau est parcouru, non plus de gauche à droite, mais de droite à 
 * gauche. Dans sa version optimisée, ce sont les (n-p) derniers éléments qui 
 * sont comparés. Cette variante est utilisée pour implémenter le tri bulle 
 * dans le cas de listes ou de piles.
 * - La seconde consiste à reprendre au début chaque fois qu’une permutation est
 * détectée. Ainsi, les plus petits et les plus grands éléments vont tout 
 * doucement migrer en début et en fin de tableau. Cette version de l’algorithme
 * est aussi connue sous le nom de "tri Shaker" ou de "tri Shuttle".
 * - Une autre version est le "tri Boustrophedon" ou "bidirectionnel". Elle 
 * consiste à parcourir le tableau de gauche à droite, puis de droite à gauche, 
 * le changement de direction ayant lieu chaque fois que l’une des extrémités 
 * est atteinte. Ainsi, les plus petits éléments du tableau descendent au même 
 * rythme que remontent les plus gros éléments.
 * 
 * @Reference Author : Nicolas DAILLY http://www.dailly.info/Tri-bulle
 */
public class BubbleSortBO extends ToSortBC{ 

	private JProgressBar progressBar;

	/**
	 * Constructeur
	 */
	public BubbleSortBO (TabObjetToSortModel tab,JProgressBar progressBar) { 
		super(tab);
		this.progressBar= progressBar; 
	}

	/**
	 *  Methode qui va executer le tri
	 */
	@Override
	public void tri(){ 

		int i=tailleTableau-1 ,j;
		boolean permut = true; // si la permutation a eu lieu

		while(i >0  && permut == true){ // si le tableau n'est pas fini d'etre trie
			permut = false; // pas encore eu de permutation
			for(j=0 ; j<i ; j ++){  // on parcourt tout le tableau sauf les parties deja triees
				if(tab.getTab(j).isGreaterThan(tab.getTab(j+1)) == true ){  // si l'objet courant est plus grand que celui qui est a sa droite
					tab.permutation(j , j+1); // on permute les deux objets
					permut = true;  // la permutation a eu lieu
					tab.redessine();  // on redessine pour voir les modifications
				}
			}
			i = i-1;  // un objet de plus a ete correctement placer de maniere triee
		}
		progressBar.setIndeterminate(false);
		JOptionPane.showMessageDialog(progressBar.getParent().getParent().getParent(),
				Message.getMessageResourceString("popup_finished"), 
				"Finished",
				JOptionPane.INFORMATION_MESSAGE);	

	}

}
