package test;

import javax.swing.UIManager;

import View.Navigation;

/*giao diện người dùng sử dụng look and feel */

@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
		try {
			 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
			new Navigation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
