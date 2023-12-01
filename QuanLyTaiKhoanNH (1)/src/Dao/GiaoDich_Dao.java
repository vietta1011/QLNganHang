package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Database.JDBC_util;
import QLTKNH.GiaoDich;
import QLTKNH.NguoiDung;

/* truy vấn csdl bảng GiaoDich */

public class GiaoDich_Dao implements Dao_interface<GiaoDich>{
	public static GiaoDich_Dao getInstance() {
		return new GiaoDich_Dao();
	}
	@Override
	public int insert(GiaoDich t) {
		int ketQua = 0;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "INSERT INTO giaodich (magiaodich, sotien, thoigiangiaodich, taikhoangiaodich, taikhoannhan, loaigiaodich) " +
			             "VALUES('" +t.getMagiaodich() +"', "+t.getSotien()+ ", '"+t.getThoiGian_giaodich() +"', '"+t.getTaikhoan_gui()+"', '"+t.getTaikhoan_nhan()+"','"+t.getLoai_giaodich()+"')";
			
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
	public int update(GiaoDich t) {
		int ketQua = 1;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "UPDATE giaodich " +
			             "SET "   +
					     " magiaodich = '"+t.getMagiaodich()+"'" +
			             ", sotien = '" +t.getSotien()+"'" +
					     ", thoigiangiaodich = '" +t.getThoiGian_giaodich()+"'" +
			             ", taikhoangiaodich = '" +t.getTaikhoan_gui()+"'" +
					     ", taikhoannhan = '"+t.getTaikhoan_nhan()+"'" +
			             ",loaigiaodich = '" +t.getLoai_giaodich()+"'"+
			             "WHERE matgiaodich = '"+t.getMagiaodich()+"\'";
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
	public int delete(GiaoDich t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from giaodich "+
						 " WHERE magiaodich='"+t.getMagiaodich()+"'";
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
	public ArrayList<GiaoDich> selectAll() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM giaodich";
//			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String magiaodich = rs.getString("magiaodich");
				Double sotien = rs.getDouble("sotien");
				LocalDateTime thoigiangiaodich = rs.getTimestamp("thoigiangiaodich").toLocalDateTime(); 
				String taikhoangiaodich = rs.getString("taikhoangiaodich");
				String taikhoannhan = rs.getString("taikhoannhan");
				String loaigiaodich = rs.getString("loaigiaodich");

				
				GiaoDich gd = new GiaoDich(magiaodich, sotien, thoigiangiaodich, taikhoangiaodich, loaigiaodich, taikhoannhan);
				ketQua.add(gd);
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
	public GiaoDich selectByID(GiaoDich t) {
		GiaoDich ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nguoidung WHERE magiaodich ='" +t.getMagiaodich()+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String magiaodich = rs.getString("magiaodich");
				Double sotien = rs.getDouble("sotien");
				LocalDateTime thoigiangiaodich = rs.getTimestamp("thoigiangiaodich").toLocalDateTime(); 
				String taikhoangiaodich = rs.getString("taikhoangiaodich");
				String taikhoannhan = rs.getString("taikhoannhan");
				String loaigiaodich = rs.getString("loaigiaodich");

				
				ketQua = new GiaoDich(magiaodich, sotien, thoigiangiaodich, taikhoangiaodich, loaigiaodich, taikhoannhan);
				
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
	public ArrayList<GiaoDich> selectByCondition(String condition) {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM giaodich WHERE " + condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String magiaodich = rs.getString("magiaodich");
				Double sotien = rs.getDouble("sotien");
				LocalDateTime thoigiangiaodich = rs.getTimestamp("thoigiangiaodich").toLocalDateTime(); 
				String taikhoangiaodich = rs.getString("taikhoangiaodich");
				String taikhoannhan = rs.getString("taikhoannhan");
				String loaigiaodich = rs.getString("loaigiaodich");

				
				GiaoDich gd = new GiaoDich(magiaodich, sotien, thoigiangiaodich, taikhoangiaodich, loaigiaodich, taikhoannhan);
				ketQua.add(gd);
			}
			
			// Bước 5:
			JDBC_util.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
