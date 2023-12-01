package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Dao.TaiKhoanThanhToan_Dao;
import Dao.TaiKhoanTietKiem_Dao;
import QLTKNH.TaiKhoan;
import QLTKNH.TaiKhoanTietKiem;
import View.taiKhoan;

public class TaiKhoanTietKiem_GD_controller implements Action {
    public taiKhoan tk_view;
    
	public TaiKhoanTietKiem_GD_controller(taiKhoan tk_view) {
		
		this.tk_view = tk_view;
	}

	/*controller các phương thức tài khoản tiết kiệm */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(tk_view, "bạn muốn " +cm );
		if(cm.equals("Gửi Tiền"))
		{   
			String stk = tk_view.textField__soTaiKhoanGui.getText();
			double st = Double.parseDouble(tk_view.textField_soTienGui.getText());
	        TaiKhoanTietKiem acc = TaiKhoanTietKiem_Dao.getInstance().findBySoTK(stk);
	        acc.napTien(st);
	        TaiKhoanTietKiem_Dao.getInstance().update(acc);
			this.tk_view.removeForm();
		}
		else if(cm.equals("Rút Tiền")) {
			String stk = tk_view.textField_soTaiKhoanRutTk.getText();
			double st = Double.parseDouble(tk_view.textField_tienNhan.getText());
	        TaiKhoanTietKiem acc = TaiKhoanTietKiem_Dao.getInstance().findBySoTK(stk);
	        acc.rutTien(st);
	        TaiKhoanTietKiem_Dao.getInstance().update(acc);
			this.tk_view.removeForm();
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
