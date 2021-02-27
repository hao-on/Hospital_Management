package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	OraclePreparedStatement pst = null;
	OracleResultSet rs = null;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_9;
	private JLabel label;
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterPatientId = new JLabel("Patient ID");
		lblEnterPatientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterPatientId.setForeground(Color.CYAN);
		lblEnterPatientId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterPatientId.setBounds(391, 81, 102, 42);
		contentPane.add(lblEnterPatientId);
		
		textField = new JTextField();
		textField.setBounds(497, 89, 408, 23);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
							conn = login.dbconnect();
							Displaydata();
				}
			}
		});
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("DISPLAY");
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				Displaydata();
				
			}
		});
		btnEnter.setBounds(930, 88, 118, 23);
		contentPane.add(btnEnter);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table.setBounds(12, 225, 1400, 225);
		contentPane.add(table);
		table.setVisible(false);
		
		btnNewButton = new JButton("NAME");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(12, 200, 140, 25);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		button = new JButton("PHONE");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button.setBounds(152, 200, 140, 25);
		contentPane.add(button);
		button.setVisible(false);
		
		button_1 = new JButton("EID_DOC");
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_1.setBounds(292, 200, 140, 25);
		contentPane.add(button_1);
		button_1.setVisible(false);
		
		button_2 = new JButton("PID_IN");
		button_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_2.setBounds(432, 200, 140, 25);
		contentPane.add(button_2);
		button_2.setVisible(false);
		
		button_3 = new JButton("TR_ID");
		button_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_3.setBounds(572, 200, 140, 25);
		contentPane.add(button_3);
		button_3.setVisible(false);
		
		button_4 = new JButton("START");
		button_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_4.setBounds(712, 200, 140, 25);
		contentPane.add(button_4);
		button_4.setVisible(false);
		
		button_5 = new JButton("END");
		button_5.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_5.setBounds(992, 200, 140, 25);
		contentPane.add(button_5);
		button_5.setVisible(false);
		
		button_6 = new JButton("RESULT");
		button_6.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_6.setBounds(852, 200, 140, 25);
		contentPane.add(button_6);
		button_6.setVisible(false);
		
		button_7 = new JButton("ADMISSION");
		button_7.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_7.setBounds(1132, 200, 140, 25);
		contentPane.add(button_7);
		button_7.setVisible(false);
		
		button_8 = new JButton("DISCHARGE");
		button_8.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_8.setBounds(1272, 200, 141, 25);
		contentPane.add(button_8);
		button_8.setVisible(false);
		
		button_9 = new JButton("NAME");
		button_9.setBounds(12, 200, 350, 25);
		contentPane.add(button_9);
		button_9.setVisible(false);
		
		button_10 = new JButton("PHONE");
		button_10.setBounds(362, 200, 350, 25);
		contentPane.add(button_10);
		button_10.setVisible(false);
		
		button_11 = new JButton("FIRST_DATE");
		button_11.setBounds(712, 200, 350, 25);
		contentPane.add(button_11);
		button_11.setVisible(false);
		
		button_12 = new JButton("SECOND_DATE");
		button_12.setBounds(1062, 200, 350, 25);
		contentPane.add(button_12);
		button_12.setVisible(false);
		
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
		
		label = new JLabel("SEARCH");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label.setBounds(596, 36, 203, 14);
		contentPane.add(label);
	}
	
	public void Displaydata() {
		try {
			String pid = textField.getText();
			String sql = "";
			String parts[] = pid.split("P", 2);
			if(!parts[0].equals("I"))
			{
				if(!parts[0].equals("O"))
				{
				JLabel label = new JLabel("Wrong format");
				label.setFont(new Font("Times New Roman",Font.PLAIN, 15));
				final ImageIcon icon = new ImageIcon(Homepage.class.getResource("/app/warn.png"));
				JOptionPane.showMessageDialog(null, label,"About", JOptionPane.INFORMATION_MESSAGE,icon);
				return;
				}
			}
			String test = parts[0];
			String test2 = parts[1];
			System.out.println(test2);
			System.out.println(test2.length());
			boolean flag = true;
			if(test2.length() != 5)
			{
				flag = false;
			}
			table.setVisible(false); btnNewButton.setVisible(false); button.setVisible(false); button_1.setVisible(false); button_2.setVisible(false); button_3.setVisible(false);
			button_4.setVisible(false); button_5.setVisible(false); button_6.setVisible(false); button_7.setVisible(false); button_8.setVisible(false);
			table.setVisible(false); button_9.setVisible(false); button_10.setVisible(false); button_11.setVisible(false); button_12.setVisible(false);
			if (test.equals("I") && flag)
			{
				sql = 
				"SELECT (PATIENT.PFNAME || ' ' || PATIENT.PLNAME) AS FULLNAME, PATIENT.PPHONE AS PHONE, TREATMENT.*, INPATIENT.PADMISSIONDATE, INPATIENT.PDISCHARGEDATE\r\n" + 
				"FROM (TREATMENT JOIN PATIENT ON TREATMENT.PID_IN = PATIENT.PID) JOIN INPATIENT ON PATIENT.PID = INPATIENT.PID_IN\r\n" + 
				"WHERE PATIENT.PID = '" + pid + "'";
			}
			else if (test.equals("O") && flag)
			{
				sql = 
				"SELECT (PATIENT.PFNAME || ' ' || PATIENT.PLNAME) AS FULLNAME, PATIENT.PPHONE AS PHONE, to_char (EXAMINATION.EXDATE, 'MM/dd/yyyy') AS FIRST_DATE, to_char (EXAMINATION.EXSECOND_EXAMINATION_DATE, 'MM/dd/yyyy') AS SECOND_DATE\r\n" + 
				"FROM (EXAMINATION JOIN PATIENT ON EXAMINATION.PID_OUT = PATIENT.PID) JOIN OUTPATIENT ON PATIENT.PID = OUTPATIENT.PID_OUT\r\n" + 
				"WHERE PATIENT.PID = '" + pid + "'";
			}
			else {

				JLabel label = new JLabel("Wrong format");
				label.setFont(new Font("Times New Roman",Font.PLAIN, 15));
				final ImageIcon icon = new ImageIcon(Homepage.class.getResource("/app/warn.png"));
				JOptionPane.showMessageDialog(null, label,"About", JOptionPane.INFORMATION_MESSAGE,icon);

			}
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			if (test.equals("I") && flag)
			{
				table.setVisible(true); btnNewButton.setVisible(true); button.setVisible(true); button_1.setVisible(true); button_2.setVisible(true); button_3.setVisible(true);
				button_4.setVisible(true); button_5.setVisible(true); button_6.setVisible(true); button_7.setVisible(true); button_8.setVisible(true);
			}
			else if (test.equals("O") && flag)
			{
				table.setVisible(true); button_9.setVisible(true); button_10.setVisible(true); button_11.setVisible(true); button_12.setVisible(true);
			}

		}
		catch(Exception e) 
		{
			
		}
	}
}
