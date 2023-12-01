package QLTKNH;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class QL_NguoiDung {
private Map<String, NguoiDung> ds_NguoiDung;

public QL_NguoiDung() {
	this.ds_NguoiDung = new HashMap<>();
}
public NguoiDung thongtin_NguoiDung(String CCCD) {
	if(ds_NguoiDung.containsKey(CCCD)) {
		return ds_NguoiDung.get(CCCD);
	}
	return null;
}

public boolean kiemTraNguoiDungTonTai(String CCCD) {
    return ds_NguoiDung.containsKey(CCCD);
}

public void them_NguoiDung(NguoiDung nguoidung) {
	if(ds_NguoiDung.containsKey(nguoidung.getCCCD())) {
		throw new IllegalArgumentException("Tài Khoản Đã tồn tại");
	}
	ds_NguoiDung.put(nguoidung.getCCCD(), nguoidung);
}
public Map<String, NguoiDung> getDs_NguoiDung() {
	return ds_NguoiDung;
}
public void setDs_NguoiDung(Map<String, NguoiDung> ds_NguoiDung) {
	this.ds_NguoiDung = ds_NguoiDung;
}
public void xoa_NguoiDung(String CCCD) {
	if(!ds_NguoiDung.containsKey(CCCD)) {
		throw new IllegalArgumentException("Tài Khoản không tồn tại");
	}
	ds_NguoiDung.remove(CCCD);
}
public void capnhatThongTin_NguoiDung(NguoiDung nguoidung,String CCCD, String sdt, String TenNguoiDung, LocalDate ngaysinh) {
	
	if(this.thongtin_NguoiDung(nguoidung.getCCCD()).equals(null)) {
		System.out.println("Không tìm thấy người dùng có tên tk hợp lệ");
	}
	else {
	   nguoidung.setCCCD(CCCD);
	   nguoidung.setSdt(sdt);
	   nguoidung.setTenNguoidung(TenNguoiDung);
	   nguoidung.setNgaySinh(ngaysinh);
	   
	   ds_NguoiDung.put(CCCD, nguoidung);
	}
}

}