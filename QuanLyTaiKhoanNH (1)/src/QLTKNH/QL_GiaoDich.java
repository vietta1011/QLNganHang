package QLTKNH;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;


public class QL_GiaoDich {
private static List<GiaoDich>  ds_giaodich; 

public QL_GiaoDich() {
	this.ds_giaodich = new ArrayList<>();
}
public static void themGiaoDich(GiaoDich gd) {
    try {
        ds_giaodich.add(gd);
    } catch (NullPointerException e) {
        System.out.println("Danh sách giao dịch không được để trống");
    } catch (Exception e) {
        System.out.println("Có lỗi xảy ra khi thêm giao dịch");
    }
}

public void xoaGiaoDich( String maGiaoDich) {
    try {
        ds_giaodich.removeIf(gd -> gd.getMagiaodich().equals(maGiaoDich));
    } catch (NullPointerException e) {
        System.out.println("Danh sách giao dịch không được để trống");
    } catch (Exception e) {
        System.out.println("Có lỗi xảy ra khi xóa giao dịch");
    }
}
public String timKiemGiaoDich(String maGiaoDich) {
    try {
        for (GiaoDich gd : ds_giaodich) {
            if (gd.getMagiaodich().equals(maGiaoDich)) {
                return gd.toString();
            }
        }
        System.out.println("Không tìm thấy giao dịch có mã " + maGiaoDich);
    } catch (NullPointerException e) {
        System.out.println("Danh sách giao dịch không được để trống");
    } catch (Exception e) {
        System.out.println("Có lỗi xảy ra khi tìm kiếm giao dịch");
    }
    return null;
}
public void duyetGiaoDich() {
    try {
        for (GiaoDich gd : ds_giaodich) {
            System.out.println(gd.toString());
        }
    } catch (NullPointerException e) {
        System.out.println("Danh sách giao dịch không được để trống");
    } catch (Exception e) {
        System.out.println("Có lỗi xảy ra khi duyệt giao dịch");
    }
}

}
