package QLTKNH;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        QL_GiaoDich list_gd = new QL_GiaoDich();
        // Test TaiKhoanThanhToan class
        TaiKhoan taiKhoanThanhToan = new TaiKhoanThanhToan("222", "Tran Thi B", 2000000);
        System.out.println(taiKhoanThanhToan);
        System.out.println();
        taiKhoanThanhToan.napTien(300000);
        System.out.println(taiKhoanThanhToan);
        System.out.println();
        taiKhoanThanhToan.rutTien(700000);
        System.out.println(taiKhoanThanhToan);
        System.out.println();
        taiKhoanThanhToan.rutTien(-700000);
        System.out.println(taiKhoanThanhToan);
        System.out.println();

        // Test TaiKhoanTietKiem class
        LocalDate ngayGui = LocalDate.now();
        TaiKhoan taiKhoanTietKiem = new TaiKhoanTietKiem("333", "Le Van C", 5000000, ngayGui);
        System.out.println(taiKhoanTietKiem);
        taiKhoanTietKiem.congLai();
        System.out.println(taiKhoanTietKiem);
        System.out.println();

        // Test TaiKhoanVayVon class
        LocalDate ngayVay = LocalDate.of(2021, 1, 1);
        TaiKhoanVayVon taiKhoanVayVon = new TaiKhoanVayVon("1234567890", "Nguyen Van A", 1000000, ngayVay, 500000);
        // In thông tin tài khoản vay vốn
        System.out.println("Thông tin tài khoản vay vốn:");
        System.out.println("Số tài khoản: " + taiKhoanVayVon.getSotk());
        System.out.println("Tên tài khoản: " + taiKhoanVayVon.getTentk());
        System.out.println("Số dư tài khoản: " + taiKhoanVayVon.getSodutk());
        System.out.println("Ngày vay: " + taiKhoanVayVon.getNgayVay());
        System.out.println("Số tiền vay: " + taiKhoanVayVon.getSoTienVay());
        System.out.println("Lãi suất: " + taiKhoanVayVon.getLaiSuatVay());
        // Tính tiền lãi phải trả
        LocalDate ngayTraNo = LocalDate.of(2021, 6, 1);
        taiKhoanVayVon.tinhTienLai(ngayTraNo);
        System.out.println();
        // Tài khoản không có tiền trả đúng hạn
        TaiKhoanVayVon tkdh = new TaiKhoanVayVon("TK001", "Nguyen Van D", 10000, ngayVay, 500000);  
        tkdh.tinhTienLai(ngayTraNo);
        System.out.println();
        // Tài khoản bị quá hạn
        LocalDate ngayVayMuon = LocalDate.of(2021, 12, 1);
        TaiKhoanVayVon tkvv = new TaiKhoanVayVon("TK001", "Nguyen Van D", 1000000, ngayVayMuon, 500000);  
        LocalDate ngayBiNo = LocalDate.of(2023, 4, 13);
        tkvv.tinhTienLai(ngayBiNo);
        System.out.println();
        // Tài khoản không có tiền trả bị quá hạn
        TaiKhoanVayVon khongcotien = new TaiKhoanVayVon("ngheo", "Nguyen Ngheo", 0, ngayVayMuon, 500000);
        khongcotien.tinhTienLai(ngayBiNo);
        System.out.println();
    }
}