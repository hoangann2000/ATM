package ATM;
import java.sql.*;
import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class dangnhap extends JFrame {
	 public static Connection conn = ConnectionDB.connectDB();
	private JPanel contentPane;
	private JTextField tfmapin;
     protected static String mathe;
     protected static int maPIN;
	Statement stmt;
	JTextField tfmathe;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhap frame = new dangnhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public dangnhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      Nhập mã pin ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 170, 273, 32);
		contentPane.add(lblNewLabel);
		
		tfmapin = new JTextField();
		tfmapin.setBounds(336, 170, 244, 40);
		contentPane.add(tfmapin);
		tfmapin.setColumns(10);
		
		JButton btnng = new JButton("\u0110\u1ED3ng \u00FD");
		btnng.setFont(new Font("Arial", Font.BOLD, 15));
		btnng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mapin = tfmapin.getText();
				 mathe = tfmathe.getText();
				 maPIN =Integer.parseInt(mapin);
					try {
						
						stmt = conn.createStatement();
						String sql ="select mapin,id from login "
								+ "where id = ? and mapin = ?";
						java.sql.PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1,mathe);
						ps.setInt(2, maPIN);
						ResultSet rs = ps.executeQuery();

						
						if(rs.next() ) {
							JOptionPane.showMessageDialog(null, "Đăng Nhập thành công vào tài khoản "+tfmathe.getText());
							dichvu obj = new dichvu();
							obj.setVisible(true);
							dispose();
						}
						else JOptionPane.showMessageDialog(null, "Fail");
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					
				}
					
				
			
		});
		btnng.setBounds(99, 294, 102, 40);
		contentPane.add(btnng);
		
		JButton btnHyB = new JButton("H\u1EE7y b\u1ECF");
		btnHyB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHyB.setFont(new Font("Arial", Font.BOLD, 15));
		btnHyB.setBounds(556, 294, 102, 40);
		contentPane.add(btnHyB);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập mã thẻ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(67, 62, 220, 40);
		contentPane.add(lblNewLabel_1);
		
		tfmathe = new JTextField();
		tfmathe.setBounds(336, 63, 244, 39);
		contentPane.add(tfmathe);
		tfmathe.setColumns(10);
	}
}
