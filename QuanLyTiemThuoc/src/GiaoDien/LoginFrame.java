package GiaoDien;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class LoginFrame extends javax.swing.JFrame {
	Connection con = null;
	PreparedStatement pst = null;
	//ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtpass;

//	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setLocationRelativeTo(null);
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
	public LoginFrame() {
		
		URL url_iconPlus = LoginFrame.class.getResource("Plus-icon.png");
		Image imgFrame = Toolkit.getDefaultToolkit().createImage(url_iconPlus);
		this.setIconImage(imgFrame);
		
		setForeground(new Color(0, 0, 0));
		setTitle("Đăng nhập tài khoản");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		System.out.println("hello");

		JLabel lblNewLabel_1 = new JLabel("MẬT KHẨU");
		lblNewLabel_1.setForeground(new Color(0, 51, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(37, 89, 129, 32);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 51, 51));
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT `user_name`, `user_password` FROM `user` WHERE user_name=? and user_password=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management","root","");
					pst = con.prepareStatement(query);
					pst.setString(1, txtuser.getText());
					pst.setString(2, String.valueOf(txtpass.getText()));
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnNewButton, "Đăng nhập thành công!");
						ManHinhChinh a = new ManHinhChinh();
						a.main(null);
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Tên người dùng hoặc mật khẩu không đúng!");
					}

				} catch (Exception ex) {

				}
			}
		});
		btnNewButton.setBounds(170, 178, 101, 32);
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);

		txtuser = new JTextField();
		txtuser.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(255, 255, 204)));
		txtuser.setSelectionColor(new Color(0, 0, 0));
		txtuser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtuser.setBounds(201, 53, 187, 23);
		contentPane.add(txtuser);
		txtuser.setColumns(10);

		txtpass = new JPasswordField();
		txtpass.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(255, 255, 204)));
		txtpass.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpass.setColumns(10);
		txtpass.setBounds(201, 96, 187, 23);
		
		contentPane.add(txtpass);

		JLabel lblNewLabel_1_1 = new JLabel("TÊN TÀI KHOẢN");
		lblNewLabel_1_1.setAutoscrolls(true);
		lblNewLabel_1_1.setForeground(new Color(0, 51, 51));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(37, 46, 154, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(10, 40, 414, 2);
		contentPane.add(separator);
		
		JCheckBox checkBoxShowPassword = new JCheckBox("Hiển thị mật khẩu");
		checkBoxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxShowPassword.isSelected()) {
					txtpass.setEchoChar((char)0);
				}
				else {
					txtpass.setEchoChar('●');
				}
			}
		});
		checkBoxShowPassword.setFont(new Font("Tahoma", Font.ITALIC, 13));
		checkBoxShowPassword.setBackground(new Color(102, 204, 153));
		checkBoxShowPassword.setBounds(201, 126, 163, 23);
		contentPane.add(checkBoxShowPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(10, 161, 414, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setBounds(170, 11, 114, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}

			private void reset(ActionEvent e) {
				txtuser.setText("");
				txtpass.setText("");
				
			}
		});
		btnReset.setForeground(new Color(0, 51, 51));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.setBorder(null);
		btnReset.setBackground(new Color(255, 255, 204));
		btnReset.setBounds(301, 178, 101, 32);
		contentPane.add(btnReset);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnHuy.setForeground(new Color(0, 51, 51));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBorder(null);
		btnHuy.setBackground(new Color(255, 255, 204));
		btnHuy.setBounds(37, 178, 101, 32);
		contentPane.add(btnHuy);

	}
}

