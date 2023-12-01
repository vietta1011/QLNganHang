package QLTKNH;

public abstract class TaiKhoan {
	private String sotk;
	private String tentk;
	private double  sodutk;
 
	public TaiKhoan(String sotk, String tentk, double  sodutk) {
		this.sotk = sotk;
		this.tentk = tentk;
		this.sodutk = sodutk;
	}
	
	
	public TaiKhoan(String sotk, double sodutk) {
		super();
		this.sotk = sotk;
		this.sodutk = sodutk;
	}


	public TaiKhoan(String sotk) {
		super();
		this.sotk = sotk;
	}


	public String getSotk() {
		return sotk;
	}
	
	public void setSotk(String sotk) {
		this.sotk = sotk;
	}
	
	public String getTentk() {
		return tentk;
	}
	
	public void setTentk(String tentk) {
		this.tentk = tentk;
	}
	
	public double getSodutk() {
		return sodutk;
	}
	
	public void setSodutk(double sodutk) {
		this.sodutk = sodutk;
	}
	
	/*các phương thức cơ bản của một tài khoản ngân hàng */
	
	public abstract void napTien(double  soTien);
	
	public abstract void rutTien(double  soTien);

	public abstract void chuyenKhoan(TaiKhoan nguonNhan, double  soTien);

	protected abstract void congLai();
}
