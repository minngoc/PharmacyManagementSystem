package pharmacy;

import java.awt.JobAttributes;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import doanhthu.doanhthu;
import nhanvien.nhanvien;

/**
 * CRUD (insert, update, delete, findAll)
 */
public class PharmacyModify {
    private static Pharmacy std;
    private static doanhthu std1;
    private static nhanvien std2;

 	public static List<Pharmacy> findAll() {
        List<Pharmacy> pharmacyList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach thuoc
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "select * from pharmacy";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
            	Pharmacy std = new Pharmacy(resultSet.getString("mathuoc"), 
                        resultSet.getString("tensanpham"), resultSet.getString("dvt"), 
                        resultSet.getDouble("gia"), resultSet.getInt("soluong"),resultSet.getString("hansudung"), 
                        resultSet.getString("cachdung"));
            	pharmacyList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pharmacyList;
    }
 	
    public static Pharmacy FindWithID(String id) {
    	//List<Pharmacy> pharmacyList = new ArrayList<>();
    	Connection connection = null;
        PreparedStatement statement = null;
        Pharmacy std = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");

            String query ="select * from pharmacy where `mathuoc` =?";
            statement = connection.prepareCall(query);
            
            statement.setString(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
            	 std = new Pharmacy(resultSet.getString("mathuoc"), 
                        resultSet.getString("tensanpham"), resultSet.getString("dvt"), 
                        resultSet.getDouble("gia"), resultSet.getInt("soluong"),resultSet.getString("hansudung"), 
                        resultSet.getString("cachdung"));
            	//pharmacyList.add(std);
            	
            }
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "MÃ THUỐC NÀY KHÔNG TỒN TẠI!","TÌM THẤT BẠI!",JOptionPane.ERROR_MESSAGE);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		return std;
    }
    
    public static void insertThuoc(Pharmacy std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach pharmacy de thuc hien truy van query
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "insert into pharmacy(mathuoc,tensanpham, dvt, gia, soluong, cachdung, hansudung) values(?,?, ?, ?, ?, ?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getId());
            statement.setString(2, std.getTensanpham());
            statement.setString(3, std.getDvt());
            statement.setDouble(4, std.getGia());
            statement.setInt(5, std.getSoluong());
            statement.setString(6, std.getCachdung());
            statement.setString(7,std.getHSD());
            
            statement.execute();
            System.out.println("Them thanh cong");
            JOptionPane.showMessageDialog(null, "THÊM THUỐC THÀNH CÔNG", "THÔNG TIN",
					JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "THUỐC NÀY ĐÃ TỒN TẠI!","THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void updateThuoc(Pharmacy std, String id) {
    	
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach pharmacy
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy_management", "root", "");
            
            //query
            String sql = "update pharmacy set tensanpham=?,dvt=?,gia=?,soluong=?,cachdung=? where mathuoc = ?";
            
            statement = connection.prepareCall(sql);
            statement.setString(1, std.getTensanpham());
            statement.setString(2, std.getDvt());
            statement.setDouble(3, std.getGia());
            statement.setInt(4, std.getSoluong());
            statement.setString(5, std.getCachdung());
            statement.setString(6, id);
            //statement.setString(6, id);
            
            statement.execute();
            JOptionPane.showMessageDialog(null, "CẬP NHẬT THUỐC THÀNH CÔNG", "THÔNG TIN",
					JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "THUỐC NÀY KHÔNG TỒN TẠI!","THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void deleteThuoc(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach pharmacy
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "delete from pharmacy where `mathuoc` = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<Pharmacy> findByFullname(String fullname) {
        List<Pharmacy> pharmacyList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "select * from pharmacy where tensanpham like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
            	Pharmacy std = new Pharmacy(resultSet.getString("mathuoc"), 
                        resultSet.getString("tensanpham"), resultSet.getString("dvt"), 
                        resultSet.getDouble("gia"), resultSet.getInt("soluong"),resultSet.getString("hansudung"), 
                        resultSet.getString("cachdung"));
            	pharmacyList.add(std);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "KHÔNG TÌM THẤY THUỐC","THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return pharmacyList;
    }
    
    public static List<doanhthu> findByDate(String fullname) {
        List<doanhthu> doanthulist = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "select * from doanhthu where ngay like ? order by ngay desc";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
            	doanhthu std = new doanhthu(resultSet.getString("ngay"), 
                        resultSet.getFloat("total"));
            	doanthulist.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return doanthulist;
    }

    
    public static void insertNhanVien(nhanvien std) {
    	Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach pharmacy de thuc hien truy van query
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "insert into nhanvien(id,tennhanvien, ngaysinh, gioitinh, hocvan, sodienthoai, diachi) values(?,?,?,?,?,?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getID());
            statement.setString(2, std.getHovaten());
            statement.setString(3, std.getNgaysinh());
            statement.setString(4, std.getGioitinh());
            statement.setString(5, std.getHocvan());
            statement.setInt(6, std.getSodienthoai());
            statement.setString(7, std.getDiachi());
            
            statement.execute();
            System.out.println("Them thanh cong");
            JOptionPane.showMessageDialog(null, "THÊM NHÂN VIÊN THÀNH CÔNG", "THÔNG TIN",
					JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NHÂN VIÊN NÀY ĐÃ TỒN TẠI!","THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void updateNhanVien(nhanvien nv, String id) {
    	
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach pharmacy
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacy_management", "root", "");
            
            //query
            String sql = "update nhanvien set tennhanvien=?,ngaysinh=?,gioitinh=?,hocvan=?,sodienthoai=?,diachi=? where id = ?";
            
            statement = connection.prepareCall(sql);
            statement.setString(1, nv.getHovaten());
            statement.setString(2, nv.getNgaysinh());
            statement.setString(3, nv.getGioitinh());
            statement.setString(4, nv.getHocvan());
            statement.setInt(5, nv.getSodienthoai());
            statement.setString(6, nv.getDiachi());
            statement.setString(7, id);
            
            statement.execute();
            JOptionPane.showMessageDialog(null, "CẬP NHẬT NHÂN VIÊN THÀNH CÔNG", "THÔNG TIN",
					JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "KHÔNG CÓ NHÂN VIÊN NÀY HOẶC\n LỖI ĐỊNH DẠNG DỮ LIỆU!","THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
	public static void deleteNhanVien(String tennhanvien) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach pharmacy
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "delete from nhanvien where `tennhanvien` = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, tennhanvien);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
	public static List<nhanvien> findallNhanVien() {
		List<nhanvien> nhanvienlist = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach thuoc
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "select * from nhanvien order by id";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            int stt=1;
            while (resultSet.next()) {                
               	nhanvien std = new nhanvien(resultSet.getString("id"),resultSet.getString("tennhanvien"), 
                           resultSet.getString("ngaysinh"), resultSet.getString("gioitinh"), 
                           resultSet.getInt("sodienthoai"), resultSet.getString("hocvan"),
                           resultSet.getString("diachi"));
               	nhanvienlist.add(std);
               	stt++;
               }
        } catch (SQLException ex) {
            Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
        }
		return nhanvienlist;
	}

	public static nhanvien FindbyMaNV(String id) {
		Connection connection = null;
        PreparedStatement statement = null;
        nhanvien std = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");

            String query ="select * from nhanvien where `id` =?";
            statement = connection.prepareCall(query);
            
            statement.setString(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
            	 std = new nhanvien(resultSet.getString("id"),resultSet.getString("tennhanvien"), 
                        resultSet.getString("ngaysinh"), resultSet.getString("gioitinh"), 
                        resultSet.getInt("sodienthoai"), resultSet.getString("hocvan"),resultSet.getString("diachi"));
            	
            }
		} catch (SQLException ex) {
            Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PharmacyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		return std;
	}
}