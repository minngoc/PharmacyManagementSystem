package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManHinhChinh extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldMaThuocThemThuoc;
	public JTextField textFieldTenThuocThemThuoc;
	public JTextField textFieldGiaThemThuoc;
	public JTextField textFieldSoLuongThemThuoc;
	public JTextField textFieldCachDungThemThuoc;
	public JTextField textFieldTenThuocTraCuu;
	public JComboBox comboBoxDvtThemThuoc;
	
	///Chữa cháy lỗi this.comboBoxDVT is null
//	private String DVT;

	/**
	 * Launch the application.
	 */
	
	////////////////////////////////////////////////////////////////////
	DefaultTableModel tableModel;
	List<Pharmacy> pharmacyList = new ArrayList<>();
	public JPanel panelThemThuoc;
	public JTabbedPane tabbedPane;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
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
		
		
		//setIcon cho Frame màn hình chính
		URL url_iconPlus = ManHinhChinh.class.getResource("Plus-icon.png");
		Image imgFrame = Toolkit.getDefaultToolkit().createImage(url_iconPlus);
		this.setIconImage(imgFrame);
		
		setTitle("QUẢN LÝ THUỐC");
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
		
		URL url_iconLogout = ManHinhChinh.class.getResource("Logout-icon.png");
//		ImageIcon imgLogout = Toolkit.getDefaultToolkit().createImage(url_iconLogout);
//		imgLogout.getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
//		btnDangXuat.setIcon(imgLogout);
		
		btnDangXuat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
								.createImage(ManHinhChinh.class.getResource("Logout-icon.png"))
								.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH)));
		layeredPane.add(btnDangXuat);
		
		JButton btnThongKe = new JButton("THỐNG KÊ");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnThongKe.setOpaque(true);
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 15));
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(0, 102, 153));
		btnThongKe.setBounds(10, 6, 131, 41);
		layeredPane.add(btnThongKe);
		
		//////////////////////////////////////////////////////////////
		//Dãy các btn chức năng//////////////////////////////////////
		JButton btnThemThuoc = new JButton("THÊM THUỐC");
//		btnThemThuoc.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				btnThemThuoc.setBackground(new Color(255,255,255));
//				btnThemThuoc.setForeground(new Color(0, 0, 0));
//			}
//		});
		btnThemThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnThemThuoc.setOpaque(true);
		btnThemThuoc.setForeground(new Color(255, 255, 255));
		btnThemThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		btnThemThuoc.setBorderPainted(false);
		btnThemThuoc.setBackground(new Color(0, 102, 153));
		btnThemThuoc.setBounds(137, 0, 141, 52);
		layeredPane.add(btnThemThuoc);
		
		JButton btnTraCuuThuoc = new JButton("TRA CỨU THUỐC");
		btnTraCuuThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnTraCuuThuoc.setOpaque(true);
		btnTraCuuThuoc.setForeground(Color.WHITE);
		btnTraCuuThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		btnTraCuuThuoc.setBorderPainted(false);
		btnTraCuuThuoc.setBackground(new Color(0, 102, 153));
		btnTraCuuThuoc.setBounds(277, 6, 170, 41);
		layeredPane.add(btnTraCuuThuoc);
		
		JButton btnCapNhatThuoc = new JButton("CẬP NHẬT THUỐC");
		btnCapNhatThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnCapNhatThuoc.setOpaque(true);
		btnCapNhatThuoc.setForeground(Color.WHITE);
		btnCapNhatThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		btnCapNhatThuoc.setBorderPainted(false);
		btnCapNhatThuoc.setBackground(new Color(0, 102, 153));
		btnCapNhatThuoc.setBounds(434, 6, 180, 41);
		layeredPane.add(btnCapNhatThuoc);
		
		//////////Label chứa các button/////////////////////////
		JLabel labelForButton = new JLabel("");
		labelForButton.setBounds(0, 92, 905, 52);
		contentPane.add(labelForButton);
		labelForButton.setEnabled(false);
		labelForButton.setBackground(new Color(0, 102, 153));
		labelForButton.setOpaque(true);
		
		/////////tabbed chứa các tab hiển thị chức năng////////////
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(-17, 117, 957, 528);
		contentPane.add(tabbedPane);
		
		JPanel panelThongKe = new JPanel();
		panelThongKe.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panelThongKe, null);
		
		/////////PANEL CHỨC NĂNG THÊM THUỐC/////////////////////
		panelThemThuoc = new JPanel();
		panelThemThuoc.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panelThemThuoc, null);
		panelThemThuoc.setLayout(null);
		
		JLabel lblMaThuocThemThuoc = new JLabel("MÃ THUỐC");
		lblMaThuocThemThuoc.setFont(new Font("Arial", Font.BOLD, 17));
		lblMaThuocThemThuoc.setBounds(178, 52, 115, 36);
		panelThemThuoc.add(lblMaThuocThemThuoc);
		
		textFieldMaThuocThemThuoc = new JTextField();
		textFieldMaThuocThemThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldMaThuocThemThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldMaThuocThemThuoc.setBackground(new Color(255, 255, 255));
		textFieldMaThuocThemThuoc.setForeground(new Color(0, 0, 0));
		textFieldMaThuocThemThuoc.setBounds(178, 85, 220, 28);
		panelThemThuoc.add(textFieldMaThuocThemThuoc);
		textFieldMaThuocThemThuoc.setColumns(10);
		
		JLabel lblTenThuocThemThuoc = new JLabel("TÊN THUỐC");
		lblTenThuocThemThuoc.setFont(new Font("Arial", Font.BOLD, 17));
		lblTenThuocThemThuoc.setBounds(178, 138, 100, 28);
		panelThemThuoc.add(lblTenThuocThemThuoc);
		
		textFieldTenThuocThemThuoc = new JTextField();
		textFieldTenThuocThemThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldTenThuocThemThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldTenThuocThemThuoc.setColumns(10);
		textFieldTenThuocThemThuoc.setBounds(178, 169, 220, 28);
		panelThemThuoc.add(textFieldTenThuocThemThuoc);
		
		JLabel lblDonViTinhThemThuoc = new JLabel("ĐƠN VỊ TÍNH");
		lblDonViTinhThemThuoc.setFont(new Font("Arial", Font.BOLD, 17));
		lblDonViTinhThemThuoc.setBounds(178, 216, 115, 31);
		panelThemThuoc.add(lblDonViTinhThemThuoc);
		
		comboBoxDvtThemThuoc = new JComboBox();
//		comboBoxDvtThemThuoc.addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////				DVT = comboBoxDvtThemThuoc.getSelectedItem().toString();
////			}
////		});
		comboBoxDvtThemThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		comboBoxDvtThemThuoc.setBackground(new Color(255, 255, 255));
		comboBoxDvtThemThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		comboBoxDvtThemThuoc.setBounds(178, 252, 220, 28);
		String [] dvt = new String [] {" ","Vỉ", "Hộp"};
		comboBoxDvtThemThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(dvt));
		//comboBoxDvtThemThuoc.setEnabled(true);
		panelThemThuoc.add(comboBoxDvtThemThuoc);
		
		JLabel lblGiaThemThuoc = new JLabel("GIÁ");
		lblGiaThemThuoc.setFont(new Font("Arial", Font.BOLD, 17));
		lblGiaThemThuoc.setBounds(555, 52, 80, 36);
		panelThemThuoc.add(lblGiaThemThuoc);
		
		textFieldGiaThemThuoc = new JTextField();
		textFieldGiaThemThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldGiaThemThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldGiaThemThuoc.setColumns(10);
		textFieldGiaThemThuoc.setBounds(555, 85, 220, 28);
		panelThemThuoc.add(textFieldGiaThemThuoc);
		
		JLabel lblSoLuongThemThuoc = new JLabel("SỐ LƯỢNG");
		lblSoLuongThemThuoc.setFont(new Font("Arial", Font.BOLD, 17));
		lblSoLuongThemThuoc.setBounds(555, 138, 100, 28);
		panelThemThuoc.add(lblSoLuongThemThuoc);
		
		textFieldSoLuongThemThuoc = new JTextField();
		textFieldSoLuongThemThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldSoLuongThemThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldSoLuongThemThuoc.setColumns(10);
		textFieldSoLuongThemThuoc.setBounds(555, 169, 220, 28);
		panelThemThuoc.add(textFieldSoLuongThemThuoc);
		
		JLabel lblCachDungThemThuoc = new JLabel("CÁCH DÙNG");
		lblCachDungThemThuoc.setFont(new Font("Arial", Font.BOLD, 17));
		lblCachDungThemThuoc.setBounds(555, 219, 115, 28);
		panelThemThuoc.add(lblCachDungThemThuoc);
		
		textFieldCachDungThemThuoc = new JTextField();
		textFieldCachDungThemThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldCachDungThemThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldCachDungThemThuoc.setColumns(10);
		textFieldCachDungThemThuoc.setBounds(555, 256, 220, 86);
		panelThemThuoc.add(textFieldCachDungThemThuoc);
		
		JSeparator separator = new JSeparator();
		separator.setAlignmentY(0.75f);
		separator.setAlignmentX(0.75f);
		separator.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator.setBounds(479, 52, 6, 290);
		panelThemThuoc.add(separator);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem(e);
				JOptionPane.showMessageDialog(btnThem, e, "THÊM THÀNH CÔNG", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0, 102, 153));
		btnThem.setBorder(null);
		btnThem.setBounds(495, 413, 100, 36);
		
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
		btnReset.setBounds(688, 413, 100, 36);
		//btnReset.addActionListener(ac);
		btnReset.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(ManHinhChinh.class.getResource("Redo-icon.png"))
				.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH)));
		panelThemThuoc.add(btnReset);
		
		//String [] dvt = new String [] {"Vỉ", "Hộp"};
		
		
		JPanel panelTraCucThuoc = new JPanel();
		panelTraCucThuoc.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panelTraCucThuoc, null);
		panelTraCucThuoc.setLayout(null);
		
		JLabel lblTenThuocTraCuu = new JLabel("TÊN THUỐC");
		lblTenThuocTraCuu.setFont(new Font("Arial", Font.BOLD, 17));
		lblTenThuocTraCuu.setBounds(143, 26, 100, 30);
		panelTraCucThuoc.add(lblTenThuocTraCuu);
		
		textFieldTenThuocTraCuu = new JTextField();
		textFieldTenThuocTraCuu.setColumns(10);
		textFieldTenThuocTraCuu.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldTenThuocTraCuu.setBounds(142, 52, 226, 23);
		panelTraCucThuoc.add(textFieldTenThuocTraCuu);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1.setAlignmentY(0.75f);
		separator_1.setAlignmentX(0.75f);
		separator_1.setBounds(22, 110, 886, 5);
		panelTraCucThuoc.add(separator_1);
		
		JButton btnTraCuu = new JButton("TRA CỨU");
		btnTraCuu.setForeground(Color.WHITE);
		btnTraCuu.setFont(new Font("Arial", Font.BOLD, 14));
		btnTraCuu.setBorder(null);
		btnTraCuu.setBackground(new Color(0, 102, 153));
		btnTraCuu.setBounds(557, 48, 100, 36);
		panelTraCucThuoc.add(btnTraCuu);
		
		JButton btnResetTraCuu = new JButton("RESET");
		btnResetTraCuu.setForeground(Color.WHITE);
		btnResetTraCuu.setFont(new Font("Arial", Font.BOLD, 14));
		btnResetTraCuu.setBorder(null);
		btnResetTraCuu.setBackground(new Color(0, 102, 153));
		btnResetTraCuu.setBounds(723, 48, 100, 36);
		btnResetTraCuu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(ManHinhChinh.class.getResource("Redo-icon.png"))
				.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH)));
		panelTraCucThuoc.add(btnResetTraCuu);
		
		JPanel panelCapNhatThuoc = new JPanel();
		panelCapNhatThuoc.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panelCapNhatThuoc, null);
		panelCapNhatThuoc.setLayout(null);
		
		JLabel lblMaThuoc_1_1 = new JLabel("MÃ THUỐC");
		lblMaThuoc_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblMaThuoc_1_1.setBounds(195, 60, 100, 28);
		panelCapNhatThuoc.add(lblMaThuoc_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_5.setForeground(Color.BLACK);
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(195, 91, 220, 28);
		panelCapNhatThuoc.add(textField_5);
		
		JLabel lblTenThuoc_1_1 = new JLabel("TÊN THUỐC");
		lblTenThuoc_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblTenThuoc_1_1.setBounds(195, 161, 100, 28);
		panelCapNhatThuoc.add(lblTenThuoc_1_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_6.setBounds(195, 189, 220, 31);
		panelCapNhatThuoc.add(textField_6);
		
		JLabel lblDonViTinh_1_1 = new JLabel("ĐƠN VỊ TÍNH");
		lblDonViTinh_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblDonViTinh_1_1.setBounds(195, 248, 111, 31);
		panelCapNhatThuoc.add(lblDonViTinh_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox_1_1.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		comboBox_1_1.setBackground(Color.WHITE);
		comboBox_1_1.setBounds(195, 280, 220, 28);
		panelCapNhatThuoc.add(comboBox_1_1);
		
		JLabel lblGia_1_1 = new JLabel("GIÁ");
		lblGia_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblGia_1_1.setBounds(537, 60, 100, 28);
		panelCapNhatThuoc.add(lblGia_1_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_7.setBounds(537, 91, 220, 28);
		panelCapNhatThuoc.add(textField_7);
		
		JLabel lblSoLuong_1_1 = new JLabel("SỐ LƯỢNG");
		lblSoLuong_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblSoLuong_1_1.setBounds(537, 161, 100, 28);
		panelCapNhatThuoc.add(lblSoLuong_1_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_8.setBounds(537, 189, 220, 31);
		panelCapNhatThuoc.add(textField_8);
		
		JLabel lblCachDung_1_1 = new JLabel("CÁCH DÙNG");
		lblCachDung_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblCachDung_1_1.setBounds(537, 248, 105, 24);
		panelCapNhatThuoc.add(lblCachDung_1_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_9.setColumns(10);
		textField_9.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textField_9.setBounds(537, 274, 220, 82);
		panelCapNhatThuoc.add(textField_9);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_1.setAlignmentY(0.75f);
		separator_1_1.setAlignmentX(0.75f);
		separator_1_1.setBounds(461, 44, 5, 312);
		panelCapNhatThuoc.add(separator_1_1);
		
		JButton btnCapNhat = new JButton("CẬP NHẬT");
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Arial", Font.BOLD, 14));
		btnCapNhat.setBorder(null);
		btnCapNhat.setBackground(new Color(0, 102, 153));
		btnCapNhat.setBounds(475, 414, 100, 36);
		panelCapNhatThuoc.add(btnCapNhat);
		
		JButton btnResetCapNhat = new JButton("RESET");
		btnResetCapNhat.setForeground(Color.WHITE);
		btnResetCapNhat.setFont(new Font("Arial", Font.BOLD, 14));
		btnResetCapNhat.setBorder(null);
		btnResetCapNhat.setBackground(new Color(0, 102, 153));
		btnResetCapNhat.setBounds(720, 414, 100, 36);
		btnResetCapNhat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(ManHinhChinh.class.getResource("Logout-icon.png"))
				.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH)));
		panelCapNhatThuoc.add(btnResetCapNhat);
		
		JButton btnCapNhat_Xoa = new JButton("XÓA");
		btnCapNhat_Xoa.setForeground(Color.WHITE);
		btnCapNhat_Xoa.setFont(new Font("Arial", Font.BOLD, 14));
		btnCapNhat_Xoa.setBorder(null);
		btnCapNhat_Xoa.setBackground(new Color(0, 102, 153));
		btnCapNhat_Xoa.setBounds(601, 414, 100, 36);
		panelCapNhatThuoc.add(btnCapNhat_Xoa);
		
		
		//this.setVisible(true);
	}
	
	
	private void showStudent() {
		pharmacyList = PharmacyModify.findAll();

		tableModel.setRowCount(0);

		pharmacyList.forEach((Pharmacy) -> {
			tableModel.addRow(new Object[] { tableModel.getRowCount() + 1,Pharmacy.getId(),
																		Pharmacy.getTensanpham(),
																		Pharmacy.getDvt(),
																		Pharmacy.getGia(),
																		Pharmacy.getSoluong(),
																		Pharmacy.getCachdung()});
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
		String id=textFieldMaThuocThemThuoc.getText();
		String Tensanpham = textFieldTenThuocThemThuoc.getText();
		String Dvt = null;
		Dvt = comboBoxDvtThemThuoc.getSelectedItem().toString();
		double Gia = Integer.parseInt(textFieldGiaThemThuoc.getText());
		int Soluong = Integer.parseInt(textFieldSoLuongThemThuoc.getText());
		String Cachdung = textFieldCachDungThemThuoc.getText();
		
		
		Pharmacy std = new Pharmacy(id,Tensanpham, Dvt,  Gia, Soluong, Cachdung);

		PharmacyModify.insert(std);

		showStudent();
	}
	
	private void btnReset(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		textFieldMaThuocThemThuoc.setText("");
		textFieldTenThuocThemThuoc.setText("");
		textFieldGiaThemThuoc.setText("");
		textFieldSoLuongThemThuoc.setText("");
		textFieldCachDungThemThuoc.setText("");
		comboBoxDvtThemThuoc.setSelectedIndex(-1);
	}
}
