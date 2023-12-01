package QLTKNH;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Dao.GiaoDich_Dao;

public class TaiKhoanTietKiem extends TaiKhoan{
    private final static double LAI_TIET_KIEM = 6;
	private final static int PHI_DICH_VU = 1000;
    private LocalDate ngayGui;
	private String loaitk;
    
	public TaiKhoanTietKiem(String sotk, String tentk, double sodutk, LocalDate ngayGui) {
		super(sotk, tentk, sodutk);
		this.ngayGui = ngayGui;		
	}
	public TaiKhoanTietKiem(String sotk, String tentk, double sodutk, String loaitk) {
		super(sotk, tentk, sodutk);
        this.loaitk = loaitk;
	}

	public static double getLaiTietKiem() {
		return LAI_TIET_KIEM;
	}
	
	/*phương thức tính tiền lãi tiết kiệm */
	
	
	public void congLai() {
		double tienLai = getSodutk() * LAI_TIET_KIEM / 100 * 180 / 365;
		long laiLamTron = Math.round(tienLai);
		setSodutk(getSodutk() + laiLamTron);
		System.out.println("Cộng lãi thành công!");
        System.out.println("- Tiền lãi: " + laiLamTron);
        System.out.println("- Số dư tài khoản: " + getSodutk());
        GiaoDich gd = new GiaoDich("congLai" + RandomNumberExample.RandomNumber(), laiLamTron, LocalDateTime.now(), getSotk(),"Cộng Lãi");
        GiaoDich_Dao.getInstance().insert(gd);
        
	}
	
	public LocalDate getNgayGui() {
		return ngayGui;
	}
	
	public void setNgayGui(LocalDate ngayGui) {
		this.ngayGui = ngayGui;
	}
	
	@Override
	   public String toString() {
        return "TaiKhoanTietKiem{" +
                "Sotk =" + getSotk() +
                ", Tentk = " + getTentk() +
                ", Sodutk = " + getSodutk() +
                ", ngayGui = " + ngayGui +
                ", ngayHetHan = " + ngayGui.plusMonths(6) +
                '}';
    }

	@Override
	public void napTien(double soTien) {
		if(soTien <= 0) {
			System.out.println("Số tiền nhập phải lớn hơn 0!");
		} else {
			setSodutk(getSodutk() + soTien);
			System.out.println("Nạp tiền thành công!");
			System.out.println("- Số dư tài khoản: " + getSodutk());
			GiaoDich gd = new GiaoDich("napTien" + RandomNumberExample.RandomNumber(), soTien, LocalDateTime.now(), getSotk(),"Nạp Tiền Tiết Kiệm");
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
	        GiaoDich gd = new GiaoDich("rutTien" + RandomNumberExample.RandomNumber(), soTien, LocalDateTime.now(), getSotk(),"Rút Tiền Tiết Kiệm");
	        GiaoDich_Dao.getInstance().insert(gd);
		} else {
			System.out.println("Số dư không đủ để thực hiện rút tiền!");
		}		
	}

	@Override
	public void chuyenKhoan(TaiKhoan nguonNhan, double soTien) {
		// TODO Auto-generated method stub
		
	}

}

