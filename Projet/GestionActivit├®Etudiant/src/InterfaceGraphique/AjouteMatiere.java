package InterfaceGraphique;


import java.awt.Font;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import BaseDonnee.manipulationBD;
import java.awt.Toolkit;
import java.awt.Color;

public class AjouteMatiere extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField dtrpnDr;
	private JOptionPane msageConfi;
	private JComboBox credit;
	private JRadioButton rdbtnTp;
	manipulationBD bd =new manipulationBD();
	ClassPrincipale cp;
	public AjouteMatiere() {
		cp =new ClassPrincipale("AJOUT MATIERE",300,260);
		cp.setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.PNG"));
		
		JLabel lblMatiere = new JLabel("MATIERE:");
		lblMatiere.setFont(new Font("Sylfaen", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNomEnse = new JLabel("Enseignant");
		lblNomEnse.setFont(new Font("Sylfaen", Font.BOLD, 11));
		
		JLabel lblCredits = new JLabel("Cr\u00E9dits");
		lblCredits.setFont(new Font("Sylfaen", Font.BOLD, 11));
		
		credit = new JComboBox();
		//ajouts des credits dans l'item
		for(int i=1;i<7;++i){
			credit.addItem(""+i);
		}
		
		rdbtnTp = new JRadioButton("Comporte TP");
		rdbtnTp.setFont(new Font("Sylfaen", Font.BOLD, 11));
		rdbtnTp.setForeground(Color.BLUE);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.setFont(new Font("Sylfaen", Font.BOLD, 11));
		btnAjouter.setIcon(new ImageIcon(AjouteMatiere.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify.gif")));
		
		JButton btnAnnuler = new JButton("ANNULER");
		btnAnnuler.setFont(new Font("Sylfaen", Font.BOLD, 11));
		btnAnnuler.setIcon(new ImageIcon(AjouteMatiere.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		
		JLabel lblAjouterUneMatiere = new JLabel("AJOUTER UNE MATIERE");
		lblAjouterUneMatiere.setFont(new Font("Traditional Arabic", Font.BOLD, 11));
		
		dtrpnDr = new JTextField();
		GroupLayout groupLayout = new GroupLayout(cp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(lblAjouterUneMatiere))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMatiere)
								.addComponent(lblNomEnse)
								.addComponent(lblCredits))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dtrpnDr, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(rdbtnTp))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAjouter)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(btnAnnuler)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblAjouterUneMatiere)
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatiere)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNomEnse)
						.addComponent(dtrpnDr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCredits)
						.addComponent(credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(rdbtnTp)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAjouter)
						.addComponent(btnAnnuler))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		cp.getContentPane().setLayout(groupLayout);
		
		btnAjouter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String  a=textField.getText();
				String  c =dtrpnDr.getText();
				int b = credit.getSelectedIndex()+1; //on ajoute 1 car le 1er élément ici est 1 au lieu de 0
				boolean d =rdbtnTp.getModel().isSelected();
				//boolean selected=abstractButton.getModel().isSelected();

				int resulta =JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment ajouter cette matiere", "Ajout Matière", JOptionPane.OK_OPTION);
				if(resulta==0){
				try{
				bd.AjouterMatiere(a, b, c, d);
				cp.dispose();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				}
			}
		});

		btnAnnuler.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cp.dispose();
			}});
	}

	public static void main(String[] args) {
		new accueilP();
}

	public JOptionPane getMsageConfi() {
		return msageConfi;
	}

	public void setMsageConfi(JOptionPane msageConfi) {
		this.msageConfi = msageConfi;
	}
}

