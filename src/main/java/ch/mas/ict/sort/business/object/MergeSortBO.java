package ch.mas.ict.sort.business.object;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import ch.mas.ict.model.TabObjetToSortModel;
import ch.mas.ict.ressources.Message;
import ch.mas.ict.sort.business.controller.ToSortBC;
import ch.mas.ict.sort.business.model.ObjetToSortBM;

/**
 * 
 * @file    	TrieurFusionBO.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:49:32
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui execute l'algorithme d'un tri par Fusion.
 * Le tri fusion est construit suivant la stratégie "diviser pour régner", 
 * en anglais "divide and conquer". Le principe de base de la stratégie "diviser
 * pour régner" est que pour résoudre un gros problème, il est souvent plus 
 * facile de le diviser en petits problèmes élémentaires. Une fois chaque petit 
 * problème résolu, il n’y a plus qu’à combiner les différentes solutions pour 
 * résoudre le problème global. La méthode "diviser pour régner" est tout à fait 
 * applicable au problème de tri : plutôt que de trier le tableau complet, il 
 * est préférable de trier deux sous tableaux de taille égale, puis de fusionner 
 * les résultats.
 * L’algorithme proposé ici est récursif. En effet, les deux sous tableaux 
 * seront eux même triés à l’aide de l’algorithme de tri fusion. Un tableau ne 
 * comportant qu’un seul élément sera considéré comme trié : c’est la condition 
 * sine qua non sans laquelle l’algorithme n’aurais pas de conditions d’arrêt. 
 * Etapes de l’algorithme :
 * - Division de l’ensemble de valeurs en deux parties
 * - Tri de chacun des deux ensembles
 * - Fusion des deux ensembles
 * 
 * @Reference Author : Nicolas DAILLY http://www.dailly.info/Tri-bulle
 */
public class MergeSortBO extends ToSortBC{  

	private ObjetToSortBM tableauGauche[] = null; // les tableaux d'objets pour les coupures
	private ObjetToSortBM tableauDroit[] = null; // les tableaux d'objets pour les coupures
	private JProgressBar progressBar;
	
	/**
	 * Constructeur
	 * @param tab
	 */
	public MergeSortBO(TabObjetToSortModel tab, JProgressBar progressBar) {
		super(tab);
		this.progressBar= progressBar; 
	}

	/**
	 * Methode qui va executer le tri
	 */
	@Override
	public void tri(){
		TriFusion(tab,0,tailleTableau-1);  // on lance une premiere fois cette fonction recursive
	     JOptionPane.showMessageDialog(progressBar.getParent().getParent().getParent(), 
	    		 Message.getMessageResourceString("popup_finished"), 
	    		 "Finished",
	    		 JOptionPane.INFORMATION_MESSAGE);	
	}

	/**
	 * Fonction reccursive
	 * @param tab
	 * @param indiceGauche
	 * @param indiceDroit
	 */
	public void TriFusion(TabObjetToSortModel tab, int indiceGauche, int indiceDroit){ 

		int coupure;
		if(indiceGauche < indiceDroit){ // s'il y a plus d'un element dans le tableau
			coupure = (indiceGauche+indiceDroit)/2; // on localise la coupure
			TriFusion(tab,indiceGauche,coupure);  // on lance recursivement la fonction pour qu elle coupe le tableau de gauche
			TriFusion(tab,coupure+1,indiceDroit);  // on lance recursivement la fonction pour qu elle coupe le tableau de droite
			Fusion(tab,indiceGauche,coupure,indiceDroit);  // puis on fait la fusion des deux tableaux
			tab.redessine();   // on redessine pour voir les modifications apres la fusion
		}
		progressBar.setIndeterminate(false);
	}

	/**
	 * Fonction qui permet de faire la fusion entre deux tableaux
	 * @param tab 
	 * @param Gauche
	 * @param milieu
	 * @param Droit
	 */
	public void Fusion(TabObjetToSortModel tab,int Gauche, int milieu,int Droit){
		int i,j,k;
		tableauGauche = new ObjetToSortBM [milieu - Gauche + 1];  // creer un tableau d'objets
		tableauDroit = new ObjetToSortBM [Droit - milieu];  // creer un tableau d'objets

		int tailleGauche,tailleDroit;
		tailleGauche = (milieu - Gauche + 1);
		tailleDroit=Droit - milieu;

		for(i=0;i<tailleGauche;i++){  // on rempli le tableau de gauche
			tableauGauche[i] = tab.getTab(Gauche + i);
		}

		for(i=0;i<tailleDroit;i++){  // on rempli le tableau de droite
			tableauDroit[i] = tab.getTab(milieu+1+i);
		}

		i = 0;
		j = 0;
		k = Gauche;

		while(i < tailleGauche && j < tailleDroit){

			if(tableauGauche[i].isGreaterThan(tableauDroit[j]) == false){ // si l
				tab.setTab(k , tableauGauche[i]);  // place l'objet du tableau de gauche dans le tableau pour qu'il soit trie
				i = i+1;
			}else{
				tab.setTab(k , tableauDroit[j]);  // place l'objet du tableau de droite dans le tableau pour qu'il soit trie
				j = j + 1;
			}
			k = k+1;
		}

		if(i==tailleGauche){
			while(j < tailleDroit){
				tab.setTab(k , tableauDroit[j]); // place l'objet du tableau de droite dans le tableau pour qu'il soit trie
				j = j+1;
				k = k+1;
			}
		}else{
			while(i < tailleGauche){
				tab.setTab(k , tableauGauche[i]);  // place l'objet du tableau de gauche dans le tableau pour qu'il soit trie
				i = i+1;
				k = k+1;
			}
		}
	}
}