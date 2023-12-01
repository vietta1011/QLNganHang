package QLTKNH;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class GiaoDich {
	private String magiaodich;

	private double sotien;
	private LocalDateTime thoigian_giaodich;
	private String loai_giaodich;
	private String taikhoan_giaodich;
	private String taikhoan_nhan;
	
	public GiaoDich(String magiaodich, double sotien, LocalDateTime thoigian_giaodich,String taikhoan_giaodich, String loai_giaodich) {
		this.magiaodich = magiaodich;
		this.sotien = sotien;
		this.thoigian_giaodich = thoigian_giaodich;
		this.taikhoan_giaodich = taikhoan_giaodich;
		this.loai_giaodich = loai_giaodich;
		
	}

	public GiaoDich(String magiaodich, double sotien, LocalDateTime thoigian_giaodich, String loai_giaodich, String taikhoan_giaodich,String taikhoan_nhan ) {
		this.magiaodich = magiaodich;
		this.sotien = sotien;
		this.thoigian_giaodich = thoigian_giaodich;
		this.loai_giaodich = loai_giaodich;
		this.taikhoan_giaodich = taikhoan_giaodich;
		this.taikhoan_nhan = taikhoan_nhan;
	}
	public String getMagiaodich() {
		return magiaodich;
	}
	public void setMagiaodich(String magiaodich) {
		this.magiaodich = magiaodich;
	}
	public double getSotien() {
		return sotien;
	}
	public void setSotien(double sotien) {
		this.sotien = sotien;
	}
	public LocalDateTime getThoiGian_giaodich() {
		return thoigian_giaodich;
	}
	public void setNgay_giaodich(LocalDateTime thoigian_giaodich) {
		this.thoigian_giaodich = thoigian_giaodich;
	}
	public String getLoai_giaodich() {
		return loai_giaodich;
	}
	public void setLoai_giaodich(String loai_giaodich) {
		this.loai_giaodich = loai_giaodich;
	}
	
	public String getTaikhoan_gui() {
		return taikhoan_giaodich;
	}
	public void setTaikhoan_gui(String taikhoan_gui) {
		this.taikhoan_giaodich = taikhoan_gui;
	}
	public String getTaikhoan_nhan() {
		return taikhoan_nhan;
	}
	public void setTaikhoan_nhan(String taikhoan_nhan) {
		this.taikhoan_nhan = taikhoan_nhan;
	}
@Override
	public String toString() {
	    return "Mã giao dịch: " + this.magiaodich +
	           "\nSố tiền: " + this.sotien +
	           "\nThời gian giao dịch: " + this.thoigian_giaodich +
	           "\nTài khoản giaodich " + this.taikhoan_giaodich +
	           "\nLoại giao dịch: " + this.loai_giaodich;
	           
	}
	
}