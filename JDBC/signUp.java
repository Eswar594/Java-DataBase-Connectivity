package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class signUp {
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

            System.out.println("Enter name:");
            String name = sc.next();
            System.out.println("Enter new email:");
            String email = sc.next();

            // Check if the email already exists in the database
            String checkEmailSQL = "SELECT * FROM Trainees WHERE email=?";
            pst = con.prepareStatement(checkEmailSQL);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Email already exists. Please use a different email.");
            } else {
                System.out.println("Enter new password:");
                String password = sc.next();
                String sql = "INSERT INTO Trainees (name, email, password) VALUES (?, ?, ?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, password);

                int inserted = pst.executeUpdate(); // Execute only if the email is not found
                if (inserted > 0) {
                    System.out.println("User signed up successfully!");
                } else {
                    System.out.println("Failed to sign up. Please try again.");
                }
            }

            con.close();
            pst.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
