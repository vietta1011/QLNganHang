package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.NAV_controller;


import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Action;
import javax.swing.ImageIcon;

                    /* phần trang chủ */


public class Navigation extends JFrame {

	private JPanel contentPane_backGround;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigation frame = new Navigation();
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
	public Navigation() {
		ActionListener ac = new NAV_controller(this);
		
		setResizable(false);
		setTitle("Quản lí tài khoản ngân hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 464);
		contentPane_backGround = new JPanel();
		contentPane_backGround.setBackground(new Color(192, 192, 192));
		contentPane_backGround.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		URL icon_title = Navigation.class.getResource("icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(icon_title);
		this.setIconImage(img);
		
		JMenuBar menuBar = new JMenuBar();
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
		menu_quanLiTT.addActionListener(ac);
		
		JMenu menu_thoat = new JMenu("Thoát");
		menu_thoat.setFont(new Font("Arial", Font.PLAIN, 17));
		menuBar.add(menu_thoat);
		
		JMenuItem menu_dangXuat = new JMenuItem("Đăng xuất");
		menu_dangXuat.setFont(new Font("Arial", Font.PLAIN, 15));
		menu_thoat.add(menu_dangXuat);
		menu_dangXuat.addActionListener(ac);

		setContentPane(contentPane_backGround);
		contentPane_backGround.setLayout(null);
		
		JPanel panel_picture = new JPanel();
		panel_picture.setBounds(0, 0, 650, 406);
		contentPane_backGround.add(panel_picture);
		panel_picture.setLayout(null);
		
		JLabel label_picture = new JLabel("");
		label_picture.setIcon(new ImageIcon(Navigation.class.getResource("/View/picture_bank.png")));
		label_picture.setBounds(0, 0, 650, 406);
		panel_picture.add(label_picture);
		
		JPanel panel_navigation = new JPanel();
		panel_navigation.setBounds(650, 0, 323, 406);
		contentPane_backGround.add(panel_navigation);
		panel_navigation.setLayout(null);
		
		JLabel label_trangChu = new JLabel("TRANG CHỦ");
		label_trangChu.setFont(new Font("Arial", Font.BOLD, 25));
		label_trangChu.setBounds(85, 10, 147, 50);
		panel_navigation.add(label_trangChu);
		
		JLabel label_footer = new JLabel("Bản quyền thuộc nhóm 24 Bank IT5");
		label_footer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_footer.setBounds(75, 360, 185, 36);
		panel_navigation.add(label_footer);
		
		JButton button_taoTaiKhoan = new JButton("Tạo tài khoản");
		button_taoTaiKhoan.setBackground(new Color(255, 255, 255));
		button_taoTaiKhoan.setBounds(99, 180, 120, 50);
		panel_navigation.add(button_taoTaiKhoan);
		button_taoTaiKhoan.addActionListener(ac);
		
		JButton button_taiKhoan = new JButton("Tài khoản");
		button_taiKhoan.setBackground(new Color(255, 255, 255));
		button_taiKhoan.setBounds(99, 80, 120, 50);
		panel_navigation.add(button_taiKhoan);
		button_taiKhoan.addActionListener(ac);
		
		JButton button_quanLi = new JButton("Quản lí");
		button_quanLi.setBackground(new Color(255, 255, 255));
		button_quanLi.setBounds(99, 280, 120, 50);
		panel_navigation.add(button_quanLi);
		button_quanLi.addActionListener(ac);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
