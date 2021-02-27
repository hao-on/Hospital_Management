package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class IncreaseFee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncreaseFee frame = new IncreaseFee();
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
	private JTable table;
	private JTextField textField;
	public IncreaseFee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 453);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table.setBounds(10, 153, 1158, 246);
		table.setVisible(false);
		contentPane.add(table);
		
		JLabel lblEnterDate = new JLabel("Enter Date:");
		lblEnterDate.setForeground(Color.CYAN);
		lblEnterDate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDate.setBounds(283, 77, 135, 36);
		contentPane.add(lblEnterDate);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					try 
					{
						table.setVisible(true);
						conn = login.dbconnect();
						Displaydata();
					}
					catch (Exception e) 
					{
						
					}
				}
				}
			
		});
		textField.setBounds(414, 84, 293, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("DISPLAY");
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					table.setVisible(true);
					conn = login.dbconnect();
					Displaydata();
				}
				catch (Exception e) 
				{
					
				}
			}
		});
		btnEnter.setBounds(728, 84, 97, 25);
		contentPane.add(btnEnter);
		
		BasicArrowButton back = new BasicArrowButton(7);
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
		
		JLabel lblFee = new JLabel("FEE");
		lblFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblFee.setForeground(Color.YELLOW);
		lblFee.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFee.setBounds(457, 32, 203, 14);
		contentPane.add(lblFee);
	}
	
	public void Displaydata() {
		try 
		{
			String date = textField.getText();
			if(isValidDate(date))
			{
							
			}
			else
			{
				table.setVisible(false);
				JLabel label = new JLabel("Wrong format");
				label.setFont(new Font("Times New Roman",Font.PLAIN, 15));
				final ImageIcon icon = new ImageIcon(Homepage.class.getResource("/app/warn.png"));
				JOptionPane.showMessageDialog(null, label,"About", JOptionPane.INFORMATION_MESSAGE,icon);
				return;
			}
			String proc = "{call INC(?)}";
			CallableStatement cs = conn.prepareCall(proc); 
			cs.setString(1, date);
			cs.execute();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from INPATIENT");
			
			table.setModel(DbUtils.resultSetToTableModel(rs)); 
			rs.close();

		} 
		catch(Exception e) 
		{
			
		}
	}
	
	public boolean isValidDate(String inDate) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		try 
		{
			dateFormat.parse(inDate.trim());
		} 
		catch (ParseException pe) 
		{
			return false;
		}
		return true;
	}
}
