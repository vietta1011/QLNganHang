package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import View.quanLi;

public class QLTK_CONTROLLER implements Action{
 public quanLi view;
 
	public QLTK_CONTROLLER(quanLi view) {
	this.view = view;
}
	
    /* controller tab quản lý tài khoản */
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	  
	  String cm = e.getActionCommand();
	  
	  JOptionPane.showMessageDialog(view, "bạn muốn " +cm );
	  if(cm.equals("Xóa")) {
		  this.view.xoaThongTinTaiKhoan();
	  }
	  else if(cm.equals("Cập nhật")) {
		  this.view.ThemVaoBangTaikhoan();
		  
	  }
	  else if(cm.equals("Tìm kiếm"))
	  {
		  this.view.timTaiKhoan();
	  }
	  else if(cm.equals("Top số dư")) {
		  this.view.TopsoDu();
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
