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

@SuppressWarnings("serial")
public class TreatmentPage extends JFrame {

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
	public TreatmentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 453);
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
		lblData.setForeground(Color.YELLOW);
		lblData.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblData.setBounds(258, 33, 203, 14);
		contentPane.add(lblData);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table.setBounds(10, 107, 750, 193);
		conn = login.dbconnect();
		Displaydata();
		contentPane.add(table);
		
		btnNewButton = new JButton("DoctorID");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 83, 100, 23);
		contentPane.add(btnNewButton);
		
		btnPatientid = new JButton("PatientID");
		btnPatientid.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnPatientid.setBounds(110, 83, 100, 23);
		contentPane.add(btnPatientid);
		
		btnTreatmentid = new JButton("TreatmentID");
		btnTreatmentid.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnTreatmentid.setBounds(210, 83, 100, 23);
		contentPane.add(btnTreatmentid);
		
		btnStartdate = new JButton("Startdate");
		btnStartdate.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnStartdate.setBounds(310, 83, 125, 23);
		contentPane.add(btnStartdate);
		
		btnEnddate = new JButton("Enddate");
		btnEnddate.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnEnddate.setBounds(435, 83, 125, 23);
		contentPane.add(btnEnddate);
		
		btnResult = new JButton("Result");
		btnResult.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnResult.setBounds(560, 83, 200, 23);
		contentPane.add(btnResult);
		
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
	
	}
	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	public void Displaydata() {
	try {
	  String sql = "SELECT EID_DOC,PID_IN,TRID,to_char(treatment.trstart,'MM/dd/yyyy'),to_char(treatment.trend,'MM/dd/yyyy'),trresult FROM TREATMENT";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery( sql );
      table.setModel(DbUtils.resultSetToTableModel(rs));
      table.getColumnModel().getColumn(0).setPreferredWidth(100);
      table.getColumnModel().getColumn(1).setPreferredWidth(100);
      table.getColumnModel().getColumn(2).setPreferredWidth(100);
      table.getColumnModel().getColumn(3).setPreferredWidth(125);
      table.getColumnModel().getColumn(4).setPreferredWidth(125);
      table.getColumnModel().getColumn(5).setPreferredWidth(200);

	  rs.close();

	}catch(Exception e) {
		
	}
}
}