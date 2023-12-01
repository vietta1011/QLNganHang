package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.Navigation;
import View.quanLi;
import View.taiKhoan;
import View.taoTaiKhoan;

public class NAV_controller implements ActionListener {
	private Navigation nav;
	
	
	public NAV_controller(Navigation nav) {
		// TODO Auto-generated constructor stub
		this.nav = nav;
	}
	/* controller chuyển cửa sổ  */
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Tài khoản")) {
			this.nav.setVisible(false);
			new taiKhoan();
			
		}

		else if(src.equals("Tạo tài khoản")) {
			this.nav.setVisible(false);
			new taoTaiKhoan();
		}

		else if(src.equals("Quản lí")) {
			this.nav.setVisible(false);
			
			new quanLi();
			
			
		}
		else if(src.equals("Đăng xuất")) {
			this.nav.setVisible(false);
			this.nav.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}

}
