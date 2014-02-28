package ch.mas.ict.sort.business.object;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.ressources.Message;
import ch.mas.ict.sort.business.controller.ToSortBC;

/**
 * 
 * @file    	TrieurRapideBO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 d�c. 2010 00:51:15
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri rapide.
 * L�algorithme de tri rapide, "quick sort" en anglais, est un algorithme de 
 * type dichotomique. Son principe consiste � s�parer l�ensemble des �l�ments 
 * en deux parties. La diff�rence par rapport au tri fusion, vu pr�c�demment, 
 * est que la s�paration des diff�rentes valeurs ne s�effectue pas n�importe 
 * comment. Pour effectuer la s�paration, une valeur pivot est choisie. 
 * Les valeurs sont r�parties en deux ensembles suivant qu�elles sont plus 
 * grandes ou plus petites que le pivot. Ensuite, les deux ensembles sont tri�s 
 * s�par�ment, suivant la m�me m�thode. L�algorithme, tout comme le tri fusion, 
 * est r�cursif, mais cette fois, il n�est pas n�cessaire de fusionner les deux 
 * ensembles. Le r�sultat du tri est �gal au tri de l�ensemble dont les valeurs 
 * sont inf�rieures au pivot concat�n� � l�ensemble des valeurs sup�rieures au 
 * pivot, ce dernier �tant pris en sandwich entre les deux ensembles.
 * 
 * @Reference Author : Nicolas DAILLY http://www.dailly.info/Tri-bulle
 */
public class QuickSortBO extends ToSortBC{
	
	private JProgressBar progressBar;

	/**
	 * Constructeur
	 */
	public QuickSortBO(TabObjetToSortModel tab, JProgressBar progressBar) {
		super(tab); // lance le tri
		this.progressBar = progressBar; 
	}

	/**
	 * methode qui va executer le tri
	 * on lance une premiere fois cette fonction recursive
	 */
	@Override
	public void tri(){
		TriRapide(tab,0,tailleTableau-1);
        JOptionPane.showMessageDialog(progressBar.getParent().getParent().getParent(), Message.getMessageResourceString("popup_finished"), "Finished",JOptionPane.INFORMATION_MESSAGE);	
	}

	/**
	 * 
	 * @param tab
	 * @param p
	 * @param q
	 */
	public void TriRapide(TabObjetToSortModel tab, int p, int q){
		int r;
		if(p<q){
			r = Partitionner(tab,p,q);
			TriRapide(tab,p,r);
			TriRapide(tab,(r+1),q);
			tab.redessine(); 
		}
		progressBar.setIndeterminate(false);
			
	}

	/**
	 * 
	 * @param tab
	 * @param bas
	 * @param haut
	 * @return
	 */
	public int Partitionner(TabObjetToSortModel tab,int bas, int haut){
		boolean stop = false;
		int i,j;
		i = bas - 1;
		j = haut + 1;

		while(stop == false){
			do{
				j = j-1;
			}while(tab.getTab(bas).isGreaterThan(tab.getTab(j)) == false ); 
			do{
				i = i+1;
			}while(tab.getTab(i).isGreaterThan(tab.getTab(bas)) == false);

			if(i < j){
				tab.permutation(i , j);
			}else{
				stop = true;
			}
		}
		return j;
	}
}