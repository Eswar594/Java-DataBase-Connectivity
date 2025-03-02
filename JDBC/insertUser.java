package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertUser {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3307/jdbc";
	private static final String username="Eswar";
	private static final String password="Eswar1412";
	private static Connection con;
	  private static PreparedStatement pst;
	  public static void main(String[] args) {
			try {
				Scanner sc = new Scanner(System.in); 
				Class.forName(Driver);
				con=DriverManager.getConnection(url,username,password);
				String sql="insert into Trainees(name,email,password) values(?,?,?)";
				pst=con.prepareStatement(sql);
				System.out.println("enter name");
			    pst.setString(1, sc.next());
			    System.out.println("enter email");
			    pst.setString(2, sc.next());
			    System.out.println("enter password");
			    pst.setString(3, sc.next());
			    int i=pst.executeUpdate();
			    if(i>0) {
			    	System.out.println("updated successfully");
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