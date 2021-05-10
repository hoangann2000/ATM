package ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class dichvu extends dangnhap {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dichvu frame = new dichvu();
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
	public dichvu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qu\u00FD Kh\u00E1ch vui l\u00F2ng ch\u1ECDn giao d\u1ECBch");
		lblNewLabel.setBounds(207, 11, 363, 43);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\u0110\u1ED5i m\u1EADt m\u00E3");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBounds(485, 125, 188, 57);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				doimapin obj = new doimapin();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("R\u00FAt ti\u1EC1n m\u1EB7t");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ruttien rut = new ruttien();
				rut.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_2.setBounds(67, 125, 188, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Chuy\u1EC3n ti\u1EC1n");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				chuyentien obj = new chuyentien();
				obj.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_4.setBounds(67, 246, 188, 57);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("Tho\u00E1t");
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_7.setBounds(485, 246, 188, 57);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				dangnhap obj = new dangnhap();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_7);
	}
}
