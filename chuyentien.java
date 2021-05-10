package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class chuyentien extends dichvu {
	public static Connection conn = ConnectionDB.connectDB();
	  protected static double money;
	  protected static Long moneysend;
	  protected static String idGet;
	  protected static int GetMoney;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chuyentien frame = new chuyentien();
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
	public chuyentien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\r\nS\u1ED1 ti\u1EC1n c\u1EA7n chuy\u1EC3n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 16, 160, 51);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(195, 29, 190, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00E0i kho\u1EA3n nh\u1EADn");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 95, 123, 41);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 103, 190, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Chuyển tiền");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String moneysend = textField.getText();
				idGet= textField_1.getText();
			try {
				Statement stmt = conn.createStatement();
				
		String sql = "update login " 
				+ " set Balance = case "
				+ " when (id = ? and mapin = ? ) then Balance - ? "
				+ " when (id = ? ) then Balance + ? "
				+ " else Balance "
				+ " end " ;
				
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mathe);
		ps.setInt(2,maPIN);
		ps.setNString(3, moneysend);
		ps.setString(4, idGet);
		ps.setNString(5, moneysend);
		
		if(ps.executeUpdate() !=0 )
		{
			JOptionPane.showMessageDialog(null,"Chuyển tiền thành công");
		}
		else JOptionPane.showMessageDialog(null,"không thể chuyển tiền");
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(54, 186, 121, 41);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Tho\u00E1t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				dichvu obj = new dichvu();
				obj.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBounds(262, 186, 123, 41);
		contentPane.add(btnNewButton_1);
	}
}
