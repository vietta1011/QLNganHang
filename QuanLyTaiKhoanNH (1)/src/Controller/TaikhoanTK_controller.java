package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JOptionPane;

import Dao.TaiKhoanThanhToan_Dao;
import Dao.TaiKhoanTietKiem_Dao;
import QLTKNH.TaiKhoan;
import QLTKNH.TaiKhoanThanhToan;
import QLTKNH.TaiKhoanTietKiem;
import View.quanLi;
import View.taiKhoan;
import View.taoTaiKhoan;

public class TaikhoanTK_controller implements ActionListener {
public taoTaiKhoan view2;
public quanLi view3;



	public TaikhoanTK_controller(taoTaiKhoan view2) {
	
	this.view2 = view2;
}

	/*controller tab tạo tài khoản tiết kiệm */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(view2, "bạn muốn " +cm );
		if(cm.equals("Xác nhận")) { 
			String stk = view2.textField_nhapSTKTK.getText();
			String ttk = view2.textField_nhapTTKTK.getText();
			double st = Double.parseDouble(view2.textField_STG.getText());
			Date date = view2.dateChooser_ngayGui.getDate();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			TaiKhoanTietKiem acc = new TaiKhoanTietKiem(stk, ttk, st, localDate);
			TaiKhoanTietKiem_Dao.getInstance().insert(acc);	
		    this.view2.removeForm();
			
			
		}
		
	}

}
