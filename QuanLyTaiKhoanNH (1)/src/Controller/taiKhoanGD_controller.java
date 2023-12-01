package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.Navigation;
import View.quanLi;
import View.taiKhoan;
import View.taoTaiKhoan;

public class taiKhoanGD_controller implements ActionListener{
	private taiKhoan tK;
	public taiKhoanGD_controller(taiKhoan tK) {
		this.tK = tK;
	}
	
	/* controller chuyển cửa sổ */
	
	@Override
	public void actionPerformed(ActionEvent e) {
String src = e.getActionCommand();
		
		if(src.equals("Tài khoản")) {
			this.tK.setVisible(false);
			new taiKhoan();
		}

		else if(src.equals("Tạo tài khoản")) {
			this.tK.setVisible(false);
			new taoTaiKhoan();
		}

		else if(src.equals("Quản lí")) {
			this.tK.setVisible(false);
			new quanLi();
		}
		
		else if(src.equals("Quay lại")) {
			this.tK.setVisible(false);
			new Navigation();
		}
		
		else if(src.equals("Đăng xuất")) {
			this.tK.setVisible(false);
			this.tK.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}

}
