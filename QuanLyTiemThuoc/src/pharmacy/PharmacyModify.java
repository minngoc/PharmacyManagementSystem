package pharmacy;

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

/**
 * CRUD (insert, update, delete, findAll)
 */
public class PharmacyModify {
    private static Pharmacy std;

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
                        resultSet.getDouble("gia"), resultSet.getInt("soluong"), 
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
        //ket thuc.
        
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
                        resultSet.getDouble("gia"), resultSet.getInt("soluong"), 
                        resultSet.getString("cachdung"));
            	//pharmacyList.add(std);
            	
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
    
    public static void insert(Pharmacy std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach pharmacy de thuc hien truy van query
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management", "root", "");
            
            //query
            String sql = "insert into pharmacy(mathuoc,tensanpham, dvt, gia, soluong, cachdung) values(?,?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getId());
            statement.setString(2, std.getTensanpham());
            statement.setString(3, std.getDvt());
            statement.setDouble(4, std.getGia());
            statement.setInt(5, std.getSoluong());
            statement.setString(6, std.getCachdung());
            
            statement.execute();
            System.out.println("Them thanh cong");
            
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
    
    public static void update(Pharmacy std, String id) {
    	
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
    
    public static void delete(String id) {
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
                        resultSet.getDouble("gia"), resultSet.getInt("soluong"), 
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
        //ket thuc.
        
        return pharmacyList;
    }
}