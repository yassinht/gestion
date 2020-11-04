package InterfaceGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import BaseDonnee.manipulationBD;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class nouveauTache extends JPanel implements ActionListener {
	JOptionPane mssageConf;
	manipulationBD bd = new manipulationBD();
	JComboBox Matiere;
	JComboBox typeTache;
	JComboBox Jour;
	JComboBox Moi;
	JComboBox Annee;
	JComboBox Heure;
	JComboBox Minute;
	ClassPrincipale cp = new ClassPrincipale("NOUVELLE TACHE", 330,300);
	private static final long serialVersionUID = 1L;
	public nouveauTache() {
		
		//activation des menu items
		cp.mntmNouveau.setEnabled(true);
		cp.mntmSupprimer.setEnabled(false);
		cp.mntmCouper.setEnabled(false);
		cp.mntmColler.setEnabled(false);
		cp.mntmCopier.setEnabled(false);
		cp.mntmAide.setEnabled(false);
		
		cp.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		cp.setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.PNG"));
		cp.getContentPane().setBackground(Color.LIGHT_GRAY);
		cp.getContentPane().setFont(new Font("Tunga", Font.BOLD, 12));
		
		JLabel lblTypeTache = new JLabel("TYPE DE TACHE");
		lblTypeTache.setFont(new Font("Showcard Gothic", Font.BOLD, 9));
		
		typeTache = new JComboBox();
		typeTache.setModel(new DefaultComboBoxModel(new String[] {"EXAMEN","CC", "TPE","COURS"}));
		
		JLabel lblMatiere = new JLabel("MATIERE");
		lblMatiere.setFont(new Font("Showcard Gothic", Font.BOLD, 11));
		
		Matiere = new JComboBox();
		
		JLabel lblJour = new JLabel("JOUR");
		lblJour.setFont(new Font("Showcard Gothic", Font.BOLD, 11));
		
		Jour = new JComboBox();
		//ajout des jours
		for(int i=1; i<32; i++){
			Jour.addItem(""+i);
		}
		
		
		Moi = new JComboBox();
		//ajout des mois
		for(int i=01;i<13;i++){
			Moi.addItem(""+i);
		}
		
		
		Annee = new JComboBox();
		//ajout d'année
		for(int i=0; i<20;i++){
			int annee =2013+i;
			Annee.addItem(""+annee);
		}
		
		
		JLabel lblHeure = new JLabel("HEURE");
		lblHeure.setFont(new Font("Showcard Gothic", Font.BOLD, 11));
		
		Heure = new JComboBox();
		//ajout heure, de 7h à 17h comme horaires pssible
		
		for(int i=1; i<13; i++){
			int hourr =6+i;
			Heure.addItem(""+hourr);
			i=i+0;
		}
		Minute = new JComboBox();
		//ajout minute
			Minute.addItem("00");
			Minute.addItem("15");
			Minute.addItem("30");
			Minute.addItem("45");
			
		JButton Planifier = new JButton("PLANIFIER");
		
		JButton BtnAnnulee = new JButton("ANNULER");
		
		JLabel lblPlanificationDunNouveau = new JLabel("PLANIFICATION D'UN NOUVEAU TACHE");
		lblPlanificationDunNouveau.setForeground(Color.BLUE);
		lblPlanificationDunNouveau.setFont(new Font("Urdu Typesetting", Font.BOLD, 11));
		lblPlanificationDunNouveau.setBackground(Color.GRAY);
		
		
		GroupLayout groupLayout = new GroupLayout(cp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTypeTache)
								.addComponent(lblJour)
								.addComponent(lblHeure)
								.addComponent(Planifier)
								.addComponent(lblMatiere))
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(Jour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(Moi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(Annee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(typeTache, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(Heure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(Minute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(Matiere, 0, 141, Short.MAX_VALUE))
								.addComponent(BtnAnnulee)))
						.addComponent(lblPlanificationDunNouveau))
					.addGap(35))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlanificationDunNouveau)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTypeTache)
						.addComponent(typeTache, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Matiere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatiere))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJour)
						.addComponent(Jour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Moi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Annee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeure)
						.addComponent(Heure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Minute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Planifier)
						.addComponent(BtnAnnulee))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		cp.getContentPane().setLayout(groupLayout);
		
		try  {
			bd.afficherTache();
			for(int i=0; i<bd.AfficherMatiere().getRowCount();i++){
				Matiere.addItem(""+bd.AfficherMatiere().getValueAt(i, 0));
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		
		BtnAnnulee.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cp.dispose();
			}
			
		});
		Planifier.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    String typeTach = (String) typeTache.getSelectedItem();
				String matiere= (String) Matiere.getSelectedItem();
				//date, on recupere le jr, moi et l'anné
				int j = Jour.getSelectedIndex()+1;
				int m = Moi.getSelectedIndex()+1;
				int a =Integer.parseInt((String) Annee.getSelectedItem());
				//la date en String
				String date =(a+"-"+m+"-"+j);
				//heur, on recupere l'heure, minute
				String h=(String) Heure.getSelectedItem();
				String mi =(String) Minute.getSelectedItem();
				//Heur en String
				//si 30 fevrier ou 31
				boolean testDate;
				if(j>=30 && m==2){
					testDate=false;
				}
				else{
					testDate=true;
				}
				String heur =(h+"h:"+mi);
			    	
			int test =	JOptionPane.showConfirmDialog(null,"Voulez vous vraiment ajouter cette tache ?", "Ajouter Tache",JOptionPane.YES_NO_OPTION );
			if(testDate==true){
			  if(test==0){
				bd.AjouterTache(matiere, typeTach, date,heur);
				cp.dispose();}	
			}
			else{
				   JOptionPane.showMessageDialog(null, "LA DATE ENTREE EST INVALIDE", "ERREUR DATE", JOptionPane.ERROR_MESSAGE);
			   }
			}});
	}

	public static void main(String[] args) {
		new nouveauTache();
		
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
