package InterfaceGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultEditorKit;

public class ClassPrincipale extends JFrame {
	

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JOptionPane confirmation;
	JMenu mnFichiers = new JMenu("Fichier");
	JMenuItem mntmNouveau = new JMenuItem("Nouveau");
	JMenuItem mntmSupprimer = new JMenuItem("Supprimer");
	JMenuItem mntmQuitter = new JMenuItem("Quitter");
	JMenuItem mntmCopier; //= new JMenuItem("Copier");

	JMenu mnEdition = new JMenu("Edition");
	JMenuItem mntmColler = new JMenuItem("coller");
	JMenuItem mntmCouper;
	
	JMenu mnApropos = new JMenu("Apropos");
	JMenuItem mntmAide = new JMenuItem("Aide");
	JMenuItem mntmContactMe = new JMenuItem("Contact me");
	JMenuItem mntmApropos = new JMenuItem("Apropos");
	
	public ClassPrincipale(String Titre,int longu,int large) {
		
		
		this.setSize(longu,large);
		this.setTitle(Titre);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		Action actionCopier = new DefaultEditorKit.CopyAction();
		Action actionCouper = new DefaultEditorKit.CutAction();
		Action actionColler = new DefaultEditorKit.PasteAction();
		
		mntmCopier = new JMenuItem(actionCopier);
        mntmCouper = new JMenuItem(actionCouper);
        mntmColler = new JMenuItem(actionColler);
		mntmCopier.setText("Copier");
		mntmCouper.setText("Couper");
		mntmColler.setText("Coller");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 153));
		this.setJMenuBar(menuBar);
		
		
		mnFichiers.setForeground(new Color(255, 255, 255));
		//lblAjouterUneMatiere.setFont(new Font("Traditional Arabic", Font.BOLD, 11));
		mnFichiers.setFont(new Font("Arabic", Font.BOLD,12));
		menuBar.add(mnFichiers);
		
		
		mnFichiers.add(mntmNouveau);
		mnFichiers.add(mntmSupprimer);
		mnFichiers.add(mntmQuitter);
		mnEdition.setForeground(new Color(255, 255, 255));
		menuBar.add(mnEdition);
		mnEdition.add(mntmCouper);
		mnEdition.add(mntmCopier);
		mnEdition.add(mntmColler);
		
		mnApropos.setForeground(new Color(255, 255, 255));
		menuBar.add(mnApropos);
		mnApropos.add(mntmAide);
		mnApropos.add(mntmContactMe);
		mnApropos.add(mntmApropos);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		
		
		
		
		//activer/desactiver les items
				mntmNouveau.setEnabled(true);
				mntmSupprimer.setEnabled(true);
				mntmQuitter.setEnabled(true);
				mnEdition.setEnabled(true);
				mntmCouper.setEnabled(true);
				mntmCopier.setEnabled(true);
				mntmColler.setEnabled(true);
				mnApropos.setEnabled(true);
				mntmAide.setEnabled(true);
				mntmContactMe.setEnabled(true);
				
				
			//clique sur nouveau
				mntmNouveau.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new nouveauTache();
					}});
		  //clique sur supprimer
				mntmSupprimer.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
                       new SupprimerTache();						
					}});
	     //clique sur quitter
				mntmQuitter.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0){
						int test = JOptionPane.showConfirmDialog(null, "Vouler vous vraiment quitter l'application", "Quitter", JOptionPane.YES_NO_OPTION);
						if(test==0){
						dispose();
						}}});
		 //Menu AIde
				mntmAide.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
                            new aide();						
					}});
				mntmApropos.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
                          new aide();						
					}});
				mntmContactMe.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {	
						new contactMe();
					}
					
				});
				
	}
	//JDialog confirm = new JDialog();
	/*void quitter_actionPerformed() {
	    int result=confirm.showConfirmDialog(null,"Voulez vous sauvegarder avant de quitter??","Gestion Etudiants",JOptionPane.YES_NO_CANCEL_OPTION);
	    if(result==0){//reponse oui
	      System.exit(0);
	    }
	    else if(result==1){//reponse non
	        System.exit(0);
	    }*/
	
	  
	public static void main(String[] args) {
		new ClassPrincipale("NOm Interface",500,600);
}
}
