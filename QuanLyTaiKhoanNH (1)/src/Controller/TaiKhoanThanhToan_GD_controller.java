package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Dao.TaiKhoanThanhToan_Dao;
import QLTKNH.TaiKhoan;
import View.taiKhoan;

public class TaiKhoanThanhToan_GD_controller implements Action {
    public taiKhoan thanhtoan_view;
    
	public TaiKhoanThanhToan_GD_controller(taiKhoan thanhtoan_view) {
		this.thanhtoan_view = thanhtoan_view;
	}
  
	/*contoller các phương thức nạp rút tài khoản thanh toán */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(thanhtoan_view, "bạn muốn " +cm );
		if(cm.equals("Nạp Tiền")) {
			String stk = thanhtoan_view.textField_nhapSTKN.getText();
			double st = Double.parseDouble(thanhtoan_view.textField_nhapSTN.getText());
	        TaiKhoan acc = TaiKhoanThanhToan_Dao.getInstance().findBySoTK(stk);
	        acc.napTien(st);
	        TaiKhoanThanhToan_Dao.getInstance().update(acc);
			this.thanhtoan_view.removeForm();
		}
		else if(cm.equals("Rút Tiền"))
		{
			String stk = thanhtoan_view.textField_nhapSTKR.getText();
			double st = Double.parseDouble(thanhtoan_view.textField_nhapSTR.getText());
	        TaiKhoan acc = TaiKhoanThanhToan_Dao.getInstance().findBySoTK(stk);
	        acc.rutTien(st);
	        TaiKhoanThanhToan_Dao.getInstance().update(acc);
			this.thanhtoan_view.removeForm();
			
		}
		else if(cm.equals("Chuyển")) {
			String stkg = thanhtoan_view.textField_nhapSTKG.getText();
			String stknh =  thanhtoan_view.textField_nhapSTKNh.getText();
			double st = Double.parseDouble(thanhtoan_view.textField_nhapSTCK.getText());
	        TaiKhoan acc1 = TaiKhoanThanhToan_Dao.getInstance().findBySoTK(stkg);
	        TaiKhoan acc2 = TaiKhoanThanhToan_Dao.getInstance().findBySoTK(stknh);
	        acc1.chuyenKhoan(acc2, st);
	        TaiKhoanThanhToan_Dao.getInstance().update(acc1);
	        TaiKhoanThanhToan_Dao.getInstance().update(acc2);
			this.thanhtoan_view.removeForm();
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
