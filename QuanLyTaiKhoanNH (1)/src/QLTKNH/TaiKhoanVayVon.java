package QLTKNH;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Dao.GiaoDich_Dao;

public class TaiKhoanVayVon extends TaiKhoan{
	private final static int PHI_DICH_VU = 1000;
	private final static double LAI_SUAT_VAY = 0.1;
	private double soTienVay;
	private double soTienLai;
	private LocalDate ngayVay;
	private String loaitk;

	public TaiKhoanVayVon(String sotk, String tentk, double sodutk, LocalDate ngayVay, double soTienVay) {
		super(sotk, tentk, sodutk);
		this.soTienVay = soTienVay;
		this.ngayVay = ngayVay;
	}
	public TaiKhoanVayVon(String sotk, String tentk, double sodutk, String loaitk) {
		super(sotk, tentk, sodutk);
        this.loaitk = loaitk;
		
	}
	public LocalDate getNgayVay() {
        return ngayVay;
    }

    public void setNgayVay(LocalDate ngayVay) {
        this.ngayVay = ngayVay;
    }

    public double getSoTienVay() {
        return soTienVay;
    }

    public void setSoTienVay(double soTienVay) {
        this.soTienVay = soTienVay;
    }

    public double getSoTienLai() {
        return soTienLai;
    }

    public void setSoTienLai(double soTienLai) {
        this.soTienLai = soTienLai;
    }
    
    public static double getLaiSuatVay() {
    	return LAI_SUAT_VAY;
    }
    
    /* phương thức tính tiền lãi phải trả */

	public void tinhTienLai(LocalDate ngayTraNo) {
		long soNgayVay = ngayTraNo.toEpochDay() - ngayVay.toEpochDay();
		LocalDate ngayHanMuc = ngayVay.plusMonths(6);
		long soNgayHanChoPhep = ngayHanMuc.toEpochDay() - ngayVay.toEpochDay();
		double laiPhaiTra = soTienVay * LAI_SUAT_VAY * soNgayVay / 365;
        double laiabs =Math.abs(laiPhaiTra);
        long lailamtron = Math.round(laiabs);
        soTienLai += lailamtron;
        setSodutk(getSodutk() + soTienVay);
		if(soNgayVay <= soNgayHanChoPhep) {
	        if(getSodutk() < (lailamtron + soTienVay)) {
	        	System.out.println("Tổng số tiền còn lại phải trả là: " + Math.abs(getSodutk() - (lailamtron + soTienVay)));
	        	System.out.println("số dư tài khoản là: 0 ");
	        	setSodutk(0);
	        }
	        else {
	        	setSodutk(getSodutk() - (lailamtron + soTienVay));
	            System.out.println("Số dư tài khoản còn lại là: " + getSodutk());
	        }
		}
		else {
			long soNgayTraNoMuon = soNgayVay - soNgayHanChoPhep;
			double phatQuaHan = soTienVay * 0.05 * soNgayTraNoMuon / 365;
			long phatLamTron = Math.round(phatQuaHan);
			System.out.println("Tài khoản vay vốn đã quá hạn " + soNgayTraNoMuon + " ngày.");
			if(getSodutk() < (phatLamTron + soTienVay + lailamtron)) {
				System.out.println("Tổng số tiền còn lại phải trả là: " + Math.abs(getSodutk() - lailamtron - soTienVay - phatLamTron));
				System.out.println("số dư tài khoản là: 0 ");
				setSodutk(0);
			}
			else {
				setSodutk(getSodutk() - (lailamtron + soTienVay + phatLamTron));
	            System.out.println("Số dư tài khoản còn lại là: " + getSodutk());
			}
		}        
        GiaoDich gd = new GiaoDich("tinhtienlai" + RandomNumberExample.RandomNumber(), lailamtron, LocalDateTime.now(), getSotk(),"Tính tiền lãi");
       GiaoDich_Dao.getInstance().insert(gd);
	}
	
	@Override
	public void napTien(double soTien) {
		if(soTien <= 0) {
			System.out.println("Số tiền nhập phải lớn hơn 0!");
		} else {
			setSodutk(getSodutk() + soTien);
			System.out.println("Nạp tiền thành công!");
			System.out.println("- Số dư tài khoản: " + getSodutk());
			GiaoDich gd = new GiaoDich("napTien" + RandomNumberExample.RandomNumber(), soTien, LocalDateTime.now(), getSotk(),"Nạp Tiền Vay Vốn");
			GiaoDich_Dao.getInstance().insert(gd);
		}
	}

	@Override
	public void rutTien(double soTien) {
		if(soTien <= 0) {
			System.out.println("Số tiền nhập phải lớn hơn 0!");
		} else if(soTien <= (getSodutk() - PHI_DICH_VU)) {
			setSodutk(getSodutk() - soTien - PHI_DICH_VU);
			System.out.println("Rút tiền thành công!");
	        System.out.println("- Phí dịch vụ: " + PHI_DICH_VU);
	        System.out.println("- Số dư tài khoản: " + getSodutk());
	        GiaoDich gd = new GiaoDich("rutTien" + RandomNumberExample.RandomNumber(), soTien, LocalDateTime.now(), getSotk(),"Rút Tiền Vay Vốn");
	        GiaoDich_Dao.getInstance().insert(gd);
		} else {
			System.out.println("Số dư không đủ để thực hiện rút tiền!");
		}
	}

	@Override
	public void chuyenKhoan(TaiKhoan nguonNhan, double soTien) {
		System.out.println("Không thể chuyển tiền từ tài khoản vay vốn.");
	}

	

	@Override
	public String toString() {
		return "TaiKhoanVayVon [LAI_SUAT_VAY = " + LAI_SUAT_VAY + 
				", soTienVay = " + soTienVay + 
				", soTienLai = " + soTienLai + 
				", Sotk = " + getSotk() + 
				", Tentk = " + getTentk() + 
				", Sodutk = " + getSodutk() + "]";
	}

	@Override
	protected void congLai() {
		// TODO Auto-generated method stub
		
	}
}
