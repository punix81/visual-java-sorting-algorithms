package ch.mas.ict.view.visual;

import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ch.mas.ict.controller.SortController;
import ch.mas.ict.ressources.Message;

/**
 * 
 * @file    	MenuBar.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:53:54
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe qui définie la menu bar visuelle.
 */
public class MenuBar extends JMenuBar  {

	private static final long serialVersionUID = -4507271554882579647L;
	public JMenuItem menuQuitter, menuApropos, menuRedessiner;
	public JCheckBoxMenuItem cbm1, cbm2;
	private SortController menuController;

	public MenuBar(final SortController controller){
		this.menuController = controller;
		
		JMenu menuFichier = new JMenu(Message.getMessageResourceString("menubar_file"));
		menuQuitter = new JMenuItem(Message.getMessageResourceString("menubar_quit"));
		menuFichier.add(menuQuitter);
		JMenu menuEdition = new JMenu("Edition");
		JMenu menuDessin = new JMenu("Dessin");

		cbm1 = new JCheckBoxMenuItem("Formes");
		cbm2 = new JCheckBoxMenuItem("Sinus");

		cbm1.setSelected(true); // La case de l'item 1 sera cochée

		menuDessin.add(cbm1);
		menuDessin.add(cbm2);

		menuEdition.add(menuDessin);
		menuRedessiner = new JMenuItem("Redessiner");
		menuEdition.add(menuRedessiner);
		JMenu menuAide = new JMenu("Aide");
		menuApropos = new JMenuItem("A propos");
		menuAide.add(menuApropos);

		menuQuitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				controller.shutDownAll();
			}
		});

		menuApropos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {

			}
		});


		add(menuFichier);
		add(menuEdition);
		add(menuAide);
	}



}
