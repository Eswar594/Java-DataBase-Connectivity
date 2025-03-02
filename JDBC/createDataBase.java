package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createDataBase {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3307/?user=Eswar";
	private static final String username = "Eswar";
	private static final String password = "Eswar1412";
	private static Connection con;
	private static PreparedStatement pst;

	public static void main(String[] args) {
		try {
			Scanner sc =new Scanner(System.in); 
			Class.forName(Driver);
			con=DriverManager.getConnection(url,username,password);
		    System.out.println("enter database name");
		    String sql="create database "+sc.next();
		    pst=con.prepareStatement(sql);
		    int i=pst.executeUpdate();
		    if(i>0) {
		    	System.out.println("successfully executed");
		    }
		    else {
		    	System.out.println("error");
		    }
		    con.close();
		    pst.close(); 
		    sc.close();
		}catch(Exception e) {
			System.out.println("database already exists");
		}
	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
}
