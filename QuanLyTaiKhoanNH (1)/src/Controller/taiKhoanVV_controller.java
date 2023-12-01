package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JOptionPane;

import Dao.TaiKhoanTietKiem_Dao;
import Dao.TaiKhoanVayVon_Dao;
import QLTKNH.TaiKhoanTietKiem;
import QLTKNH.TaiKhoanVayVon;
import View.taiKhoan;
import View.taoTaiKhoan;

public class taiKhoanVV_controller implements ActionListener{
	public taoTaiKhoan view3;

	
	public taiKhoanVV_controller(taoTaiKhoan view3) {
	
		this.view3 = view3;
	}
	
	/*controller tạo tài khoản vay vốn */

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(view3, "bạn muốn " +cm );
		if(cm.equals("Xác nhận")) {
			String stk = view3.textField_nhapSTKVV.getText();
			String ttk = view3.textField_nhapTTKVV.getText();
			double st = Double.parseDouble(view3.textField_STGVV.getText());
			double stv = Double.parseDouble(view3.textField_nhapSTVVV.getText());
			Date date = view3.dateChooser_ngayVay.getDate();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			TaiKhoanVayVon acc = new TaiKhoanVayVon(stk, ttk, st, localDate, stv);
			TaiKhoanVayVon_Dao.getInstance().insert(acc);
			this.view3.removeForm();
		
	}

}
}
