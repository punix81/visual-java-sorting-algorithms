package ch.mas.ict.view.visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import ch.mas.ict.controller.SortController;
import ch.mas.ict.events.SortChangedEvent;
import ch.mas.ict.ressources.Message;
import ch.mas.ict.sort.business.controller.DrawSort;
import ch.mas.ict.sort.business.model.SynchronizerBM;
import ch.mas.ict.view.SortView;

/**
 * 
 * @file    	Window.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 d�c. 2010 00:54:05
 * @mail 		lopespaulo18@gmail.com
 * @Description Classe de la fenetre principale. Visuelle principale.
 */
public class Window	 extends SortView implements PropertyChangeListener {

	private JFrame frame = null;
	private JPanel canvasPanel;
	private JButton clearButton;
	private JButton displayButton;
	private JPanel displayPanel;
	private JTextField nbElementField  ;
	private JLabel nbElementLabel;
	private JPanel progressionPanel;
	private JButton sortButton;
	private JLabel sortObjectLabel;
	private JProgressBar sortProgressBar;
	private JComboBox sortTypeComboBox;
	private JLabel sortTypeLabel;
	private JPanel systemPanel;
	private JComboBox typeObjetComboBox;
	private MenuBar menuBar; 

	private  JPanel top;




	/**
	 * 
	 * @param controller
	 */
	public Window(SortController controller) {
		this(controller, 0);             	
	}

	/**
	 * 
	 * @param controller
	 * @param volume
	 */
	public Window(SortController controller, int volume){
		super(controller); 
		buildFrame(volume);
	}

	/**
	 * 
	 * @param volume
	 */
	private void buildFrame(int volume) {
		frame = new JFrame();
		systemPanel = new JPanel();
		sortTypeLabel = new JLabel();
		sortObjectLabel = new JLabel();
		nbElementLabel = new JLabel();
		nbElementField = new JTextField();
		typeObjetComboBox = new JComboBox();
		displayPanel = new JPanel();
		canvasPanel = new JPanel();
		progressionPanel = new JPanel();
		
		setProgressBar(new JProgressBar());
		sortButton = new JButton(Message.getMessageResourceString("bt_sort"));
		clearButton = new JButton(Message.getMessageResourceString("bt_Clear"));
		displayButton = new JButton(Message.getMessageResourceString("bt_display"));
		menuBar = new MenuBar(this.getController()); 

		Vector<String> listeTri = new Vector<String>(7);  

		listeTri.addElement (Message.getMessageResourceString("sort_insertion")); 
		listeTri.addElement (Message.getMessageResourceString("sort_perutation")); 
		listeTri.addElement (Message.getMessageResourceString("sort_bubble")); 
		listeTri.addElement (Message.getMessageResourceString("sort_DoubleBubble")); 
		listeTri.addElement (Message.getMessageResourceString("sort_tas")); 
		listeTri.addElement (Message.getMessageResourceString("sort_fusion")); 
		listeTri.addElement (Message.getMessageResourceString("sort_quicksort")); 
		sortTypeComboBox = new JComboBox (listeTri);  	

		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle(Message.getMessageResourceString("windowTitel"));

		systemPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(Message.getMessageResourceString("window_System")));
		sortTypeLabel.setText(Message.getMessageResourceString("label_TypeSort"));
		sortObjectLabel.setText(Message.getMessageResourceString("label_SortTypeObject"));
		nbElementLabel.setText(Message.getMessageResourceString("label_nombreElement"));
		
		/* Buttons */
		sortButton.setEnabled(false);
		clearButton.setEnabled(false);
		sortButton.setIcon(new javax.swing.ImageIcon("./icons/sort.png"));
		clearButton.setIcon(new javax.swing.ImageIcon("./icons/clear.png"));
		displayButton.setIcon(new javax.swing.ImageIcon("./icons/display.png"));

		displayButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				displayPerformed(evt);
			}
		});

		clearButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				clearPerformed(evt);
			}
		});

		sortButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				sortPerformed(evt);
			}
		});
		
		typeObjetComboBox.setModel(new DefaultComboBoxModel(new String[] { 	
				Message.getMessageResourceString("label_Integer"), 
				Message.getMessageResourceString("label_Real"),
				Message.getMessageResourceString("label_Stik") 
			}));

		org.jdesktop.layout.GroupLayout systemPanelLayout = new org.jdesktop.layout.GroupLayout(systemPanel);
		systemPanel.setLayout(systemPanelLayout);
		systemPanelLayout.setHorizontalGroup(
				systemPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(systemPanelLayout.createSequentialGroup()
						.addContainerGap()
						.add(systemPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
								.add(org.jdesktop.layout.GroupLayout.TRAILING, nbElementLabel)
								.add(org.jdesktop.layout.GroupLayout.TRAILING, sortObjectLabel)
								.add(org.jdesktop.layout.GroupLayout.TRAILING, sortTypeLabel))
								.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
								.add(systemPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
										.add(org.jdesktop.layout.GroupLayout.LEADING, sortTypeComboBox, 0, 179, Short.MAX_VALUE)
										.add(systemPanelLayout.createSequentialGroup()
												.add(nbElementField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
												.add(displayButton))
												.add(typeObjetComboBox, 0, 179, Short.MAX_VALUE))
												.addContainerGap())
		);
		systemPanelLayout.setVerticalGroup(
				systemPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(systemPanelLayout.createSequentialGroup()
						.add(29, 29, 29)
						.add(systemPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
								.add(sortTypeLabel)
								.add(sortTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
								.add(14, 14, 14)
								.add(systemPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
										.add(sortObjectLabel)
										.add(typeObjetComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.add(18, 18, 18)
										.add(systemPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
												.add(nbElementLabel)
												.add(nbElementField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(displayButton))
												.addContainerGap(237, Short.MAX_VALUE))
		);

		displayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(Message.getMessageResourceString("panel_Display")));


		canvasPanel.setBackground(new Color(204, 204, 255));


		setSync(new SynchronizerBM(getProgressBar()));
		top = new JPanel();  // creation de la fenetre principale
		setDessin(new DrawSort(getSync()));  // creation du panneau de dessin
		getDessin().setBackground(  Color.white);  // La couleur de fond du canvas est blanche
		top.setLayout (new BorderLayout() );
		top.add ( getDessin(), BorderLayout.CENTER ); // place le dessin sur la fenetre graphique

		canvasPanel.setLayout (new BorderLayout() );
		canvasPanel.add(top, BorderLayout.CENTER );

		progressionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(Message.getMessageResourceString("panel_Progression")));

		org.jdesktop.layout.GroupLayout progressionPanelLayout = new org.jdesktop.layout.GroupLayout(progressionPanel);
		progressionPanel.setLayout(progressionPanelLayout);
		progressionPanelLayout.setHorizontalGroup(
				progressionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING, progressionPanelLayout.createSequentialGroup()
						.addContainerGap()
						.add(getProgressBar(), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(sortButton)
						.add(18, 18, 18)
						.add(clearButton)
						.addContainerGap())
		);
		progressionPanelLayout.setVerticalGroup(
				progressionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING, progressionPanelLayout.createSequentialGroup()
						.addContainerGap()
						.add(progressionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
								.add(org.jdesktop.layout.GroupLayout.LEADING, getProgressBar(), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
								.add(org.jdesktop.layout.GroupLayout.LEADING, sortButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.add(org.jdesktop.layout.GroupLayout.LEADING, clearButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.add(20, 20, 20))
		);

		org.jdesktop.layout.GroupLayout displayPanelLayout = new org.jdesktop.layout.GroupLayout(displayPanel);
		displayPanel.setLayout(displayPanelLayout);
		displayPanelLayout.setHorizontalGroup(
				displayPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING, displayPanelLayout.createSequentialGroup()
						.addContainerGap()
						.add(displayPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
								.add(org.jdesktop.layout.GroupLayout.LEADING, progressionPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.add(org.jdesktop.layout.GroupLayout.LEADING, canvasPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);
		displayPanelLayout.setVerticalGroup(
				displayPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(displayPanelLayout.createSequentialGroup()
						.add(canvasPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(progressionPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
		);

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.add(displayPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.add(18, 18, 18)
						.add(systemPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
								.add(org.jdesktop.layout.GroupLayout.LEADING, displayPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.add(org.jdesktop.layout.GroupLayout.LEADING, systemPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);

		frame.pack();
	}

	@Override
	public void close() {
		frame.dispose();
	}

	@Override
	public void display() {
		frame.setVisible(true);
	}

	void shutDownPerformed(ActionEvent e) { 
		this.getController().shutDownAll();
	}

	@Override
	public void volumeChanged(SortChangedEvent event) {
		this.getController().shutDownAll();

	}

	@Override
	public void displayPerformed(ActionEvent arg0) {
		if (! nbElementField.getText().equals("")||  nbElementField.getText()== null) {
			if ((Integer.parseInt(nbElementField.getText()) <=2000)&&(Integer.parseInt(nbElementField.getText()) >=25) ) {
				sortButton.setEnabled(true);
				clearButton.setEnabled(true);
				displayButton.setEnabled(false);
				sortTypeComboBox.setEnabled(false);
				typeObjetComboBox.setEnabled(false);
				nbElementField.setEnabled(false);
				getController().notifyVolumeChanged(sortTypeComboBox.getSelectedIndex() , typeObjetComboBox.getSelectedIndex(), Integer.parseInt(nbElementField.getText()),top.getWidth(), top.getHeight() );
				getController().displayCanvas();
			} else {
				JOptionPane.showMessageDialog(canvasPanel,Message.getMessageResourceString("message_error1"), "error", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(canvasPanel,new JLabel(Message.getMessageResourceString("message_error2")) , "error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void clearPerformed(ActionEvent arg0) {
		sortButton.setEnabled(false);
		clearButton.setEnabled(false);
		displayButton.setEnabled(true);
		sortTypeComboBox.setEnabled(true);
		typeObjetComboBox.setEnabled(true);
		nbElementField.setEnabled(true);
		nbElementField.setText("");
		getController().cancelCanvas();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			getProgressBar().setValue(progress);

		} 
	}

	@Override
	public void sortPerformed(ActionEvent arg0) {
		getProgressBar().setIndeterminate(true);
		sortButton.setEnabled(false);
		getController().displayAndSorTCanvas();
	}
}
