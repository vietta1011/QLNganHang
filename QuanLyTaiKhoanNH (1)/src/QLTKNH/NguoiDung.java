package QLTKNH;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class NguoiDung {
private String CCCD;
private String sdt;
private TaiKhoan tk_nguoidung;
private String tenNguoidung;
private LocalDate NgaySinh;
private String sotaikhoan;

public NguoiDung(String CCCD, String tenNguoidung , String sdt, LocalDate NgaySinh, TaiKhoan tk_nguoidung) {
	this.CCCD = CCCD;
	this.sdt = sdt;
	this.tk_nguoidung = tk_nguoidung;
	this.tenNguoidung = tenNguoidung;
	this.NgaySinh = NgaySinh;
}

public NguoiDung(String CCCD,String tenNguoidung, String sdt , LocalDate NgaySinh, String sotk_nguoidung) {
	this.CCCD = CCCD;
	this.sdt = sdt;
	sotaikhoan = sotk_nguoidung;
	this.tenNguoidung = tenNguoidung;
	this.NgaySinh = NgaySinh;
	}
public String getCCCD() {
	return CCCD;
}
public void setCCCD(String CCCD) {
	this.CCCD = CCCD;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}


public String getTenNguoidung() {
	return tenNguoidung;
}
public void setTenNguoidung(String tenNguoidung) {
	this.tenNguoidung = tenNguoidung;
}
public LocalDate getNgaySinh() {
	return NgaySinh;
}
public void setNgaySinh(LocalDate ngaySinh) {
	NgaySinh = ngaySinh;
}
public TaiKhoan getTk_nguoidung() {
	return tk_nguoidung;
}
public void setTk_nguoidung(TaiKhoan tk_nguoidung) {
	this.tk_nguoidung = tk_nguoidung;
}
public String getSoTk_nguoidung() {
	return sotaikhoan;
}
@Override
public int hashCode() {
	return Objects.hash(NgaySinh, tenNguoidung,sdt, CCCD, tk_nguoidung);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	NguoiDung other = (NguoiDung) obj;
	return Objects.equals(NgaySinh, other.NgaySinh) && Objects.equals(sdt, other.sdt)
			&& Objects.equals(tenNguoidung, other.tenNguoidung) && Objects.equals(CCCD, other.CCCD)
			&& Objects.equals(tk_nguoidung, other.tk_nguoidung);
}
@Override
public String toString() {
	return "NguoiDung [CCCD=" +CCCD + ", tenNguoidung=" + tenNguoidung + ", sotaikhoan=" + sotaikhoan + ", Sdt="
			+sdt  + ", NgaySinh=" + NgaySinh + "]";
}


}