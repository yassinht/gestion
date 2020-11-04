package InterfaceGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BaseDonnee.manipulationBD;

public class Matiere extends JPanel {
	JButton btnAffiche = new JButton("Retour au Menu Principal");

	
	

	private static final long serialVersionUID = 1L;
	private JTable table;

	ClassPrincipale cp;
	public Matiere() {
		cp = new ClassPrincipale("MATIERES",800,350);
		cp.setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.PNG"));
		cp.setFont(new Font("Constantia", Font.BOLD, 12));
		//activer/desactiver les menuItems ... ici on desactive tous
		cp.mnEdition.setEnabled(false);
		cp.mnApropos.setEnabled(false);
		cp.mnFichiers.setEnabled(false);
		
		
		cp.setForeground(Color.BLACK);
		btnAffiche.setForeground(Color.BLUE);
		manipulationBD bd = new manipulationBD();
		
		
		btnAffiche.setIcon(new ImageIcon(Matiere.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		btnAffiche.setFont(new Font("SimSun-ExtB", Font.BOLD, 10));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(cp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(270)
					.addComponent(btnAffiche)
					.addContainerGap(323, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAffiche)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setFont(new Font("Sylfaen", Font.BOLD, 11));
		scrollPane.setViewportView(table);
		table.setModel(bd.AfficherMatiere());
		cp.getContentPane().setLayout(groupLayout);
		
	   btnAffiche.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cp.dispose();
 			}
	    });	
	}

	public static void main(String[] args) {
		new Matiere();
		}
}
