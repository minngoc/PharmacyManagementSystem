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
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import java.awt.print.PrinterException;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextArea;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import GiaoDien.LoginFrame;
import doanhthu.doanhthu;
import nhanvien.nhanvien;
import com.itextpdf.text.BaseColor;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.text.pdf.PdfPCell;

import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;

import java.io.File;

import java.io.FileOutputStream;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.sql.*;

import java.text.NumberFormat;

import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManHinhChinh extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldTenThuocTraCuu;

	public JTable table;
	public JTable table1;
	public JTabbedPane tabbedPane;
	public JTextField textFieldMaThuocQuanLyThuoc;
	public JTextField textFieldTenThuocQuanLyThuoc;
	public JTextField textFieldGiaQuanLyThuoc;
	public JTextField textFieldSLuongQuanLyThuoc;
	public JTextField textFieldCDungQuanLyThuoc;
	public JComboBox comboBoxDVTQuanLyThuoc;
	public JComboBox combobox;

	DefaultTableModel tableModel;
	DefaultTableModel tableModel_1;
	DefaultTableModel tableModel_2;
	DefaultTableModel tableModel_3;
	DefaultTableModel tableModel_4;
	List<Pharmacy> pharmacyList = new ArrayList<>();
	List<doanhthu> doanhthulist = new ArrayList<>();
	List<nhanvien> nhanvienlist = new ArrayList<>();
	public String[] model_DVT;
	public Integer[] model_index_comboboxCapNhat;
	private JTable table_1;
	private JTextField mathuocThanhToan;
	private JTextField tenthuocThanhToan;
	private JTextField dvtThanhToan;
	private JTextField giaThanhToan;
	private JTextField soluongThanhToan;
	private JTextField cachdungThanhToan;
	private JTextField txtTracuuthuoctheotenThanhToan;
	private double total = 0;
	private JTextField textFieldTongCong;
	private JTextArea txtReceipt;
	private String str;
	private int flag = 0;
	private JTextField doanhthu;
	private JTable tbldoanhthu;
	private JTextField tongcong;
	private float tong = 0;
	private JTextField textFieldHSDQuanLyThuoc;
	private JTable tableQuanLyThuoc;
	private JTextField textFieldNSinhNV;
	private JTextField textFieldSDTNhanVien;
	private JTextField textFieldDChiNhanVien;
	private JTextField textFieldTenNV;
	private JTable tableNhanVien;
	private JComboBox gioitinh;
	private JComboBox hocvan;
	private String[] model_gender;
	private String[] model_hocvan;
	private JTextField textFieldTienKhachDua;
	private JTextField textFieldMaNV;

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
		setResizable(false);
		init();
		showTablePharmacy();
	}

	public void changeColor(JButton hover, Color bg, Color fg) {
		hover.setBackground(bg);
		hover.setForeground(fg);

	}

	public void init() {

		// setIcon cho Frame màn hình chính
		URL url_iconPlus = ManHinhChinh.class.getResource("Plus-icon.png");
		Image imgFrame = Toolkit.getDefaultToolkit().createImage(url_iconPlus);
		this.setIconImage(imgFrame);

		setTitle("QUẢN LÝ THUỐC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLocationRelativeTo(null);
		// this.setExtendedState(MAXIMIZED_BOTH);
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

		setBounds(100, 100, 1366, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel pharmacityLabel = new JLabel("P H A R M A C I T Y");
		pharmacityLabel.setForeground(new Color(255, 255, 255));
		pharmacityLabel.setBackground(new Color(0, 51, 102));
		pharmacityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pharmacityLabel.setFont(new Font("Impact", Font.BOLD, 55));
		pharmacityLabel.setBounds(0, 0, 1350, 93);
		pharmacityLabel.setOpaque(true);
		contentPane.add(pharmacityLabel);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 93, 1350, 52);
		contentPane.add(layeredPane);

		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnDangXuat, new Color(255, 255, 255), new Color(0, 102, 153));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnDangXuat, new Color(0, 102, 153), new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "BẠN CÓ CHẮC MUỐN THOÁT PHIÊN ĐĂNG NHẬP NÀY?", "Lựa chọn",
						JOptionPane.YES_NO_OPTION);
				if (a == 0) {
					setVisible(false);
					LoginFrame l = new LoginFrame();
					l.main(null);
				}
			}
		});
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(255, 255, 204)));
		btnDangXuat.setFont(new Font("Arial", Font.BOLD, 15));
		btnDangXuat.setForeground(new Color(255, 255, 255));
		btnDangXuat.setBackground(new Color(0, 102, 153));
		btnDangXuat.setBounds(1217, 0, 133, 51);
		btnDangXuat.setOpaque(true);

		URL url_iconLogout = ManHinhChinh.class.getResource("Logout-icon.png");
//		ImageIcon imgLogout = Toolkit.getDefaultToolkit().createImage(url_iconLogout);
//		imgLogout.getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
//		btnDangXuat.setIcon(imgLogout);

		btnDangXuat.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManHinhChinh.class.getResource("Logout-icon.png"))
						.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH)));
		layeredPane.add(btnDangXuat);
		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnThanhToan, new Color(255, 255, 255), new Color(0, 102, 153));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnThanhToan, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				showTablePharmacy();
			}
		});

		btnThanhToan.setOpaque(true);
		btnThanhToan.setForeground(new Color(255, 255, 255));
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 15));
		btnThanhToan.setBorderPainted(false);
		btnThanhToan.setBackground(new Color(0, 102, 153));
		btnThanhToan.setBounds(0, 0, 143, 51);
		layeredPane.add(btnThanhToan);

		JButton btnTraCuuThuoc = new JButton("TRA CỨU THUỐC");
		btnTraCuuThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnTraCuuThuoc, new Color(255, 255, 255), new Color(0, 102, 153));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnTraCuuThuoc, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnTraCuuThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				showTablePharmacy();
			}
		});
		btnTraCuuThuoc.setOpaque(true);
		btnTraCuuThuoc.setForeground(Color.WHITE);
		btnTraCuuThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		btnTraCuuThuoc.setBorderPainted(false);
		btnTraCuuThuoc.setBackground(new Color(0, 102, 153));
		btnTraCuuThuoc.setBounds(144, 0, 169, 51);
		layeredPane.add(btnTraCuuThuoc);

		JButton btnQuanLyThuoc = new JButton("QUẢN LÝ THUỐC");
		btnQuanLyThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnQuanLyThuoc, new Color(255, 255, 255), new Color(0, 102, 153));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnQuanLyThuoc, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnQuanLyThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginFrame.isAdmin() == true) {
					tabbedPane.setSelectedIndex(2);
					showTablePharmacy();
				} else {
					JOptionPane.showMessageDialog(null, "CHỨC NĂNG NÀY CHỈ DÀNH CHO QUẢN TRỊ VIÊN!");
				}
			}
		});
		btnQuanLyThuoc.setOpaque(true);
		btnQuanLyThuoc.setForeground(Color.WHITE);
		btnQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		btnQuanLyThuoc.setBorderPainted(false);
		btnQuanLyThuoc.setBackground(new Color(0, 102, 153));
		btnQuanLyThuoc.setBounds(313, 0, 169, 51);
		layeredPane.add(btnQuanLyThuoc);

		JButton btnThongKe = new JButton("THỐNG KÊ");
		btnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnThongKe, new Color(255, 255, 255), new Color(0, 102, 153));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnThongKe, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginFrame.isAdmin() == true) {
					tabbedPane.setSelectedIndex(3);
					showTabledt();
				} else {
					JOptionPane.showMessageDialog(null, "CHỨC NĂNG NÀY CHỈ DÀNH CHO QUẢN TRỊ VIÊN!");
				}
			}
		});
		btnThongKe.setOpaque(true);
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 15));
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(0, 102, 153));
		btnThongKe.setBounds(482, 0, 169, 51);
		layeredPane.add(btnThongKe);

		JButton btnNhanVien = new JButton("NHÂN VIÊN");
		btnNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnNhanVien, new Color(255, 255, 255), new Color(0, 102, 153));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnNhanVien, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginFrame.isAdmin() == true) {
					tabbedPane.setSelectedIndex(4);
					showTableNhanVien();
				} else {
					JOptionPane.showMessageDialog(null, "CHỨC NĂNG NÀY CHỈ DÀNH CHO QUẢN TRỊ VIÊN!");
				}
			}
		});
		btnNhanVien.setOpaque(true);
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 15));
		btnNhanVien.setBorderPainted(false);
		btnNhanVien.setBackground(new Color(0, 102, 153));
		btnNhanVien.setBounds(651, 0, 169, 51);
		layeredPane.add(btnNhanVien);

		////////// Label chứa các button/////////////////////////
		JLabel labelForButton = new JLabel("");
		labelForButton.setBounds(0, 92, 1350, 52);
		contentPane.add(labelForButton);
		labelForButton.setEnabled(false);
		labelForButton.setBackground(new Color(0, 102, 153));
		labelForButton.setOpaque(true);

		///////// tabbed chứa các tab hiển thị chức năng////////////
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(-17, 117, 1383, 639);
		contentPane.add(tabbedPane);

		JPanel panelThanhToan = new JPanel();
		panelThanhToan.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panelThanhToan, null);
		panelThanhToan.setLayout(null);

		JLabel lblTenThuocTraCuu_1 = new JLabel("NHẬP TÊN THUỐC");
		lblTenThuocTraCuu_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblTenThuocTraCuu_1.setBounds(53, 73, 187, 27);
		panelThanhToan.add(lblTenThuocTraCuu_1);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.BOLD, 16));

		scrollPane_1.setBounds(29, 289, 913, 286);

		table_1 = new JTable();
		table_1.setSelectionBackground(new Color(51, 204, 204));
		table_1.setGridColor(new Color(51, 153, 102));
		table_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		table_1.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(51, 204, 153)));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection connection = null;
				PreparedStatement statement = null;
				int row = table_1.getSelectedRow();
				String mathuoc = (String) table_1.getValueAt(row, 0);

				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root",
							"");
					String sql = "SELECT * FROM `pharmacy` where `mathuoc` = '" + mathuoc + "'";
					statement = connection.prepareCall(sql);
					ResultSet resultSet = statement.executeQuery();
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {
						mathuocThanhToan.setText(rs.getString("mathuoc"));
						tenthuocThanhToan.setText(rs.getString("tensanpham"));
						dvtThanhToan.setText(rs.getString("dvt"));
						giaThanhToan.setText(rs.getString("gia"));
						soluongThanhToan.setText(rs.getString("soluong"));
						cachdungThanhToan.setText(rs.getString("cachdung"));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 thu\u1ED1c", "T\u00EAn thu\u1ED1c", "\u0110\u01A1n v\u1ECB t\u00EDnh",
						"Gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "H\u1EA1n s\u1EED d\u1EE5ng", "C\u00E1ch d\u00F9ng" }));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(47);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(184);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(31);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(52);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(47);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(276);
		scrollPane_1.setViewportView(table_1);
		table_1.setBounds(0, 0, 1, 1);
		tableModel_1 = (DefaultTableModel) table_1.getModel();

		panelThanhToan.add(scrollPane_1);

		JLabel lblNewLabel = new JLabel("MÃ THUỐC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(384, 123, 76, 21);
		panelThanhToan.add(lblNewLabel);

		mathuocThanhToan = new JTextField();
		mathuocThanhToan.setEditable(false);
		mathuocThanhToan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		mathuocThanhToan.setBounds(486, 124, 115, 19);
		panelThanhToan.add(mathuocThanhToan);
		mathuocThanhToan.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("TÊN THUỐC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(384, 153, 83, 21);
		panelThanhToan.add(lblNewLabel_1);

		tenthuocThanhToan = new JTextField();
		tenthuocThanhToan.setEditable(false);
		tenthuocThanhToan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		tenthuocThanhToan.setBounds(486, 154, 205, 19);
		panelThanhToan.add(tenthuocThanhToan);
		tenthuocThanhToan.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ĐƠN VỊ TÍNH");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(710, 124, 92, 19);
		panelThanhToan.add(lblNewLabel_2);

		dvtThanhToan = new JTextField();
		dvtThanhToan.setEditable(false);
		dvtThanhToan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		dvtThanhToan.setBounds(812, 125, 115, 19);
		panelThanhToan.add(dvtThanhToan);
		dvtThanhToan.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("ĐƠN GIÁ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(710, 183, 76, 21);
		panelThanhToan.add(lblNewLabel_3);

		giaThanhToan = new JTextField();
		giaThanhToan.setEditable(false);
		giaThanhToan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		giaThanhToan.setBounds(812, 185, 114, 19);
		panelThanhToan.add(giaThanhToan);
		giaThanhToan.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SỐ LƯỢNG");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(710, 153, 76, 21);
		panelThanhToan.add(lblNewLabel_4);

		soluongThanhToan = new JTextField();
		soluongThanhToan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		soluongThanhToan.setBounds(812, 155, 115, 19);
		panelThanhToan.add(soluongThanhToan);
		soluongThanhToan.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("CÁCH DÙNG");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(384, 185, 83, 16);
		panelThanhToan.add(lblNewLabel_5);

		cachdungThanhToan = new JTextField();
		cachdungThanhToan.setEditable(false);
		cachdungThanhToan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		cachdungThanhToan.setBounds(486, 185, 204, 19);
		panelThanhToan.add(cachdungThanhToan);
		cachdungThanhToan.setColumns(10);
		combobox = new JComboBox<>();
//		combobox.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				txtReceipt.setText(" ");
//				txtReceipt.append("PHARMACY MANAGEMENT\n"+
//    		 			"Hoá đơn thanh toán\n"+
//    		 			"Ngày lập hóa đơn: "+str+"\n"+
//    		 			"Nhân viên "+ combobox.getSelectedItem()+
//    		 			"\n===========================\n"
//    		 );
//			}
//		});
		combobox.setFont(new Font("Tahoma", Font.BOLD, 15));
		combobox.setBounds(593, 76, 199, 21);
		panelThanhToan.add(combobox);

		JLabel lblNewLabel_6 = new JLabel("NHÂN VIÊN THANH TOÁN");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(384, 73, 205, 27);
		panelThanhToan.add(lblNewLabel_6);
		try {
			Connection connection = null;
			PreparedStatement statement = null;
			// tạo connnect sql
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
			// lấy tất cả giá trị từ table benhnhan
			String sql = "select tennhanvien from nhanvien ";

			// truyền connect sql1 cho statement benhnhan
			statement = connection.prepareCall(sql);

			// xử lý lấy kết quả của tenbn
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				combobox.addItem(rs.getString(1));

			}
			statement.close();
		} catch (Exception ex) {
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		str = formatter.format(date);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(976, 93, 377, 358);
		panelThanhToan.add(scrollPane_2);

		txtReceipt = new JTextArea(" ");
		txtReceipt.append("  PHARMACY MANAGEMENT\n" + "Hoá đơn thanh toán\n" + "Ngày lập hóa đơn: " + str
				+ "\n===========================\n");
		txtReceipt.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtReceipt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 153)));
		txtReceipt.setBackground(new Color(255, 255, 255));
		txtReceipt.setBounds(966, 321, 389, 210);
		scrollPane_2.setViewportView(txtReceipt);

		JButton btnAddRecord = new JButton("THÊM HÓA ĐƠN");
		btnAddRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnAddRecord, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnAddRecord, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});

		btnAddRecord.setForeground(new Color(255, 255, 255));
		btnAddRecord.setBorder(null);
		btnAddRecord.setBackground(new Color(0, 102, 153));
		btnAddRecord.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLabel lblNewLabel_8 = new JLabel("Tổng cộng: ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_8.setBounds(1072, 459, 105, 27);
		panelThanhToan.add(lblNewLabel_8);

		textFieldTongCong = new JTextField();
		textFieldTongCong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		textFieldTongCong.setBorder(null);
		textFieldTongCong.setBounds(1198, 462, 155, 20);
		panelThanhToan.add(textFieldTongCong);
		textFieldTongCong.setColumns(10);

		// add record
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkSoLuong() == true) {
					if (txtReceipt.getText() != "") {
						total = total
								+ Double.valueOf(giaThanhToan.getText()) * Integer.valueOf(soluongThanhToan.getText());
						txtReceipt.append("Tên thuốc: " + tenthuocThanhToan.getText() + "\n" + "Số lượng: "
								+ soluongThanhToan.getText() + "\n" + "Giá: " + giaThanhToan.getText() + "\n"
								+ "Cách dùng: " + cachdungThanhToan.getText() + "\n" + "-----------------------\n");
						String tCong = String.valueOf(total);
						textFieldTongCong.setText(tCong);
						PreparedStatement statement2 = null;

						try {
							Connection connection = null;
							PreparedStatement statement = null;
							PreparedStatement statement1 = null;
							// lay tat ca danh sach pharmacy
							connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy_management",
									"root", "");

							String query = "select * from doanhthu";
							statement = connection.prepareCall(query);

							ResultSet resultSet = statement.executeQuery();
							while (resultSet.next()) {

								String st = resultSet.getString("ngay");
								if (st.equalsIgnoreCase(str)) {

									flag = 1;
								}
							}
							// query

						} catch (SQLException ex) {
							System.out.println(ex);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "SỐ LƯỢNG THUỐC TRONG KHO KHÔNG ĐỦ", "THÔNG BÁO",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnAddRecord.setBounds(516, 238, 269, 32);
		panelThanhToan.add(btnAddRecord);

		JButton btnPrint = new JButton("THANH TOÁN");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnPrint, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnPrint, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnPrint.setBorder(null);
		btnPrint.setBackground(new Color(0, 102, 153));
		btnPrint.setForeground(new Color(255, 255, 255));
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 17));
		// button print
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Double tong= Double.parseDouble(textFieldTongCong.getText());
					Double tien = Double.parseDouble(textFieldTienKhachDua.getText());
					if(tien>=tong) {
						Double tienthua= tien-tong;
						JOptionPane.showMessageDialog(null, "TIỀN THỪA PHẢI TRẢ CHO KHÁCH LÀ:   "+tienthua+"\n TIẾN HÀNH IN HÓA ĐƠN","THÔNG TIN",JOptionPane.INFORMATION_MESSAGE);
						Connection connection = null;
						PreparedStatement statement = null;
						PreparedStatement statement1 = null;
						PreparedStatement statement2 = null;
						String tCong = String.valueOf(0);
						if (flag == 0) {
							try {
								// lay tat ca danh sach pharmacy de thuc hien truy van query
								connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management",
										"root", "");
								// query
								String sql = "insert into doanhthu(ngay,total) values(?,?)";
								statement1 = connection.prepareCall(sql);

								statement1.setString(1, str);
								statement1.setString(2, tCong);

								statement1.execute();
								System.out.println("Them thanh cong");

							} catch (SQLException ex) {
								System.out.println(ex);
							}
						}
						try {
							// lay tat ca danh sach pharmacy
							connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy_management", "root",
									"");

							String query = "select * from doanhthu where `ngay` =?";
							statement2 = connection.prepareCall(query);
							statement2.setString(1, str);
							ResultSet resultSet = statement2.executeQuery();
							if (resultSet.next()) {

								String sql = "update doanhthu set total=? where ngay = ?";
								statement2 = connection.prepareCall(sql);

								statement2.setString(1, String.valueOf(resultSet.getFloat("total") + total));
								statement2.setString(2, str);
								statement2.execute();
							}
							// query

						} catch (SQLException ex) {
							System.out.println(ex);
						}

						try {
							// lay tat ca danh sach pharmacy
							connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy_management", "root",
									"");

							String query = "select * from pharmacy where `mathuoc` =?";
							statement = connection.prepareCall(query);
							statement.setString(1, mathuocThanhToan.getText());
							ResultSet resultSet = statement.executeQuery();
							while (resultSet.next()) {
								System.out.println(resultSet.getInt("soluong"));
								int sl = resultSet.getInt("soluong") - Integer.valueOf(soluongThanhToan.getText());
								System.out.println(sl);
								String sql = "update pharmacy set soluong=? where mathuoc = ?";
								statement1 = connection.prepareCall(sql);
								statement1.setString(1, String.valueOf(sl));
								statement1.setString(2, mathuocThanhToan.getText());
								statement1.execute();
							}
							// query

						} catch (SQLException ex) {
							System.out.println(ex);
						}
						try {

							txtReceipt.append("====================================\n" + 
												"\t Tổng tiền phải trả: " + total+
												"\n\tTiền khách đưa: "+tien
												+ "\n\n" + "Chúc bạn mạnh khỏe!");
							txtReceipt.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						showTablePharmacy();
						
					}else {
						JOptionPane.showMessageDialog(null, "TIỀN KHÁCH ĐƯA KHÔNG ĐỦ!","THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "ĐỊNH DẠNG TIỀN KHÔNG HỢP LỆ!","THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnPrint.setBounds(1198, 542, 137, 43);
		panelThanhToan.add(btnPrint);

		JButton btnClear = new JButton("XÓA");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClear.setBorder(null);
		btnClear.setBackground(new Color(0, 102, 153));
		// button clear
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnClear, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnClear, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total = 0;
				txtReceipt.setText("");
				mathuocThanhToan.setText("");
				tenthuocThanhToan.setText("");
				giaThanhToan.setText("");
				dvtThanhToan.setText("");
				soluongThanhToan.setText("");
				cachdungThanhToan.setText("");
			}
		});
		btnClear.setBounds(1015, 542, 114, 43);
		panelThanhToan.add(btnClear);

		txtTracuuthuoctheotenThanhToan = new JTextField();
		txtTracuuthuoctheotenThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTracuuthuoctheotenThanhToan.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtTracuuthuoctheotenThanhToan.setColumns(10);
		txtTracuuthuoctheotenThanhToan.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		txtTracuuthuoctheotenThanhToan.setBounds(53, 111, 287, 27);
		panelThanhToan.add(txtTracuuthuoctheotenThanhToan);

		JButton btnTraCuu_2 = new JButton("TÌM KIẾM");
		btnTraCuu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnTraCuu_2, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnTraCuu_2, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnTraCuu_2.setActionCommand("TÌM KIẾM");
		btnTraCuu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTimTheoTen_1(e);
				System.out.println("Đã tìm");
			}
		});

		btnTraCuu_2.setForeground(Color.WHITE);
		btnTraCuu_2.setFont(new Font("Arial", Font.BOLD, 14));
		btnTraCuu_2.setBorder(null);
		btnTraCuu_2.setBackground(new Color(0, 102, 153));
		btnTraCuu_2.setBounds(53, 158, 114, 43);
		panelThanhToan.add(btnTraCuu_2);

		JButton btnResetTraCuu_1 = new JButton("RESET");
		btnResetTraCuu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnResetTraCuu_1, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnResetTraCuu_1, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnResetTraCuu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTracuuthuoctheotenThanhToan.setText("");
				showTablePharmacy();
			}
		});
		btnResetTraCuu_1.setForeground(Color.WHITE);
		btnResetTraCuu_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnResetTraCuu_1.setBorder(null);
		btnResetTraCuu_1.setBackground(new Color(0, 102, 153));
		btnResetTraCuu_1.setBounds(219, 158, 114, 44);
		panelThanhToan.add(btnResetTraCuu_1);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_2.setAlignmentY(0.75f);
		separator_1_2.setAlignmentX(0.75f);
		separator_1_2.setBounds(29, 46, 1326, 5);
		panelThanhToan.add(separator_1_2);

		JLabel lblTrangThanhToan = new JLabel("TRANG THANH TOÁN");
		lblTrangThanhToan.setForeground(new Color(0, 51, 102));
		lblTrangThanhToan.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTrangThanhToan.setBounds(565, 8, 269, 35);
		panelThanhToan.add(lblTrangThanhToan);

		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_2_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_2_1.setAlignmentY(0.75f);
		separator_1_2_1.setAlignmentX(0.75f);
		separator_1_2_1.setBounds(350, 62, 4, 216);
		panelThanhToan.add(separator_1_2_1);

		JSeparator separator_1_2_1_1 = new JSeparator();
		separator_1_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_2_1_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_2_1_1.setAlignmentY(0.75f);
		separator_1_2_1_1.setAlignmentX(0.75f);
		separator_1_2_1_1.setBounds(952, 62, 4, 513);
		panelThanhToan.add(separator_1_2_1_1);

		JLabel lblThongTinHoaDon = new JLabel("THÔNG TIN HÓA ĐƠN");
		lblThongTinHoaDon.setForeground(new Color(0, 51, 102));
		lblThongTinHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTinHoaDon.setBounds(1061, 62, 224, 35);
		panelThanhToan.add(lblThongTinHoaDon);

		JLabel lblTienKhachDua = new JLabel("Tiền khách đưa:");
		lblTienKhachDua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblTienKhachDua.setBounds(1031, 496, 137, 27);
		panelThanhToan.add(lblTienKhachDua);

		textFieldTienKhachDua = new JTextField();
		textFieldTienKhachDua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		textFieldTienKhachDua.setColumns(10);
		textFieldTienKhachDua.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 153)));
		textFieldTienKhachDua.setBounds(1198, 493, 155, 26);
		panelThanhToan.add(textFieldTienKhachDua);
		String[] dvt = new String[] { " ", "Vỉ", "Hộp" };

		JPanel panelTraCuuThuoc = new JPanel();
		panelTraCuuThuoc.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panelTraCuuThuoc, null);
		panelTraCuuThuoc.setLayout(null);

		JLabel lblTenThuocTraCuu = new JLabel("NHẬP TÊN THUỐC");
		lblTenThuocTraCuu.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblTenThuocTraCuu.setBounds(138, 86, 177, 30);
		panelTraCuuThuoc.add(lblTenThuocTraCuu);

		textFieldTenThuocTraCuu = new JTextField();
		textFieldTenThuocTraCuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTenThuocTraCuu.setColumns(10);
		textFieldTenThuocTraCuu.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldTenThuocTraCuu.setBounds(138, 115, 304, 36);
		panelTraCuuThuoc.add(textFieldTenThuocTraCuu);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1.setAlignmentY(0.75f);
		separator_1.setAlignmentX(0.75f);
		separator_1.setBounds(30, 172, 1326, 5);
		panelTraCuuThuoc.add(separator_1);

		JButton btnTraCuu = new JButton("TRA CỨU");
		btnTraCuu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnTraCuu, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnTraCuu, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnTraCuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTimTheoTen(e);
				System.out.println("Đã tìm");

			}
		});
		btnTraCuu.setForeground(Color.WHITE);
		btnTraCuu.setFont(new Font("Arial", Font.BOLD, 17));
		btnTraCuu.setBorder(null);
		btnTraCuu.setBackground(new Color(0, 102, 153));
		btnTraCuu.setBounds(587, 111, 109, 40);
		panelTraCuuThuoc.add(btnTraCuu);

		JButton btnResetTraCuu = new JButton("RESET");
		btnResetTraCuu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnResetTraCuu, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnResetTraCuu, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnResetTraCuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldTenThuocTraCuu.setText("");
				showTablePharmacy();
			}
		});
		btnResetTraCuu.setForeground(Color.WHITE);
		btnResetTraCuu.setFont(new Font("Arial", Font.BOLD, 17));
		btnResetTraCuu.setBorder(null);
		btnResetTraCuu.setBackground(new Color(0, 102, 153));
		btnResetTraCuu.setBounds(753, 111, 109, 40);
		btnResetTraCuu.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManHinhChinh.class.getResource("Redo-icon.png"))
						.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH)));
		panelTraCuuThuoc.add(btnResetTraCuu);

		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(102, 205, 170)));
		table.setSelectionBackground(new Color(173, 216, 230));
		table.setGridColor(new Color(46, 139, 87));
		table.setRowHeight(20);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 17));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(30, 188, 1326, 383);
		panelTraCuuThuoc.add(scrollPane);

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Thu\u1ED1c", "T\u00EAn Thu\u1ED1c", "\u0110\u01A1n V\u1ECB T\u00EDnh",
						"Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "H\u1EA1n s\u1EED d\u1EE5ng", "C\u00E1ch D\u00F9ng" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(47);
		table.getColumnModel().getColumn(1).setPreferredWidth(184);
		table.getColumnModel().getColumn(2).setPreferredWidth(31);
		table.getColumnModel().getColumn(3).setPreferredWidth(52);
		table.getColumnModel().getColumn(4).setPreferredWidth(47);
		table.getColumnModel().getColumn(6).setPreferredWidth(276);
		table.setBounds(0, 0, 1, 1);

		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_1_3.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_3.setAlignmentY(0.75f);
		separator_1_3.setAlignmentX(0.75f);
		separator_1_3.setBounds(30, 70, 1326, 5);
		panelTraCuuThuoc.add(separator_1_3);

		JLabel lblNewLabel_7 = new JLabel("DANH MỤC THUỐC");
		lblNewLabel_7.setForeground(new Color(0, 102, 153));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_7.setBounds(587, 11, 234, 47);
		panelTraCuuThuoc.add(lblNewLabel_7);
		tableModel = (DefaultTableModel) table.getModel();

		// cap nhat thuoc
		JPanel panelQuanLyThuoc = new JPanel();
		panelQuanLyThuoc.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panelQuanLyThuoc, null);
		panelQuanLyThuoc.setLayout(null);

		JLabel lblMaThuocQuanLyThuoc = new JLabel("MÃ THUỐC");
		lblMaThuocQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaThuocQuanLyThuoc.setBounds(48, 60, 100, 28);
		panelQuanLyThuoc.add(lblMaThuocQuanLyThuoc);

		textFieldMaThuocQuanLyThuoc = new JTextField();
		textFieldMaThuocQuanLyThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldMaThuocQuanLyThuoc.setForeground(Color.BLACK);
		textFieldMaThuocQuanLyThuoc.setColumns(10);
		textFieldMaThuocQuanLyThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldMaThuocQuanLyThuoc.setBackground(Color.WHITE);
		textFieldMaThuocQuanLyThuoc.setBounds(48, 87, 130, 21);
		panelQuanLyThuoc.add(textFieldMaThuocQuanLyThuoc);

		JLabel lblTenThuocQuanLyThuoc = new JLabel("TÊN THUỐC");
		lblTenThuocQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenThuocQuanLyThuoc.setBounds(48, 114, 111, 24);
		panelQuanLyThuoc.add(lblTenThuocQuanLyThuoc);

		textFieldTenThuocQuanLyThuoc = new JTextField();
		textFieldTenThuocQuanLyThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldTenThuocQuanLyThuoc.setColumns(10);
		textFieldTenThuocQuanLyThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldTenThuocQuanLyThuoc.setBounds(48, 138, 231, 21);
		panelQuanLyThuoc.add(textFieldTenThuocQuanLyThuoc);

		JLabel lblDonViTinhQuanLyThuoc = new JLabel("ĐƠN VỊ TÍNH");
		lblDonViTinhQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		lblDonViTinhQuanLyThuoc.setBounds(48, 165, 111, 27);
		panelQuanLyThuoc.add(lblDonViTinhQuanLyThuoc);

		model_DVT = new String[] { " ", "Vỉ", "Hộp","Tuýp","Chai" };
//		model_index_comboboxCapNhat = new Integer[] {0,1,2}; 
		comboBoxDVTQuanLyThuoc = new JComboBox<>();
		comboBoxDVTQuanLyThuoc.setModel(new DefaultComboBoxModel(new String[] { " ", "Vỉ", "Hộp", "Tuýp","Chai" }));
		comboBoxDVTQuanLyThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBoxDVTQuanLyThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		comboBoxDVTQuanLyThuoc.setBackground(Color.WHITE);
		comboBoxDVTQuanLyThuoc.setBounds(48, 191, 100, 21);
		panelQuanLyThuoc.add(comboBoxDVTQuanLyThuoc);

		JLabel lblGiaQuanLyThuoc = new JLabel("GIÁ");
		lblGiaQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		lblGiaQuanLyThuoc.setBounds(48, 266, 38, 26);
		panelQuanLyThuoc.add(lblGiaQuanLyThuoc);

		textFieldGiaQuanLyThuoc = new JTextField();
		textFieldGiaQuanLyThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldGiaQuanLyThuoc.setColumns(10);
		textFieldGiaQuanLyThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldGiaQuanLyThuoc.setBounds(48, 291, 130, 21);
		panelQuanLyThuoc.add(textFieldGiaQuanLyThuoc);

		JLabel lblSoLuongQuanLyThuoc = new JLabel("SỐ LƯỢNG");
		lblSoLuongQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoLuongQuanLyThuoc.setBounds(48, 318, 100, 28);
		panelQuanLyThuoc.add(lblSoLuongQuanLyThuoc);

		textFieldSLuongQuanLyThuoc = new JTextField();
		textFieldSLuongQuanLyThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldSLuongQuanLyThuoc.setColumns(10);
		textFieldSLuongQuanLyThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldSLuongQuanLyThuoc.setBounds(48, 346, 100, 21);
		panelQuanLyThuoc.add(textFieldSLuongQuanLyThuoc);

		JLabel lblCDungQuanLyThuoc = new JLabel("CÁCH DÙNG");
		lblCDungQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		lblCDungQuanLyThuoc.setBounds(48, 373, 111, 24);
		panelQuanLyThuoc.add(lblCDungQuanLyThuoc);

		textFieldCDungQuanLyThuoc = new JTextField();
		textFieldCDungQuanLyThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldCDungQuanLyThuoc.setColumns(10);
		textFieldCDungQuanLyThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldCDungQuanLyThuoc.setBounds(48, 397, 220, 41);
		panelQuanLyThuoc.add(textFieldCDungQuanLyThuoc);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_1.setAlignmentY(0.75f);
		separator_1_1.setAlignmentX(0.75f);
		separator_1_1.setBounds(305, 24, 2, 509);
		panelQuanLyThuoc.add(separator_1_1);

		JButton btnCapNhatQuanLyThuoc = new JButton("CẬP NHẬT");
		btnCapNhatQuanLyThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnCapNhatQuanLyThuoc, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnCapNhatQuanLyThuoc, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnCapNhatQuanLyThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnCapNhatQuanLyThuoc(e);
					showTablePharmacy();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "NHẬP SAI ĐỊNH DẠNG DỮ LIỆU HOẶC\n THUỐC NÀY ĐÃ CÓ TRONG DANH SÁCH", "CẬP NHẬT THẤT BẠI!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCapNhatQuanLyThuoc.setForeground(Color.WHITE);
		btnCapNhatQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnCapNhatQuanLyThuoc.setBorder(null);
		btnCapNhatQuanLyThuoc.setBackground(new Color(0, 102, 153));
		btnCapNhatQuanLyThuoc.setBounds(158, 449, 100, 36);
		panelQuanLyThuoc.add(btnCapNhatQuanLyThuoc);

		JButton btnResetQuanLyThuoc = new JButton("RESET");
		btnResetQuanLyThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnResetQuanLyThuoc, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnResetQuanLyThuoc, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnResetQuanLyThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMaThuocQuanLyThuoc.setText("");
				textFieldTenThuocQuanLyThuoc.setText("");
				textFieldGiaQuanLyThuoc.setText("");
				textFieldSLuongQuanLyThuoc.setText("");
				textFieldCDungQuanLyThuoc.setText("");
				comboBoxDVTQuanLyThuoc.setSelectedIndex(-1);
			}
		});
		btnResetQuanLyThuoc.setForeground(Color.WHITE);
		btnResetQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnResetQuanLyThuoc.setBorder(null);
		btnResetQuanLyThuoc.setBackground(new Color(0, 102, 153));
		btnResetQuanLyThuoc.setBounds(158, 496, 100, 36);
		btnResetQuanLyThuoc.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(ManHinhChinh.class.getResource("redo-icon.png"))
						.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH)));
		panelQuanLyThuoc.add(btnResetQuanLyThuoc);

		JButton btnXoaQuanLyThuoc = new JButton("XÓA");
		btnXoaQuanLyThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnXoaQuanLyThuoc, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnXoaQuanLyThuoc, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnXoaQuanLyThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnDelete(e);
					JOptionPane.showMessageDialog(null, "XÓA THUỐC THÀNH CÔNG", "THÔNG TIN",
							JOptionPane.INFORMATION_MESSAGE);
					showTablePharmacy();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "NHẬP SAI ĐỊNH DẠNG DỮ LIỆU HOẶC\n THUỐC NÀY KHÔNG TỒN TẠI", "XÓA THẤT BẠI!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnXoaQuanLyThuoc.setForeground(Color.WHITE);
		btnXoaQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoaQuanLyThuoc.setBorder(null);
		btnXoaQuanLyThuoc.setBackground(new Color(0, 102, 153));
		btnXoaQuanLyThuoc.setBounds(48, 496, 100, 36);
		panelQuanLyThuoc.add(btnXoaQuanLyThuoc);

		JButton btnTimKiemQuanLyThuoc = new JButton("Tìm");
		btnTimKiemQuanLyThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnTimKiemQuanLyThuoc, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnTimKiemQuanLyThuoc, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnTimKiemQuanLyThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnQuanLyThuocTim(e);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "KHÔNG TÌM THẤY THUỐC!","THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
				}
				;
			}
		});
		btnTimKiemQuanLyThuoc.setForeground(Color.WHITE);
		btnTimKiemQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnTimKiemQuanLyThuoc.setBorder(null);
		btnTimKiemQuanLyThuoc.setBackground(new Color(0, 102, 153));
		btnTimKiemQuanLyThuoc.setBounds(188, 84, 84, 28);
		panelQuanLyThuoc.add(btnTimKiemQuanLyThuoc);

		JButton btnThemQuanLyThuoc = new JButton("THÊM");
		btnThemQuanLyThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnThemQuanLyThuoc(e);
					showTablePharmacy();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "NHẬP SAI ĐỊNH DẠNG DỮ LIỆU HOẶC\n THUỐC NÀY ĐÃ CÓ TRONG DANH SÁCH", "THÊM THẤT BẠI!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnThemQuanLyThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnThemQuanLyThuoc, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnThemQuanLyThuoc, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnThemQuanLyThuoc.setForeground(Color.WHITE);
		btnThemQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 14));
		btnThemQuanLyThuoc.setBorder(null);
		btnThemQuanLyThuoc.setBackground(new Color(0, 102, 153));
		btnThemQuanLyThuoc.setBounds(48, 449, 100, 36);
		panelQuanLyThuoc.add(btnThemQuanLyThuoc);

		JLabel lblHSDQuanLyThuoc = new JLabel("HẠN SỬ DỤNG");
		lblHSDQuanLyThuoc.setFont(new Font("Arial", Font.BOLD, 15));
		lblHSDQuanLyThuoc.setBounds(48, 216, 119, 28);
		panelQuanLyThuoc.add(lblHSDQuanLyThuoc);

		textFieldHSDQuanLyThuoc = new JTextField();
		textFieldHSDQuanLyThuoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldHSDQuanLyThuoc.setColumns(10);
		textFieldHSDQuanLyThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldHSDQuanLyThuoc.setBounds(48, 242, 130, 21);
		panelQuanLyThuoc.add(textFieldHSDQuanLyThuoc);

		JLabel lblChiTietLoaiThuoc = new JLabel("CHI TIẾT LOẠI THUỐC");
		lblChiTietLoaiThuoc.setForeground(new Color(0, 51, 102));
		lblChiTietLoaiThuoc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblChiTietLoaiThuoc.setBounds(46, 24, 222, 35);
		panelQuanLyThuoc.add(lblChiTietLoaiThuoc);

		JLabel lblThuocTonKho = new JLabel("THUỐC TỒN KHO");
		lblThuocTonKho.setForeground(new Color(0, 51, 102));
		lblThuocTonKho.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThuocTonKho.setBounds(746, 24, 220, 35);
		panelQuanLyThuoc.add(lblThuocTonKho);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(351, 68, 982, 432);
		panelQuanLyThuoc.add(scrollPane_4);

		tableQuanLyThuoc = new JTable();
		tableQuanLyThuoc.setSelectionBackground(new Color(102, 204, 255));
		tableQuanLyThuoc.setGridColor(new Color(51, 102, 51));
		tableQuanLyThuoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		tableQuanLyThuoc.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(102, 204, 153)));
		tableQuanLyThuoc.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 thu\u1ED1c", "T\u00EAn thu\u1ED1c", "\u0110\u01A1n v\u1ECB t\u00EDnh",
						"Gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "H\u1EA1n s\u1EED d\u1EE5ng", "C\u00E1ch d\u00F9ng" }));
		tableQuanLyThuoc.getColumnModel().getColumn(0).setPreferredWidth(57);
		tableQuanLyThuoc.getColumnModel().getColumn(1).setPreferredWidth(171);
		tableQuanLyThuoc.getColumnModel().getColumn(2).setPreferredWidth(37);
		tableQuanLyThuoc.getColumnModel().getColumn(3).setPreferredWidth(46);
		tableQuanLyThuoc.getColumnModel().getColumn(4).setPreferredWidth(33);
		tableQuanLyThuoc.getColumnModel().getColumn(5).setPreferredWidth(63);
		tableQuanLyThuoc.getColumnModel().getColumn(6).setPreferredWidth(232);
		scrollPane_4.setViewportView(tableQuanLyThuoc);

		JButton intonkho = new JButton("XUẤT");
		intonkho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(intonkho, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(intonkho, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		intonkho.setFont(new Font("Tahoma", Font.BOLD, 17));
		intonkho.setBorder(null);
		intonkho.setBackground(new Color(0, 102, 153));
		intonkho.setForeground(Color.WHITE);

		intonkho.setBounds(746, 518, 200, 50);
		panelQuanLyThuoc.add(intonkho);

		JTextArea txtrThuoctonkho = new JTextArea();
		txtrThuoctonkho.setBounds(361, 518, 20, -33);
		panelQuanLyThuoc.add(txtrThuoctonkho);
		tableModel_3 = (DefaultTableModel) tableQuanLyThuoc.getModel();

		intonkho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				Statement statement = null;
				com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
				String filename = "Thống kê tồn kho";
				String path = "E:\\";
				try {
					PdfWriter writer = PdfWriter.getInstance(document,
							new FileOutputStream(path + "" + filename + ".pdf"));
					document.open();
					document.addAuthor("Nhóm 6");
					document.addCreationDate();
					document.addCreator("QLKS");
					document.addTitle("Thống kê tồn kho");
					document.addSubject("Thống kê tồn kho");

					// Định dạng Font Tiêu đề
					File filefontTieuDe = new File("fonts/vuArialBold.ttf");
					BaseFont bfTieuDe = BaseFont.createFont(filefontTieuDe.getAbsolutePath(), BaseFont.IDENTITY_H,
							BaseFont.EMBEDDED);
					com.itextpdf.text.Font fontTieuDe1 = new com.itextpdf.text.Font(bfTieuDe, 16);
					fontTieuDe1.setColor(BaseColor.BLUE);
					com.itextpdf.text.Font fontTieuDe2 = new com.itextpdf.text.Font(bfTieuDe, 13);
					fontTieuDe2.setColor(BaseColor.BLUE);
					com.itextpdf.text.Font fontTieuDe3 = new com.itextpdf.text.Font(bfTieuDe, 13);
					com.itextpdf.text.Font fontTieuDe4 = new com.itextpdf.text.Font(bfTieuDe, 12);

					// Định dạng Font Nội dung
					File filefontNoiDung = new File("fonts/vuArial.ttf");
					BaseFont bfNoiDung = BaseFont.createFont(filefontNoiDung.getAbsolutePath(), BaseFont.IDENTITY_H,
							BaseFont.EMBEDDED);
					com.itextpdf.text.Font fontNoiDung1 = new com.itextpdf.text.Font(bfNoiDung, 13);
					com.itextpdf.text.Font fontNoiDung2 = new com.itextpdf.text.Font(bfNoiDung, 12);
					com.itextpdf.text.Font fontNoiDung3 = new com.itextpdf.text.Font(bfNoiDung, 11);

					PdfPTable tableDV = new PdfPTable(7); // 6 cột
					tableDV.setWidthPercentage(80);
					tableDV.setSpacingBefore(10);
					tableDV.setSpacingAfter(10);

					// Set Column widths
					float[] tableDV_columnWidths = { 80, 120, 120, 100, 80, 100, 100 };
					tableDV.setWidths(tableDV_columnWidths);

					PdfPCell cellTDSP = new PdfPCell(new Paragraph("Mã thuốc", fontTieuDe4));
					cellTDSP.setBorderColor(BaseColor.BLACK);
					cellTDSP.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDSP.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellTDSP.setMinimumHeight(30);
					tableDV.addCell(cellTDSP);

					PdfPCell cellTDLoaiPhong = new PdfPCell(new Paragraph("Tên sản phẩm", fontTieuDe4));
					cellTDLoaiPhong.setBorderColor(BaseColor.BLACK);
					cellTDLoaiPhong.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDLoaiPhong.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDLoaiPhong);

					PdfPCell cellTDBed = new PdfPCell(new Paragraph("Đơn vị tính", fontTieuDe4));
					cellTDBed.setBorderColor(BaseColor.BLACK);
					cellTDBed.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDBed.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDBed);

					PdfPCell cellTDGia = new PdfPCell(new Paragraph("Giá", fontTieuDe4));
					cellTDGia.setBorderColor(BaseColor.BLACK);
					cellTDGia.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDGia.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDGia);

					PdfPCell cellTDSL = new PdfPCell(new Paragraph("Số lượng", fontTieuDe4));
					cellTDSL.setBorderColor(BaseColor.BLACK);
					cellTDSL.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDSL.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDSL);

					PdfPCell cellTDThanhTien = new PdfPCell(new Paragraph("Cách dùng", fontTieuDe4));
					cellTDThanhTien.setBorderColor(BaseColor.BLACK);
					cellTDThanhTien.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDThanhTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDThanhTien);

					PdfPCell cellcachdung = new PdfPCell(new Paragraph("Hạn sử dụng", fontTieuDe4));
					cellcachdung.setBorderColor(BaseColor.BLACK);
					cellcachdung.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellcachdung.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellcachdung);
					try {
						int TongTien = 0;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management",
								"root", "");

						// query
						String sql = "select * from pharmacy";
						statement = connection.createStatement();

						ResultSet rs = statement.executeQuery(sql);

						while (rs.next()) {

							PdfPCell mathuoc1 = new PdfPCell(new Paragraph(rs.getString("mathuoc"), fontNoiDung3));
							mathuoc1.setPaddingLeft(10);
							mathuoc1.setHorizontalAlignment(Element.ALIGN_CENTER);
							mathuoc1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(mathuoc1);

							PdfPCell tensp = new PdfPCell(new Paragraph(rs.getString("tensanpham"), fontNoiDung3));
							tensp.setPaddingLeft(10);
							tensp.setHorizontalAlignment(Element.ALIGN_CENTER);
							tensp.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(tensp);

							PdfPCell dvt1 = new PdfPCell(new Paragraph(rs.getString("dvt"), fontNoiDung3));
							dvt1.setPaddingLeft(10);
							dvt1.setHorizontalAlignment(Element.ALIGN_CENTER);
							dvt1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(dvt1);

							PdfPCell gia1 = new PdfPCell(new Paragraph(rs.getString("gia"), fontNoiDung3));
							gia1.setPaddingLeft(10);
							gia1.setHorizontalAlignment(Element.ALIGN_CENTER);
							gia1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(gia1);

							PdfPCell soluong1 = new PdfPCell(new Paragraph(rs.getString("soluong"), fontNoiDung3));
							soluong1.setPaddingLeft(10);
							soluong1.setHorizontalAlignment(Element.ALIGN_CENTER);
							soluong1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(soluong1);

							PdfPCell cachdung1 = new PdfPCell(new Paragraph(rs.getString("cachdung"), fontNoiDung3));
							cachdung1.setPaddingLeft(10);
							cachdung1.setHorizontalAlignment(Element.ALIGN_CENTER);
							cachdung1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(cachdung1);

							PdfPCell hansudung1 = new PdfPCell(new Paragraph(rs.getString("hansudung"), fontNoiDung3));
							hansudung1.setPaddingLeft(10);
							hansudung1.setHorizontalAlignment(Element.ALIGN_CENTER);
							hansudung1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(hansudung1);

						}
						PdfPCell cellTongCong = new PdfPCell(new Paragraph("TỔNG CỘNG: ", fontTieuDe4));
						cellTongCong.setColspan(5);
						cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
						cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cellTongCong.setMinimumHeight(20);
						tableDV.addCell(cellTongCong);

					} catch (Exception e1) {
						System.out.println(e1);
						System.out.println("Lỗi");
					}
					document.add(tableDV);

					// Đóng document sau khi định dạng
					document.close();
					// Đóng writer sau khi ghi file pdf
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// Mở file pdf sau khi định dạng và write
				try {
					File file = new File("D:\\" + filename + ".pdf");
					if (!Desktop.isDesktopSupported()) {
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if (file.exists()) {
						desktop.open(file);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				showTablePharmacy();
			}

		});

		JPanel panelThongKe = new JPanel();
		panelThongKe.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panelThongKe, null);
		panelThongKe.setLayout(null);

		doanhthu = new JTextField();
		doanhthu.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		doanhthu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		doanhthu.setBounds(116, 90, 159, 29);
		panelThongKe.add(doanhthu);
		doanhthu.setColumns(10);

		JButton btnNewButton = new JButton("TÌM KIẾM");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnNewButton, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnNewButton, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnNewButton.setBackground(new Color(0, 102, 153));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timtheongay(e);
			}
		});
		btnNewButton.setBounds(386, 84, 126, 35);
		panelThongKe.add(btnNewButton);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setViewportBorder(new LineBorder(new Color(0, 153, 153)));
		scrollPane_3.setBounds(90, 137, 1191, 330);
		panelThongKe.add(scrollPane_3);

		tbldoanhthu = new JTable();
		tbldoanhthu.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 204, 153)));
		tbldoanhthu.setSelectionBackground(new Color(51, 204, 255));
		tbldoanhthu.setRowHeight(30);
		tbldoanhthu.setGridColor(new Color(0, 153, 102));
		tbldoanhthu.setFont(new Font("Tahoma", Font.BOLD, 17));
		tbldoanhthu.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Ng\u00E0y", "Doanh thu" }));
		scrollPane_3.setViewportView(tbldoanhthu);

		JLabel lblNewLabel_9 = new JLabel("Tổng cộng:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_9.setBounds(970, 486, 135, 29);
		panelThongKe.add(lblNewLabel_9);
		tableModel_2 = (DefaultTableModel) tbldoanhthu.getModel();

		tongcong = new JTextField();
		tongcong.setBorder(new LineBorder(new Color(0, 102, 153), 3, true));
		tongcong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		tongcong.setBounds(1111, 486, 159, 27);
		panelThongKe.add(tongcong);
		tongcong.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel_10.setForeground(new Color(0, 102, 153));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_10.setBounds(552, 9, 289, 50);
		panelThongKe.add(lblNewLabel_10);

		JButton btnInDoanhThu = new JButton("IN DOANH THU");
		btnInDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
				String filename = "Thống kê doanh thu";
				String path = "E:\\";
				try {
					PdfWriter writer = PdfWriter.getInstance(document,
							new FileOutputStream(path + "" + filename + ".pdf"));
					document.open();
					document.addAuthor("Nhóm 6");
					document.addCreationDate();
					document.addCreator("QLKS");
					document.addTitle("Thống kê doanh thu");
					document.addSubject("Thống kê doanh thu");

					// Định dạng Font Tiêu đề
					File filefontTieuDe = new File("fonts/vuArialBold.ttf");
					BaseFont bfTieuDe = BaseFont.createFont(filefontTieuDe.getAbsolutePath(), BaseFont.IDENTITY_H,
							BaseFont.EMBEDDED);
					com.itextpdf.text.Font fontTieuDe1 = new com.itextpdf.text.Font(bfTieuDe, 16);
					fontTieuDe1.setColor(BaseColor.BLUE);
					com.itextpdf.text.Font fontTieuDe2 = new com.itextpdf.text.Font(bfTieuDe, 13);
					fontTieuDe2.setColor(BaseColor.BLUE);
					com.itextpdf.text.Font fontTieuDe3 = new com.itextpdf.text.Font(bfTieuDe, 13);
					com.itextpdf.text.Font fontTieuDe4 = new com.itextpdf.text.Font(bfTieuDe, 12);

					// Định dạng Font Nội dung
					File filefontNoiDung = new File("fonts/vuArial.ttf");
					BaseFont bfNoiDung = BaseFont.createFont(filefontNoiDung.getAbsolutePath(), BaseFont.IDENTITY_H,
							BaseFont.EMBEDDED);
					com.itextpdf.text.Font fontNoiDung1 = new com.itextpdf.text.Font(bfNoiDung, 13);
					com.itextpdf.text.Font fontNoiDung2 = new com.itextpdf.text.Font(bfNoiDung, 12);
					com.itextpdf.text.Font fontNoiDung3 = new com.itextpdf.text.Font(bfNoiDung, 11);

					PdfPTable tableDV = new PdfPTable(3); // 6 cột
					tableDV.setWidthPercentage(80);
					tableDV.setSpacingBefore(10);
					tableDV.setSpacingAfter(10);

					// Set Column widths
					float[] tableDV_columnWidths = { 80, 120, 120 };
					tableDV.setWidths(tableDV_columnWidths);

					PdfPCell cellTDSP = new PdfPCell(new Paragraph("Mã doanh thu", fontTieuDe4));
					cellTDSP.setBorderColor(BaseColor.BLACK);
					cellTDSP.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDSP.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellTDSP.setMinimumHeight(30);
					tableDV.addCell(cellTDSP);

					PdfPCell cellTDLoaiPhong = new PdfPCell(new Paragraph("Ngày", fontTieuDe4));
					cellTDLoaiPhong.setBorderColor(BaseColor.BLACK);
					cellTDLoaiPhong.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDLoaiPhong.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDLoaiPhong);

					PdfPCell cellTDBed = new PdfPCell(new Paragraph("Tổng", fontTieuDe4));
					cellTDBed.setBorderColor(BaseColor.BLACK);
					cellTDBed.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDBed.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDBed);

					try {
						float tongtien = 0;
						Connection connection = null;
						PreparedStatement statement = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management",
								"root", "");
						// query
						String query = "select * from doanhthu where ngay like ? order by id";
						statement = connection.prepareCall(query);
						statement.setString(1, "%" + doanhthu.getText() + "%");
						ResultSet resultSet = statement.executeQuery();

						System.out.println("nghia");
						while (resultSet.next()) {
							System.out.println("nghia1");

							PdfPCell mathuoc1 = new PdfPCell(new Paragraph(resultSet.getString("id"), fontNoiDung3));
							mathuoc1.setPaddingLeft(10);
							mathuoc1.setHorizontalAlignment(Element.ALIGN_CENTER);
							mathuoc1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(mathuoc1);

							PdfPCell tensp = new PdfPCell(new Paragraph(resultSet.getString("ngay"), fontNoiDung3));
							tensp.setPaddingLeft(10);
							tensp.setHorizontalAlignment(Element.ALIGN_CENTER);
							tensp.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(tensp);

							PdfPCell dvt1 = new PdfPCell(new Paragraph(resultSet.getString("total"), fontNoiDung3));
							dvt1.setPaddingLeft(10);
							dvt1.setHorizontalAlignment(Element.ALIGN_CENTER);
							dvt1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(dvt1);

							tongtien = tongtien + Float.parseFloat(resultSet.getString("total"));
						}

						PdfPCell cellTongCong = new PdfPCell(
								new Paragraph("TỔNG CỘNG:   " + String.valueOf(tongtien), fontTieuDe4));
						cellTongCong.setColspan(5);
						cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
						cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cellTongCong.setMinimumHeight(20);
						tableDV.addCell(cellTongCong);

					} catch (Exception e1) {
						System.out.println(e1);

					}
					document.add(tableDV);

					// Đóng document sau khi định dạng
					document.close();
					// Đóng writer sau khi ghi file pdf
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// Mở file pdf sau khi định dạng và write
				try {
					File file = new File("D:\\" + filename + ".pdf");
					if (!Desktop.isDesktopSupported()) {
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if (file.exists()) {
						desktop.open(file);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				showTabledt();
			}
		});
		btnInDoanhThu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnInDoanhThu, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnInDoanhThu, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnInDoanhThu.setForeground(new Color(255, 255, 255));
		btnInDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnInDoanhThu.setBackground(new Color(0, 102, 153));
		btnInDoanhThu.setBorder(null);
		btnInDoanhThu.setBounds(1020, 548, 200, 34);
		panelThongKe.add(btnInDoanhThu);

		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2_2.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_2_2.setAlignmentY(0.75f);
		separator_1_2_2.setAlignmentX(0.75f);
		separator_1_2_2.setBounds(25, 56, 1326, 3);
		panelThongKe.add(separator_1_2_2);

		JLabel lblNhapNgayDoanhThu = new JLabel("Nhập ngày");
		lblNhapNgayDoanhThu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNhapNgayDoanhThu.setBounds(112, 66, 92, 29);
		panelThongKe.add(lblNhapNgayDoanhThu);
		
		JButton btnResetThongKe = new JButton("RESET");
		btnResetThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTabledt();
				tongcong.setText("");
				doanhthu.setText("");
			}
		});
		btnResetThongKe.setForeground(Color.WHITE);
		btnResetThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnResetThongKe.setBorder(null);
		btnResetThongKe.setBackground(new Color(0, 102, 153));
		btnResetThongKe.setBounds(552, 84, 115, 36);
		panelThongKe.add(btnResetThongKe);

		JPanel panelNhanVien = new JPanel();
		panelNhanVien.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panelNhanVien, null);
		panelNhanVien.setLayout(null);

		JLabel lblTenNV = new JLabel("Họ và tên");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenNV.setBounds(50, 143, 82, 19);
		panelNhanVien.add(lblTenNV);

		JLabel lblNSinhNV = new JLabel("Ngày sinh");
		lblNSinhNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNSinhNV.setBounds(50, 187, 85, 22);
		panelNhanVien.add(lblNSinhNV);

		textFieldNSinhNV = new JTextField();
		textFieldNSinhNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNSinhNV.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldNSinhNV.setColumns(10);
		textFieldNSinhNV.setBounds(50, 210, 122, 28);
		panelNhanVien.add(textFieldNSinhNV);

		JLabel lblGTinhNV = new JLabel("Giới tính");
		lblGTinhNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGTinhNV.setBounds(50, 237, 70, 28);
		panelNhanVien.add(lblGTinhNV);

		model_gender = new String[] { " ", "Nam", "Nữ" };
		gioitinh = new JComboBox();
		gioitinh.setBackground(Color.WHITE);
		gioitinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		gioitinh.setModel(new DefaultComboBoxModel(new String[] { "", "Nam", "Nữ" }));
		gioitinh.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		gioitinh.setBounds(50, 262, 85, 27);
		panelNhanVien.add(gioitinh);

		JLabel lblHVanNV = new JLabel("Học vấn");
		lblHVanNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHVanNV.setBounds(50, 300, 85, 19);
		panelNhanVien.add(lblHVanNV);

		model_hocvan = new String[] { " ", "Đại học", "Cấp 3", "Cao đẳng" };
		hocvan = new JComboBox();
		hocvan.setModel(new DefaultComboBoxModel(new String[] { " ", "Đại học", "Cấp 3", "Cao đẳng" }));
		hocvan.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		hocvan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		hocvan.setBounds(50, 324, 122, 25);
		panelNhanVien.add(hocvan);

		JLabel lblSDTNhanVien = new JLabel("Số điện thoại");
		lblSDTNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSDTNhanVien.setBounds(50, 360, 102, 19);
		panelNhanVien.add(lblSDTNhanVien);

		textFieldSDTNhanVien = new JTextField();
		textFieldSDTNhanVien.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldSDTNhanVien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textFieldSDTNhanVien.setColumns(10);
		textFieldSDTNhanVien.setBounds(50, 380, 133, 28);
		panelNhanVien.add(textFieldSDTNhanVien);

		JLabel lblNewLabel_2_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(50, 419, 122, 22);
		panelNhanVien.add(lblNewLabel_2_1_1);

		textFieldDChiNhanVien = new JTextField();
		textFieldDChiNhanVien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textFieldDChiNhanVien.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldDChiNhanVien.setColumns(10);
		textFieldDChiNhanVien.setBounds(50, 443, 256, 28);
		panelNhanVien.add(textFieldDChiNhanVien);

		JButton btnThemNhanVien = new JButton("THÊM");
		btnThemNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnThemNhanVien, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnThemNhanVien, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnThemNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnThemNhanVien(e);
					showTableNhanVien();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "NHẬP SAI ĐỊNH DẠNG DỮ LIỆU HOẶC\n ĐÃ TỒN TẠI NHÂN VIÊN TRONG DANH SÁCH", "THÊM KHÔNG THÀNH CÔNG!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnThemNhanVien.setForeground(new Color(255, 255, 255));
		btnThemNhanVien.setBackground(new Color(0, 102, 153));
		btnThemNhanVien.setBorder(null);
		btnThemNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThemNhanVien.setBounds(50, 495, 102, 36);
		panelNhanVien.add(btnThemNhanVien);

		JButton btnCapNhatNhanVien = new JButton("CẬP NHẬT");
		btnCapNhatNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnCapNhatNhanVien(e);
					showTableNhanVien();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "NHẬP SAI ĐỊNH DẠNG DỮ LIỆU HOẶC\n NHÂN VIÊN KHÔNG CÓ TRONG DANH SÁCH", "CẬP NHẬT THẤT BẠI!",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCapNhatNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnCapNhatNhanVien, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnCapNhatNhanVien, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnCapNhatNhanVien.setBackground(new Color(0, 102, 153));
		btnCapNhatNhanVien.setBorder(null);
		btnCapNhatNhanVien.setForeground(new Color(255, 255, 255));
		btnCapNhatNhanVien.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCapNhatNhanVien.setBounds(173, 495, 102, 36);
		panelNhanVien.add(btnCapNhatNhanVien);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(413, 90, 913, 391);
		panelNhanVien.add(scrollPane_5);

		tableNhanVien = new JTable();
		tableNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection connection = null;
				PreparedStatement statement = null;
				int row = tableNhanVien.getSelectedRow();
				String id = (String) tableNhanVien.getValueAt(row, 0);

				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root",
							"");
					String sql = "SELECT * FROM `nhanvien` where `id` = '"+id+"'";
					statement = connection.prepareCall(sql);
					ResultSet resultSet = statement.executeQuery();
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {
						textFieldMaNV.setText(rs.getString("id"));
						textFieldTenNV.setText(rs.getString("tennhanvien"));
						textFieldNSinhNV.setText(rs.getString("ngaysinh"));
						gioitinh.setSelectedItem(rs.getString("gioitinh"));
						hocvan.setSelectedItem(rs.getString("hocvan"));
						textFieldSDTNhanVien.setText(rs.getString("sodienthoai"));
						textFieldDChiNhanVien.setText(rs.getString("diachi"));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		tableNhanVien.setRowHeight(20);
		tableNhanVien.setSelectionBackground(new Color(0, 204, 204));
		tableNhanVien.setGridColor(new Color(0, 153, 204));
		tableNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "H\u1ECDc v\u1EA5n", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		tableNhanVien.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableNhanVien.getColumnModel().getColumn(3).setPreferredWidth(44);
		tableNhanVien.getColumnModel().getColumn(6).setPreferredWidth(188);
		scrollPane_5.setViewportView(tableNhanVien);

		JLabel lblNewLabelQLNhanVien = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabelQLNhanVien.setForeground(new Color(0, 102, 153));
		lblNewLabelQLNhanVien.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabelQLNhanVien.setBounds(533, 11, 299, 48);
		panelNhanVien.add(lblNewLabelQLNhanVien);

		textFieldTenNV = new JTextField();
		textFieldTenNV.setForeground(Color.BLACK);
		textFieldTenNV.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldTenNV.setColumns(10);
		textFieldTenNV.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldTenNV.setBackground(Color.WHITE);
		textFieldTenNV.setBounds(50, 163, 180, 25);
		panelNhanVien.add(textFieldTenNV);

		JButton btnInDSNhanVien = new JButton("IN DANH SÁCH");
		btnInDSNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				Statement statement = null;
				com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
				String filename = "Danh sách nhân viên";
				String path = "E:\\";
				try {
					PdfWriter writer = PdfWriter.getInstance(document,
							new FileOutputStream(path + "" + filename + ".pdf"));
					document.open();
					document.addAuthor("Nhóm 6");
					document.addCreationDate();
					document.addCreator("QLKS");
					document.addTitle("Danh sách nhân viên");
					document.addSubject("Danh sách nhân viên");

					// Định dạng Font Tiêu đề
					File filefontTieuDe = new File("fonts/vuArialBold.ttf");
					BaseFont bfTieuDe = BaseFont.createFont(filefontTieuDe.getAbsolutePath(), BaseFont.IDENTITY_H,
							BaseFont.EMBEDDED);
					com.itextpdf.text.Font fontTieuDe1 = new com.itextpdf.text.Font(bfTieuDe, 16);
					fontTieuDe1.setColor(BaseColor.BLUE);
					com.itextpdf.text.Font fontTieuDe2 = new com.itextpdf.text.Font(bfTieuDe, 13);
					fontTieuDe2.setColor(BaseColor.BLUE);
					com.itextpdf.text.Font fontTieuDe3 = new com.itextpdf.text.Font(bfTieuDe, 13);
					com.itextpdf.text.Font fontTieuDe4 = new com.itextpdf.text.Font(bfTieuDe, 12);

					// Định dạng Font Nội dung
					File filefontNoiDung = new File("fonts/vuArial.ttf");
					BaseFont bfNoiDung = BaseFont.createFont(filefontNoiDung.getAbsolutePath(), BaseFont.IDENTITY_H,
							BaseFont.EMBEDDED);
					com.itextpdf.text.Font fontNoiDung1 = new com.itextpdf.text.Font(bfNoiDung, 13);
					com.itextpdf.text.Font fontNoiDung2 = new com.itextpdf.text.Font(bfNoiDung, 12);
					com.itextpdf.text.Font fontNoiDung3 = new com.itextpdf.text.Font(bfNoiDung, 11);

					PdfPTable tableDV = new PdfPTable(7); // 7 cột
					tableDV.setWidthPercentage(100);
					tableDV.setSpacingBefore(5);
					tableDV.setSpacingAfter(5);

					// Set Column widths
					float[] tableDV_columnWidths = { 40, 125, 100, 55, 85, 100, 250 };
					tableDV.setWidths(tableDV_columnWidths);

					PdfPCell cellTDSP = new PdfPCell(new Paragraph("STT", fontTieuDe4));
					cellTDSP.setBorderColor(BaseColor.BLACK);
					cellTDSP.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDSP.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cellTDSP.setMinimumHeight(30);
					tableDV.addCell(cellTDSP);

					PdfPCell cellTDLoaiPhong = new PdfPCell(new Paragraph("Họ và tên", fontTieuDe4));
					cellTDLoaiPhong.setBorderColor(BaseColor.BLACK);
					cellTDLoaiPhong.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDLoaiPhong.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDLoaiPhong);

					PdfPCell cellTDBed = new PdfPCell(new Paragraph("Ngày sinh", fontTieuDe4));
					cellTDBed.setBorderColor(BaseColor.BLACK);
					cellTDBed.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDBed.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDBed);

					PdfPCell cellTDGia = new PdfPCell(new Paragraph("Giới tính", fontTieuDe4));
					cellTDGia.setBorderColor(BaseColor.BLACK);
					cellTDGia.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDGia.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDGia);
					
					PdfPCell cellHV = new PdfPCell(new Paragraph("Học Vấn", fontTieuDe4));
					cellHV.setBorderColor(BaseColor.BLACK);
					cellHV.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellHV.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellHV);

					PdfPCell cellTDSL = new PdfPCell(new Paragraph("Số Điện Thoại", fontTieuDe4));
					cellTDSL.setBorderColor(BaseColor.BLACK);
					cellTDSL.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDSL.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDSL);

					PdfPCell cellTDThanhTien = new PdfPCell(new Paragraph("Địa Chỉ", fontTieuDe4));
					cellTDThanhTien.setBorderColor(BaseColor.BLACK);
					cellTDThanhTien.setHorizontalAlignment(Element.ALIGN_CENTER);
					cellTDThanhTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
					tableDV.addCell(cellTDThanhTien);

					try {

						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management",
								"root", "");

						// query
						String sql = "select * from nhanvien order by tennhanvien";
						statement = connection.createStatement();

						ResultSet rs = statement.executeQuery(sql);
						int stt=1;
						while (rs.next()) {
							String s=Integer.toString(stt);  
							PdfPCell mathuoc1 = new PdfPCell(new Paragraph(s, fontNoiDung3));
							mathuoc1.setPaddingLeft(10);
							mathuoc1.setHorizontalAlignment(Element.ALIGN_CENTER);
							mathuoc1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(mathuoc1);
							stt++;
							PdfPCell tensp = new PdfPCell(new Paragraph(rs.getString("tennhanvien"), fontNoiDung3));
							tensp.setPaddingLeft(10);
							tensp.setHorizontalAlignment(Element.ALIGN_CENTER);
							tensp.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(tensp);

							PdfPCell dvt1 = new PdfPCell(new Paragraph(rs.getString("ngaysinh"), fontNoiDung3));
							dvt1.setPaddingLeft(10);
							dvt1.setHorizontalAlignment(Element.ALIGN_CENTER);
							dvt1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(dvt1);

							PdfPCell gia1 = new PdfPCell(new Paragraph(rs.getString("gioitinh"), fontNoiDung3));
							gia1.setPaddingLeft(10);
							gia1.setHorizontalAlignment(Element.ALIGN_CENTER);
							gia1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(gia1);

							PdfPCell soluong1 = new PdfPCell(new Paragraph(rs.getString("hocvan"), fontNoiDung3));
							soluong1.setPaddingLeft(10);
							soluong1.setHorizontalAlignment(Element.ALIGN_CENTER);
							soluong1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(soluong1);

							PdfPCell cachdung1 = new PdfPCell(new Paragraph(rs.getString("sodienthoai"), fontNoiDung3));
							cachdung1.setPaddingLeft(10);
							cachdung1.setHorizontalAlignment(Element.ALIGN_CENTER);
							cachdung1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(cachdung1);

							PdfPCell hansudung1 = new PdfPCell(new Paragraph(rs.getString("diachi"), fontNoiDung3));
							hansudung1.setPaddingLeft(10);
							hansudung1.setHorizontalAlignment(Element.ALIGN_CENTER);
							hansudung1.setVerticalAlignment(Element.ALIGN_MIDDLE);
							tableDV.addCell(hansudung1);

						}

					} catch (Exception e1) {
						System.out.println(e1);
						System.out.println("Lỗi");
					}
					document.add(tableDV);

					// Đóng document sau khi định dạng
					document.close();
					// Đóng writer sau khi ghi file pdf
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// Mở file pdf sau khi định dạng và write
				try {
					File file = new File("D:\\" + filename + ".pdf");
					if (!Desktop.isDesktopSupported()) {
						System.out.println("not supported");
						return;
					}
					Desktop desktop = Desktop.getDesktop();
					if (file.exists()) {
						desktop.open(file);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnInDSNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnInDSNhanVien, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnInDSNhanVien, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnInDSNhanVien.setBackground(new Color(0, 102, 153));
		btnInDSNhanVien.setBorder(null);
		btnInDSNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInDSNhanVien.setForeground(new Color(255, 255, 255));
		btnInDSNhanVien.setBounds(1126, 508, 200, 50);
		panelNhanVien.add(btnInDSNhanVien);

		JSeparator separator_1_2_2_1 = new JSeparator();
		separator_1_2_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_2_2_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_2_2_1.setAlignmentY(0.75f);
		separator_1_2_2_1.setAlignmentX(0.75f);
		separator_1_2_2_1.setBounds(26, 56, 1326, 3);
		panelNhanVien.add(separator_1_2_2_1);

		JLabel lblChiTietNhanVien = new JLabel("CHI TIẾT THÔNG TIN NHÂN VIÊN");
		lblChiTietNhanVien.setForeground(new Color(0, 51, 102));
		lblChiTietNhanVien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblChiTietNhanVien.setBounds(36, 56, 333, 35);
		panelNhanVien.add(lblChiTietNhanVien);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBorder(new LineBorder(new Color(0, 102, 153), 3));
		separator_1_1_1.setAlignmentY(0.75f);
		separator_1_1_1.setAlignmentX(0.75f);
		separator_1_1_1.setBounds(375, 90, 2, 450);
		panelNhanVien.add(separator_1_1_1);

		JButton btnTimKiemNhanVien = new JButton("Tìm");
		btnTimKiemNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnTimMaNhanVien(e);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "KHÔNG CÓ NHÂN VIÊN TRONG DANH SÁCH!","THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnTimKiemNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnTimKiemNhanVien, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnTimKiemNhanVien, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnTimKiemNhanVien.setForeground(Color.WHITE);
		btnTimKiemNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		btnTimKiemNhanVien.setBorder(null);
		btnTimKiemNhanVien.setBackground(new Color(0, 102, 153));
		btnTimKiemNhanVien.setBounds(199, 114, 84, 28);
		panelNhanVien.add(btnTimKiemNhanVien);

		JButton btnXoaNhanVien = new JButton("XÓA");
		btnXoaNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnXoaNhanVien, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnXoaNhanVien, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnXoaNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = JOptionPane.showConfirmDialog(null, "BẠN CÓ CHẮC MUỐN XÓA NHÂN VIÊN NÀY?", "THÔNG TIN",
							JOptionPane.YES_NO_OPTION);
					if (a == 0) {
						btnXoaNhanVien(e);
						JOptionPane.showMessageDialog(null, "XÓA NHÂN VIÊN THÀNH CÔNG", "THÔNG TIN",
								JOptionPane.INFORMATION_MESSAGE);
						showTableNhanVien();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "NHẬP SAI ĐỊNH DẠNG DỮ LIỆU HOẶC \n NHÂN VIÊN KHÔNG CÓ TRONG DANH SÁCH", "XÓA KHÔNG THÀNH CÔNG!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnXoaNhanVien.setForeground(Color.WHITE);
		btnXoaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoaNhanVien.setBorder(null);
		btnXoaNhanVien.setBackground(new Color(0, 102, 153));
		btnXoaNhanVien.setBounds(50, 545, 102, 36);
		panelNhanVien.add(btnXoaNhanVien);

		JButton btnResetNhanVien = new JButton("RESET");
		btnResetNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldTenNV.setText("");
				textFieldNSinhNV.setText("");
				gioitinh.setSelectedIndex(0);
				hocvan.setSelectedIndex(0);
				textFieldSDTNhanVien.setText("");
				textFieldDChiNhanVien.setText("");
				showTableNhanVien();
			}
		});
		btnResetNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(btnResetNhanVien, new Color(0, 153, 255), new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(btnResetNhanVien, new Color(0, 102, 153), new Color(255, 255, 255));
			}
		});
		btnResetNhanVien.setForeground(Color.WHITE);
		btnResetNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnResetNhanVien.setBorder(null);
		btnResetNhanVien.setBackground(new Color(0, 102, 153));
		btnResetNhanVien.setBounds(173, 545, 102, 36);
		panelNhanVien.add(btnResetNhanVien);
		
		textFieldMaNV = new JTextField();
		textFieldMaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldMaNV.setColumns(10);
		textFieldMaNV.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(0, 102, 153)));
		textFieldMaNV.setBounds(50, 114, 122, 28);
		panelNhanVien.add(textFieldMaNV);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaNV.setBounds(50, 90, 122, 19);
		panelNhanVien.add(lblMaNV);

		// this.setVisible(true);
	}

	private boolean checkSoLuong() {
		String id = mathuocThanhToan.getText();
		int a = Integer.parseInt(soluongThanhToan.getText());
		int sl = PharmacyModify.FindWithID(id).getSoluong();
		if (sl < a)
			return false;
		return true;
	}

	private void timtheongay(java.awt.event.ActionEvent evt) {
		String input = doanhthu.getText();

		if (input != null && input.length() > 0) {

			doanhthulist = PharmacyModify.findByDate(input);

			tableModel_2.setRowCount(0);

			doanhthulist.forEach((doanhthu) -> {

				tableModel_2.addRow(new Object[] { doanhthu.getNgay(), doanhthu.getDoanhthu(), });
			});
			doanhthulist.forEach((doanhthu) -> {
				tong = tong + doanhthu.getDoanhthu();
			});
			tongcong.setText(String.valueOf(tong));
			tong = 0;
		}
	}

	public void showTabledt() {
		doanhthulist = find();
		DefaultTableModel tableModel;
		tableModel = (DefaultTableModel) tbldoanhthu.getModel();
		tableModel.setRowCount(0);
		doanhthulist.forEach((doanhthu) -> {
			tableModel.addRow(new Object[] { doanhthu.getNgay(), doanhthu.getDoanhthu(), });
		});
	}

	public void showTableNhanVien() {
		nhanvienlist = PharmacyModify.findallNhanVien();
		tableModel_4 = (DefaultTableModel) tableNhanVien.getModel();
		tableModel_4.setRowCount(0);
		nhanvienlist.forEach((nhanvien) -> {
			tableModel_4.addRow(new Object[] { nhanvien.getID(), nhanvien.getHovaten(), nhanvien.getNgaysinh(),
					nhanvien.getGioitinh(), nhanvien.getHocvan(), nhanvien.getSodienthoai(), nhanvien.getDiachi() });
		});
	}

	public static List<doanhthu> find() {

		List<doanhthu> doanhthulist = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;

		try {
			// lay tat ca danh sach thuoc
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");

			// query
			String sql = "select * from doanhthu order by id desc";
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				doanhthu std = new doanhthu(resultSet.getString("ngay"), resultSet.getFloat("total"));
				doanhthulist.add(std);
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return doanhthulist;
	}

	private void showTablePharmacy() {
		pharmacyList = PharmacyModify.findAll();
		tableModel_1.setRowCount(0);
		tableModel.setRowCount(0);
		tableModel_3.setRowCount(0);
		pharmacyList.forEach((Pharmacy) -> {
			tableModel.addRow(new Object[] { Pharmacy.getId(), Pharmacy.getTensanpham(), Pharmacy.getDvt(),
					Pharmacy.getGia(), Pharmacy.getSoluong(), Pharmacy.getHSD(), Pharmacy.getCachdung() });
		});
		pharmacyList.forEach((Pharmacy) -> {
			tableModel_1.addRow(new Object[] { Pharmacy.getId(), Pharmacy.getTensanpham(), Pharmacy.getDvt(),
					Pharmacy.getGia(), Pharmacy.getSoluong(), Pharmacy.getHSD(), Pharmacy.getCachdung() });
		});
		pharmacyList.forEach((Pharmacy) -> {
			tableModel_3.addRow(new Object[] { Pharmacy.getId(), Pharmacy.getTensanpham(), Pharmacy.getDvt(),
					Pharmacy.getGia(), Pharmacy.getSoluong(), Pharmacy.getHSD(), Pharmacy.getCachdung() });
		});
	}

	private void btnThemQuanLyThuoc(java.awt.event.ActionEvent evt) {

		String id = textFieldMaThuocQuanLyThuoc.getText();
		String Tensanpham = textFieldTenThuocQuanLyThuoc.getText();
		String Dvt = null;
		Dvt = comboBoxDVTQuanLyThuoc.getSelectedItem().toString();
		double Gia = Integer.parseInt(textFieldGiaQuanLyThuoc.getText());

		int Soluong = Integer.parseInt(textFieldSLuongQuanLyThuoc.getText());
		String hsd = textFieldHSDQuanLyThuoc.getText();
		String Cachdung = textFieldCDungQuanLyThuoc.getText();

		Pharmacy std = new Pharmacy(id, Tensanpham, Dvt, Gia, Soluong, Cachdung, hsd);
		PharmacyModify.insertThuoc(std);
	}

	///// Tìm theo tên
	private void btnTimTheoTen(java.awt.event.ActionEvent evt) {
		System.out.println("tim theo ");
		String input = textFieldTenThuocTraCuu.getText();
		if (input != null && input.length() > 0) {
			System.out.println("vào if");
			pharmacyList = PharmacyModify.findByFullname(input);

			tableModel.setRowCount(0);

			pharmacyList.forEach((Pharmacy) -> {
				System.out.println("check");
				tableModel.addRow(new Object[] { Pharmacy.getId(), Pharmacy.getTensanpham(), Pharmacy.getDvt(),
						Pharmacy.getGia(), Pharmacy.getSoluong(), Pharmacy.getHSD(), Pharmacy.getCachdung() });
			});
		}
	}

	private void btnTimTheoTen_1(java.awt.event.ActionEvent evt) {
		String input = txtTracuuthuoctheotenThanhToan.getText();
		if (input != null && input.length() > 0) {

			pharmacyList = PharmacyModify.findByFullname(input);

			tableModel_1.setRowCount(0);

			pharmacyList.forEach((Pharmacy) -> {

				tableModel_1.addRow(new Object[] { Pharmacy.getId(), Pharmacy.getTensanpham(), Pharmacy.getDvt(),
						Pharmacy.getGia(), Pharmacy.getSoluong(),Pharmacy.getHSD(), Pharmacy.getCachdung() });
			});

		}
	}

	public void btnQuanLyThuocTim(java.awt.event.ActionEvent evt) {
		String id = textFieldMaThuocQuanLyThuoc.getText();
		PharmacyModify.FindWithID(id);

		String ID = PharmacyModify.FindWithID(id).getId();
		String tensanpham = PharmacyModify.FindWithID(id).getTensanpham();
		String Dvt = PharmacyModify.FindWithID(id).getDvt();
		String hsd = PharmacyModify.FindWithID(id).getHSD();
		int i = 0;
		while (true) {
			if (Dvt.equals(model_DVT[i])) {
				break;
			}
			i++;
		}
		Double gia = PharmacyModify.FindWithID(id).getGia();
		Integer soluong = PharmacyModify.FindWithID(id).getSoluong();
		String Cachdung = PharmacyModify.FindWithID(id).getCachdung();

		textFieldMaThuocQuanLyThuoc.setText(ID);
		textFieldTenThuocQuanLyThuoc.setText(tensanpham);
		textFieldGiaQuanLyThuoc.setText(gia.toString());
		textFieldSLuongQuanLyThuoc.setText(soluong.toString());
		textFieldHSDQuanLyThuoc.setText(hsd);
		textFieldCDungQuanLyThuoc.setText(Cachdung);
		comboBoxDVTQuanLyThuoc.setSelectedIndex(i);
	}

	private void btnTimMaNhanVien(java.awt.event.ActionEvent evt) {
		String id = textFieldMaNV.getText();
		nhanvien n = PharmacyModify.FindbyMaNV(id);
		String hocvan = n.getHocvan();
		String gioitinh = n.getGioitinh();
		int i = 0, j = 0;
		while (true) {
			if (gioitinh.equalsIgnoreCase(model_gender[i])) {
				break;
			}
			i++;
		}
		while (true) {
			if (hocvan.equalsIgnoreCase(model_hocvan[j])) {
				break;
			}
			j++;
		}
		Integer sdt = n.getSodienthoai();

		textFieldTenNV.setText(n.getHovaten());
		textFieldNSinhNV.setText(n.getNgaysinh());
		this.gioitinh.setSelectedIndex(i);
		this.hocvan.setSelectedIndex(j);
		textFieldHSDQuanLyThuoc.setText(sdt.toString());
		textFieldSDTNhanVien.setText(sdt.toString());
		textFieldDChiNhanVien.setText(n.getDiachi());
	}

	private void btnThemNhanVien(java.awt.event.ActionEvent evt) {
		String id = textFieldMaNV.getText();
		String name = textFieldTenNV.getText();
		String ngsinh = textFieldNSinhNV.getText();
		String gender = gioitinh.getSelectedItem().toString();
		String hocvan = this.hocvan.getSelectedItem().toString();
		int sdt = Integer.parseInt(textFieldSDTNhanVien.getText());
		String dchi = textFieldDChiNhanVien.getText();

		nhanvien std = new nhanvien(id,name, ngsinh, gender, sdt, hocvan, dchi);
		PharmacyModify.insertNhanVien(std);
	}

	private void btnCapNhatQuanLyThuoc(java.awt.event.ActionEvent evt) {
		String id = textFieldMaThuocQuanLyThuoc.getText();
		String Tensanpham = textFieldTenThuocQuanLyThuoc.getText();
		String Dvt = comboBoxDVTQuanLyThuoc.getSelectedItem().toString();
		double Gia = Double.parseDouble(textFieldGiaQuanLyThuoc.getText());
		int Soluong = Integer.parseInt(textFieldSLuongQuanLyThuoc.getText());
		String Cachdung = textFieldCDungQuanLyThuoc.getText();
		Pharmacy std1 = new Pharmacy(Tensanpham, Dvt, Gia, Soluong, Cachdung);
//		System.out.println(std);
		PharmacyModify.updateThuoc(std1, id);
	}

	private void btnDelete(java.awt.event.ActionEvent evt) {

		String id = textFieldMaThuocQuanLyThuoc.getText();
		int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa loại thuốc này?");
		System.out.println("option : " + option);
		if (option == 0) {
			PharmacyModify.deleteThuoc(id);
			textFieldMaThuocQuanLyThuoc.setText("");
			textFieldTenThuocQuanLyThuoc.setText("");
			textFieldGiaQuanLyThuoc.setText("");
			textFieldSLuongQuanLyThuoc.setText("");
			textFieldCDungQuanLyThuoc.setText("");
			comboBoxDVTQuanLyThuoc.setSelectedIndex(-1);
		}
	}

	private void btnCapNhatNhanVien(ActionEvent e) {
		String id = textFieldMaNV.getText();
		String name = textFieldTenNV.getText();
		String nsinh= textFieldNSinhNV.getText();
		String gender=gioitinh.getSelectedItem().toString();
		String hvan=hocvan.getSelectedItem().toString();
		int sdt=Integer.parseInt(textFieldSDTNhanVien.getText());
		String dchi=textFieldDChiNhanVien.getText();
		
		nhanvien nv= new nhanvien(name,nsinh, gender, hvan, sdt, dchi);
		PharmacyModify.updateNhanVien(nv,id);
	}

	private void btnXoaNhanVien(ActionEvent e) {
		String name = textFieldTenNV.getText();
		PharmacyModify.deleteNhanVien(name);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
