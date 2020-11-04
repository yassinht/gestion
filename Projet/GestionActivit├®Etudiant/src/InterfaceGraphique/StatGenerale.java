package InterfaceGraphique;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import BaseDonnee.manipulationBD;
import java.awt.Font;
import java.awt.Toolkit;

public class StatGenerale extends JPanel {
	/**
	 * 
	 */
	manipulationBD bd = new manipulationBD();
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	ClassPrincipale cp ;
	public StatGenerale() {
		cp = new ClassPrincipale("TACHES A FAIRE",400,300);
		cp.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fire-PC\\Documents\\adt-bundle-windows-x86-20140702\\pROJETaNDROID\\GestionActivit\u00E9Etudiant\\picture\\logo.PNG"));
		//activer/desactiver les menuItems
				cp.mnEdition.setEnabled(false);
				cp.mnApropos.setEnabled(false);
				cp.mnFichiers.setEnabled(false);
				
		
		JButton btnMettreJour = new JButton("Retour ");
		btnMettreJour.setIcon(new ImageIcon(StatGenerale.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(cp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(btnMettreJour))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnMettreJour)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		cp.getContentPane().setLayout(groupLayout);
		table.setModel(bd.afficherTache());
		btnMettreJour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cp.dispose();
			}
		});
	}
	
  
	public static void main(String[] args) {
		new StatGenerale();
}
}

