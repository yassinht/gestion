package InterfaceGraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import BaseDonnee.connexion;
import BaseDonnee.manipulationBD;

public class Login extends JDialog {
	public String usr;
	public String pswr;

	private static final long serialVersionUID = 1L;
	JTextField textField_1;
	JPasswordField passwordField;
    manipulationBD bd;
    Thread t;
    JButton btnConn;
    private final JLabel lblNewLabel = new JLabel("image login");

	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Login() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.PNG"));
		setForeground(new Color(255, 69, 0));
		setFont(new Font("DFKai-SB", Font.BOLD, 12));
		setTitle("Login");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		btnConn = new JButton("Connecter");
		btnConn.setIcon(new ImageIcon("images\\ajoutmatiere.gif"));
		
		JButton btnAnn = new JButton("Annuler");
		btnAnn.setIcon(new ImageIcon("picture\\exit.png"));
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, btnConn, 1, SpringLayout.NORTH, btnAnn);
		sl_panel.putConstraint(SpringLayout.EAST, btnAnn, 0, SpringLayout.EAST, textField_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, -188, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -26, SpringLayout.EAST, panel);
		panel.setLayout(sl_panel);
		panel.add(textField_1);
		panel.add(btnConn);
		panel.add(btnAnn);
		
		Label label = new Label("User");
		sl_panel.putConstraint(SpringLayout.WEST, btnConn, 0, SpringLayout.WEST, label);
		sl_panel.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, textField_1);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("French Script MT", Font.BOLD, 12));
		panel.add(label);
		
		Label label_1 = new Label("PassWord");
		sl_panel.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, label_1);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Colonna MT", Font.BOLD, 12));
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.WEST, passwordField, 268, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, passwordField, -154, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label_1, -29, SpringLayout.WEST, passwordField);
		sl_panel.putConstraint(SpringLayout.NORTH, btnAnn, 56, SpringLayout.SOUTH, passwordField);
		sl_panel.putConstraint(SpringLayout.NORTH, passwordField, 14, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, passwordField, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, passwordField);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, passwordField);
		panel.add(passwordField);
		
		Label label_2 = new Label("Login");
		sl_panel.putConstraint(SpringLayout.NORTH, label_2, 28, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_2, -214, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label_2, -152, SpringLayout.EAST, panel);
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Bradley Hand ITC", Font.BOLD, 16));
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 232, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 144, SpringLayout.WEST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, 134, SpringLayout.WEST, panel_1);
		panel_1.setLayout(sl_panel_1);
		lblNewLabel.setIcon(new ImageIcon("picture\\anigif.gif"));
		panel_1.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);

		
		btnAnn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHistorique = new JMenu("Historique");
		menuBar.add(mnHistorique);
		
		JMenuItem mntmAfficher = new JMenuItem("Afficher");
		mntmAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new afficheConnec();
			}
		});
		mnHistorique.add(mntmAfficher);
		
		btnConn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				usr=(textField_1.getText());
				manipulationBD bd=new manipulationBD();
				
				char[] pass=passwordField.getPassword();
				pswr =new String(pass);
				System.out.println(usr+" et "+pswr);
				try  {
					connexion c = new connexion();
					Statement st =c.conn.createStatement();
					ResultSet rs = st.executeQuery("Select* from login");
					//tests, test si nom d'utilisateur ou mdp valide ou pas. par defaut on met faux
					boolean tests=false;
					while(rs.next()){
						if(usr.equals(rs.getObject("usr")) && pswr.equals(rs.getObject("Password"))){
							//nom d'utilisateur valide
							tests=true;
							bd.InsertConnect(usr);
							new accueilP();
							dispose();
							}
					}
					//si user ou mdp invalide, on affiche un message d'erreur
						if(tests==false){
                         JOptionPane.showMessageDialog(null, "Le nom d'utilisateur ou le mot de pass est incorrect", "INCONNU", JOptionPane.ERROR_MESSAGE);                        
					}
				}catch(SQLException ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"ERREUR DE CONNEXION","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Echec de connexion");
				}
			}});
		}
}
