package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.w3c.dom.events.MouseEvent;

import View.quanLi;

public class quanlyGiaoDich_controller implements ActionListener {
    public quanLi qlgd_view;
    

	public quanlyGiaoDich_controller(quanLi qlgd_view) {
		this.qlgd_view = qlgd_view;
	}

   /* controller tab quản lý giao dịch*/ 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(qlgd_view, "bạn muốn " +cm );
		if(cm.equals("Tìm kiếm")) {
			this.qlgd_view.timGiaoDich();
		}
		else if(cm.equals("Xem")) {
			this.qlgd_view.themVaoBang_gd();
		}
		
	}
    


}
