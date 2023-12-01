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
import QLTKNH.TaiKhoan;
import QLTKNH.TaiKhoanThanhToan;
import QLTKNH.TaiKhoanTietKiem;
import QLTKNH.TaiKhoanVayVon;

/* truy vấn csdl bảng taikhoanvayvon */

public class TaiKhoanVayVon_Dao implements Dao_interface<TaiKhoanVayVon>{
	public static TaiKhoanVayVon_Dao getInstance() {
		return new TaiKhoanVayVon_Dao();
	}
	@Override
	public int insert(TaiKhoanVayVon t) {
		int ketQua = 0;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "INSERT INTO taikhoanvayvon (sotaikhoan, tentaikhoan, sodutaikhoan, sotienvay, sotienlai, ngayvay) " +
			             "VALUES('" +t.getSotk() +"', '"+t.getTentk()+ "', "+t.getSodutk() +", "+t.getSoTienVay()+","+t.getSoTienLai()+",'"+t.getNgayVay()+"')";
			
             ketQua = st.executeUpdate(sql);
			
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			
			JDBC_util.closeConnection(cn);
			JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công!");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Số tài khoản đã tồn tại!");
		}
		
		return ketQua;
	}

	@Override
	public int update(TaiKhoanVayVon t) {
		int ketQua = 1;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "UPDATE taikhoanvayvon " +
			             "SET "   +
					     "sotaikhoan = '"+t.getSotk()+"'" +
			             ", tentaikhoan = '" +t.getTentk()+"'" +
					     ", sodutaikhoan = " +t.getSodutk()+"" +
                         ", sotienvay = "+t.getSoTienVay()+"" +
					     ", sotienlai = "+t.getSoTienLai()+"" +
                         ",ngayvay = '"+t.getNgayVay()+"'" +
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
	public int delete(TaiKhoanVayVon t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from taikhoanvayvon "+
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
	public ArrayList<TaiKhoanVayVon> selectAll() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taikhoanvayvon";
//			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				Double sotienvay = rs.getDouble("sotienvay");
				LocalDate ngayvay = rs.getDate("ngayvay").toLocalDate();
				
				
				TaiKhoanVayVon acc = new TaiKhoanVayVon(sotaikhoan, tentaikhoan, sodutaikhoan, ngayvay, sotienvay);
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
	public TaiKhoanVayVon selectByID(TaiKhoanVayVon t) {
		TaiKhoanVayVon ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taikhoanvayvon WHERE sotaikhoan ='" +t.getSotk()+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				Double sotienvay = rs.getDouble("sotienvay");
				LocalDate ngayvay = rs.getDate("ngayvay").toLocalDate();
				
				
				ketQua = new TaiKhoanVayVon(sotaikhoan, tentaikhoan, sodutaikhoan, ngayvay, sotienvay);
				
				
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
	public ArrayList<TaiKhoanVayVon> selectByCondition(String condition) {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taihkoanvayvon WHERE " + condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				Double sotienvay = rs.getDouble("sotienvay");
				LocalDate ngayvay = rs.getDate("ngayvay").toLocalDate();
				
				
				TaiKhoanVayVon acc = new TaiKhoanVayVon(sotaikhoan, tentaikhoan, sodutaikhoan, ngayvay, sotienvay);
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
	public TaiKhoanVayVon findBySoTK(String soTK) {
	    try { 
	    	Connection conn = JDBC_util.getConnection();
	        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM taikhoanvayvon WHERE sotaikhoan = ?");
	        stmt.setString(1, soTK);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				Double sotienvay = rs.getDouble("sotienvay");
				LocalDate ngayvay = rs.getDate("ngayvay").toLocalDate();
				
				
				TaiKhoanVayVon acc = new TaiKhoanVayVon(sotaikhoan, tentaikhoan, sodutaikhoan, ngayvay, sotienvay);
	            return acc;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
