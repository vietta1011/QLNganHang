package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Database.JDBC_util;
import QLTKNH.NguoiDung;
import QLTKNH.TaiKhoan;

/* truy vấn csdl bảng NguoiDung */

public class NguoiDung_Dao implements Dao_interface<NguoiDung>{
    
	public static NguoiDung_Dao getInstance() {
		return new NguoiDung_Dao();
	}
	
	@Override
	public int insert(NguoiDung t) {
		int ketQua = 0;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "INSERT INTO nguoidung (cccd, tennguoidung, sdt, ngaysinh, taikhoan) " +
			             "VALUES('" +t.getCCCD() +"', '"+t.getTenNguoidung()+ "', '"+t.getSdt() +"', '"+t.getNgaySinh()+"', '"+t.getSoTk_nguoidung()+"')";
			
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
	public int update(NguoiDung t) {
		int ketQua = 1;
		try {
			Connection cn = JDBC_util.getConnection();
			Statement st = cn.createStatement();
			
			String sql = "UPDATE nguoidung " +
			             "SET "   +
					     "cccd= '"+t.getCCCD()+"'" +
			             ", tennguoidung = '" +t.getTenNguoidung()+"'" +
					     ", sdt = '" +t.getSdt()+"'" +
			             ", ngaysinh = '" +t.getNgaySinh()+"'" +
					     ", taikhoan = '"+t.getSoTk_nguoidung()+"'" +
			             "WHERE cccd = '"+t.getCCCD()+"\'";
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
	public int delete(NguoiDung t) {
		
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from nguoidung "+
						 " WHERE cccd='"+t.getCCCD()+"'";
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
	public ArrayList<NguoiDung> selectAll() {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nguoidung";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String cccd = rs.getString("CCCD");
				String tennguoidung = rs.getString("tennguoidung");
				String sdt = rs.getString("sdt");
				LocalDate ngaysinh = rs.getDate("ngaySinh").toLocalDate();
				String taikhoan = rs.getString("taikhoan");

				
				NguoiDung user = new NguoiDung(cccd, tennguoidung, sdt, ngaysinh, taikhoan);
				ketQua.add(user);
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
	public NguoiDung selectByID(NguoiDung t) {
		NguoiDung ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nguoidung WHERE cccd ='" +t.getCCCD()+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String cccd = rs.getString("CCCD");
				String tennguoidung = rs.getString("tennguoidung");
				String sdt = rs.getString("sdt");
				LocalDate ngaysinh = rs.getDate("ngaySinh").toLocalDate();
				String taikhoan = rs.getString("taikhoan");

				
				ketQua = new NguoiDung(cccd, tennguoidung, sdt, ngaysinh, taikhoan);
				
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
	public ArrayList<NguoiDung> selectByCondition(String condition) {
		ArrayList ketQua = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBC_util.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nguoidung WHERE " + condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String cccd = rs.getString("CCCD");
				String tennguoidung = rs.getString("tennguoidung");
				String sdt = rs.getString("sdt");
				LocalDate ngaysinh = rs.getDate("ngaySinh").toLocalDate();
				String taikhoan = rs.getString("taikhoan");

				
				NguoiDung user = new NguoiDung(cccd, tennguoidung, sdt, ngaysinh, taikhoan);
				ketQua.add(user);
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
