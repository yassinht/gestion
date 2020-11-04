package InterfaceGraphique;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import BaseDonnee.manipulationBD;

public class SupprimerMatiere extends JPanel {
manipulationBD bd = new manipulationBD();
JComboBox numTach;
	
	private static final long serialVersionUID = 1L;
	ClassPrincipale cp ;
	public SupprimerMatiere() {
		cp=new ClassPrincipale("SUPPRIMER MATIERE", 450, 200);
		cp.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		cp.setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.PNG"));
		
		//activer/desactiver les menuItems ... ici on desactive tous
				cp.mnEdition.setEnabled(false);
				cp.mnApropos.setEnabled(false);
				cp.mnFichiers.setEnabled(false);
		
		
		JLabel lblRechercherLaTache = new JLabel("Rechercher la Matiere \u00E0 Supprimer");
		lblRechercherLaTache.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechercherLaTache.setForeground(Color.BLUE);
		lblRechercherLaTache.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		
		JLabel lblNumTache = new JLabel("CHOISIR");
		lblNumTache.setFont(new Font("Shonar Bangla", Font.BOLD | Font.ITALIC, 12));
		
		
		numTach = new JComboBox();
		
		
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setForeground(Color.RED);
		btnSupprimer.setFont(new Font("Shonar Bangla", Font.BOLD, 14));
		btnSupprimer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   String matier =	(String)numTach.getSelectedItem();
				int a = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette matiere?", "SUPPRIMER MATIERE", JOptionPane.YES_NO_OPTION);
			    if(a==0){
			    	bd.SupprimerMatiere(matier);
			    	cp.dispose();
			    }
			}
		});
		btnSupprimer.setIcon(new ImageIcon("picture\\annul.PNG"));
		
		JButton btnAnnuler = new JButton("Quitter");
		btnAnnuler.setIcon(new ImageIcon("picture\\exit.png"));
		GroupLayout groupLayout = new GroupLayout(cp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
						.addComponent(lblRechercherLaTache)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNumTache)
							.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
							.addComponent(numTach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(150))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblRechercherLaTache)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumTache)
						.addComponent(numTach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSupprimer)
						.addComponent(btnAnnuler))
					.addGap(33))
		);
		cp.getContentPane().setLayout(groupLayout);
		cp.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cp.getContentPane(), lblNumTache, numTach, btnSupprimer, lblRechercherLaTache}));

		try  {
		bd.afficherTache();
		for(int i=0; i<bd.AfficherMatiere().getRowCount();i++){
			numTach.addItem(""+bd.AfficherMatiere().getValueAt(i, 0));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		btnAnnuler.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			      cp.dispose();	
			}});
	}
	public static void main(String[] args) {
		new accueilP();		
}
}

