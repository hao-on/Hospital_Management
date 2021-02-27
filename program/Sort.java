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
import oracle.jdbc.OracleTypes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Sort extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort frame = new Sort();
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
	public Sort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 506);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 183, 858, 253);
		table.setVisible(false);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("FROM");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(237, 79, 70, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setForeground(Color.CYAN);
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(237, 113, 70, 25);
		contentPane.add(lblTo);
		
		textField = new JTextField();
		textField.setBounds(317, 82, 211, 20);
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
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
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
		textField_1.setColumns(10);
		textField_1.setBounds(317, 113, 211, 24);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("DISPLAY");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(538, 93, 97, 25);
		contentPane.add(btnNewButton);
		
		BasicArrowButton back = new BasicArrowButton(7);
		back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			conn = login.dbconnect();
			try {
					dispose();
					Doctor dc = new Doctor();
					dc.setVisible(true);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	 });
		back.setBackground(Color.BLACK);
		back.setBounds(0, 0, 34, 22);
		contentPane.add(back);
		
		JLabel lblSort = new JLabel("SORT");
		lblSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblSort.setForeground(Color.YELLOW);
		lblSort.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSort.setBounds(317, 31, 203, 14);
		contentPane.add(lblSort);
	}
	
	public void Displaydata() {
		try 
		{
			String from = textField.getText();
			String to = textField_1.getText();
			if(isValidDate(from) && isValidDate(to))
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
			String proc = "{call GETDBUSERCURSOR(?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(proc); 
			cs.setString(1, from);
			cs.setString(2, to);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.execute(); 

			ResultSet rs = (ResultSet) cs.getObject(3);
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
