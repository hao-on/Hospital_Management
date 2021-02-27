package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	
	Connection conn = null;

	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPatient = new JButton("");
		btnPatient.setForeground(Color(240, 240, 240));
		btnPatient.setFont(new Font("Times New Roman", Font.BOLD, 11));
		contentPane.add(btnPatient);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO OUR HOSPTIAL");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(121, 67, 203, 14);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(Homepage.class.getResource("/app/redcross.png"));
		
		JButton btnDisplay = new JButton(icon);
		btnDisplay.setOpaque(false);
		btnDisplay.setContentAreaFilled(false);
		btnDisplay.setBorderPainted(false);
		btnDisplay.setFocusPainted(false);
		//btnDisplay.setIcon(new ImageIcon(Homepage.class.getResource("/app/redcross.png")));
		//btnDisplay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDisplay.setBorder(null);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				try {
						dispose();
						Display dp = new Display();
						dp.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDisplay.setBackground(new Color(0, 0, 0));
		btnDisplay.setBounds(189, 113, 61, 45);
		contentPane.add(btnDisplay);
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				try {
						dispose();
						Login_page lg = new Login_page();
						lg.setVisible(true);
						
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(341, 0, 93, 23);
		contentPane.add(btnNewButton);
		

		
	}

	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
}
