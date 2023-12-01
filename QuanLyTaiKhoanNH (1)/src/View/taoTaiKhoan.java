package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JTabbedPane;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;

import Controller.NAV_controller;
import Controller.TaikhoanTK_controller;
import Controller.taiKhoanVV_controller;
import Controller.taikhoan_controller;
import Controller.taoTaiKhoan_controller;
                          
                
                            /*Phần tạo tài khoản */

public class taoTaiKhoan extends JFrame {

	private JPanel contentPane;

	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	public JTextField textField_STK;
	public  JTextField textField_ST;
	public  JTextField textField_nhapSTK;
	public  JTextField textField_nhapTTK;
	public  JTextField textField_nhapST;
	public  JTextField textField_nhapSTKTK;
	public  JTextField textField_nhapTTKTK;
	public  JTextField textField_STG;
	public  JTextField textField_nhapSTKVV;
	public  JTextField textField_nhapTTKVV;
	public  JTextField textField_STGVV;
	public  JTextField textField_nhapSTVVV;
	public JDateChooser dateChooser_ngayGui;
	public JDateChooser dateChooser_ngayVay;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taoTaiKhoan frame = new taoTaiKhoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public taoTaiKhoan() {
		ActionListener ac = new taoTaiKhoan_controller(this);
		
		setTitle("Quản lí tài khoản ngân hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 591);
		setResizable(false);
		
		URL icon_title = taoTaiKhoan.class.getResource("icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(icon_title);
		this.setIconImage(img);
		
		Action ac0 = new taikhoan_controller(this);
		
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
		
		JMenuItem menu_quanLiTT = new JMenuItem("Quản lí");
		menu_quanLiTT.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_quanLi.add(menu_quanLiTT);
		menu_quanLiTT.addActionListener(ac);
		
		JMenu menu_thoat = new JMenu("Thoát");
		menu_thoat.setFont(new Font("Arial", Font.PLAIN, 17));
		menuBar.add(menu_thoat);
		menu_thoat.addActionListener(ac);
		
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
		tabbedPane_main.setBounds(10, 0, 757, 527);
		contentPane.add(tabbedPane_main);
		
		JPanel panel_TKTT = new JPanel();
		panel_TKTT.setBackground(new Color(255, 255, 255));
		tabbedPane_main.addTab("Tài khoản thanh toán", null, panel_TKTT, null);
		panel_TKTT.setLayout(null);
		
		JLabel label_taoTKTT = new JLabel("Tạo tài khoản thanh toán");
		label_taoTKTT.setFont(new Font("Arial", Font.PLAIN, 27));
		label_taoTKTT.setBounds(210, 30, 325, 70);
		panel_TKTT.add(label_taoTKTT);
		
		JLabel label_nhapSTK = new JLabel("Nhập số tài khoản");
		label_nhapSTK.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapSTK.setBounds(60, 105, 232, 70);
		panel_TKTT.add(label_nhapSTK);
		
		textField_nhapSTK = new JTextField();
		textField_nhapSTK.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTK.setOpaque(false);
		textField_nhapSTK.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapSTK.setBorder(BorderFactory.createCompoundBorder(


						        new MatteBorder(0, 0, 2, 0, Color.BLACK),


						        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTK.setBounds(265, 110, 398, 60);
		panel_TKTT.add(textField_nhapSTK);
		
		JLabel label_nhapTTK = new JLabel("Nhập tên tài khoản");
		label_nhapTTK.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapTTK.setBounds(60, 225, 232, 70);
		panel_TKTT.add(label_nhapTTK);
		
		textField_nhapTTK = new JTextField();
		textField_nhapTTK.setPreferredSize(new Dimension(150, 20));
		textField_nhapTTK.setOpaque(false);
		textField_nhapTTK.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapTTK.setBorder(BorderFactory.createCompoundBorder(



								        new MatteBorder(0, 0, 2, 0, Color.BLACK),



								        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapTTK.setBounds(265, 230, 398, 60);
		panel_TKTT.add(textField_nhapTTK);
		
		JLabel label_nhapST = new JLabel("Nhập số tiền gửi");
		label_nhapST.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapST.setBounds(60, 345, 232, 70);
		panel_TKTT.add(label_nhapST);
		
		textField_nhapST = new JTextField();
		textField_nhapST.setPreferredSize(new Dimension(150, 20));
		textField_nhapST.setOpaque(false);
		textField_nhapST.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapST.setBorder(BorderFactory.createCompoundBorder(




										        new MatteBorder(0, 0, 2, 0, Color.BLACK),




										        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapST.setBounds(267, 350, 398, 60);
		panel_TKTT.add(textField_nhapST);
		
		JButton button_xacNhanTT = new JButton("Xác nhận");
		button_xacNhanTT.addActionListener(ac0);
		button_xacNhanTT.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xacNhanTT.setBounds(553, 450, 110, 29);
		panel_TKTT.add(button_xacNhanTT);
		
		JLabel label_dangTien = new JLabel("đ");
		label_dangTien.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTien.setBounds(650, 370, 10, 13);
		panel_TKTT.add(label_dangTien);
		
		JPanel panel_TKTK = new JPanel();
		panel_TKTK.setBackground(new Color(255, 255, 255));
		tabbedPane_main.addTab("Tài khoản tiết kiệm", null, panel_TKTK, null);
		panel_TKTK.setLayout(null);
		
		JLabel label_taoTKTK = new JLabel("Tạo tài khoản tiết kiệm");
		label_taoTKTK.setFont(new Font("Arial", Font.PLAIN, 27));
		label_taoTKTK.setBounds(220, 30, 282, 70);
		panel_TKTK.add(label_taoTKTK);
		
		JLabel label_nhapSTKTK = new JLabel("Nhập số tài khoản");
		label_nhapSTKTK.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapSTKTK.setBounds(70, 90, 232, 70);
		panel_TKTK.add(label_nhapSTKTK);
		
		textField_nhapSTKTK = new JTextField();
		textField_nhapSTKTK.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTKTK.setOpaque(false);
		textField_nhapSTKTK.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapSTKTK.setBorder(BorderFactory.createCompoundBorder(



								        new MatteBorder(0, 0, 2, 0, Color.BLACK),



								        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTKTK.setBounds(270, 95, 398, 60);
		panel_TKTK.add(textField_nhapSTKTK);
		
		JLabel label_nhapTTKTK = new JLabel("Nhập tên tài khoản");
		label_nhapTTKTK.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapTTKTK.setBounds(70, 170, 232, 70);
		panel_TKTK.add(label_nhapTTKTK);
		
		textField_nhapTTKTK = new JTextField();
		textField_nhapTTKTK.setPreferredSize(new Dimension(150, 20));
		textField_nhapTTKTK.setOpaque(false);
		textField_nhapTTKTK.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapTTKTK.setBorder(BorderFactory.createCompoundBorder(




										        new MatteBorder(0, 0, 2, 0, Color.BLACK),




										        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapTTKTK.setBounds(269, 175, 398, 60);
		panel_TKTK.add(textField_nhapTTKTK);
		
		JLabel label_nhapSTG = new JLabel("Nhập số tiền gửi");
		label_nhapSTG.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapSTG.setBounds(70, 250, 232, 70);
		panel_TKTK.add(label_nhapSTG);
		
		textField_STG = new JTextField();
		textField_STG.setPreferredSize(new Dimension(150, 20));
		textField_STG.setOpaque(false);
		textField_STG.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_STG.setBorder(BorderFactory.createCompoundBorder(





												        new MatteBorder(0, 0, 2, 0, Color.BLACK),





												        new EmptyBorder(0, 0, 0, 0)));
		textField_STG.setBounds(269, 255, 398, 60);
		panel_TKTK.add(textField_STG);
		
		JLabel label_nhapNG = new JLabel("Nhập ngày gửi");
		label_nhapNG.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapNG.setBounds(70, 330, 232, 70);
		panel_TKTK.add(label_nhapNG);
		
	    dateChooser_ngayGui = new JDateChooser();
		dateChooser_ngayGui.setForeground(Color.BLACK);
		dateChooser_ngayGui.setFont(new Font("Arial", Font.PLAIN, 17));
		dateChooser_ngayGui.setDateFormatString("y/ M/ d");
		dateChooser_ngayGui.setBounds(422, 355, 245, 38);
		panel_TKTK.add(dateChooser_ngayGui);
		ActionListener ac1 = new TaikhoanTK_controller(this);
		JButton button_xacNhanTK = new JButton("Xác nhận");
		button_xacNhanTK.addActionListener(ac1);
		button_xacNhanTK.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xacNhanTK.setBounds(558, 442, 110, 29);
		panel_TKTK.add(button_xacNhanTK);
		
		JLabel label_dangTienTK = new JLabel("đ");
		label_dangTienTK.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienTK.setBounds(644, 277, 10, 13);
		panel_TKTK.add(label_dangTienTK);
		
		JPanel panel_TKVV = new JPanel();
		panel_TKVV.setBackground(new Color(255, 255, 255));
		tabbedPane_main.addTab("Tài khoản vay vốn", null, panel_TKVV, null);
		panel_TKVV.setLayout(null);
		
		JLabel label_taoTKVV = new JLabel("Tạo tài khoản vay vốn");
		label_taoTKVV.setFont(new Font("Arial", Font.PLAIN, 27));
		label_taoTKVV.setBounds(220, 10, 282, 70);
		panel_TKVV.add(label_taoTKVV);
		
		JLabel label_nhapSTKVV = new JLabel("Nhập số tài khoản");
		label_nhapSTKVV.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapSTKVV.setBounds(70, 65, 232, 70);
		panel_TKVV.add(label_nhapSTKVV);
		
		textField_nhapSTKVV = new JTextField();
		textField_nhapSTKVV.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTKVV.setOpaque(false);
		textField_nhapSTKVV.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapSTKVV.setBorder(BorderFactory.createCompoundBorder(




										        new MatteBorder(0, 0, 2, 0, Color.BLACK),




										        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTKVV.setBounds(270, 70, 398, 60);
		panel_TKVV.add(textField_nhapSTKVV);
		
		JLabel label_nhapTTKVV = new JLabel("Nhập tên tài khoản");
		label_nhapTTKVV.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapTTKVV.setBounds(70, 145, 232, 70);
		panel_TKVV.add(label_nhapTTKVV);
		
		textField_nhapTTKVV = new JTextField();
		textField_nhapTTKVV.setPreferredSize(new Dimension(150, 20));
		textField_nhapTTKVV.setOpaque(false);
		textField_nhapTTKVV.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapTTKVV.setBorder(BorderFactory.createCompoundBorder(





												        new MatteBorder(0, 0, 2, 0, Color.BLACK),





												        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapTTKVV.setBounds(270, 150, 398, 60);
		panel_TKVV.add(textField_nhapTTKVV);
		
		textField_STGVV = new JTextField();
		textField_STGVV.setPreferredSize(new Dimension(150, 20));
		textField_STGVV.setOpaque(false);
		textField_STGVV.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_STGVV.setBorder(BorderFactory.createCompoundBorder(





												        new MatteBorder(0, 0, 2, 0, Color.BLACK),





												        new EmptyBorder(0, 0, 0, 0)));
		textField_STGVV.setBounds(270, 230, 398, 60);
		panel_TKVV.add(textField_STGVV);
		
		textField_nhapSTVVV = new JTextField();
		textField_nhapSTVVV.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTVVV.setOpaque(false);
		textField_nhapSTVVV.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_nhapSTVVV.setBorder(BorderFactory.createCompoundBorder(





												        new MatteBorder(0, 0, 2, 0, Color.BLACK),





												        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTVVV.setBounds(270, 310, 398, 60);
		panel_TKVV.add(textField_nhapSTVVV);
		
	    dateChooser_ngayVay = new JDateChooser();
		dateChooser_ngayVay.setForeground(Color.BLACK);
		dateChooser_ngayVay.setFont(new Font("Arial", Font.PLAIN, 17));
		dateChooser_ngayVay.setDateFormatString("y/ M/ d");
		dateChooser_ngayVay.setBounds(423, 395, 245, 38);
		panel_TKVV.add(dateChooser_ngayVay);
		
		JLabel label_nhapSTGVV = new JLabel("Nhập số tiền gửi cọc");
		label_nhapSTGVV.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapSTGVV.setBounds(70, 225, 232, 70);
		panel_TKVV.add(label_nhapSTGVV);
		
		JLabel label_nhapSTVVV = new JLabel("Nhập số tiền vay");
		label_nhapSTVVV.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapSTVVV.setBounds(70, 305, 232, 70);
		panel_TKVV.add(label_nhapSTVVV);
		
		JLabel label_nhapNVVV = new JLabel("Nhập ngày vay");
		label_nhapNVVV.setFont(new Font("Arial", Font.PLAIN, 20));
		label_nhapNVVV.setBounds(70, 385, 232, 70);
		panel_TKVV.add(label_nhapNVVV);
		
		ActionListener ac2 = new taiKhoanVV_controller(this);
		JButton button_xacNhanVV = new JButton("Xác nhận");
		button_xacNhanVV.addActionListener(ac2);
		button_xacNhanVV.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xacNhanVV.setBounds(558, 456, 110, 29);
		panel_TKVV.add(button_xacNhanVV);
		
		JLabel label_dangTienVV = new JLabel("đ");
		label_dangTienVV.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienVV.setBounds(658, 252, 10, 13);
		panel_TKVV.add(label_dangTienVV);
		
		JLabel label_dangTienVVV = new JLabel("đ");
		label_dangTienVVV.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienVVV.setBounds(658, 332, 10, 13);
		panel_TKVV.add(label_dangTienVVV);
		
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/*xóa form trên text field */
	
	public void removeForm() {
	textField_nhapSTK.setText("");
	textField_nhapTTK.setText("");
	textField_nhapST.setText("");
	
	textField_nhapSTKTK.setText("");
	textField_nhapTTKTK.setText("");
	textField_STG.setText("");
	dateChooser_ngayGui.setCalendar(null);
	
	textField_nhapSTKVV.setText("");
	textField_nhapTTKVV.setText("");
	textField_STGVV.setText("");
	textField_nhapSTVVV.setText("");
    dateChooser_ngayVay.setCalendar(null);
	}
}
