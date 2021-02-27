package app;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import net.proteanit.sql.DbUtils;

public class PatientTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorPage frame = new DoctorPage();
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
	private JButton btnNewButton;
	private JButton btnPatientid;
	private JButton btnTreatmentid;
	private JButton btnStartdate;
	private JButton btnEnddate;
	private JButton btnResult;
	public PatientTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 453);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPatient = new JButton("");
		btnPatient.setForeground(Color(240, 240, 240));
		btnPatient.setFont(new Font("Times New Roman", Font.BOLD, 11));
		contentPane.add(btnPatient);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(new Color(255, 255, 0));
		lblData.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblData.setBounds(277, 35, 203, 14);
		contentPane.add(lblData);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table.setBounds(10, 97, 760, 193);
		conn = login.dbconnect();
		Displaydata();
		contentPane.add(table);

		
		btnNewButton = new JButton("PatientID");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 73, 80, 23);
		contentPane.add(btnNewButton);
		
		btnPatientid = new JButton("Full Name");
		btnPatientid.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnPatientid.setBounds(90, 73, 150, 23);
		contentPane.add(btnPatientid);
		
		btnTreatmentid = new JButton("Birth Date");
		btnTreatmentid.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnTreatmentid.setBounds(240, 73, 100, 23);
		contentPane.add(btnTreatmentid);
		
		btnStartdate = new JButton("Gender");
		btnStartdate.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnStartdate.setBounds(340, 73, 80, 23);
		contentPane.add(btnStartdate);
		
		btnEnddate = new JButton("Phone No");
		btnEnddate.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnEnddate.setBounds(420, 73, 100, 23);
		contentPane.add(btnEnddate);
		
		btnResult = new JButton("Address");
		btnResult.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnResult.setBounds(520, 73, 250, 23);
		contentPane.add(btnResult);
		
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
	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	public void Displaydata() {
	try {
	  String sql = "SELECT PID,PLNAME||' '||PFNAME,to_char(patient.pdob,'MM/dd/yyyy'),pgenre,pphone,paddress FROM patient";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery( sql );
      table.setModel(DbUtils.resultSetToTableModel(rs));
      table.getColumnModel().getColumn(0).setPreferredWidth(80);
      table.getColumnModel().getColumn(1).setPreferredWidth(150);
      table.getColumnModel().getColumn(2).setPreferredWidth(100);
      table.getColumnModel().getColumn(3).setPreferredWidth(80);
      table.getColumnModel().getColumn(4).setPreferredWidth(100);
      table.getColumnModel().getColumn(5).setPreferredWidth(250);

	  rs.close();

	}catch(Exception e) {
		
	}	
	}
}
