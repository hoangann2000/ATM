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

public class ruttien extends dichvu {
	public static Connection conn = ConnectionDB.connectDB();
	public static DecimalFormat Formatter = new DecimalFormat("#,###");

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ruttien frame = new ruttien();
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
	public ruttien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 ti\u1EC1n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(44, 11, 140, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(275, 16, 159, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRtTin = new JButton("R\u00FAt ti\u1EC1n");
		btnRtTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String so = textField .getText();
				double money = Integer.parseInt(so);
				double mon = money;
				int i;
				final double FiveHundredThousand = 500000,
						 TwoHundredThousand = 200000 ,
						  OneHundredThousand = 100000, 
						  FiftyThousand = 50000,
						  TwentyThousand = 20000,
						  TenThousand = 10000;
				int Num_FiveHundredThousand = 0,
						Num_TwoHundredThousand =0 ,
						Num_OneHundredThousand = 0,
						Num_FiftyThousand =0 ,
						Num_TwentyThousand =0 ,
						Num_TenThousand =0;
				double FiveHundredThousand_Sum = 0,
						 TwoHundredThousand_Sum = 0 ,
						  OneHundredThousand_Sum = 0, 
						  FiftyThousand_Sum = 0,
						  TwentyThousand_Sum = 0,
						  TenThousand_Sum= 0;
				double [] GiaTien = {FiveHundredThousand, TwoHundredThousand, OneHundredThousand, 
						                              FiftyThousand, TwentyThousand, TenThousand};
				int [] SoLuong = {Num_FiveHundredThousand, Num_TwoHundredThousand ,Num_OneHundredThousand,
						                                    Num_FiftyThousand,Num_TwentyThousand ,Num_TenThousand };
				double[] ThanhTien = {FiveHundredThousand_Sum,TwoHundredThousand_Sum,OneHundredThousand_Sum ,
						                                    FiftyThousand_Sum,TwentyThousand_Sum,TenThousand_Sum};
				for(i=0;i<GiaTien.length;i++) 
					if(money >= GiaTien[i]) {
						SoLuong[i] = (int) (money / GiaTien[i]);
						ThanhTien[i]= GiaTien[i]*SoLuong[i];
						money  = money - ThanhTien[i];
						
					}
				
				textField_1.setText(String.valueOf(SoLuong[0]));textField_2.setText(String.valueOf(Formatter.format(ThanhTien[0])));
				textField_3.setText(String.valueOf(SoLuong[1]));textField_4.setText(String.valueOf(Formatter.format(ThanhTien[1])));
				textField_5.setText(String.valueOf(SoLuong[2]));textField_6.setText(String.valueOf(Formatter.format(ThanhTien[2])));
				textField_7.setText(String.valueOf(SoLuong[3]));textField_8.setText(String.valueOf(Formatter.format(ThanhTien[3])));
				textField_9.setText(String.valueOf(SoLuong[4]));textField_10.setText(String.valueOf(Formatter.format(ThanhTien[4])));
				textField_11.setText(String.valueOf(SoLuong[5]));textField_12.setText(String.valueOf(Formatter.format(ThanhTien[5])));
				try {
					
					String sql = "update login "
							+ " set Balance = Balance - ? "
							+ " where id = ? and mapin = ? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setDouble(1, mon);
					ps.setString(2, mathe);
					ps.setInt(3,maPIN);
					if(ps.executeUpdate() !=0 ) {
					 JOptionPane.showMessageDialog(null,"Rút tiền thành công");
					 
					}else JOptionPane.showMessageDialog(null,"Không thể rút tiền");

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
		btnRtTin.setFont(new Font("Arial", Font.BOLD, 15));
		btnRtTin.setBounds(582, 13, 109, 36);
		contentPane.add(btnRtTin);
		
		JButton btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				dichvu obj = new dichvu();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(582, 333, 109, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EC7nh gi\u00E1 500.000");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 78, 159, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EC7nh gi\u00E1 200.000");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(44, 116, 140, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M\u1EC7nh gi\u00E1 100.000");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(44, 155, 140, 41);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("M\u1EC7nh gi\u00E1 50.000");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(44, 196, 140, 46);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("M\u1EC7nh gi\u00E1 20.000");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(44, 240, 140, 51);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("M\u1EC7nh gi\u00E1 10.000");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(44, 289, 140, 38);
		contentPane.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(275, 89, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(444, 89, 140, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(275, 128, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(444, 128, 140, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(275, 167, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(444, 167, 140, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(275, 211, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(444, 211, 140, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(275, 257, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(444, 257, 140, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(275, 300, 86, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(444, 300, 140, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
	}
}
