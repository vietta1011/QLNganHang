package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Dao.NguoiDung_Dao;
import QLTKNH.NguoiDung;
import View.quanLi;

public class quanlyNguoiDung_controller implements Action {
public quanLi ql_view;

	public quanlyNguoiDung_controller(quanLi ql_view) {
	this.ql_view = ql_view;
}
	
	 /* controller tab quản lý người dùng*/

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(ql_view, "bạn muốn " +cm );
		if(cm.equals("Thêm")) {
		
			this.ql_view.themNguoiDung();
			this.ql_view.removeForm();
			
		}
		else if(cm.equals("Cập nhật")) {
			this.ql_view.HienThiThongTinNguoiDung();
		}
		else if(cm.equals("Lưu")) {
			this.ql_view.CapnhatNguoiDung();
		}
		else if(cm.equals("Xóa")) {
			this.ql_view.xoaThongTinNguoiDung();
		}
		else if(cm.equals("Tìm kiếm")) {
			this.ql_view.timNguoiDung();
		}
		else if(cm.equals("Xem")) {
			this.ql_view.removeForm();
			this.ql_view.themVaoBangND();
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
