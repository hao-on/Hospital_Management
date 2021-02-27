package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Display extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
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
	public Display() {
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
		
		JButton btnPatient = new JButton("PATIENT");
		btnPatient.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPatient.addActionListener(new ActionListener() {
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
		btnPatient.setBackground(SystemColor.menu);
		btnPatient.setBounds(51, 82, 146, 31);
		contentPane.add(btnPatient);
		
		JButton btnExamination = new JButton("EXAMINATION");
		btnExamination.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExamination.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					ExaminationPage ep = new ExaminationPage();
					ep.setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
		btnExamination.setBackground(SystemColor.menu);
		btnExamination.setBounds(242, 154, 146, 31);
		contentPane.add(btnExamination);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.YELLOW);
		lblData.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblData.setBounds(119, 39, 203, 14);
		contentPane.add(lblData);
		
		JButton btnDoctor = new JButton("DOCTOR");
		btnDoctor.addActionListener(new ActionListener() {
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
		btnDoctor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDoctor.setBackground(SystemColor.menu);
		btnDoctor.setBounds(242, 82, 146, 31);
		contentPane.add(btnDoctor);
		
		JButton btnTreatment = new JButton("TREATMENT");
		btnTreatment.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTreatment.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					TreatmentPage tp = new TreatmentPage();
					tp.setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
		btnTreatment.setBackground(SystemColor.menu);
		btnTreatment.setBounds(51, 154, 146, 31);
		contentPane.add(btnTreatment);
		
		BasicArrowButton back = new BasicArrowButton(BasicArrowButton.WEST);
		back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					Homepage hp = new Homepage();
					hp.setVisible(true);
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

}
