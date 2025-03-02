package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createTable {
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

            System.out.println("Enter table name:");
            String tableName = sc.next();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
            		                "name VARCHAR(255) NOT NULL," + 
                                    "email VARCHAR(255) NOT NULL," +
                                    "password VARCHAR(255) NOT NULL" +
                                    ")";

            pst = con.prepareStatement(createTableSQL);

            int result = pst.executeUpdate();
            if (result == 0) {
                System.out.println("Table '" + tableName + "' created successfully");
            } else {
                System.out.println("Table creation failed.");
            }

            con.close();
            pst.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
