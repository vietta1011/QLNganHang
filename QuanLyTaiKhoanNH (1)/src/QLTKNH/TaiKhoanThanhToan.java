package QLTKNH;

import java.time.LocalDateTime;

import Dao.GiaoDich_Dao;

public class TaiKhoanThanhToan extends TaiKhoan{
	private final static int PHI_DICH_VU = 1000;
	private String loaitk;
	
	public TaiKhoanThanhToan(String sotk, String tentk, double  sodutk) {
		super(sotk, tentk, sodutk);
	}
	public TaiKhoanThanhToan(String sotk, String tentk, double sodutk, String loaitk) {
		super(sotk, tentk, sodutk);
        this.loaitk = loaitk;
	}
	public static int getPhiDichVu() {
		return PHI_DICH_VU;
	}
	
	@Override
	public void napTien(double soTien) {
		
		if(soTien <= 0) {
			System.out.println("Số tiền nhập phải lớn hơn 0!");
		} else {
			setSodutk(getSodutk() + soTien);
			System.out.println("Nạp tiền thành công!");
			System.out.println("- Số dư tài khoản: " + getSodutk());
			GiaoDich gd = new GiaoDich("napien" + RandomNumberExample.RandomNumber(), soTien, LocalDateTime.now(), getSotk(),"Nạp Tiền");
	        
	        GiaoDich_Dao.getInstance().insert(gd);
			
		}
}

	@Override
	public void rutTien(double  soTien) {
		if(soTien <= 0) {
			System.out.println("Số tiền nhập phải lớn hơn 0!");
		} else if(soTien <= (getSodutk() - PHI_DICH_VU)) {
			setSodutk(getSodutk() - soTien - PHI_DICH_VU);
			System.out.println("Rút tiền thành công!");
	        System.out.println("- Phí dịch vụ: " + PHI_DICH_VU);
	        System.out.println("- Số dư tài khoản: " + getSodutk());
	        GiaoDich gd = new GiaoDich("rutien" + RandomNumberExample.RandomNumber(), soTien, LocalDateTime.now(), getSotk(),"Rút tiền");
	       
	        GiaoDich_Dao.getInstance().insert(gd);
		} else {
			System.out.println("Số dư không đủ để thực hiện rút tiền!");
		}
	}
	
	@Override
	public void chuyenKhoan(TaiKhoan nguoiNhan, double  soTien) {
		if(soTien <= 0) {
			System.out.println("Số tiền nhập phải lớn hơn 0!");
		} else if(soTien <= (getSodutk() - PHI_DICH_VU)) {
			setSodutk(getSodutk() - soTien - PHI_DICH_VU);
			nguoiNhan.napTien(soTien);
			System.out.println("Rút tiền thành công!");
	        System.out.println("- Phí dịch vụ: " + PHI_DICH_VU);
	        System.out.println("- Số dư tài khoản: " + getSodutk());
	       
	        GiaoDich gd = new GiaoDich("Chuyenkhoan" + RandomNumberExample.RandomNumber(), soTien, LocalDateTime.now(), "Chuyển khoản", getSotk(),nguoiNhan.getSotk());
	        GiaoDich_Dao.getInstance().insert(gd);
		} else {
			System.out.println("Số dư không đủ để thực hiện chuyển tiền!");
		}
	}
	
	@Override
	public String toString() {
		return"TaiKhoanThanhToan [Sotk = " + getSotk() + 
				", Tentk = " + getTentk() + 
				", Sodutk = " + getSodutk() + 
				"]";
	}


	@Override
	protected void congLai() {
		// TODO Auto-generated method stub
		
	}
}
