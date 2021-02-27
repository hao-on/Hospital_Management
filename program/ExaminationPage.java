package app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
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
public class ExaminationPage extends JFrame {

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
	private JButton btnExamid;
	private JButton btnDate;
	private JButton btnFee;
	private JButton btnDiagnosis;
	private JButton btnSecondexam;
	public ExaminationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 430);
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
		lblData.setBounds(257, 35, 203, 14);
		contentPane.add(lblData);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table.setBounds(10, 111, 760, 206);
		conn = login.dbconnect();
		Displaydata();
		contentPane.add(table);
		
		btnNewButton = new JButton("DoctorID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 87, 90, 23);
		contentPane.add(btnNewButton);
		
		btnPatientid = new JButton("PatientID");
		btnPatient.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnPatientid.setBounds(100, 87, 90, 23);
		contentPane.add(btnPatientid);
		
		btnExamid = new JButton("ExamID");
		btnExamid.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnExamid.setBounds(190, 87, 90, 23);
		contentPane.add(btnExamid);
		
		btnDate = new JButton("Date");
		btnDate.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnDate.setBounds(280, 87, 110, 23);
		contentPane.add(btnDate);
		
		btnFee = new JButton("Fee");
		btnFee.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnFee.setBounds(390, 87, 70, 23);
		contentPane.add(btnFee);
		
		btnDiagnosis = new JButton("Diagnosis");
		btnDiagnosis.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnDiagnosis.setBounds(460, 87, 200, 23);
		contentPane.add(btnDiagnosis);
		
		btnSecondexam = new JButton("SecondExam");
		btnSecondexam.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnSecondexam.setBounds(660, 87, 110, 23);
		contentPane.add(btnSecondexam);
		
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
	  String sql = "SELECT EID_DOC,PID_OUT,EX_ID,to_char(examination.exdate,'MM/dd/yyyy'),exfee,exdiagnosis,to_char(examination.exsecond_examination_date,'MM/dd/yyyy') FROM EXAMINATION ";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery( sql );
      table.setModel(DbUtils.resultSetToTableModel(rs));
      table.getColumnModel().getColumn(0).setPreferredWidth(90);
      table.getColumnModel().getColumn(1).setPreferredWidth(90);
      table.getColumnModel().getColumn(2).setPreferredWidth(90);
      table.getColumnModel().getColumn(3).setPreferredWidth(110);
      table.getColumnModel().getColumn(4).setPreferredWidth(70);
      table.getColumnModel().getColumn(5).setPreferredWidth(200);
      table.getColumnModel().getColumn(6).setPreferredWidth(110);
	  rs.close();

	}catch(Exception e) {
		
	}
	}

}