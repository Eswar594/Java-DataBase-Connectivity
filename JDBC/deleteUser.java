package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deleteUser {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3307/jdbc";
	private static final String username="Eswar";
	private static final String password="Eswar1412";
	private static Connection con;
	private static PreparedStatement pst;
	public static void main(String[] args) {
		try {
			Scanner sc =new Scanner(System.in); 
			Class.forName(Driver);
	        con=DriverManager.getConnection(url,username,password);
	        
			System.out.println("enter table name");
			String sql = "delete from" + sc.next() + "where id=?";
			pst.getConnection().prepareStatement(sql);
			
			System.out.println("Enter id");
			pst.setInt(1, sc.nextInt());
			
			int i =pst.executeUpdate();
			if(i>0) {
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("error");
			}
			con.close();
			pst.close();
			sc.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}		

}
