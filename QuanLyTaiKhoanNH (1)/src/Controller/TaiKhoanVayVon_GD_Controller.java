package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Dao.TaiKhoanTietKiem_Dao;
import Dao.TaiKhoanVayVon_Dao;
import QLTKNH.TaiKhoanTietKiem;
import QLTKNH.TaiKhoanVayVon;
import View.taiKhoan;

public class TaiKhoanVayVon_GD_Controller implements Action{
    public taiKhoan vv_view;
    
	public TaiKhoanVayVon_GD_Controller(taiKhoan vv_view) {
	
		this.vv_view = vv_view;
	}
	
	/*controller các phương thức tài khoản vay vốn */

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(vv_view, "bạn muốn " +cm );
		if(cm.equals("Nạp Tiền"))
		{   
			String stk = vv_view.textField_soTaiKhoan.getText();
			double st = Double.parseDouble(vv_view.textField.getText());
	        TaiKhoanVayVon acc = TaiKhoanVayVon_Dao.getInstance().findBySoTK(stk);
	        acc.napTien(st);
	        TaiKhoanVayVon_Dao.getInstance().update(acc);
			this.vv_view.removeForm();
		}
		else if(cm.equals("Rút Tiền")) {

			String stk = vv_view.textField_STKVV.getText();
			double st = Double.parseDouble(vv_view.textField_2.getText());
	        TaiKhoanVayVon acc = TaiKhoanVayVon_Dao.getInstance().findBySoTK(stk);
	        acc.rutTien(st);
	        TaiKhoanVayVon_Dao.getInstance().update(acc);
			this.vv_view.removeForm();
		}
		else if(cm.equals("Thanh Toán"))
		{
			String stk = vv_view.textField_STK.getText();
			Date date = vv_view.dateChooser_ngayThanhToan.getDate();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        TaiKhoanVayVon acc = TaiKhoanVayVon_Dao.getInstance().findBySoTK(stk);
	        acc.tinhTienLai(localDate);
	        TaiKhoanVayVon_Dao.getInstance().update(acc);
			this.vv_view.removeForm();
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
