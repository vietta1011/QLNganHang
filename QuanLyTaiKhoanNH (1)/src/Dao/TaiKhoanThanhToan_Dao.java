package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.JDBC_util;
import QLTKNH.NguoiDung;
import QLTKNH.TaiKhoan;
import QLTKNH.TaiKhoanThanhToan;

/* truy vấn csdl bảng taikhoanthanhtoan*/

public class TaiKhoanThanhToan_Dao implements Dao_interface<TaiKhoan> {
	public static TaiKhoanThanhToan_Dao getInstance() {
		return new TaiKhoanThanhToan_Dao();
	}
	@Override
	public int insert(TaiKhoan t) {
		int ketQua = 0;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "INSERT INTO taikhoanthanhtoan (sotaikhoan, tentaikhoan, sodutaikhoan) " +
			             "VALUES('" +t.getSotk() +"', '"+t.getTentk()+ "', "+t.getSodutk() +")";
			
             ketQua = st.executeUpdate(sql);
			
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công!");
			JDBC_util.closeConnection(cn);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Số tài khoản đã tồn tại!");
		}
		
		return ketQua;
	}

	

	@Override
	public int update(TaiKhoan t) {
		int ketQua = 1;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "UPDATE taikhoanthanhtoan " +
			             "SET "   +
					     "sotaikhoan = '"+t.getSotk()+"'" +
			             ", tentaikhoan = '" +t.getTentk()+"'" +
					     ", sodutaikhoan = " +t.getSodutk()+"" +
			             "WHERE sotaikhoan = '"+t.getSotk()+"\'";
			 ;
             ketQua = st.executeUpdate(sql);
			
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			
			JDBC_util.closeConnection(cn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(TaiKhoan t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from taikhoanthanhtoan "+
						 " WHERE sotaikhoan ='"+t.getSotk()+"'";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBC_util.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<TaiKhoan> selectAll() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taikhoanthanhtoan";
//			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				
				
				TaiKhoan acc = new TaiKhoanThanhToan(sotaikhoan, tentaikhoan, sodutaikhoan);
				ketQua.add(acc);
			}
			
			// Bước 5:
			JDBC_util.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public TaiKhoan selectByID(TaiKhoan t) {
		TaiKhoan ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taikhoanthanhtoan WHERE sotaikhoan ='" +t.getSotk()+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");

				
				ketQua = new TaiKhoanThanhToan(sotaikhoan, tentaikhoan, sodutaikhoan);
				
			}
			
			// Bước 5:
			JDBC_util.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<TaiKhoan> selectByCondition(String condition) {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taikhoanthanhtoan WHERE " + condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				
				
				TaiKhoan acc = new TaiKhoanThanhToan(sotaikhoan, tentaikhoan, sodutaikhoan);
				ketQua.add(acc);
			}
			
			// Bước 5:
			JDBC_util.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	public TaiKhoan findBySoTK(String soTK) {
	    try { 
	    	Connection conn = JDBC_util.getConnection();
	        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM taikhoanthanhtoan WHERE sotaikhoan = ?");
	        stmt.setString(1, soTK);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String tenTK = rs.getString("tentaikhoan");
	            double soDu = rs.getDouble("sodutaikhoan");
	            TaiKhoan taiKhoan = new TaiKhoanThanhToan(soTK, tenTK, soDu);
	            return taiKhoan;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
	    return null;
	}

}
