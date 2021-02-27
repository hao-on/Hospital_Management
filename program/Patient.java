package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Patient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient frame = new Patient();
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
	public Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnP = new JButton("TABLE");
		btnP.setForeground(Color(240, 240, 240));
		btnP.setFont(new Font("Times New Roman", Font.BOLD, 11));
		contentPane.add(btnP);
		
		JButton btnTable = new JButton("TABLE");
		btnTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				try {
						dispose();
						PatientTable pt = new PatientTable();
						pt.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTable.setBackground(SystemColor.menu);
		btnTable.setBounds(22, 111, 133, 25);
		contentPane.add(btnTable);
		

		
		
		JButton btnPayment = new JButton("PAYMENT");
		btnPayment.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				try {
						dispose();
						Payment pm = new Payment();
						pm.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnPayment.setBackground(SystemColor.menu);
		btnPayment.setBounds(297, 171, 133, 25);
		contentPane.add(btnPayment);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				try {
						dispose();
						Search se = new Search();
						se.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSearch.setBackground(SystemColor.menu);
		btnSearch.setBounds(111, 171, 133, 25);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				try {
						dispose();
						Adding ad = new Adding();
						ad.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBackground(SystemColor.menu);
		btnAdd.setBounds(384, 111, 133, 25);
		contentPane.add(btnAdd);
		
		JLabel lblPatient = new JLabel("PATIENT");
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setForeground(Color.YELLOW);
		lblPatient.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPatient.setBounds(169, 50, 203, 14);
		contentPane.add(lblPatient);
		
		BasicArrowButton back = new BasicArrowButton(7);
		back.addActionListener(new ActionListener() {
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
		back.setBackground(Color.BLACK);
		back.setBounds(0, 0, 34, 22);
		contentPane.add(back);
		
		JButton btnFeeIncrease = new JButton("FEE INCREASE");
		btnFeeIncrease.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnFeeIncrease.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					IncreaseFee ic = new IncreaseFee();
					ic.setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
		btnFeeIncrease.setBackground(SystemColor.menu);
		btnFeeIncrease.setBounds(204, 111, 133, 25);
		contentPane.add(btnFeeIncrease);

	}

	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
}
