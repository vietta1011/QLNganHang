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

/* truy vấn csdl bảng taihkoantietkiem */

public class TaiKhoanTietKiem_Dao implements Dao_interface<TaiKhoanTietKiem>{
	public static TaiKhoanTietKiem_Dao getInstance() {
		return new TaiKhoanTietKiem_Dao();
	}

	@Override
	public int insert(TaiKhoanTietKiem t) {
		int ketQua = 0;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "INSERT INTO taikhoantietkiem (sotaikhoan, tentaikhoan, sodutaikhoan, ngaygui, laisuattietkiem) " +
			             "VALUES('" +t.getSotk() +"', '"+t.getTentk()+ "', "+t.getSodutk() +", '"+t.getNgayGui()+"',"+t.getLaiTietKiem()+")";
			
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
	public int update(TaiKhoanTietKiem t) {
		int ketQua = 1;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "UPDATE taikhoantietkiem " +
			             "SET "   +
					     "sotaikhoan = '"+t.getSotk()+"'" +
			             ", tentaikhoan = '" +t.getTentk()+"'" +
					     ", sodutaikhoan = " +t.getSodutk()+"" +
			             ", ngaygui = '" +t.getNgayGui() +"'"+
					     ", laisuattietkiem = " +t.getLaiTietKiem()+"" +
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
	public int delete(TaiKhoanTietKiem t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from taikhoantietkiem "+
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
	public ArrayList<TaiKhoanTietKiem> selectAll() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taikhoantietkiem";
		//	System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				LocalDate ngaygui = rs.getDate("ngaygui").toLocalDate();
				
			    TaiKhoanTietKiem acc = new TaiKhoanTietKiem(sotaikhoan, tentaikhoan, sodutaikhoan, ngaygui);
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
	public TaiKhoanTietKiem selectByID(TaiKhoanTietKiem t) {
		TaiKhoanTietKiem ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taikhoantietkiem WHERE sotaikhoan ='" +t.getSotk()+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				LocalDate ngaygui = rs.getDate("ngaygui").toLocalDate();
				
				ketQua = new TaiKhoanTietKiem(sotaikhoan, tentaikhoan, sodutaikhoan, ngaygui);
				
				
				
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
	public ArrayList<TaiKhoanTietKiem> selectByCondition(String condition) {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM taihkoantietkiem WHERE " + condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String sotaikhoan = rs.getString("sotaikhoan");
				String tentaikhoan = rs.getString("tentaikhoan");
				Double sodutaikhoan = rs.getDouble("sodutaikhoan");
				LocalDate ngaygui = rs.getDate("ngaygui").toLocalDate();
				
				TaiKhoanTietKiem acc = new TaiKhoanTietKiem(sotaikhoan, tentaikhoan, sodutaikhoan, ngaygui);
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
	public TaiKhoanTietKiem findBySoTK(String soTK) {
	    try { 
	    	Connection conn = JDBC_util.getConnection();
	        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM taikhoantietkiem WHERE sotaikhoan = ?");
	        stmt.setString(1, soTK);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String tenTK = rs.getString("tentaikhoan");
	            double soDu = rs.getDouble("sodutaikhoan");
	            LocalDate ngaygui = rs.getDate("ngaygui").toLocalDate();
	            TaiKhoanTietKiem taiKhoan = new TaiKhoanTietKiem(soTK, tenTK, soDu, ngaygui);
	            return taiKhoan;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
