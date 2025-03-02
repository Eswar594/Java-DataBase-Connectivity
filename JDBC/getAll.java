package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getAll {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3307/jdbc";
	private static final String username = "Eswar";
	private static final String password = "Eswar1412";
	private static Connection con;
	private static PreparedStatement pst;

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql = "select * from " + sc.next();
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("name : " + rs.getString("name"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("password : " + rs.getString("password"));
			}

			con.close();
			pst.close();
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
