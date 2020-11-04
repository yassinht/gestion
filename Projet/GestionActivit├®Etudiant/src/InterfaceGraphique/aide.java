package InterfaceGraphique;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class aide extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public aide() {
		setVisible(true);
		setResizable(false);
		setBackground(Color.GREEN);
		setFont(new Font("Footlight MT Light", Font.BOLD, 16));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fire-PC\\Documents\\adt-bundle-windows-x86-20140702\\pROJETaNDROID\\GestionActivit\u00E9Etudiant\\picture\\help.png"));
		setTitle("Apropos - Gestion des Taches Studentine");
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBorder(new LineBorder(Color.MAGENTA, 3));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des taches, cette applicaions sert \u00E0:");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 13));
		lblNewLabel.setBounds(54, 303, 388, 14);
		panel.add(lblNewLabel);
		
		JLabel lblGererToutes = new JLabel("--G\u00E9rer les activit\u00E9s des \u00E9tudiants au sein d'une salle;");
		lblGererToutes.setForeground(Color.BLACK);
		lblGererToutes.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblGererToutes.setBounds(20, 328, 378, 14);
		panel.add(lblGererToutes);
		
		JLabel lblaccderAuxContenu = new JLabel("--Acc\u00E9der au contenu d'une base de donn\u00E9e , afin de:");
		lblaccderAuxContenu.setForeground(Color.BLACK);
		lblaccderAuxContenu.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblaccderAuxContenu.setBounds(20, 342, 378, 14);
		panel.add(lblaccderAuxContenu);
		
		JLabel lblajouterUneNouvelle = new JLabel("-Supprimer ou Ajouter une nouvelle t\u00E2che (examen, cc, tp ou un tpe.)");
		lblajouterUneNouvelle.setForeground(Color.BLACK);
		lblajouterUneNouvelle.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblajouterUneNouvelle.setBounds(44, 367, 378, 14);
		panel.add(lblajouterUneNouvelle);
		
		JLabel lblajoutersupprimerDesMatires = new JLabel("-Ajouter/supprimer des mati\u00E8res;");
		lblajoutersupprimerDesMatires.setForeground(Color.BLACK);
		lblajoutersupprimerDesMatires.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblajoutersupprimerDesMatires.setBounds(44, 392, 378, 14);
		panel.add(lblajoutersupprimerDesMatires);
		
		JLabel lblplanifierLexamenEnregistrer = new JLabel("-Planifier l'examen, Enr\u00E9gistrer sa date;");
		lblplanifierLexamenEnregistrer.setForeground(Color.BLACK);
		lblplanifierLexamenEnregistrer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblplanifierLexamenEnregistrer.setBounds(64, 417, 378, 14);
		panel.add(lblplanifierLexamenEnregistrer);
		
		JLabel lblProjetDeProgrammation = new JLabel("UNIVERSITE DE NGAOUNDERE");
		lblProjetDeProgrammation.setIcon(new ImageIcon("picture\\logo_univ.png"));
		lblProjetDeProgrammation.setVerticalAlignment(SwingConstants.TOP);
		lblProjetDeProgrammation.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjetDeProgrammation.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblProjetDeProgrammation.setBounds(20, 11, 428, 32);
		panel.add(lblProjetDeProgrammation);
		
		JLabel lblLicenseArchitecture = new JLabel("License 2 Architecture & R\u00E9seaux");
		lblLicenseArchitecture.setVerticalAlignment(SwingConstants.TOP);
		lblLicenseArchitecture.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicenseArchitecture.setForeground(Color.PINK);
		lblLicenseArchitecture.setFont(new Font("Arabic Typesetting", Font.BOLD, 20));
		lblLicenseArchitecture.setBounds(73, 111, 315, 32);
		panel.add(lblLicenseArchitecture);
		
		JLabel lblCoursDeConception = new JLabel("Cours de: CONCEPTION DES APPLICATIONS ET ATELIER DE PROGRAMMATION");
		lblCoursDeConception.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCoursDeConception.setFont(new Font("MS Gothic", Font.BOLD, 10));
		lblCoursDeConception.setBounds(20, 154, 399, 32);
		panel.add(lblCoursDeConception);
		
		JLabel lblEnseignantMrTchakounte = new JLabel("Enseignant: Mr TCHAKOUNTE FRANCKLIN");
		lblEnseignantMrTchakounte.setVerticalAlignment(SwingConstants.TOP);
		lblEnseignantMrTchakounte.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		lblEnseignantMrTchakounte.setBounds(20, 197, 249, 26);
		panel.add(lblEnseignantMrTchakounte);
		
		JLabel lblProgrammeConuEt = new JLabel("par l'Etudiant:");
		lblProgrammeConuEt.setFont(new Font("Papyrus", Font.PLAIN, 12));
		lblProgrammeConuEt.setBounds(20, 220, 110, 26);
		panel.add(lblProgrammeConuEt);
		
		JLabel lblIgnabaiTchindebeBruno = new JLabel("IGNABAI TCHINDEBE BRUNO");
		lblIgnabaiTchindebeBruno.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIgnabaiTchindebeBruno.setFont(new Font("Traditional Arabic", Font.BOLD, 12));
		lblIgnabaiTchindebeBruno.setBounds(189, 222, 209, 21);
		panel.add(lblIgnabaiTchindebeBruno);
		
		JLabel lblDepartementDeMathematique = new JLabel("DEPARTEMENT DE MATHEMATIQUE ET INFORMATIQUE");
		lblDepartementDeMathematique.setFont(new Font("Traditional Arabic", Font.BOLD, 12));
		lblDepartementDeMathematique.setBounds(73, 67, 388, 26);
		panel.add(lblDepartementDeMathematique);
		
		JLabel lblMatricule = new JLabel("Matricule:");
		lblMatricule.setFont(new Font("Papyrus", Font.PLAIN, 13));
		lblMatricule.setVerticalAlignment(SwingConstants.TOP);
		lblMatricule.setBounds(20, 250, 88, 26);
		panel.add(lblMatricule);
		
		JLabel lblafs = new JLabel("13A070FS");
		lblafs.setVerticalAlignment(SwingConstants.TOP);
		lblafs.setFont(new Font("Traditional Arabic", Font.BOLD, 12));
		lblafs.setBounds(191, 253, 182, 21);
		panel.add(lblafs);
		
		JButton btnOk = new JButton("OK");
		btnOk.setIcon(new ImageIcon("images\\ajoutmatiere.gif"));
		btnOk.setBounds(372, 427, 89, 23);
		panel.add(btnOk);
		contentPane.setLayout(gl_contentPane);
		
		btnOk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
	}
}
