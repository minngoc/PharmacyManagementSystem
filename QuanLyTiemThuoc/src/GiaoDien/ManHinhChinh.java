package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import pharmacy.Pharmacy;
import pharmacy.PharmacyModify;

import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JComboBox;

public class ManHinhChinh extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaThuoc;
	private JTextField textFieldTenThuoc;
	private JTextField textFieldGia;
	private JTextField textFieldSoLuong;
	private JTextField textFieldCachDung;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JComboBox comboBoxDVT;
	
	private String DVT;

	/**
	 * Launch the application.
	 */
	
	////////////////////////////////////////////////////////////////////
	DefaultTableModel tableModel;
	List<Pharmacy> pharmacyList = new ArrayList<>();
	
	//tableModel = (DefaultTableModel) tblPharmacy.getModel();
	////////////////////////////////////////////////////////////////////
	
//	private void showStudent() {
//		pharmacyList = PharmacyModify.findAll();
//
//		tableModel.setRowCount(0);
//
//		pharmacyList.forEach((Pharmacy) -> {
//			tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, Pharmacy.getTensanpham(), Pharmacy.getDvt(),
//					Pharmacy.getGia(), Pharmacy.getSoluong() });
//		});
//	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChinh frame = new ManHinhChinh();
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
	public ManHinhChinh() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		//this.setExtendedState(MAXIMIZED_BOTH);
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
		
		
		/////////////////////////////////////////////////////////////////////
//		ActionListener ac = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String src = e.getActionCommand();
//				
//				if(src.equals("THÊM"))
//				{
//					btnThem(e);
//				}
//				else if(src.equals("RESET")) {
//					btnReset(e);
//				}
//				
//			}
//		};
		
		
		setBounds(100, 100, 921, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pharmacityLabel = new JLabel("PHARMACITY");
		pharmacityLabel.setForeground(new Color(255, 255, 255));
		pharmacityLabel.setBackground(new Color(0, 51, 102));
		pharmacityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pharmacityLabel.setFont(new Font("Impact", Font.BOLD, 35));
		pharmacityLabel.setBounds(0, 0, 905, 93);
		pharmacityLabel.setOpaque(true);
		contentPane.add(pharmacityLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 92, 905, 52);
		contentPane.add(layeredPane);
		
		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(255, 255, 204)));
		btnDangXuat.setFont(new Font("Arial", Font.BOLD, 15));
		btnDangXuat.setForeground(new Color(255, 255, 255));
		btnDangXuat.setBackground(new Color(0, 102, 153));
		btnDangXuat.setBounds(772, 6, 123, 41);
		btnDangXuat.setOpaque(true);
		layeredPane.add(btnDangXuat);
		
		JButton btnThongKe = new JButton("THỐNG KÊ");
		btnThongKe.setOpaque(true);
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 15));
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(0, 102, 153));
		btnThongKe.setBounds(631, 6, 131, 41);
		layeredPane.add(btnThongKe);
		
		JButton btnThemThuoc = new JButton("THÊM THUỐC");
		btnThemThuoc.setOpaque(true);
		btnThemThuoc.setForeground(new Color(255, 255, 255));
		btnThemThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		btnThemThuoc.setBorderPainted(false);
		btnThemThuoc.setBackground(new Color(0, 102, 153));
		btnThemThuoc.setBounds(110, 6, 141, 41);
		layeredPane.add(btnThemThuoc);
		
		JButton btnTraCuuThuoc = new JButton("TRA CỨU THUỐC");
		btnTraCuuThuoc.setOpaque(true);
		btnTraCuuThuoc.setForeground(Color.WHITE);
		btnTraCuuThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		btnTraCuuThuoc.setBorderPainted(false);
		btnTraCuuThuoc.setBackground(new Color(0, 102, 153));
		btnTraCuuThuoc.setBounds(261, 6, 170, 41);
		layeredPane.add(btnTraCuuThuoc);
		
		JButton btnCapNhatThuoc = new JButton("CẬP NHẬT THUỐC");
		btnCapNhatThuoc.setOpaque(true);
		btnCapNhatThuoc.setForeground(Color.WHITE);
		btnCapNhatThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		btnCapNhatThuoc.setBorderPainted(false);
		btnCapNhatThuoc.setBackground(new Color(0, 102, 153));
		btnCapNhatThuoc.setBounds(441, 6, 180, 41);
		layeredPane.add(btnCapNhatThuoc);
		
		JLabel labelForButton = new JLabel("");
		labelForButton.setBounds(0, 92, 905, 52);
		contentPane.add(labelForButton);
		labelForButton.setEnabled(false);
		labelForButton.setBackground(new Color(0, 102, 153));
		labelForButton.setOpaque(true);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(-11, 119, 930, 525);
		contentPane.add(tabbedPane);
		
		JPanel panelThemThuoc = new JPanel();
		panelThemThuoc.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panelThemThuoc, null);
		panelThemThuoc.setLayout(null);
		
		JLabel lblMaThuoc = new JLabel("MÃ THUỐC");
		lblMaThuoc.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaThuoc.setBounds(158, 27, 80, 20);
		panelThemThuoc.add(lblMaThuoc);
		
		textFieldMaThuoc = new JTextField();
		textFieldMaThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldMaThuoc.setBackground(new Color(255, 255, 255));
		textFieldMaThuoc.setForeground(new Color(0, 0, 0));
		textFieldMaThuoc.setBounds(158, 44, 201, 20);
		panelThemThuoc.add(textFieldMaThuoc);
		textFieldMaThuoc.setColumns(10);
		
		JLabel lblTenThuoc = new JLabel("TÊN THUỐC");
		lblTenThuoc.setFont(new Font("Arial", Font.BOLD, 13));
		lblTenThuoc.setBounds(158, 97, 80, 20);
		panelThemThuoc.add(lblTenThuoc);
		
		textFieldTenThuoc = new JTextField();
		textFieldTenThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldTenThuoc.setColumns(10);
		textFieldTenThuoc.setBounds(158, 114, 201, 20);
		panelThemThuoc.add(textFieldTenThuoc);
		
		JLabel lblDonViTinh = new JLabel("ĐƠN VỊ TÍNH");
		lblDonViTinh.setFont(new Font("Arial", Font.BOLD, 13));
		lblDonViTinh.setBounds(158, 167, 80, 20);
		panelThemThuoc.add(lblDonViTinh);
		
		JLabel lblGia = new JLabel("GIÁ");
		lblGia.setFont(new Font("Arial", Font.BOLD, 13));
		lblGia.setBounds(500, 27, 80, 20);
		panelThemThuoc.add(lblGia);
		
		textFieldGia = new JTextField();
		textFieldGia.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldGia.setColumns(10);
		textFieldGia.setBounds(500, 44, 201, 20);
		panelThemThuoc.add(textFieldGia);
		
		JLabel lblSoLuong = new JLabel("SỐ LƯỢNG");
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 13));
		lblSoLuong.setBounds(500, 97, 80, 20);
		panelThemThuoc.add(lblSoLuong);
		
		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(500, 114, 201, 20);
		panelThemThuoc.add(textFieldSoLuong);
		
		JLabel lblCachDung = new JLabel("CÁCH DÙNG");
		lblCachDung.setFont(new Font("Arial", Font.BOLD, 13));
		lblCachDung.setBounds(500, 167, 80, 20);
		panelThemThuoc.add(lblCachDung);
		
		textFieldCachDung = new JTextField();
		textFieldCachDung.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldCachDung.setColumns(10);
		textFieldCachDung.setBounds(500, 184, 201, 54);
		panelThemThuoc.add(textFieldCachDung);
		
		JSeparator separator = new JSeparator();
		separator.setAlignmentY(0.75f);
		separator.setAlignmentX(0.75f);
		separator.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator.setBounds(424, 11, 6, 290);
		panelThemThuoc.add(separator);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem(e);
			}
		});
		
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0, 102, 153));
		btnThem.setBorder(null);
		btnThem.setBounds(475, 308, 100, 36);
		
		panelThemThuoc.add(btnThem);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReset(e);
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset.setBorder(null);
		btnReset.setBackground(new Color(0, 102, 153));
		btnReset.setBounds(641, 308, 100, 36);
		//btnReset.addActionListener(ac);
		panelThemThuoc.add(btnReset);
		
		//String [] dvt = new String [] {"Vỉ", "Hộp"};
		JComboBox comboBoxDVT = new JComboBox();
		comboBoxDVT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DVT = comboBoxDVT.getSelectedItem().toString();
			}
		});
		comboBoxDVT.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxDVT.setBackground(new Color(255, 255, 255));
		comboBoxDVT.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		comboBoxDVT.setBounds(158, 184, 201, 22);
		String [] dvt = new String [] {" ","Vỉ", "Hộp"};
		comboBoxDVT.setModel(new javax.swing.DefaultComboBoxModel<>(dvt));
		panelThemThuoc.add(comboBoxDVT);
		
		JPanel panelTraCucThuoc = new JPanel();
		panelTraCucThuoc.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panelTraCucThuoc, null);
		panelTraCucThuoc.setLayout(null);
		
		JLabel lblMaThuoc_1 = new JLabel("MÃ THUỐC");
		lblMaThuoc_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaThuoc_1.setBounds(179, 42, 80, 20);
		panelTraCucThuoc.add(lblMaThuoc_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField.setBackground(Color.WHITE);
		textField.setBounds(179, 59, 201, 20);
		panelTraCucThuoc.add(textField);
		
		JLabel lblTenThuoc_1 = new JLabel("TÊN THUỐC");
		lblTenThuoc_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblTenThuoc_1.setBounds(179, 112, 80, 20);
		panelTraCucThuoc.add(lblTenThuoc_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_1.setBounds(179, 129, 201, 20);
		panelTraCucThuoc.add(textField_1);
		
		JLabel lblDonViTinh_1 = new JLabel("ĐƠN VỊ TÍNH");
		lblDonViTinh_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblDonViTinh_1.setBounds(179, 182, 80, 20);
		panelTraCucThuoc.add(lblDonViTinh_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_1.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(179, 199, 201, 22);
		panelTraCucThuoc.add(comboBox_1);
		
		JLabel lblGia_1 = new JLabel("GIÁ");
		lblGia_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblGia_1.setBounds(521, 42, 80, 20);
		panelTraCucThuoc.add(lblGia_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_2.setBounds(521, 59, 201, 20);
		panelTraCucThuoc.add(textField_2);
		
		JLabel lblSoLuong_1 = new JLabel("SỐ LƯỢNG");
		lblSoLuong_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblSoLuong_1.setBounds(521, 112, 80, 20);
		panelTraCucThuoc.add(lblSoLuong_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_3.setBounds(521, 129, 201, 20);
		panelTraCucThuoc.add(textField_3);
		
		JLabel lblCachDung_1 = new JLabel("CÁCH DÙNG");
		lblCachDung_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblCachDung_1.setBounds(521, 182, 80, 20);
		panelTraCucThuoc.add(lblCachDung_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_4.setBounds(521, 199, 201, 54);
		panelTraCucThuoc.add(textField_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1.setAlignmentY(0.75f);
		separator_1.setAlignmentX(0.75f);
		separator_1.setBounds(445, 26, 6, 290);
		panelTraCucThuoc.add(separator_1);
		
		JButton btnCapNhat = new JButton("CẬP NHẬT");
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Arial", Font.BOLD, 14));
		btnCapNhat.setBorder(null);
		btnCapNhat.setBackground(new Color(0, 102, 153));
		btnCapNhat.setBounds(496, 323, 100, 36);
		panelTraCucThuoc.add(btnCapNhat);
		
		JButton btnReset_1 = new JButton("RESET");
		btnReset_1.setForeground(Color.WHITE);
		btnReset_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset_1.setBorder(null);
		btnReset_1.setBackground(new Color(0, 102, 153));
		btnReset_1.setBounds(662, 323, 100, 36);
		panelTraCucThuoc.add(btnReset_1);
		
		JPanel panelThongKe = new JPanel();
		tabbedPane.addTab("New tab", null, panelThongKe, null);
		
		
		//this.setVisible(true);
	}
	
	
	private void showStudent() {
		pharmacyList = PharmacyModify.findAll();

		tableModel.setRowCount(0);

		pharmacyList.forEach((Pharmacy) -> {
			tableModel.addRow(new Object[] { tableModel.getRowCount() + 1, Pharmacy.getTensanpham(), Pharmacy.getDvt(),
					Pharmacy.getGia(), Pharmacy.getSoluong() });
		});
	}
	
	private void btnThem(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		//String Dvt = (String)comboBoxDVT.getSelectedItem();
//		String Dvt = null;
//		try {
//			Dvt = comboBoxDVT.getItemAt(comboBoxDVT.getSelectedIndex()).toString();
//			System.out.println("get duoc dvt duoc roi");
//		} catch (Exception e) {
//			System.out.println("Lay thong tin DVT that bai");
//			e.printStackTrace();
//		}
		//String Dvt = "Vỉ";
		
		int Gia = Integer.parseInt(textFieldGia.getText());
		int Soluong = Integer.parseInt(textFieldSoLuong.getText());
		String Cachdung = textFieldCachDung.getText();
		String Tensanpham = textFieldTenThuoc.getText();
		
		Pharmacy std = new Pharmacy(Tensanpham, DVT,  Gia, Soluong, Cachdung);

		PharmacyModify.insert(std);

		showStudent();
	}
	
	private void btnReset(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		textFieldMaThuoc.setText("");
		textFieldTenThuoc.setText("");
		textFieldGia.setText("");
		textFieldSoLuong.setText("");
		textFieldCachDung.setText("");
		comboBoxDVT.setSelectedIndex(0);
	}
}
