package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

public class Login_page extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;

	/**
	 * Launch the application.
	 */
	Connection conn = null;
	OraclePreparedStatement pst = null;
	OracleResultSet rs = null;
	private JPasswordField txtpass;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page frame = new Login_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 289);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setForeground(new Color(255, 0, 0));
		lblWelcome.setBounds(-29, 32, 524, 16);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblWelcome);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(new Color(255, 255, 0));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblUsername.setBounds(84, 76, 128, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPassword.setBounds(84, 113, 128, 26);
		contentPane.add(lblPassword);
		
		txtuser = new JTextField();
		txtuser.setBounds(222, 79, 136, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		
		txtpass = new JPasswordField();
		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
							conn = login.dbconnect();
							try {
								String query = "select* from Login_Table where Username = ? and Password = ?";
								pst = (OraclePreparedStatement) conn.prepareStatement(query);
								pst.setString(1, txtuser.getText());
								pst.setString(2, txtpass.getText());
								rs = (OracleResultSet) pst.executeQuery();
								
								if(rs.next()) {
									dispose();
									//JOptionPane.showMessageDialog(null, "User & Password correct");
									Homepage hp = new Homepage();
									hp.setVisible(true);
								}
								else {
									JLabel label = new JLabel("Invalid User/Password");
									label.setFont(new Font("Times New Roman",Font.PLAIN, 15));
									final ImageIcon icon = new ImageIcon(Homepage.class.getResource("/app/warn.png"));
									JOptionPane.showMessageDialog(null, label,"About", JOptionPane.INFORMATION_MESSAGE,icon);
								}
								pst.close();
								rs.close();
							}catch (Exception e) {
								e.printStackTrace();
							};
				}
			}
		});
		txtpass.setBounds(222, 119, 136, 20);
		contentPane.add(txtpass);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(240, 240, 240));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				try {
					String query = "select* from Login_Table where Username = ? and Password = ?";
					pst = (OraclePreparedStatement) conn.prepareStatement(query);
					pst.setString(1, txtuser.getText());
					pst.setString(2, txtpass.getText());
					rs = (OracleResultSet) pst.executeQuery();
					
					if(rs.next()) {
						dispose();
						//JOptionPane.showMessageDialog(null, "User & Password correct");
						Homepage hp = new Homepage();
						hp.setVisible(true);
					}
					else {
						JLabel label = new JLabel("Invalid User/Password");
						label.setFont(new Font("Times New Roman",Font.PLAIN, 15));
						final ImageIcon icon = new ImageIcon(Homepage.class.getResource("/app/warn.png"));
						JOptionPane.showMessageDialog(null, label,"About", JOptionPane.INFORMATION_MESSAGE,icon);
					}
					pst.close();
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBounds(193, 175, 89, 23);
		contentPane.add(btnLogin);

	}
}
