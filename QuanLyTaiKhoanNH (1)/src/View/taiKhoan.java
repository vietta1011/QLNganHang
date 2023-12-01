package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JTabbedPane;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import Controller.TaiKhoanThanhToan_GD_controller;
import Controller.TaiKhoanTietKiem_GD_controller;
import Controller.TaiKhoanVayVon_GD_Controller;
import Controller.taiKhoanGD_controller;
import QLTKNH.QL_TaiKhoan;
                  

                /*phần view các phương thức của tài khoản ngân hàng */                  

public class taiKhoan extends JFrame {
    
    public JPanel contentPane;

	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	public JTextField textField_soTienGui;
	public JTextField textField__soTaiKhoanGui;
	public JTextField textThng;
	public JTextField textField_tienNhan;
	public JTextField textField_soTaiKhoanRutTk;
	public JTextField textField_soTaiKhoan;
	public JTextField textField_STK;
	public JTextField textField_nhapSTKN;
	public JTextField textField_nhapSTN;
	public JTextField textField_nhapSTKR;
	public JTextField textField_nhapSTKG;
	public JTextField textField_nhapSTKNh;
	public JTextField textField_nhapSTCK;
	public JTextField textField;
	public JTextField textField_STKVV;
	public JTextField textField_2;
	public JTextField textField_nhapSTR;
	public JDateChooser dateChooser_ngayGui;
	public JDateChooser dateChooser_ngayThanhToan;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taiKhoan frame = new taiKhoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public taiKhoan() {
		ActionListener ac = new taiKhoanGD_controller(this);
		setTitle("Quản lí tài khoản ngân hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 692);
		setResizable(false);
		
		URL icon_title = taiKhoan.class.getResource("icon.png");
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
		
		JMenuItem menu_taoTaiKhoan = new JMenuItem("Tạo tài khoản");
		menu_taoTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_quanLi.add(menu_taoTaiKhoan);
		menu_taoTaiKhoan.addActionListener(ac);
		
		JMenuItem menu_quanLiTT = new JMenuItem("Quản lí");
		menu_quanLiTT.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_quanLi.add(menu_quanLiTT);
		menu_quanLiTT.addActionListener(ac);
		
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
		contentPane = new JPanel();
		menu_dangXuat.addActionListener(ac);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_main = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_main.setFont(new Font("Arial", Font.PLAIN, 15));
		tabbedPane_main.setBounds(10, 0, 911, 617);
		contentPane.add(tabbedPane_main);
		
		JPanel panel_TKTT = new JPanel();
		panel_TKTT.setBackground(new Color(255, 255, 255));
		tabbedPane_main.addTab("Tài khoản thanh toán", null, panel_TKTT, null);
		panel_TKTT.setLayout(null);
		
		Action ac2 = new TaiKhoanThanhToan_GD_controller(this);
		
		JLabel label_napTien = new JLabel("Nạp tiền");
		label_napTien.setFont(new Font("Arial", Font.PLAIN, 20));
		label_napTien.setBounds(23, 10, 90, 44);
		panel_TKTT.add(label_napTien);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 175, 886, 2);
		panel_TKTT.add(separator);
		
		JLabel label_soTaiKhoanNap = new JLabel("Số tài khoản");
		label_soTaiKhoanNap.setFont(new Font("Arial", Font.PLAIN, 18));
		label_soTaiKhoanNap.setBounds(140, 40, 110, 44);
		panel_TKTT.add(label_soTaiKhoanNap);
		
		JLabel label_soTienNap = new JLabel("Số tiền");
		label_soTienNap.setFont(new Font("Arial", Font.PLAIN, 18));
		label_soTienNap.setBounds(140, 100, 110, 44);
		panel_TKTT.add(label_soTienNap);
		
		JLabel label_rutTien = new JLabel("Rút tiền");
		label_rutTien.setFont(new Font("Arial", Font.PLAIN, 20));
		label_rutTien.setBounds(23, 180, 90, 44);
		panel_TKTT.add(label_rutTien);
		
		JLabel label_soTaiKhoanRut = new JLabel("Số tài khoản");
		label_soTaiKhoanRut.setFont(new Font("Arial", Font.PLAIN, 18));
		label_soTaiKhoanRut.setBounds(140, 210, 110, 44);
		panel_TKTT.add(label_soTaiKhoanRut);
		
		JLabel label_soTienRut = new JLabel("Số tiền");
		label_soTienRut.setFont(new Font("Arial", Font.PLAIN, 18));
		label_soTienRut.setBounds(140, 270, 110, 44);
		panel_TKTT.add(label_soTienRut);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 340, 886, 2);
		panel_TKTT.add(separator_1);
		
		JButton button_nap = new JButton("Nạp Tiền");
		button_nap.setFont(new Font("Arial", Font.PLAIN, 15));
		button_nap.setBounds(790, 77, 100, 30);
		panel_TKTT.add(button_nap);
		button_nap.addActionListener(ac2);
		
		JButton button_rut = new JButton("Rút Tiền");
		button_rut.setFont(new Font("Arial", Font.PLAIN, 15));
		button_rut.setBounds(790, 243, 100, 30);
		panel_TKTT.add(button_rut);
		button_rut.addActionListener(ac2);
		
		JLabel label_chuyenKhoan = new JLabel("Chuyển khoản");
		label_chuyenKhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		label_chuyenKhoan.setBounds(23, 340, 130, 44);
		panel_TKTT.add(label_chuyenKhoan);
		
		JLabel label_soTaiKhoanChuyen = new JLabel("Số tài khoản gửi");
		label_soTaiKhoanChuyen.setFont(new Font("Arial", Font.PLAIN, 18));
		label_soTaiKhoanChuyen.setBounds(105, 390, 145, 44);
		panel_TKTT.add(label_soTaiKhoanChuyen);
		
		JLabel label_soTaiKhoanNhan = new JLabel("Số tài khoản nhận");
		label_soTaiKhoanNhan.setFont(new Font("Arial", Font.PLAIN, 18));
		label_soTaiKhoanNhan.setBounds(105, 460, 145, 44);
		panel_TKTT.add(label_soTaiKhoanNhan);
		
		JLabel label_soTienChuyen = new JLabel("Số tiền");
		label_soTienChuyen.setFont(new Font("Arial", Font.PLAIN, 18));
		label_soTienChuyen.setBounds(105, 530, 110, 44);
		panel_TKTT.add(label_soTienChuyen);
		
		JButton button_chuyen = new JButton("Chuyển");
		button_chuyen.setFont(new Font("Arial", Font.PLAIN, 15));
		button_chuyen.setBounds(790, 465, 100, 30);
		panel_TKTT.add(button_chuyen);
		button_chuyen.addActionListener(ac2);
		
		textField_nhapSTKN = new JTextField();
		textField_nhapSTKN.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTKN.setOpaque(false);
		textField_nhapSTKN.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_nhapSTKN.setBorder(BorderFactory.createCompoundBorder(

				        new MatteBorder(0, 0, 2, 0, Color.BLACK),

				        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTKN.setBounds(260, 33, 500, 60);
		panel_TKTT.add(textField_nhapSTKN);
		
		textField_nhapSTN = new JTextField();
		textField_nhapSTN.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTN.setOpaque(false);
		textField_nhapSTN.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_nhapSTN.setBorder(BorderFactory.createCompoundBorder(

				        new MatteBorder(0, 0, 2, 0, Color.BLACK),

				        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTN.setBounds(260, 93, 500, 60);
		panel_TKTT.add(textField_nhapSTN);
		
		textField_nhapSTKR = new JTextField();
		textField_nhapSTKR.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTKR.setOpaque(false);
		textField_nhapSTKR.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_nhapSTKR.setBorder(BorderFactory.createCompoundBorder(

				        new MatteBorder(0, 0, 2, 0, Color.BLACK),

				        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTKR.setBounds(260, 203, 500, 60);
		panel_TKTT.add(textField_nhapSTKR);
		
        textField_nhapSTR = new JTextField();
		textField_nhapSTR.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTR.setOpaque(false);
		textField_nhapSTR.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_nhapSTR.setBorder(BorderFactory.createCompoundBorder(

				        new MatteBorder(0, 0, 2, 0, Color.BLACK),

				        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTR.setBounds(260, 263, 500, 60);
		panel_TKTT.add(textField_nhapSTR);
		
		textField_nhapSTKG = new JTextField();
		textField_nhapSTKG.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTKG.setOpaque(false);
		textField_nhapSTKG.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_nhapSTKG.setBorder(BorderFactory.createCompoundBorder(

				        new MatteBorder(0, 0, 2, 0, Color.BLACK),

				        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTKG.setBounds(260, 383, 500, 60);
		panel_TKTT.add(textField_nhapSTKG);
		
		textField_nhapSTKNh = new JTextField();
		textField_nhapSTKNh.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTKNh.setOpaque(false);
		textField_nhapSTKNh.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_nhapSTKNh.setBorder(BorderFactory.createCompoundBorder(

				        new MatteBorder(0, 0, 2, 0, Color.BLACK),

				        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTKNh.setBounds(260, 453, 500, 60);
		panel_TKTT.add(textField_nhapSTKNh);
		
		textField_nhapSTCK = new JTextField();
		textField_nhapSTCK.setPreferredSize(new Dimension(150, 20));
		textField_nhapSTCK.setOpaque(false);
		textField_nhapSTCK.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_nhapSTCK.setBorder(BorderFactory.createCompoundBorder(

				        new MatteBorder(0, 0, 2, 0, Color.BLACK),

				        new EmptyBorder(0, 0, 0, 0)));
		textField_nhapSTCK.setBounds(260, 523, 500, 60);
		panel_TKTT.add(textField_nhapSTCK);
		
		JLabel label_dangTienNap = new JLabel("đ");
		label_dangTienNap.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienNap.setBounds(744, 115, 10, 13);
		panel_TKTT.add(label_dangTienNap);
		
		JLabel label_dangTienRut = new JLabel("đ");
		label_dangTienRut.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienRut.setBounds(744, 285, 10, 13);
		panel_TKTT.add(label_dangTienRut);
		
		JLabel label_dangTienChuyenKhoan = new JLabel("đ");
		label_dangTienChuyenKhoan.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienChuyenKhoan.setBounds(744, 545, 10, 13);
		panel_TKTT.add(label_dangTienChuyenKhoan);
		
		JPanel panel_TKTK = new JPanel();
		panel_TKTK.setBackground(new Color(255, 255, 255));
		tabbedPane_main.addTab("Tài khoản tiết kiệm", null, panel_TKTK, null);
		panel_TKTK.setLayout(null);
		
		JLabel label_guiTienTietKiem = new JLabel("Gửi tiền tiết kiệm");
		label_guiTienTietKiem.setFont(new Font("Arial", Font.PLAIN, 27));
		label_guiTienTietKiem.setBounds(345, 10, 214, 53);
		panel_TKTK.add(label_guiTienTietKiem);
		
		JLabel label_soTienGui = new JLabel("Số tiền gửi");
		label_soTienGui.setFont(new Font("Arial", Font.PLAIN, 20));
		label_soTienGui.setBounds(49, 30, 214, 53);
		panel_TKTK.add(label_soTienGui);
		
		textField_soTienGui = new JTextField(20);
		textField_soTienGui.setFont(new Font("Arial", Font.PLAIN, 17));
		textField_soTienGui.setBounds(49, 70, 313, 60);
		panel_TKTK.add(textField_soTienGui);
		textField_soTienGui.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 2, 0, Color.BLACK),
                new EmptyBorder(0, 0, 0, 0)));
		textField_soTienGui.setOpaque(false);
		textField_soTienGui.setPreferredSize(new Dimension(150, 20));
		
		JLabel label_dangTien = new JLabel("đ");
		label_dangTien.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTien.setBounds(337, 90, 10, 13);
		panel_TKTK.add(label_dangTien);
		
		JLabel label_soTaiKhoanGui = new JLabel("Số tài khoản gửi");
		label_soTaiKhoanGui.setFont(new Font("Arial", Font.PLAIN, 20));
		label_soTaiKhoanGui.setBounds(49, 140, 214, 53);
		panel_TKTK.add(label_soTaiKhoanGui);
		
		textField__soTaiKhoanGui = new JTextField();
		textField__soTaiKhoanGui.setFont(new Font("Arial", Font.PLAIN, 17));
		textField__soTaiKhoanGui.setBorder(BorderFactory.createCompoundBorder(
		        new MatteBorder(0, 0, 2, 0, Color.BLACK),
		        new EmptyBorder(0, 0, 0, 0)));
		textField__soTaiKhoanGui.setBounds(49, 190, 313, 60);
		textField__soTaiKhoanGui.setPreferredSize(new Dimension(150, 20));
		textField__soTaiKhoanGui.setOpaque(false);
		panel_TKTK.add(textField__soTaiKhoanGui);
		
		JLabel label_kyHan_laiSuat = new JLabel("Kỳ hạn           /           Lãi suất ");
		label_kyHan_laiSuat.setFont(new Font("Arial", Font.PLAIN, 20));
		label_kyHan_laiSuat.setBounds(49, 380, 298, 53);
		panel_TKTK.add(label_kyHan_laiSuat);
		
		textThng = new JTextField();
		textThng.setEditable(false);
		textThng.setText("6 tháng             /               6%");
		textThng.setPreferredSize(new Dimension(150, 20));
		textThng.setOpaque(false);
		textThng.setFont(new Font("Arial", Font.PLAIN, 17));
		textThng.setBorder(BorderFactory.createCompoundBorder(
		        new MatteBorder(0, 0, 2, 0, Color.BLACK),
		        new EmptyBorder(0, 0, 0, 0)));
		textThng.setBounds(49, 440, 313, 60);
		panel_TKTK.add(textThng);
		
		JPanel panel_tinhLai = new JPanel();
		panel_tinhLai.setBackground(new Color(240, 240, 240));
		panel_tinhLai.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_tinhLai.setBounds(452, 125, 420, 360);
		panel_TKTK.add(panel_tinhLai);
		panel_tinhLai.setLayout(null);
		
		JLabel label_soTienRutTk = new JLabel("Số tiền rút");
		label_soTienRutTk.setFont(new Font("Arial", Font.PLAIN, 20));
		label_soTienRutTk.setBounds(30, 20, 202, 53);
		panel_tinhLai.add(label_soTienRutTk);
		
		textField_tienNhan = new JTextField(20);
		textField_tienNhan.setPreferredSize(new Dimension(150, 20));
		textField_tienNhan.setOpaque(false);
		textField_tienNhan.setFont(new Font("Arial", Font.PLAIN, 17));
		textField_tienNhan.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 2, 0, Color.BLACK),
                new EmptyBorder(0, 0, 0, 0)));
		textField_tienNhan.setBounds(30, 70, 313, 60);
		panel_tinhLai.add(textField_tienNhan);
		
		JLabel label_dangTienLai = new JLabel("đ");
		label_dangTienLai.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienLai.setBounds(319, 90, 10, 13);
		panel_tinhLai.add(label_dangTienLai);
		
		JLabel label_soTaiKhoanRutTk = new JLabel("Số tài khoản ");
		label_soTaiKhoanRutTk.setFont(new Font("Arial", Font.PLAIN, 20));
		label_soTaiKhoanRutTk.setBounds(30, 140, 214, 53);
		panel_tinhLai.add(label_soTaiKhoanRutTk);
		
		textField_soTaiKhoanRutTk = new JTextField(20);
		textField_soTaiKhoanRutTk.setPreferredSize(new Dimension(150, 20));
		textField_soTaiKhoanRutTk.setOpaque(false);
		textField_soTaiKhoanRutTk.setFont(new Font("Arial", Font.PLAIN, 17));
		textField_soTaiKhoanRutTk.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 2, 0, Color.BLACK),
                new EmptyBorder(0, 0, 0, 0)));
		textField_soTaiKhoanRutTk.setBounds(30, 190, 313, 60);
		panel_tinhLai.add(textField_soTaiKhoanRutTk);
		
		Action ac3 = new TaiKhoanTietKiem_GD_controller(this);
		
		JButton button_xacNhanRutTk = new JButton("Rút Tiền");
		button_xacNhanRutTk.addActionListener(ac3);
		button_xacNhanRutTk.setFont(new Font("Arial", Font.PLAIN, 15));
		button_xacNhanRutTk.setBounds(157, 296, 105, 27);
		panel_tinhLai.add(button_xacNhanRutTk);
		
		JButton button_xacNhan = new JButton("Gửi Tiền");
		button_xacNhan.addActionListener(ac3);
		button_xacNhan.setFont(new Font("Arial", Font.PLAIN, 15));
		button_xacNhan.setBounds(150, 533, 105, 27);
		panel_TKTK.add(button_xacNhan);
		
		JLabel label_ngayGui = new JLabel("Ngày gửi");
		label_ngayGui.setFont(new Font("Arial", Font.PLAIN, 20));
		label_ngayGui.setBounds(49, 270, 214, 53);
		panel_TKTK.add(label_ngayGui);
		
		 dateChooser_ngayGui = new JDateChooser();
		dateChooser_ngayGui.setFont(new Font("Arial", Font.PLAIN, 17));
		dateChooser_ngayGui.setForeground(new Color(0, 0, 0));
		dateChooser_ngayGui.setDateFormatString("y/ M/ d");
		dateChooser_ngayGui.setBounds(49, 330, 313, 38);
		panel_TKTK.add(dateChooser_ngayGui);
		
		JPanel panel_TKVV = new JPanel();
		panel_TKVV.setBackground(new Color(255, 255, 255));
		tabbedPane_main.addTab("Tài khoản vay vốn", null, panel_TKVV, null);
		panel_TKVV.setLayout(null);
		
		JPanel panel_napRutVayVon = new JPanel();
		panel_napRutVayVon.setBackground(new Color(192, 192, 192));
		panel_napRutVayVon.setBounds(10, 10, 465, 565);
		panel_TKVV.add(panel_napRutVayVon);
		panel_napRutVayVon.setLayout(null);
		
		JLabel label_napTienVV = new JLabel("Nạp tiền");
		label_napTienVV.setFont(new Font("Arial", Font.PLAIN, 23));
		label_napTienVV.setBounds(180, 10, 91, 48);
		panel_napRutVayVon.add(label_napTienVV);
		
		JLabel label_soTaiKhoan = new JLabel("Số tài khoản");
		label_soTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		label_soTaiKhoan.setBounds(10, 50, 154, 48);
		panel_napRutVayVon.add(label_soTaiKhoan);
		
		textField_soTaiKhoan = new JTextField();
		textField_soTaiKhoan.setPreferredSize(new Dimension(150, 20));
		textField_soTaiKhoan.setOpaque(false);
		textField_soTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_soTaiKhoan.setBorder(BorderFactory.createCompoundBorder(

				        new MatteBorder(0, 0, 2, 0, Color.BLACK),

				        new EmptyBorder(0, 0, 0, 0)));
		textField_soTaiKhoan.setBounds(142, 70, 313, 60);
		panel_napRutVayVon.add(textField_soTaiKhoan);
		
		JLabel label_soTienNapVV = new JLabel("Số tiền");
		label_soTienNapVV.setFont(new Font("Arial", Font.PLAIN, 20));
		label_soTienNapVV.setBounds(10, 140, 154, 48);
		panel_napRutVayVon.add(label_soTienNapVV);
		Action ac4 = new TaiKhoanVayVon_GD_Controller(this);
		JButton button_xacNhanNapVV = new JButton("Nạp Tiền");
		button_xacNhanNapVV.addActionListener(ac4);
		button_xacNhanNapVV.setBackground(new Color(255, 255, 255));
		button_xacNhanNapVV.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xacNhanNapVV.setBounds(160, 240, 108, 29);
		panel_napRutVayVon.add(button_xacNhanNapVV);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(150, 20));
		textField.setOpaque(false);
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setBorder(BorderFactory.createCompoundBorder(


						        new MatteBorder(0, 0, 2, 0, Color.BLACK),


						        new EmptyBorder(0, 0, 0, 0)));
		textField.setBounds(142, 160, 313, 60);
		panel_napRutVayVon.add(textField);
		
		JLabel label_dangTienVV = new JLabel("đ");
		label_dangTienVV.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienVV.setBounds(435, 180, 10, 13);
		panel_napRutVayVon.add(label_dangTienVV);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 275, 445, 2);
		panel_napRutVayVon.add(separator_2);
		
		JLabel label_rutTienVV = new JLabel("Rút tiền");
		label_rutTienVV.setFont(new Font("Arial", Font.PLAIN, 23));
		label_rutTienVV.setBounds(180, 280, 91, 48);
		panel_napRutVayVon.add(label_rutTienVV);
		
		JLabel label_soTaiKhoanVayVon = new JLabel("Số tài khoản");
		label_soTaiKhoanVayVon.setFont(new Font("Arial", Font.PLAIN, 20));
		label_soTaiKhoanVayVon.setBounds(10, 310, 154, 48);
		panel_napRutVayVon.add(label_soTaiKhoanVayVon);
		
		textField_STKVV = new JTextField();
		textField_STKVV.setPreferredSize(new Dimension(150, 20));
		textField_STKVV.setOpaque(false);
		textField_STKVV.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_STKVV.setBorder(BorderFactory.createCompoundBorder(


						        new MatteBorder(0, 0, 2, 0, Color.BLACK),


						        new EmptyBorder(0, 0, 0, 0)));
		textField_STKVV.setBounds(142, 330, 313, 60);
		panel_napRutVayVon.add(textField_STKVV);
		
		JLabel label_soTienNapVV_1 = new JLabel("Số tiền");
		label_soTienNapVV_1.setFont(new Font("Arial", Font.PLAIN, 20));
		label_soTienNapVV_1.setBounds(10, 390, 154, 48);
		panel_napRutVayVon.add(label_soTienNapVV_1);
		
		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(150, 20));
		textField_2.setOpaque(false);
		textField_2.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_2.setBorder(BorderFactory.createCompoundBorder(



								        new MatteBorder(0, 0, 2, 0, Color.BLACK),



								        new EmptyBorder(0, 0, 0, 0)));
		textField_2.setBounds(142, 410, 313, 60);
		panel_napRutVayVon.add(textField_2);
		
		JButton button_xacNhanNapVV_1 = new JButton("Rút Tiền");
		button_xacNhanNapVV_1.addActionListener(ac4);
		button_xacNhanNapVV_1.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xacNhanNapVV_1.setBackground(Color.WHITE);
		button_xacNhanNapVV_1.setBounds(160, 510, 108, 29);
		panel_napRutVayVon.add(button_xacNhanNapVV_1);
		
		JLabel label_dangTienVV_1 = new JLabel("đ");
		label_dangTienVV_1.setFont(new Font("Arial", Font.PLAIN, 17));
		label_dangTienVV_1.setBounds(435, 430, 10, 13);
		panel_napRutVayVon.add(label_dangTienVV_1);
		
		JPanel panel_thongTinVay = new JPanel();
		panel_thongTinVay.setBounds(485, 157, 411, 418);
		panel_TKVV.add(panel_thongTinVay);
		panel_thongTinVay.setLayout(null);
		
		JLabel label_thanhToanTienVay = new JLabel("Thanh toán tiền vay");
		label_thanhToanTienVay.setFont(new Font("Arial", Font.PLAIN, 23));
		label_thanhToanTienVay.setBounds(110, 10, 207, 49);
		panel_thongTinVay.add(label_thanhToanTienVay);
		
		JLabel label_STK = new JLabel("Số tài khoản");
		label_STK.setFont(new Font("Arial", Font.PLAIN, 20));
		label_STK.setBounds(10, 73, 126, 49);
		panel_thongTinVay.add(label_STK);
		
		textField_STK = new JTextField();
		textField_STK.setPreferredSize(new Dimension(150, 20));
		textField_STK.setOpaque(false);
		textField_STK.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_STK.setBorder(BorderFactory.createCompoundBorder(


						        new MatteBorder(0, 0, 2, 0, Color.BLACK),


						        new EmptyBorder(0, 0, 0, 0)));
		textField_STK.setBounds(88, 100, 313, 60);
		panel_thongTinVay.add(textField_STK);
		
		JLabel label__ngayThanhToan = new JLabel("Ngày thanh toán");
		label__ngayThanhToan.setFont(new Font("Arial", Font.PLAIN, 20));
		label__ngayThanhToan.setBounds(10, 180, 147, 49);
		panel_thongTinVay.add(label__ngayThanhToan);
		
		dateChooser_ngayThanhToan = new JDateChooser();
		dateChooser_ngayThanhToan.setForeground(Color.BLACK);
		dateChooser_ngayThanhToan.setFont(new Font("Arial", Font.PLAIN, 17));
		dateChooser_ngayThanhToan.setDateFormatString("y/ M/ d");
		dateChooser_ngayThanhToan.setBounds(88, 246, 313, 38);
		panel_thongTinVay.add(dateChooser_ngayThanhToan);
		
		JButton button_xacNhanVV = new JButton("Thanh Toán");
		button_xacNhanVV.addActionListener(ac4);
		button_xacNhanVV.setBackground(new Color(255, 255, 255));
		button_xacNhanVV.setFont(new Font("Arial", Font.PLAIN, 17));
		button_xacNhanVV.setBounds(148, 330, 130, 29);
		panel_thongTinVay.add(button_xacNhanVV);
		
		JLabel lblThanhTonVay = new JLabel("Thanh toán vay vốn");
		lblThanhTonVay.setFont(new Font("Arial", Font.PLAIN, 27));
		lblThanhTonVay.setBounds(565, 47, 248, 62);
		panel_TKVV.add(lblThanhTonVay);
		
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/*xóa form trên text field */
	
	public void removeForm() {
		textField_nhapSTKN.setText("");
		textField_nhapSTN.setText("");
		
		textField_nhapSTKR.setText("");
		textField_nhapSTR.setText("");
		
		textField_nhapSTKG.setText("");
		textField_nhapSTKNh.setText("");
		textField_nhapSTCK.setText("");
		
		textField__soTaiKhoanGui.setText("");
		textField_soTienGui.setText("");
		dateChooser_ngayGui.setCalendar(null);
		
		textField_tienNhan.setText("");
		textField_soTaiKhoanRutTk.setText("");
		
		textField_soTaiKhoan.setText("");
		textField.setText("");
		textField_STKVV.setText("");
		textField_2.setText("");
		textField_STK.setText("");
		dateChooser_ngayThanhToan.setCalendar(null);
	}
}
