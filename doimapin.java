package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DecimalFormat;
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

public class doimapin extends dichvu {

	private JPanel contentPane;
	private JTextField tfmapincu;
	private JTextField tfmapinmoi;

	/**
	 * Launch the application.
	 */
	Connection conn;
	Statement stmt;
	private JTextField tfmathe1;
	
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/atm", "root", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doimapin frame = new doimapin();
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
	public doimapin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbliMPin = new JLabel("\u0110\u1ED5i m\u00E3 pin");
		lbliMPin.setFont(new Font("Arial", Font.BOLD, 20));
		lbliMPin.setBounds(295, 11, 131, 62);
		contentPane.add(lbliMPin);
		
		JLabel lblMPinC = new JLabel("M\u00E3 pin c\u0169");
		lblMPinC.setFont(new Font("Arial", Font.BOLD, 15));
		lblMPinC.setBounds(144, 167, 104, 34);
		contentPane.add(lblMPinC);
		
		tfmapincu = new JTextField();
		tfmapincu.setBounds(319, 168, 208, 35);
		contentPane.add(tfmapincu);
		tfmapincu.setColumns(10);
		
		JLabel lblMPinMi = new JLabel("Mã pin mới");
		lblMPinMi.setFont(new Font("Arial", Font.BOLD, 15));
		lblMPinMi.setBounds(144, 232, 104, 34);
		contentPane.add(lblMPinMi);
		
		tfmapinmoi = new JTextField();
		tfmapinmoi.setBounds(319, 233, 208, 35);
		contentPane.add(tfmapinmoi);
		tfmapinmoi.setColumns(10);
		
		JButton btni = new JButton("\u0110\u1ED5i");
		btni.setFont(new Font("Arial", Font.BOLD, 15));
		btni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				connectDB();
				stmt = conn.createStatement(); 
				int n =stmt.executeUpdate("Update login set mapin='" + tfmapinmoi.getText()+"' where id = '" + tfmathe1.getText()+"'");
				if(n>0) {
					JOptionPane.showMessageDialog(null, "Đổi mã pin thành công");
				dangnhap obj = new dangnhap();
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
		btni.setBounds(117, 307, 131, 55);
		contentPane.add(btni);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				dichvu obj =  new dichvu();
				obj.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(507, 308, 122, 55);
		contentPane.add(btnNewButton);
		
		JLabel tfmathe = new JLabel("Mã thẻ");
		tfmathe.setFont(new Font("Arial", Font.BOLD, 15));
		tfmathe.setBounds(144, 98, 104, 34);
		contentPane.add(tfmathe);
		
		tfmathe1 = new JTextField();
		tfmathe1.setBounds(319, 99, 208, 34);
		contentPane.add(tfmathe1);
		tfmathe1.setColumns(10);
	}
}
