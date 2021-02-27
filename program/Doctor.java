package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

public class Doctor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor frame = new Doctor();
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
	public Doctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 295);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnP = new JButton("PATIENT");
		btnP.setForeground(Color(240, 240, 240));
		btnP.setFont(new Font("Times New Roman", Font.BOLD, 11));
		contentPane.add(btnP);
		
		JButton btnTable = new JButton("TABLE");
		btnTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					DoctorPage dp = new DoctorPage();
					dp.setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
		btnTable.setBackground(SystemColor.menu);
		btnTable.setBounds(50, 108, 146, 26);
		contentPane.add(btnTable);
		
		JLabel lblData = new JLabel("DOCTOR");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.YELLOW);
		lblData.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblData.setBounds(120, 58, 203, 14);
		contentPane.add(lblData);
		
		JButton btnSort = new JButton("SORT");
		btnSort.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSort.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					Sort sp = new Sort();
					sp.setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
		btnSort.setBackground(SystemColor.menu);
		btnSort.setBounds(255, 107, 146, 26);
		contentPane.add(btnSort);
		
		BasicArrowButton back = new BasicArrowButton(BasicArrowButton.WEST);
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
		
		JButton btnList = new JButton("LIST");
		btnList.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnList.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					List lt = new List();
					lt.setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
		btnList.setBackground(SystemColor.menu);
		btnList.setBounds(152, 166, 146, 25);
		contentPane.add(btnList);
	}
	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
