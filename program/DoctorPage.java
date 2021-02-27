package app;
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

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class DoctorPage extends JFrame {

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
	OraclePreparedStatement prt = null;
	OracleResultSet rs =null;
	public DoctorPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 430);
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
		lblData.setBounds(283, 30, 203, 14);
		contentPane.add(lblData);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(10, 100, 730, 213);
		conn = login.dbconnect();
		Displaydata();
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("EID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 75, 70, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDocLastname = new JButton("Full name");
		btnDocLastname.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnDocLastname.setBounds(80, 75, 125, 23);
		contentPane.add(btnDocLastname);
		
		JButton btnBirthdate = new JButton("Gender");
		btnBirthdate.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnBirthdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBirthdate.setBounds(205, 75, 70, 23);
		contentPane.add(btnBirthdate);
		
		JButton btnSpeciality = new JButton("Speciality");
		btnSpeciality.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnSpeciality.setBounds(385, 75, 150, 23);
		contentPane.add(btnSpeciality);
		
		JButton btnS = new JButton("Startdate");
		btnS.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnS.setBounds(535, 75, 110, 23);
		contentPane.add(btnS);
		
		JButton btnDepartment = new JButton("Department");
		btnDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnDepartment.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDepartment.setBounds(645, 75, 95, 23);
		contentPane.add(btnDepartment);
		
		JButton button = new JButton("Birthdate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(275, 75, 110, 23);
		contentPane.add(button);
		
		BasicArrowButton back = new BasicArrowButton(BasicArrowButton.WEST);
		back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					Doctor dr = new Doctor();
					dr.setVisible(true);
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
	  String sql = "SELECT EID, EFNAME||' '||ELNAME,EGENRE ,TO_CHAR(employee.edob,'mm/dd/yyyy'),ESPECIALITY,TO_CHAR(employee.estartdate,'mm/dd/yyyy'),DID FROM doctor,employee where eid_doc = eid";
	  prt = (OraclePreparedStatement) conn.prepareStatement(sql);
	  rs = (OracleResultSet) prt.executeQuery();
      table.setModel(DbUtils.resultSetToTableModel(rs));
      table.getColumnModel().getColumn(0).setPreferredWidth(70);
      table.getColumnModel().getColumn(1).setPreferredWidth(125);
      table.getColumnModel().getColumn(2).setPreferredWidth(70);
      table.getColumnModel().getColumn(3).setPreferredWidth(110);
      table.getColumnModel().getColumn(4).setPreferredWidth(150);
      table.getColumnModel().getColumn(5).setPreferredWidth(110);
      table.getColumnModel().getColumn(6).setPreferredWidth(95);

	  rs.close();

	}catch(Exception e) {
		
	}
}
	
}
