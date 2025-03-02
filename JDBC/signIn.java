package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class signIn {
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
			    System.out.println("enter email");
				String email=sc.next();
				System.out.println("enter password");
				String password=sc.next();
				String sql="select * from Trainees where email=? and password=?";
				pst=con.prepareStatement(sql);
				pst.setString(1, email);
				pst.setString(2, password);
				ResultSet rs=pst.executeQuery();
				if(rs.next()) {
					System.out.println("successesful login");
					
				}
				else {
					System.out.println("invalid user");
				}
				
			    con.close();
			    pst.close();
			    sc.close();
			    
			    
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

