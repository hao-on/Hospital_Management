package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class List extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List frame = new List();
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
	private JTable table_2;
	private JButton btnId;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_7;
	private JButton button_8;
	private JButton btnG;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton btnSickroom;
	private JButton btnFee;
	private JButton btnEiddoc;
	private JButton btnEidnur;
	public List() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.YELLOW);
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSearch.setBounds(608, 40, 203, 14);
		contentPane.add(lblSearch);
		
		JLabel lblPid = new JLabel("Doctor ID");
		lblPid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPid.setForeground(Color.CYAN);
		lblPid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPid.setBounds(517, 68, 86, 23);
		contentPane.add(lblPid);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					try 
					{
						conn = login.dbconnect();
						Displaydata();
					}
					catch (Exception e) 
					{
						
					}
				}
				}
			
		});
		textField.setColumns(10);
		textField.setBounds(613, 70, 198, 20);
		contentPane.add(textField);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					conn = login.dbconnect();
					Displaydata();
				}
				catch (Exception e) 
				{
					
				}
			}
		});
		
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEnter.setBackground(SystemColor.menu);
		btnEnter.setBounds(835, 68, 93, 23);
		contentPane.add(btnEnter);
		
		DefaultTableModel model = new DefaultTableModel();
		table_1 = new JTable(model);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table_1.setVisible(false);
		table_1.setBounds(12, 200, 1450, 200);
		contentPane.add(table_1);

		
		table_2 = new JTable();
		table_2.setVisible(false);
		table_2.setBounds(12, 550, 1200, 200);
		contentPane.add(table_2);
		
		btnId = new JButton("IN_ID");
		btnId.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnId.setBounds(12, 175, 100, 25);
		contentPane.add(btnId);
		btnId.setVisible(false);
		
		button = new JButton("ADMISSION");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button.setBounds(111, 175, 100, 25);
		contentPane.add(button);
		button.setVisible(false);
		
		button_1 = new JButton("DISCHARGE");
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_1.setBounds(211, 175, 100, 25);
		contentPane.add(button_1);
		button_1.setVisible(false);
		
		button_2 = new JButton("DIAGNOSIS");
		button_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_2.setBounds(311, 175, 200, 25);
		contentPane.add(button_2);
		button_2.setVisible(false);
		
		button_7 = new JButton("NAME");
		button_7.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_7.setBounds(911, 175, 200, 25);
		contentPane.add(button_7);
		button_7.setVisible(false);
		
		button_8 = new JButton("DOB");
		button_8.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_8.setBounds(1111, 175, 100, 25);
		contentPane.add(button_8);
		button_8.setVisible(false);
		
		btnG = new JButton("G");
		btnG.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnG.setBounds(1211, 175, 50, 25);
		contentPane.add(btnG);
		btnG.setVisible(false);
		
		button_10 = new JButton("ADDRESS");
		button_10.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		button_10.setBounds(1261, 175, 201, 25);
		contentPane.add(button_10);
		button_10.setVisible(false);
		
		button_11 = new JButton("OUT_ID");
		button_11.setBounds(12, 525, 200, 25);
		contentPane.add(button_11);
		button_11.setVisible(false);
		
		button_12 = new JButton("EID_DOC");
		button_12.setBounds(211, 525, 200, 25);
		contentPane.add(button_12);
		button_12.setVisible(false);
		
		button_13 = new JButton("NAME");
		button_13.setBounds(411, 525, 200, 25);
		contentPane.add(button_13);
		button_13.setVisible(false);
		
		button_14 = new JButton("DOB");
		button_14.setBounds(611, 525, 200, 25);
		contentPane.add(button_14);
		button_14.setVisible(false);
		
		button_15 = new JButton("GENRE");
		button_15.setBounds(811, 525, 200, 25);
		contentPane.add(button_15);
		button_15.setVisible(false);
		
		button_16 = new JButton("ADDRESS");
		button_16.setBounds(1011, 525, 201, 25);
		contentPane.add(button_16);
		button_16.setVisible(false);
		
		btnSickroom = new JButton("SICKROOM");
		btnSickroom.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnSickroom.setBounds(511, 175, 100, 25);
		contentPane.add(btnSickroom);
		btnSickroom.setVisible(false);
		
		btnFee = new JButton("FEE");
		btnFee.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnFee.setBounds(611, 175, 100, 25);
		contentPane.add(btnFee);
		btnFee.setVisible(false);
		
		btnEiddoc = new JButton("EID_DOC");
		btnEiddoc.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnEiddoc.setBounds(711, 175, 100, 25);
		contentPane.add(btnEiddoc);
		btnEiddoc.setVisible(false);
		
		btnEidnur = new JButton("EID_NUR");
		btnEidnur.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnEidnur.setBounds(811, 175, 100, 25);
		contentPane.add(btnEidnur);
		btnEidnur.setVisible(false);
		
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
		public void Displaydata() {
			try 
			{
				String id = textField.getText();
				boolean flag = false;
				String query = "Select EID_DOC from DOCTOR";
				Statement stmt2 = conn.createStatement();
				ResultSet rs3 = stmt2.executeQuery(query);
				while (rs3.next())
				{
					String eid_doc = rs3.getString("EID_DOC");
					if(id.equals(eid_doc))
					{
						flag = true;
						break;
					}
				}

				if(!flag)
				{
					Visible(false);
					JLabel label = new JLabel("Wrong format");
					label.setFont(new Font("Times New Roman",Font.PLAIN, 15));
					final ImageIcon icon = new ImageIcon(Homepage.class.getResource("/app/warn.png"));
					JOptionPane.showMessageDialog(null, label,"About", JOptionPane.INFORMATION_MESSAGE,icon);
					return;
				}
				Visible(true);
				String sql1 = 
					"select i.PID_IN, to_char (i.PADMISSIONDATE, 'MM/dd/yyyy'), to_char (i.PDISCHARGEDATE, 'MM/dd/yyyy'), i.PDIAGNOSIS, i.PSICKROOM, i.PFEE, i.EID_DOC, i.EID_NUR, (p.PFNAME || ' ' || p.PLNAME ) as FULLNAME, to_char (p.PDOB, 'MM/dd/yyyy') , p.PGENRE, p.PADDRESS \r\n" + 
			  		"from (inpatient i join patient p on pid_in = pid) join doctor d on i.eid_doc = d.eid_doc\r\n" + 
			  		"where i.EID_DOC = '" + id + "'";
			  
				String sql2 = 
					"select o.* , (p.PFNAME || ' ' || p.PLNAME ) as FULLNAME, to_char (p.PDOB, 'MM/dd/yyyy') , p.PGENRE, p.PADDRESS\r\n" + 
			  		"from (outpatient o join patient p on pid_out = pid) join doctor d on o.eid_doc = d.eid_doc\r\n" + 
			  		"where o.EID_DOC = '" + id + "'";
			 
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql1);

				table_1.setModel(DbUtils.resultSetToTableModel(rs)); 
				
				table_1.getColumnModel().getColumn(0).setPreferredWidth(100);  
				table_1.getColumnModel().getColumn(1).setPreferredWidth(100); 
				table_1.getColumnModel().getColumn(2).setPreferredWidth(100); 
				table_1.getColumnModel().getColumn(3).setPreferredWidth(200); 
				table_1.getColumnModel().getColumn(4).setPreferredWidth(100); 
				table_1.getColumnModel().getColumn(5).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(6).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(7).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(8).setPreferredWidth(200);
				table_1.getColumnModel().getColumn(9).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(10).setPreferredWidth(50);
				table_1.getColumnModel().getColumn(11).setPreferredWidth(200); 
				
				String col[] = {"1", "2", "3", "4", "5", "6"};
				DefaultTableModel model = new DefaultTableModel();
				ResultSet rs2 = stmt.executeQuery(sql2);
				model.setColumnIdentifiers(col);

				table_2.setModel(model);
				table_2.setModel(DbUtils.resultSetToTableModel(rs2));
				
				table_2.getColumnModel().getColumn(0).setPreferredWidth(200);  
				table_2.getColumnModel().getColumn(1).setPreferredWidth(200); 
				table_2.getColumnModel().getColumn(2).setPreferredWidth(200); 
				table_2.getColumnModel().getColumn(3).setPreferredWidth(200); 
				table_2.getColumnModel().getColumn(4).setPreferredWidth(200); 
				table_2.getColumnModel().getColumn(5).setPreferredWidth(200);
				
			}
			catch (Exception e) 
			{
				
			}
		}
		
		public void Visible(boolean a) {
			table_1.setVisible(a);
			table_2.setVisible(a);
			btnId.setVisible(a); button.setVisible(a); button_1.setVisible(a); button_2.setVisible(a); button_7.setVisible(a); button_8.setVisible(a); 
			btnG.setVisible(a); button_10.setVisible(a); button_11.setVisible(a); btnEiddoc.setVisible(a); btnEidnur.setVisible(a); btnSickroom.setVisible(a);
			btnFee.setVisible(a); button_12.setVisible(a); button_13.setVisible(a); button_14.setVisible(a); button_15.setVisible(a); button_16.setVisible(a);
		}
		
}
