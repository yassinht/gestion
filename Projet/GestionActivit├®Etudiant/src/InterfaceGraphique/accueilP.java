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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import BaseDonnee.manipulationBD;
public class accueilP extends JPanel implements ActionListener {
	
	JOptionPane messagedeConfirmation;

	manipulationBD bd=new manipulationBD();
	private static final long serialVersionUID = 1L;
	public accueilP() {
		final ClassPrincipale cp = new ClassPrincipale("MENU PRINCIPAL ",700,500);
		
		//activer/desactiver les menu items
		
		//fichiers
		cp.mnFichiers.setEnabled(true);
		cp.mntmNouveau.setEnabled(true);
		cp.mntmQuitter.setEnabled(true);
		cp.mntmSupprimer.setEnabled(true);
		//edition
		cp.mnEdition.setEnabled(true);
		cp.mntmCouper.setEnabled(false);
		cp.mntmColler.setEnabled(false);
		cp.mntmCopier.setEnabled(false);
		cp.mnApropos.setEnabled(true);
		cp.mntmAide.setEnabled(true);
		cp.mntmContactMe.setEnabled(true);
		
		
		
		SpringLayout springLayout = (SpringLayout) cp.getContentPane().getLayout();
		cp.setIconImage(Toolkit.getDefaultToolkit().getImage("picture/logo.PNG"));
		cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 58, SpringLayout.NORTH, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 11, SpringLayout.WEST, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -139, SpringLayout.SOUTH, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 206, SpringLayout.WEST, cp.getContentPane());
		panel.setBackground(new Color(192, 192, 192));
		panel.setForeground(new Color(0, 0, 128));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "PLANIFICATION", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 128)));
		cp.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 60, SpringLayout.NORTH, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 56, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 197, SpringLayout.NORTH, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 240, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setForeground(new Color(240, 248, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		cp.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.setIcon(new ImageIcon("picture/new.png"));
		btnNouveau.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		
		JButton btnEditer = new JButton("Editer");
		btnEditer.setIcon(new ImageIcon("images/editer.jpg"));
		btnEditer.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		
		JButton btnPlanifierExamen = new JButton("Planifier Examen");
		btnPlanifierExamen.setIcon(new ImageIcon("images/nouveau.jpg"));
		btnPlanifierExamen.setFont(new Font("Shonar Bangla", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPlanifierExamen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(btnEditer, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addComponent(btnNouveau, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNouveau, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEditer, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPlanifierExamen, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, -176, SpringLayout.EAST, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, 0, SpringLayout.SOUTH, panel_1);
		
		JButton btnAfficherTches = new JButton("Afficher T\u00E2ches");
		btnAfficherTches.setIcon(new ImageIcon(accueilP.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		btnAfficherTches.setFont(new Font("Shonar Bangla", Font.BOLD, 11));
		
		JButton btnMatires = new JButton("Mati\u00E8res");
		btnMatires.setIcon(new ImageIcon("images/navigation.gif", "tray icon"));
		btnMatires.setFont(new Font("Shonar Bangla", Font.BOLD, 11));
		
		JButton btnSupprimerTche = new JButton("Supprimer T\u00E2che");
		btnSupprimerTche.setIcon(new ImageIcon("picture/annuler.PNG", "tray icon"));
		btnSupprimerTche.setFont(new Font("Shonar Bangla", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSupprimerTche, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(btnMatires, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(btnAfficherTches, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAfficherTches, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMatires)
					.addGap(4)
					.addComponent(btnSupprimerTche, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -22, SpringLayout.EAST, cp.getContentPane());
		panel_2.setForeground(new Color(240, 248, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBackground(new Color(240, 248, 255));
		cp.getContentPane().add(panel_2);
		
		JButton btnAjouterMatire = new JButton("Ajouter Mati\u00E8re");
		btnAjouterMatire.setIcon(new ImageIcon("images/ajoutmatiere.gif", "tray icon"));
		btnAjouterMatire.setFont(new Font("Shonar Bangla", Font.BOLD, 11));
		
		JButton btnSupprimerMatire = new JButton("Supprimer Mati\u00E8re");
		btnSupprimerMatire.setForeground(new Color(220, 20, 60));
		btnSupprimerMatire.setIcon(null);
		btnSupprimerMatire.setFont(new Font("Shonar Bangla", Font.BOLD, 11));
		
		JButton btnQuitter = new JButton("QUITTER");
		btnQuitter.setIcon(new ImageIcon("picture/annuler.PNG", "tray icon"));
		btnQuitter.setFont(new Font("Shonar Bangla", Font.BOLD, 11));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAjouterMatire, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
						.addComponent(btnSupprimerMatire, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
						.addComponent(btnQuitter, GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE))
					.addGap(18))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(23)
					.addComponent(btnAjouterMatire)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSupprimerMatire, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuitter, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblMenuPrincipal = new JLabel("Gestion des T\u00E2ches Studentine");
		springLayout.putConstraint(SpringLayout.NORTH, lblMenuPrincipal, 12, SpringLayout.NORTH, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMenuPrincipal, 207, SpringLayout.WEST, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblMenuPrincipal, -15, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, lblMenuPrincipal, -138, SpringLayout.EAST, cp.getContentPane());
		lblMenuPrincipal.setIcon(new ImageIcon("picture/about.png"));
		lblMenuPrincipal.setFont(new Font("Script MT Bold", Font.BOLD, 12));
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		cp.getContentPane().add(lblMenuPrincipal);
		
		JPanel panel_3 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_3, 202, SpringLayout.SOUTH, panel_1);
		panel_3.setSize(400,300);
		panel_3.setBackground(Color.GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, panel_3, 49, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel_3, 58, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_2);
		cp.getContentPane().add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JLabel lblFghjkukjiujertfyuhik = new JLabel("image accueil");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblFghjkukjiujertfyuhik, 0, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblFghjkukjiujertfyuhik, 0, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblFghjkukjiujertfyuhik, 0, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblFghjkukjiujertfyuhik, 398, SpringLayout.WEST, panel_3);
		lblFghjkukjiujertfyuhik.setIcon(new ImageIcon("picture\\affichage.png"));
		panel_3.add(lblFghjkukjiujertfyuhik);
		
		JPanel panel_4 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_4, 84, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_4, 15, SpringLayout.WEST, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_4, -51, SpringLayout.SOUTH, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_4, 210, SpringLayout.WEST, cp.getContentPane());
		panel_4.setBackground(Color.BLUE);
		cp.getContentPane().add(panel_4);
		
		JLabel connecter = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, connecter, 0, SpringLayout.NORTH, cp.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, connecter, -20, SpringLayout.EAST, lblMenuPrincipal);
		springLayout.putConstraint(SpringLayout.SOUTH, connecter, -44, SpringLayout.NORTH, panel_2);
		springLayout.putConstraint(SpringLayout.EAST, connecter, -20, SpringLayout.EAST, cp.getContentPane());
		connecter.setIcon(new ImageIcon("picture\\user.png"));
		connecter.setBackground(Color.RED);
		cp.getContentPane().add(connecter);
		
		
		
		//Ce que fera un boutton après un clique
	
		//bouton nouveau tache
		btnNouveau.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new nouveauTache();
				Login l = new Login();
				System.out.println(l.usr);
			}
		});
		
		//boutton editer
		btnEditer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EditerTache();
			}
		});
		//boutton planifier examen
		btnPlanifierExamen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Examen();
				
			}
			
		});
		//boutton afficher matiere
		btnAfficherTches.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			new StatGenerale();
			}
		});
		//boutton matiere
		btnMatires.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Matiere();
			}
		});
		//boutton supprimer une tache
		btnSupprimerTche.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SupprimerTache();
			}
		});
		btnAjouterMatire.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AjouteMatiere();
			}		
		});
		btnSupprimerMatire.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SupprimerMatiere();
			}
		});
		btnQuitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "Voulez-vous quitter le programme ?", "QUITTER", JOptionPane.YES_NO_CANCEL_OPTION);
			    if(a==0){
			    	cp.dispose();
			    }
			}
		});
		//on affiche le nom de l'utilisateur connecter
		connecter.setText(bd.PersonneConnecte());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
        	 
	}
}

