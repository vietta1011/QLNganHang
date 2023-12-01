package Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBC_util {
 public static Connection getConnection() {
	 Connection c = null;
//	 String link_SQL = "C:\\Users\\Dzung\\OneDrive - Đại học Giao thông vận tải\\Desktop\\link_sql.txt";
//	 String link = "";
//	 try {
//		link = new String(Files.readAllBytes(Paths.get(link_SQL)));
//		JOptionPane.showMessageDialog(null, link);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	 try {
		
	
	    BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\Dzung\\\\OneDrive - Đại học Giao thông vận tải\\\\Desktop\\\\link_sql.txt"));
		
		//String url ="jdbc:mySQL://localhost:3306/qltknh";
		String url= br.readLine();
		String username = br.readLine();
		String password =br.readLine();
		br.close();
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		c = DriverManager.getConnection(url, username, password);
//		c = DriverManager.getConnection(link);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return c;
 }
 public static void closeConnection(Connection c) {
	 try {
		if(c != null) {
			c.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
 public static void prinnInfor(Connection c) {
	 try {
		if(c != null) {
			java.sql.DatabaseMetaData mtdt = c.getMetaData();
			System.out.println(c.getMetaData().toString());
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
 
}
