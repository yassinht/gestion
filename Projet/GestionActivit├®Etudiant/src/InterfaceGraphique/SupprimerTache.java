package InterfaceGraphique;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import BaseDonnee.manipulationBD;

public class SupprimerTache extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    manipulationBD bd = new manipulationBD();
    JComboBox comboBox;
    JComboBox comboBox_1;
	/**
	 * Create the panel.
	 */
	public SupprimerTache() {
		final ClassPrincipale cp =new ClassPrincipale("SUPPRIMER TACHE", 450, 200);
		cp.setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.PNG"));
		cp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//activer/desactiver les menuItems ... ici on desactive tous
		cp.mnEdition.setEnabled(false);
		cp.mnApropos.setEnabled(false);
		cp.mnFichiers.setEnabled(false);


       
		
		JLabel lblRechercherLaTache = new JLabel("Rechercher la tache \u00E0 Supprimer");
		lblRechercherLaTache.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechercherLaTache.setForeground(Color.BLUE);
		lblRechercherLaTache.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		
		JLabel lblNumTache = new JLabel("CHOISIR");
		lblNumTache.setFont(new Font("Shonar Bangla", Font.BOLD | Font.ITALIC, 12));
		
		
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setForeground(Color.RED);
		btnSupprimer.setFont(new Font("Shonar Bangla", Font.BOLD, 14));
		
		
		btnSupprimer.setIcon(new ImageIcon("picture\\annul.PNG"));
		
		JButton btnAnnuler = new JButton("Quitter");
		btnAnnuler.setIcon(new ImageIcon("picture\\exit.png"));
		
		comboBox = new JComboBox();
		
		comboBox_1 = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(cp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblRechercherLaTache)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNumTache)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
					.addGap(18))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblRechercherLaTache)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumTache)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSupprimer)
						.addComponent(btnAnnuler))
					.addGap(33))
		);
		cp.getContentPane().setLayout(groupLayout);
		cp.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cp.getContentPane(), lblNumTache, btnSupprimer, lblRechercherLaTache}));

		try  {
		bd.afficherTache();
		for(int i=0; i<bd.afficherTache().getRowCount();i++){
			comboBox_1.addItem(""+bd.afficherTache().getValueAt(i, 0));
			comboBox.addItem(""+bd.afficherTache().getValueAt(i, 1));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		btnAnnuler.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cp.dispose();
			}
			
		});
		btnSupprimer.addActionListener(new ActionListener(){
			String matiere=(String)comboBox.getSelectedItem();
			String typeTach=(String)comboBox_1.getSelectedItem();
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int rest =JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette tache?", "SUPPRIMER TACHE", JOptionPane.YES_NO_OPTION);
				if(rest==0){
					bd.SupprimerTache(typeTach, matiere);
				    System.out.println(bd.requete);	
					cp.dispose();
				}
			else{
			}
			      
			
			}}
		);
		
	}
	public static void main(String[] args) {
		new SupprimerTache();
		
}
}
