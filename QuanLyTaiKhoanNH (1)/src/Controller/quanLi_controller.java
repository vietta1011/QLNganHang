package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.Navigation;
import View.quanLi;
import View.taiKhoan;
import View.taoTaiKhoan;

public class quanLi_controller implements ActionListener {
	private quanLi qL;
	public quanLi_controller(quanLi qL) {
		this.qL = qL;
	}

	/* controller chuyển cửa sổ  */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Tài khoản")) {
			this.qL.setVisible(false);
			new taiKhoan();
		}

		else if(src.equals("Tạo tài khoản")) {
			this.qL.setVisible(false);
			new taoTaiKhoan();
		}

		else if(src.equals("Quản lí")) {
			this.qL.setVisible(false);
			new quanLi();
		}
		
		else if(src.equals("Quay lại")) {
			this.qL.setVisible(false);
			new Navigation();
		}
		
		else if(src.equals("Đăng xuất")) {
			this.qL.setVisible(false);
			this.qL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}
}
