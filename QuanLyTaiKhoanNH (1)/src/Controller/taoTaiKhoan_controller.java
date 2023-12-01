package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.Navigation;
import View.quanLi;
import View.taiKhoan;
import View.taoTaiKhoan;

public class taoTaiKhoan_controller implements ActionListener {
	private taoTaiKhoan tTK;
	public taoTaiKhoan_controller(taoTaiKhoan tTK) {
		this.tTK = tTK;
	}
	
	/*controller chuyển cửa sổ tab tạo tài khoản */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Tài khoản")) {
			this.tTK.setVisible(false);
			new taiKhoan();
		}

		else if(src.equals("Tạo tài khoản")) {
			this.tTK.setVisible(false);
			new taoTaiKhoan();
		}

		else if(src.equals("Quản lí")) {
			this.tTK.setVisible(false);
			new quanLi();
		}
		
		else if(src.equals("Quay lại")) {
			this.tTK.setVisible(false);
			new Navigation();
		}
		
		else if(src.equals("Đăng xuất")) {
			this.tTK.setVisible(false);
			this.tTK.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}

}
