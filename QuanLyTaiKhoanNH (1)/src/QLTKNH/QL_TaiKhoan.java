package QLTKNH;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class QL_TaiKhoan {
private Map<String, TaiKhoan> ds_taikhoan;
public QL_TaiKhoan() {
	this.ds_taikhoan = new HashMap<>();
}
public TaiKhoan timKiemTaiKhoan(String sotaikhoan) {
    try {
        if (ds_taikhoan.containsKey(sotaikhoan)) {
            return ds_taikhoan.get(sotaikhoan);
        }
    } catch (NullPointerException e) {
        System.out.println("Danh sách tài khoản không được để trống");
    } catch (Exception e) {
        System.out.println("Có lỗi xảy ra khi tìm kiếm tài khoản");
    }
    return null;
}

public Boolean kiemtra_TaiKhoan(String sotaikhoan) {
	TaiKhoan tk = ds_taikhoan.get(sotaikhoan);
	if(tk != null && tk.getSotk().equals(sotaikhoan) ) {
		return true;
	}
	return false;
}

public void them_TaiKhoan(TaiKhoan tk) {
	if(ds_taikhoan.containsKey(tk.getSotk())) {
		throw new IllegalArgumentException("Tài Khoản Đã tồn tại");
	}
	ds_taikhoan.put(tk.getSotk(), tk);
}
public void xoa_TaiKhoan(String sotk) {
	if(!ds_taikhoan.containsKey(sotk)) {
		throw new IllegalArgumentException("Tài Khoản không tồn tại");
	}
	ds_taikhoan.remove(sotk);
}
public void capnhatThongTin_TaiKhoan(TaiKhoan tk,String sotk, String tentk) {
	
	if(this.timKiemTaiKhoan(tk.getSotk()).equals(null)) {
		System.out.println("Không tìm thấy tài khoản có số tk hợp lệ");
	}
	else {
	   tk.getSotk();
	   tk.setTentk(tentk);
	   ds_taikhoan.put(sotk, tk);
	}
}
public void duyetDanhSachTaiKhoan() {
    for(Map.Entry<String, TaiKhoan> entry : ds_taikhoan.entrySet()) {
        System.out.println(entry.getValue());
    }
}

}
