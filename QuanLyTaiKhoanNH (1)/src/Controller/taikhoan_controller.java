package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Dao.TaiKhoanThanhToan_Dao;
import QLTKNH.QL_GiaoDich;
import QLTKNH.QL_TaiKhoan;
import QLTKNH.TaiKhoan;
import QLTKNH.TaiKhoanThanhToan;
import View.taiKhoan;
import View.taoTaiKhoan;

public class taikhoan_controller implements Action{
    public taoTaiKhoan view1;


	public taikhoan_controller(taoTaiKhoan view1) {
		this.view1 = view1;
	}
	
  /* controller tab tạo tài khoản thanh toán */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(view1, "bạn muốn " +cm );
		if(cm.equals("Xác nhận")) {
			String stk = view1.textField_nhapSTK.getText();
			String ttk = view1.textField_nhapTTK.getText();
			double st = Double.parseDouble(view1.textField_nhapST.getText());
			TaiKhoan acc = new TaiKhoanThanhToan(stk, ttk, st);
			TaiKhoanThanhToan_Dao.getInstance().insert(acc);
			this.view1.removeForm();
			
		}
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
