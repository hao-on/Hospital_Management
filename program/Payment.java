package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;

public class Payment extends JFrame {

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
					Payment frame = new Payment();
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
	OraclePreparedStatement prt = null;
	OracleResultSet rs =null;
	private JLabel lblNewLabel;
	private JTable table_2;
	private JLabel lblNewLabel_1;
	private JLabel lblLastName;
	private JLabel lblDob;
	private JLabel lblGenre;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JTable table_1;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JLabel lblSearch;
	private JButton btnNewButton;
	private JButton btnPrice;
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 664);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPid = new JLabel("Patient ID");
		lblPid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPid.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPid.setForeground(Color.CYAN);
		lblPid.setBackground(Color.WHITE);
		lblPid.setBounds(208, 83, 129, 17);
		contentPane.add(lblPid);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					conn = login.dbconnect();
					Displaydata();
				}
			}
		});
		textField.setBounds(342, 83, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("DISPLAY");
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = login.dbconnect();
				Displaydata();
			}
		});
		btnSearch.setBounds(579, 82, 98, 21);
		contentPane.add(btnSearch);
		
		table = new JTable();
		table.setVisible(false);
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setBounds(541, 229, 405, 105);
		contentPane.add(table);
		
		lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setVisible(false);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(51, 173, 129, 22);
		contentPane.add(lblNewLabel);
		
		table_2 = new JTable();
		table_2.setShowGrid(false);
		table_2.setEnabled(false);
		table_2.setBorder(null);
		table_2.setForeground(Color.LIGHT_GRAY);
		table_2.setBackground(Color.BLACK);
		table_2.setVisible(false);
		table_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		table_2.setBounds(172, 177, 113, 17);
		contentPane.add(table_2);
		
		lblNewLabel_1 = new JLabel("Total Amount ($):");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(592, 345, 188, 24);
		contentPane.add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setShowGrid(false);
		table_1.setBackground(Color.BLACK);
		table_1.setForeground(Color.LIGHT_GRAY);
		table_1.setVisible(false);
		table_1.setFont(new Font("Verdana", Font.BOLD, 15));
		table_1.setBounds(751, 350, 169, 17);
		contentPane.add(table_1);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setVisible(false);
		lblLastName.setForeground(Color.YELLOW);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLastName.setBounds(51, 216, 129, 22);
		contentPane.add(lblLastName);
		
		lblDob = new JLabel("DOB:");
		lblDob.setVisible(false);
		lblDob.setForeground(Color.YELLOW);
		lblDob.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDob.setBounds(51, 262, 129, 22);
		contentPane.add(lblDob);
		
		lblGenre = new JLabel("Genre:");
		lblGenre.setVisible(false);
		lblGenre.setForeground(Color.YELLOW);
		lblGenre.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGenre.setBounds(51, 304, 129, 22);
		contentPane.add(lblGenre);
		
		lblPhone = new JLabel("Phone:");
		lblPhone.setVisible(false);
		lblPhone.setForeground(Color.YELLOW);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPhone.setBounds(51, 347, 129, 22);
		contentPane.add(lblPhone);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setVisible(false);
		lblAddress.setForeground(Color.YELLOW);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddress.setBounds(51, 393, 129, 22);
		contentPane.add(lblAddress);
		
		table_3 = new JTable();
		table_3.setBackground(Color.BLACK);
		table_3.setForeground(Color.LIGHT_GRAY);
		table_3.setShowGrid(false);
		table_3.setVisible(false);
		table_3.setFont(new Font("Verdana", Font.BOLD, 14));
		table_3.setBounds(172, 220, 113, 17);
		contentPane.add(table_3);
		
		table_4 = new JTable();
		table_4.setBackground(Color.BLACK);
		table_4.setForeground(Color.LIGHT_GRAY);
		table_4.setShowGrid(false);
		table_4.setVisible(false);
		table_4.setFont(new Font("Verdana", Font.BOLD, 14));
		table_4.setBounds(172, 266, 113, 17);
		contentPane.add(table_4);
		
		table_5 = new JTable();
		table_5.setBackground(Color.BLACK);
		table_5.setForeground(Color.LIGHT_GRAY);
		table_5.setShowGrid(false);
		table_5.setVisible(false);
		table_5.setFont(new Font("Verdana", Font.BOLD, 14));
		table_5.setBounds(172, 308, 113, 17);
		contentPane.add(table_5);
		
		table_6 = new JTable();
		table_6.setBackground(Color.BLACK);
		table_6.setForeground(Color.LIGHT_GRAY);
		table_6.setShowGrid(false);
		table_6.setVisible(false);
		table_6.setFont(new Font("Verdana", Font.BOLD, 14));
		table_6.setBounds(172, 351, 113, 17);
		contentPane.add(table_6);
		
		table_7 = new JTable();
		table_7.setBackground(Color.BLACK);
		table_7.setForeground(Color.LIGHT_GRAY);
		table_7.setShowGrid(false);
		table_7.setVisible(false);
		table_7.setFont(new Font("Verdana", Font.BOLD, 14));
		table_7.setBounds(170, 397, 325, 17);
		contentPane.add(table_7);
		
		btnNewButton = new JButton("Fee ID");
		btnNewButton.setVisible(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(541, 206, 203, 23);
		contentPane.add(btnNewButton);
		
		btnPrice = new JButton("Price ($)");
		btnPrice.setVisible(false);
		btnPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPrice.setBounds(743, 206, 203, 23);
		contentPane.add(btnPrice);
		
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
		
		lblSearch = new JLabel("PAYMENT");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.YELLOW);
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSearch.setBounds(342, 32, 203, 14);
		contentPane.add(lblSearch);
	}
	
	public void Displaydata() {
		try {
			
			String pid = textField.getText();
			if(pid != null && !pid.isEmpty()) {
			table.setVisible(true);
			table_1.setVisible(true);
			table_2.setVisible(true);
			table_3.setVisible(true);
			table_4.setVisible(true);
			table_5.setVisible(true);
			table_6.setVisible(true);
			table_7.setVisible(true);
			lblNewLabel.setVisible(true);
			lblNewLabel_1.setVisible(true);
			lblLastName.setVisible(true);
			lblDob.setVisible(true);
			lblGenre.setVisible(true);
			lblAddress.setVisible(true);
			lblPhone.setVisible(true);
			btnNewButton.setVisible(true);
			btnPrice.setVisible(true);

			String spl3 = "SELECT PFNAME FROM PATIENT WHERE PID = '"+pid+"'";
			 prt = (OraclePreparedStatement) conn.prepareStatement(spl3);
			  rs = (OracleResultSet) prt.executeQuery();
		      table_2.setModel(DbUtils.resultSetToTableModel(rs));
		      String spl5 = "SELECT PLNAME FROM PATIENT WHERE PID = '"+pid+"'";
				 prt = (OraclePreparedStatement) conn.prepareStatement(spl5);
				  rs = (OracleResultSet) prt.executeQuery();
			      table_3.setModel(DbUtils.resultSetToTableModel(rs));
			      String spl6 = "SELECT to_char (PDOB,'MM/dd/yyyy') FROM PATIENT WHERE PID = '"+pid+"'";
					 prt = (OraclePreparedStatement) conn.prepareStatement(spl6);
					  rs = (OracleResultSet) prt.executeQuery();
				      table_4.setModel(DbUtils.resultSetToTableModel(rs));
				      String spl7 = "SELECT PGENRE FROM PATIENT WHERE PID = '"+pid+"'";
						 prt = (OraclePreparedStatement) conn.prepareStatement(spl7);
						  rs = (OracleResultSet) prt.executeQuery();
					      table_5.setModel(DbUtils.resultSetToTableModel(rs));
					      String spl8 = "SELECT PPHONE FROM PATIENT WHERE PID = '"+pid+"'";
							 prt = (OraclePreparedStatement) conn.prepareStatement(spl8);
							  rs = (OracleResultSet) prt.executeQuery();
						      table_6.setModel(DbUtils.resultSetToTableModel(rs));
						      String spl9 = "SELECT PADDRESS FROM PATIENT WHERE PID = '"+pid+"'";
								 prt = (OraclePreparedStatement) conn.prepareStatement(spl9);
								  rs = (OracleResultSet) prt.executeQuery();
							      table_7.setModel(DbUtils.resultSetToTableModel(rs));

			 String sql2 = "CREATE OR REPLACE TYPE TEST_TABTYPE AS TABLE OF TEST_OBJ_TYPE";
			 prt = (OraclePreparedStatement) conn.prepareStatement(sql2);
			  rs = (OracleResultSet) prt.executeQuery();
			  String sql = "CREATE OR REPLACE FUNCTION findPayment(id_in in VARCHAR2)\r\n" + 
			  		"RETURN TEST_TABTYPE\r\n" + 
			  		"AS\r\n" + 
			  		"V_Test_Tabtype TEST_TABTYPE;\r\n" + 
			  		"    \r\n" + 
			  		"BEGIN\r\n" + 
			  		"    IF INSTR(id_in, 'OP') > 0  THEN\r\n" + 
			  		"            SELECT TEST_OBJ_TYPE(a.ex_id, a.EXFEE)\r\n" + 
			  		"            bulk collect into\r\n" + 
			  		"            V_Test_TabType\r\n" + 
			  		"            FROM(\r\n" + 
			  		"            SELECT EX_ID,EXFEE\r\n" + 
			  		"            FROM EXAMINATION\r\n" + 
			  		"            WHERE PID_OUT = id_in) A;\r\n" + 
			  		"            RETURN V_Test_TabType;\r\n" + 
			  		"    ELSE\r\n" + 
			  		"            SELECT TEST_OBJ_TYPE(b.trid, b.mprice)\r\n" + 
			  		"            bulk collect into\r\n" + 
			  		"            V_Test_TabType\r\n" + 
			  		"            FROM(\r\n" + 
			  		"            SELECT TRID,MPRICE\r\n" + 
			  		"            FROM USE_TREAT,MEDICATION\r\n" + 
			  		"            WHERE USE_TREAT.PID_IN = id_in AND MEDICATION.MID = USE_TREAT.MID) B;\r\n" + 
			  		"            RETURN V_Test_TabType;\r\n" + 
			  		"        \r\n" + 
			  		"    END IF;\r\n" + 
			  		"END;";
			  prt = (OraclePreparedStatement) conn.prepareStatement(sql);
			  rs = (OracleResultSet) prt.executeQuery();
			  String sqls = "SELECT * \r\n" + 
			  		"FROM TABLE(findPayment('"+pid+"'))";
			  prt = (OraclePreparedStatement) conn.prepareStatement(sqls);
			  rs = (OracleResultSet) prt.executeQuery();
		      table.setModel(DbUtils.resultSetToTableModel(rs));
		      String sql4 = "SELECT SUM(FEE) FROM TABLE(findPayment('"+pid+"'))";
		      prt = (OraclePreparedStatement) conn.prepareStatement(sql4);
			  rs = (OracleResultSet) prt.executeQuery();
		      table_1.setModel(DbUtils.resultSetToTableModel(rs));}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

