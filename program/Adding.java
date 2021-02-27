package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Color;
@SuppressWarnings("unused")
public class Adding extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	
	Connection conn = null;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adding frame = new Adding();
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
	public Adding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		conn = login.dbconnect();
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.YELLOW);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblId.setBounds(52, 44, 122, 40);
		contentPane.add(lblId);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(Color.YELLOW);
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFirstName.setBounds(52, 79, 122, 40);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.YELLOW);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLastName.setBounds(52, 120, 122, 40);
		contentPane.add(lblLastName);
		
		JLabel lblDob = new JLabel("DOB:");
		lblDob.setForeground(Color.YELLOW);
		lblDob.setBackground(Color.YELLOW);
		lblDob.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDob.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDob.setBounds(52, 160, 122, 40);
		contentPane.add(lblDob);
		
		textField = new JTextField();
		textField.setBounds(201, 55, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(201, 92, 122, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(201, 129, 122, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(201, 166, 122, 20);
		contentPane.add(textField_3);
		
		table = new JTable();
		table.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.setBounds(375, 26, 1000, 387);
		contentPane.add(table);
		
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String id = textField.getText();
					String fname = textField_1.getText();
					String lname = textField_2.getText();
					String gender = textField_4.getText();
					String dob = textField_3.getText();
					String address = textField_6.getText();
					String phone = textField_5.getText();
					String query = "insert into PATIENT values ('"+id+"','"+fname+"','"+lname+"',to_date('"+dob+"','yyyy-mm-dd'), '"+gender+"','"+phone+"','"+address+"')" ;
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Inserted Successfully");
			}
		});
		btnInsert.setBounds(75, 354, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select PID, PFNAME, PLNAME, to_char(PDOB,'MM/dd/yyyy'), PGENRE, PPHONE, PADDRESS from PATIENT ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				      table.getColumnModel().getColumn(0).setPreferredWidth(70);
				      table.getColumnModel().getColumn(1).setPreferredWidth(100);
				      table.getColumnModel().getColumn(2).setPreferredWidth(100);
				      table.getColumnModel().getColumn(3).setPreferredWidth(125);
				      table.getColumnModel().getColumn(4).setPreferredWidth(30);
				      table.getColumnModel().getColumn(5).setPreferredWidth(100);
				      table.getColumnModel().getColumn(6).setPreferredWidth(475);
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(234, 354, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setForeground(Color.YELLOW);
		lblGenre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenre.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGenre.setBounds(52, 195, 122, 40);
		contentPane.add(lblGenre);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(Color.YELLOW);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPhone.setBounds(52, 233, 122, 40);
		contentPane.add(lblPhone);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setForeground(Color.YELLOW);
		lblAdress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdress.setBounds(52, 269, 122, 40);
		contentPane.add(lblAdress);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(201, 203, 122, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(201, 240, 122, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(201, 277, 122, 20);
		contentPane.add(textField_6);
		
		BasicArrowButton back = new BasicArrowButton(BasicArrowButton.WEST);
		back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					Patient pt = new Patient();
					pt.setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	 });
		back.setBackground(Color.BLACK);
		back.setBounds(0, 0, 34, 22);
		contentPane.add(back);
	}
}