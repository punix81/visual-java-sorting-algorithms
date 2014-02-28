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
 * @create  	11 d�c. 2010 00:49:14
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri � Bulle. 
 * L�algorithme du tri bulle - ou bubble sort - consiste � regarder les 
 * diff�rentes valeurs adjacentes d�un tableau, et � les permuter si le premier 
 * des deux �l�ments est sup�rieur au second. L�algorithme se d�roule ainsi : 
 * les deux premiers �l�ments du tableau sont compar�s, si le premier �l�ment 
 * est sup�rieur au second, une permutation est effectu�e. Ensuite, sont 
 * compar�s et �ventuellement permut�s les valeurs 2 et 3, 3 et 4 jusque (n-1) 
 * et n. Une fois cette �tape achev�e, il est certain que le dernier �l�ment du 
 * tableau est le plus grand. L�algorithme reprend donc pour classer les (n-1) 
 * �l�ments qui pr�c�dent. L�algorithme se termine quand il n�y a plus de 
 * permutations possibles. Pour classer les n valeurs du tableau, il faut, 
 * au pire, effectuer l�algorithme n fois.
 * 
 * Cet algorithme porte le nom de tri bulle car, petit � petit, les plus grands 
 * �l�ments du tableau remontent, par le jeu des permutations, en fin de 
 * tableau. Dans un aquarium il en va de m�me : les plus grosses bulles 
 * remontent plus rapidement � la surface que les petites qui restent coll�s 
 * au fond.
 * 
 * Il existe plusieures variantes de cet algorithme :
 * - La premi�re consiste � n�effectuer les comparaisons que sur les �l�ments du
 * tableau qui ne sont pas remont�s � la surface. Ainsi, si n est le nombre 
 * d��l�ments du tableau et p le nombre de fois o� le parcours complet du 
 * tableau a �t� effectu�, a chaque it�ration, seul les (n-p) premiers �l�ments 
 * sont compar�s. Le gain de temps apport� par cette otimisation est d�ailleurs 
 * loin d��tre n�gligeable, c�est pourquoi une version de ce tri bulle optimis� 
 * est �galement pr�sent�e.
 * - Une autre variante du tri bulle, qui n�est pas tr�s diff�rente, consiste � 
 * faire descendre les plus petites valeurs au d�but du tableau. Dans ce cas, 
 * le tableau est parcouru, non plus de gauche � droite, mais de droite � 
 * gauche. Dans sa version optimis�e, ce sont les (n-p) derniers �l�ments qui 
 * sont compar�s. Cette variante est utilis�e pour impl�menter le tri bulle 
 * dans le cas de listes ou de piles.
 * - La seconde consiste � reprendre au d�but chaque fois qu�une permutation est
 * d�tect�e. Ainsi, les plus petits et les plus grands �l�ments vont tout 
 * doucement migrer en d�but et en fin de tableau. Cette version de l�algorithme
 * est aussi connue sous le nom de "tri Shaker" ou de "tri Shuttle".
 * - Une autre version est le "tri Boustrophedon" ou "bidirectionnel". Elle 
 * consiste � parcourir le tableau de gauche � droite, puis de droite � gauche, 
 * le changement de direction ayant lieu chaque fois que l�une des extr�mit�s 
 * est atteinte. Ainsi, les plus petits �l�ments du tableau descendent au m�me 
 * rythme que remontent les plus gros �l�ments.
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
