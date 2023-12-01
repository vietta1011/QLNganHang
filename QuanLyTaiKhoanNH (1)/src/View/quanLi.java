package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.QLTK_CONTROLLER;
import Controller.quanLi_controller;
import Controller.quanlyGiaoDich_controller;
import Controller.quanlyNguoiDung_controller;
import Dao.GiaoDich_Dao;
import Dao.NguoiDung_Dao;
import Dao.TaiKhoanThanhToan_Dao;
import Dao.TaiKhoanTietKiem_Dao;
import Dao.TaiKhoanVayVon_Dao;
import QLTKNH.GiaoDich;
import QLTKNH.NguoiDung;
import QLTKNH.QL_NguoiDung;
import QLTKNH.TaiKhoan;
import QLTKNH.TaiKhoanThanhToan;
import QLTKNH.TaiKhoanTietKiem;
import QLTKNH.TaiKhoanVayVon;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.ScrollPane;
import java.awt.Component;
import java.awt.event.ActionEvent;
                     
                   /*phần quản lý */

public class quanLi extends JFrame {
    public QL_NguoiDung model;
	public JPanel contentPane;
	public JTextField textField_nhapSTK;
	public JTable table_DSTK;
	public JTable table_DSND;
	public JTextField textField_nhapSTKND;
	public JTextField textField_nhapTTKND;
	public JTextField textField_nhapMKND;
	public JTextField textField_nhapTND;
	public JTextField textField_nhapMGD;
	public JTextField textField_nhapSTKTTND;
	public JDateChooser dateChooser_ngaySinh;
	public JTable table_gd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanLi frame = new quanLi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public quanLi() {
		model = new QL_NguoiDung();
		ActionListener ac = new quanLi_controller(this);
		setTitle("Quản lí tài khoản ngân hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		URL icon_title = taoTaiKhoan.class.getResource("icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(icon_title);
		this.setIconImage(img);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu menu_quanLi = new JMenu("Menu");
		menu_quanLi.setFont(new Font("Arial", Font.PLAIN, 17));
		menuBar.add(menu_quanLi);
		
		JMenuItem menu_taiKhoan = new JMenuItem("Tài khoản");
		menu_taiKhoan.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_quanLi.add(menu_taiKhoan);
		menu_taiKhoan.addActionListener(ac);
		
		JMenuItem menu_taoTaiKhoan = new JMenuItem("Tạo tài khoản");
		menu_taoTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_quanLi.add(menu_taoTaiKhoan);
		menu_taoTaiKhoan.addActionListener(ac);
		
		JMenuItem menu_quanLiTT = new JMenuItem("Quản lí");
		menu_quanLiTT.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_quanLi.add(menu_quanLiTT);
		
		JMenu menu_thoat = new JMenu("Thoát");
		menu_thoat.setFont(new Font("Arial", Font.PLAIN, 17));
		menuBar.add(menu_thoat);
		
		JMenuItem menu_quayLai = new JMenuItem("Quay lại");
		menu_quayLai.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_thoat.add(menu_quayLai);
		menu_quayLai.addActionListener(ac);
		
		JMenuItem menu_dangXuat = new JMenuItem("Đăng xuất");
		menu_dangXuat.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_thoat.add(menu_dangXuat);
		menu_dangXuat.addActionListener(ac);
		
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_main = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_main.setFont(new Font("Arial", Font.PLAIN, 15));
		tabbedPane_main.setBounds(0, 0, 946, 626);
		contentPane.add(tabbedPane_main);
		
		
		
		JPanel panel_QLTK = new JPanel();
		panel_QLTK.setBackground(new Color(255, 255, 255));
		tabbedPane_main.addTab("Quản lí tài khoản", null, panel_QLTK, null);
		panel_QLTK.setLayout(null);
		
		JLabel label_STK = new JLabel("Số tài khoản");
		label_STK.setFont(new Font("Arial", Font.PLAIN, 23));
		label_STK.setBounds(40, 15, 135, 45);
		panel_QLTK.add(label_STK);
		
		textField_nhapSTK = new JTextField();
		textField_nhapSTK.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTK.setOpaque(false);
		textField_nhapSTK.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapSTK.setBorder(BorderFactory.createCompoundBorder(



								        new MatteBorder(0, 0, 2, 0, Color.BLACK),



								        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTK.setBounds(210, 10, 515, 60);
		panel_QLTK.add(textField_nhapSTK);
		Action ec = new QLTK_CONTROLLER(this);
		JButton button_timKiem = new JButton("Tìm kiếm");
		button_timKiem.addActionListener(ec);
		button_timKiem.setFont(new Font("Arial", Font.PLAIN, 17));
		button_timKiem.setBounds(780, 31, 105, 29);
		panel_QLTK.add(button_timKiem);
		
		JButton button_xoa = new JButton("Xóa");
		button_xoa.addActionListener(ec);
		button_xoa.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xoa.setBounds(600, 550, 105, 29);
		panel_QLTK.add(button_xoa);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 921, 2);
		panel_QLTK.add(separator);
		
		JLabel label_DSTK = new JLabel("Danh sách tài khoản");
		label_DSTK.setFont(new Font("Arial", Font.PLAIN, 23));
		label_DSTK.setBounds(40, 85, 211, 45);
		panel_QLTK.add(label_DSTK);
		
		table_DSTK = new JTable();
		table_DSTK.setBackground(new Color(255, 255, 255));
		table_DSTK.setFont(new Font("Arial", Font.PLAIN, 17));
		table_DSTK.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Số tài khoản", "Tên tài khoản", "Số dư", "Loại tài khoản"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JScrollPane scrollPane_DSTK = new JScrollPane(table_DSTK);
		scrollPane_DSTK.setBounds(10, 130, 921, 400);
		panel_QLTK.add(scrollPane_DSTK);
		
		JButton button_capNhat = new JButton("Cập nhật");
		button_capNhat.addActionListener(ec);
		button_capNhat.setFont(new Font("Arial", Font.PLAIN, 17));
		button_capNhat.setBounds(200, 550, 105, 29);
		panel_QLTK.add(button_capNhat);
		
		JButton button_topSoDu = new JButton("Top số dư");
		button_topSoDu.addActionListener(ec);
		button_topSoDu.setFont(new Font("Arial", Font.PLAIN, 17));
		button_topSoDu.setBounds(400, 550, 120, 29);
		panel_QLTK.add(button_topSoDu);
		
		JPanel panel_QLND = new JPanel();
		panel_QLND.setBackground(new Color(255, 255, 255));
		tabbedPane_main.addTab("Quản lí người dùng", null, panel_QLND, null);
		panel_QLND.setLayout(null);
		
		Action ac2 = new quanlyNguoiDung_controller(this);
		
		JLabel label_STKND = new JLabel("Số tài khoản");
		label_STKND.setFont(new Font("Arial", Font.PLAIN, 23));
		label_STKND.setBounds(40, 5, 153, 45);
		panel_QLND.add(label_STKND);
		
		textField_nhapSTKND = new JTextField();
		textField_nhapSTKND.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTKND.setOpaque(false);
		textField_nhapSTKND.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapSTKND.setBorder(BorderFactory.createCompoundBorder(




										        new MatteBorder(0, 0, 2, 0, Color.BLACK),




										        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTKND.setBounds(210, 0, 565, 60);
		panel_QLND.add(textField_nhapSTKND);
		
		JButton button_timKiemNguoiDung = new JButton("Tìm kiếm");
		button_timKiemNguoiDung.addActionListener(ac2);
		button_timKiemNguoiDung.setFont(new Font("Arial", Font.PLAIN, 17));
		button_timKiemNguoiDung.setBounds(810, 10, 105, 29);
		panel_QLND.add(button_timKiemNguoiDung);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 75, 921, 2);
		panel_QLND.add(separator_2);
		
		JLabel label_DSTKND = new JLabel("Danh sách tài khoản");
		label_DSTKND.setFont(new Font("Arial", Font.PLAIN, 23));
		label_DSTKND.setBounds(40, 75, 211, 45);
		panel_QLND.add(label_DSTKND);
		
		table_DSND = new JTable();
		table_DSND.setFont(new Font("Arial", Font.PLAIN, 15));
		table_DSND.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Căn cước công dân", "Tên người dùng", "Số điện thoại", "Ngày sinh", "Số tài khoản"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, LocalDate.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JScrollPane scrollPane_DSND = new JScrollPane(table_DSND);
		scrollPane_DSND.setBounds(10, 115, 921, 145);
		panel_QLND.add(scrollPane_DSND);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 275, 921, 2);
		panel_QLND.add(separator_2_1);
		
		JLabel label_TTTKND = new JLabel("Thông tin tài khoản");
		label_TTTKND.setFont(new Font("Arial", Font.PLAIN, 23));
		label_TTTKND.setBounds(40, 275, 211, 45);
		panel_QLND.add(label_TTTKND);
		
		JLabel label_CCCD = new JLabel("Căn cước công dân");
		label_CCCD.setFont(new Font("Arial", Font.PLAIN, 20));
		label_CCCD.setBounds(10, 360, 211, 45);
		panel_QLND.add(label_CCCD);
		
		textField_nhapTTKND = new JTextField();
		textField_nhapTTKND.setPreferredSize(new Dimension(150, 20));
		textField_nhapTTKND.setOpaque(false);
		textField_nhapTTKND.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapTTKND.setBorder(BorderFactory.createCompoundBorder(





												        new MatteBorder(0, 0, 2, 0, Color.BLACK),





												        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapTTKND.setBounds(200, 353, 530, 60);
		panel_QLND.add(textField_nhapTTKND);
		
		JLabel label_SDT = new JLabel("Số điện thoại");
		label_SDT.setFont(new Font("Arial", Font.PLAIN, 20));
		label_SDT.setBounds(10, 480, 211, 45);
		panel_QLND.add(label_SDT);
		
		JLabel label_NSND = new JLabel("Ngày sinh");
		label_NSND.setFont(new Font("Arial", Font.PLAIN, 20));
		label_NSND.setBounds(10, 540, 211, 45);
		panel_QLND.add(label_NSND);
		
		textField_nhapMKND = new JTextField();
		textField_nhapMKND.setPreferredSize(new Dimension(150, 20));
		textField_nhapMKND.setOpaque(false);
		textField_nhapMKND.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapMKND.setBorder(BorderFactory.createCompoundBorder(






														        new MatteBorder(0, 0, 2, 0, Color.BLACK),






														        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapMKND.setBounds(200, 413, 530, 60);
		panel_QLND.add(textField_nhapMKND);
		
		textField_nhapTND = new JTextField();
		textField_nhapTND.setPreferredSize(new Dimension(150, 20));
		textField_nhapTND.setOpaque(false);
		textField_nhapTND.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapTND.setBorder(BorderFactory.createCompoundBorder(







																        new MatteBorder(0, 0, 2, 0, Color.BLACK),







																        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapTND.setBounds(200, 473, 530, 60);
		panel_QLND.add(textField_nhapTND);
		
		dateChooser_ngaySinh = new JDateChooser();
		dateChooser_ngaySinh.setForeground(Color.BLACK);
		dateChooser_ngaySinh.setFont(new Font("Arial", Font.PLAIN, 17));
		dateChooser_ngaySinh.setDateFormatString("y/ M/ d");
		dateChooser_ngaySinh.setBounds(417, 554, 313, 38);
		panel_QLND.add(dateChooser_ngaySinh);
		
		JButton button_xoaNguoiDung = new JButton("Xóa");
		button_xoaNguoiDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_xoaNguoiDung.addActionListener(ac2);
		button_xoaNguoiDung.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xoaNguoiDung.setBounds(770, 370, 105, 29);
		panel_QLND.add(button_xoaNguoiDung);
		
		JButton button_capNhatNguoiDung = new JButton("Cập nhật");
		button_capNhatNguoiDung.addActionListener(ac2);
		button_capNhatNguoiDung.setFont(new Font("Arial", Font.PLAIN, 17));
		button_capNhatNguoiDung.setBounds(770, 490, 105, 29);
		panel_QLND.add(button_capNhatNguoiDung);
		
		JLabel label_TND = new JLabel("Tên người dùng");
		label_TND.setFont(new Font("Arial", Font.PLAIN, 20));
		label_TND.setBounds(10, 420, 211, 45);
		panel_QLND.add(label_TND);
		
		JLabel label_STKTTND = new JLabel("Số tài khoản");
		label_STKTTND.setFont(new Font("Arial", Font.PLAIN, 20));
		label_STKTTND.setBounds(10, 300, 211, 45);
		panel_QLND.add(label_STKTTND);
		
		textField_nhapSTKTTND = new JTextField();
		textField_nhapSTKTTND.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTKTTND.setOpaque(false);
		textField_nhapSTKTTND.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapSTKTTND.setBorder(BorderFactory.createCompoundBorder(






														        new MatteBorder(0, 0, 2, 0, Color.BLACK),






														        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTKTTND.setBounds(200, 293, 530, 60);
		panel_QLND.add(textField_nhapSTKTTND);
		
		JButton button_luuNguoiDung = new JButton("Lưu");
		button_luuNguoiDung.setFont(new Font("Arial", Font.PLAIN, 17));
		button_luuNguoiDung.setBounds(770, 550, 105, 29);
		button_luuNguoiDung.addActionListener(ac2);
		panel_QLND.add(button_luuNguoiDung);
		
		JButton button_themNguoiDung = new JButton("Thêm");
		button_themNguoiDung.setFont(new Font("Arial", Font.PLAIN, 17));
		button_themNguoiDung.setBounds(770, 310, 105, 29);
		button_themNguoiDung.addActionListener(ac2);
		panel_QLND.add(button_themNguoiDung);
		
		JButton button_resetNguoiDung = new JButton("Xem");
		button_resetNguoiDung.addActionListener(ac2);
		button_resetNguoiDung.setFont(new Font("Arial", Font.PLAIN, 17));
		button_resetNguoiDung.setBounds(770, 430, 105, 29);
		panel_QLND.add(button_resetNguoiDung);
		
		
		
		JPanel panel_QLGD = new JPanel();
		panel_QLGD.setBackground(new Color(255, 255, 255));
	
		tabbedPane_main.addTab("Quản lí giao dịch", null, panel_QLGD, null);
		panel_QLGD.setLayout(null);
		
		JLabel label_MGD = new JLabel("Mã giao dịch");
		label_MGD.setFont(new Font("Arial", Font.PLAIN, 23));
		label_MGD.setBounds(50, 30, 153, 45);
		panel_QLGD.add(label_MGD);
		
		textField_nhapMGD = new JTextField();
		textField_nhapMGD.setPreferredSize(new Dimension(150, 20));
		textField_nhapMGD.setOpaque(false);
		textField_nhapMGD.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapMGD.setBorder(BorderFactory.createCompoundBorder(





												        new MatteBorder(0, 0, 2, 0, Color.BLACK),





												        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapMGD.setBounds(215, 19, 500, 60);
		panel_QLGD.add(textField_nhapMGD);
		ActionListener dc = new quanlyGiaoDich_controller(this);
		JButton button_timKiemGiaoDich = new JButton("Tìm kiếm");
		button_timKiemGiaoDich.addActionListener(dc);
		button_timKiemGiaoDich.setFont(new Font("Arial", Font.PLAIN, 17));
		button_timKiemGiaoDich.setBounds(770, 35, 105, 29);
		panel_QLGD.add(button_timKiemGiaoDich);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(10, 105, 921, 2);
		panel_QLGD.add(separator_2_2);
		
		JLabel label_TTGD = new JLabel("Thông tin giao dịch");
		label_TTGD.setFont(new Font("Arial", Font.PLAIN, 23));
		label_TTGD.setBounds(20, 120, 198, 45);
		panel_QLGD.add(label_TTGD);
		
		table_gd = new JTable();
		table_gd.setFont(new Font("Arial", Font.PLAIN, 15));
		table_gd.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã giao dịch", "Số tiền", "Thời gian giao dịch", "Loại giao dịch", "Tài khoản gửi", "Tài khoản nhân"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, LocalDateTime.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table_gd);
		scrollPane.setBounds(9, 184, 922, 400);
		panel_QLGD.add(scrollPane);
		
		JButton button_xemGD = new JButton("Xem");
		button_xemGD.addActionListener(dc);
		button_xemGD.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xemGD.setBounds(770, 130, 105, 29);
		panel_QLGD.add(button_xemGD);
		
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/*xóa form trên text field */
	public void removeForm() {
		textField_nhapSTKTTND.setText("");
		textField_nhapTND.setText("");
		textField_nhapMKND.setText("");
		textField_nhapTTKND.setText("");
		dateChooser_ngaySinh.setCalendar(null);
		
		
	}
   /*thêm người dùng đẫ nhập trên form vào bảng */
	public void themNguoiDung() {

		String stk =  textField_nhapSTKTTND.getText();
		String cccd = textField_nhapTTKND.getText();
		String ten =  textField_nhapMKND.getText();
		String sdt = textField_nhapTND.getText();
		Date date = dateChooser_ngaySinh.getDate();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	   
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = localDate.format(formatter);
		DefaultTableModel model_table = (DefaultTableModel)table_DSND.getModel();
		if(!this.model.kiemTraNguoiDungTonTai(cccd)) {
			model_table.addRow(new Object[] {cccd , ten, sdt,formattedDate, stk,
					
					
			});
				 NguoiDung user = new NguoiDung(cccd, ten, sdt, localDate, stk);
				
			     NguoiDung_Dao.getInstance().insert(user);
			     this.model.them_NguoiDung(user);
		}
		else {
			JOptionPane.showMessageDialog(this, "Số căn cước công dân đã tồn tại!");
		}
}
	
	/* lấy người dùng khi bấm click chuột vào bảng */
	public NguoiDung LayNguoiDungDangChon() {
		DefaultTableModel model_table = (DefaultTableModel)table_DSND.getModel();
		
		int i_row = table_DSND.getSelectedRow();
		String cccd = table_DSND.getValueAt(i_row, 0)+"";
		String ten = table_DSND.getValueAt(i_row, 1)+"";
		String sdt = table_DSND.getValueAt(i_row, 2)+"";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(table_DSND.getValueAt(i_row, 3).toString(), formatter);
		String stk = table_DSND.getValueAt(i_row, 4)+"";
		NguoiDung user = new NguoiDung(cccd, ten, sdt, localDate, stk);
		
		return user;
		
	}
	
	/* hiển thị thông tin người dùng đã trọn lên text field*/
	
	public void HienThiThongTinNguoiDung() {
		NguoiDung user = LayNguoiDungDangChon();
		this.textField_nhapSTKTTND.setText(user.getSoTk_nguoidung()+"");
		this.textField_nhapTTKND.setText(user.getCCCD()+"");
		this.textField_nhapMKND.setText(user.getTenNguoidung()+"");
		this.textField_nhapTND.setText(user.getSdt()+"");
		LocalDate localDate = user.getNgaySinh();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.dateChooser_ngaySinh.setDate(date);
	}
	
	/* cập nhật lại thông tin người dùng */
	public void CapnhatNguoiDung() {

		String stk =  textField_nhapSTKTTND.getText();
		String cccd = textField_nhapTTKND.getText();
		String ten =  textField_nhapMKND.getText();
		String sdt = textField_nhapTND.getText();
		Date date = dateChooser_ngaySinh.getDate();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		NguoiDung user = new NguoiDung(cccd, ten, sdt, localDate, stk);
		
		
		if(this.model.kiemTraNguoiDungTonTai(user.getCCCD())) {
			int sodong = table_DSND.getRowCount();
            for (int i = 0; i < sodong; i++) {
				String SoCccd =  table_DSND.getValueAt(i, 0)+"";
				if(SoCccd.equals(user.getCCCD())) {
					table_DSND.setValueAt(user.getCCCD()+"", i, 0);
					table_DSND.setValueAt(user.getTenNguoidung()+"", i, 1);
					table_DSND.setValueAt(user.getSdt()+"", i, 2);
					table_DSND.setValueAt(user.getNgaySinh().toString(), i, 3);
					table_DSND.setValueAt(user.getSoTk_nguoidung()+"", i, 4);
					
				}
			}
           
		}
		NguoiDung_Dao.getInstance().update(user);
	}

	// xóa người dùng đã chọn bằng click chuột
	public void xoaThongTinNguoiDung() {
		DefaultTableModel model_table = (DefaultTableModel) table_DSND.getModel();
		int i_row = table_DSND.getSelectedRow();
		NguoiDung user = LayNguoiDungDangChon();
		
	
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng đã chọn ?");
		if(luaChon == JOptionPane.YES_OPTION) {
			model_table.removeRow(i_row);
			NguoiDung_Dao.getInstance().delete(user);
			
		}
	}
	
//thêm dang sách tài khoản lấy từ csdl vào bảng 
	public void ThemVaoBangTaikhoan() {
		ArrayList<TaiKhoan> ds_taikhoanTT = TaiKhoanThanhToan_Dao.getInstance().selectAll();
		ArrayList<TaiKhoanTietKiem> ds_taikhoanTK = TaiKhoanTietKiem_Dao.getInstance().selectAll();
		ArrayList<TaiKhoanVayVon> ds_taikhoanVV = TaiKhoanVayVon_Dao.getInstance().selectAll();
		DefaultTableModel model_table1 = (DefaultTableModel)table_DSTK.getModel();
		for (TaiKhoan TT : ds_taikhoanTT) {
			
			
			model_table1.addRow(new Object[] { TT.getSotk(), TT.getTentk(), TT.getSodutk(),"Tài Khoản Thanh toán"
					
			});
		}
		DefaultTableModel model_table2 = (DefaultTableModel)table_DSTK.getModel();
		for (TaiKhoanTietKiem TK : ds_taikhoanTK) {
			
			
			model_table2.addRow(new Object[] { 
					TK.getSotk(), TK.getTentk(), TK.getSodutk(),"Tài Khoản Tiết Kiệm"
					
			});
		}
		DefaultTableModel model_table3 = (DefaultTableModel)table_DSTK.getModel();
		for (TaiKhoanVayVon VV : ds_taikhoanVV) {
			
			model_table3.addRow(new Object[] {
					VV.getSotk(), VV.getTentk(), VV.getSodutk(), "Tài Khoản Vay Vốn"
			});
		}
		
		
	}
	
	

	
	// xóa toàn bộ bảng tài khoản
	public void xoaThongTinTaiKhoan() {
		DefaultTableModel model_table = (DefaultTableModel) table_DSTK.getModel();
		int i_row = table_DSTK.getSelectedRow();
		
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng đã chọn ?");
		if(luaChon == JOptionPane.YES_OPTION) {
		
			model_table.setRowCount(0); 
			
			
		}
	}
	
	// tìm người dùng theo số tài khoản
	public void timNguoiDung() {
		String soTaiKhoanCanTim =  this.textField_nhapSTKND.getText();
		DefaultTableModel model_table = (DefaultTableModel) table_DSND.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<String> stkCuaNguoiDungCanXoa = new TreeSet<>();
		
		if(soTaiKhoanCanTim.length() > 0) {
			for(int i = 0; i < soLuongDong; i++) {
				String sotaikhoan = model_table.getValueAt(i, 4) + "";
				if(!sotaikhoan.equals(soTaiKhoanCanTim)) {
					stkCuaNguoiDungCanXoa.add(sotaikhoan);
				}
			}
		}
		for(String stkCanXoa : stkCuaNguoiDungCanXoa) {
			soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String soTaiKhoanTrongTable = model_table.getValueAt(i, 4) +"";
				if(soTaiKhoanTrongTable.equals(stkCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch(Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	// thêm một người dùng vào bảng
	public void themVaoBangND() {
		ArrayList<NguoiDung> danhSachND = NguoiDung_Dao.getInstance().selectAll();
		
		DefaultTableModel model_table_nd = (DefaultTableModel)table_DSND.getModel();
		for (NguoiDung nd : danhSachND) {
			LocalDate localDate = nd.getNgaySinh();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String formattedDate = localDate.format(formatter);
			model_table_nd.addRow(new Object[] {nd.getCCCD(), nd.getTenNguoidung(),nd.getSdt() ,formattedDate, nd.getSoTk_nguoidung()});
		}
		
		
	}
	// tìm kiếm tài khoản theo số tài khoản
	public void timTaiKhoan() {
		String soTaiKhoanCanTim =  this.textField_nhapSTK.getText();
		DefaultTableModel model_table = (DefaultTableModel) table_DSTK.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<String> stkCuaNguoiDungCanXoa = new TreeSet<>();
		
		if(soTaiKhoanCanTim.length() > 0) {
			for(int i = 0; i < soLuongDong; i++) {
				String sotaikhoan = model_table.getValueAt(i, 0) + "";
				if(!sotaikhoan.equals(soTaiKhoanCanTim)) {
					stkCuaNguoiDungCanXoa.add(sotaikhoan);
				}
			}
		}
		for(String stkCanXoa : stkCuaNguoiDungCanXoa) {
			soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String soTaiKhoanTrongTable = model_table.getValueAt(i, 0) +"";
				if(soTaiKhoanTrongTable.equals(stkCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch(Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	// tìm ra tài khoản có số dưng cao nhất trong 3 loại tài khoản ( câu hỏi thêm hôm thuyết trình)
	public void TopsoDu() {
		xoaThongTinTaiKhoan();
		
		ArrayList<TaiKhoan> ds_taikhoanTT = TaiKhoanThanhToan_Dao.getInstance().selectAll();
		ArrayList<TaiKhoanTietKiem> ds_taikhoanTK = TaiKhoanTietKiem_Dao.getInstance().selectAll();
		ArrayList<TaiKhoanVayVon> ds_taikhoanVV = TaiKhoanVayVon_Dao.getInstance().selectAll();

		double max1 = 0;
		TaiKhoan tk = null;
for (TaiKhoan TT : ds_taikhoanTT) {
			if(TT.getSodutk() > max1 ) {
				max1 = TT.getSodutk();
				tk = TT;
			}
			
			
		}
	
		TaiKhoanTietKiem ttk = null;
		double max2 = 0;
		for (TaiKhoanTietKiem TK : ds_taikhoanTK) {
			
			if(TK.getSodutk() > max2 ) {
				max2 = TK.getSodutk();
				ttk = TK;
			}
			
					
			
		}
		
		double max3= 0;
		TaiKhoanVayVon tvv = null;

		for (TaiKhoanVayVon VV : ds_taikhoanVV) {
			
			if(VV.getSodutk() > max2 ) {
				max2 = VV.getSodutk();
				tvv = VV;
			}
		}
		DefaultTableModel model_table3 = (DefaultTableModel)table_DSTK.getModel();
		model_table3.addRow(new Object[] { 
				tk.getSotk(), tk.getTentk(), tk.getSodutk(),"Tài Khoản Thanh toán"
				
		});
		model_table3.addRow(new Object[] { 
				ttk.getSotk(), ttk.getTentk(), ttk.getSodutk(),"Tài Khoản tiết kiệm"
				
		});
		model_table3.addRow(new Object[] { 
				tvv.getSotk(), tvv.getTentk(), tvv.getSodutk(),"Tài Khoản vay vốn"
				
		});

		
	}
     // thêm lịch sử giao dịch các giao dịch lấy từ csdl
	public void themVaoBang_gd() {
		ArrayList<GiaoDich> danhSachGiaoDich = GiaoDich_Dao.getInstance().selectAll();
		
		DefaultTableModel model_table_gd = (DefaultTableModel)table_gd.getModel();
		for (GiaoDich giaoDich : danhSachGiaoDich) {
			LocalDateTime localDate = giaoDich.getThoiGian_giaodich();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String formattedDate = localDate.format(formatter);
			model_table_gd.addRow(new Object[] {giaoDich.getMagiaodich(), giaoDich.getSotien(), formattedDate, giaoDich.getTaikhoan_gui(), giaoDich.getLoai_giaodich(),giaoDich.getTaikhoan_nhan()});
		}
		
		
	}
	//tìm kiếm theo mã giao dịch
	public void timGiaoDich() {
		String soGDCanTim =  this.textField_nhapMGD.getText();
		DefaultTableModel model_table = (DefaultTableModel) table_gd.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<String> sgdCuaNguoiDungCanXoa = new TreeSet<>();
		
		if(soGDCanTim.length() > 0) {
			for(int i = 0; i < soLuongDong; i++) {
				String sotaikhoan = model_table.getValueAt(i, 0) + "";
				if(!sotaikhoan.equals(soGDCanTim)) {
					sgdCuaNguoiDungCanXoa.add(sotaikhoan);
				}
			}
		}
		for(String sgdCanXoa : sgdCuaNguoiDungCanXoa) {
			soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String soTaiKhoanTrongTable = model_table.getValueAt(i, 0) +"";
				if(soTaiKhoanTrongTable.equals(sgdCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch(Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
}