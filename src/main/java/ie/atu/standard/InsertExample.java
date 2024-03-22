package ie.atu.standard;

import java.sql.*;

public class InsertExample {

    public static void main(String[] args) throws SQLException {

        // Connect to the database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/week8", "root", "password");

        try {

            // Insert a new record into the "makeup" table
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO makeup (brand, product,item_no,year_to_expire) VALUES (?, ?,?,?)");
            stmt.setString(1, "Des");
            stmt.setString(2, "software");
           stmt.setInt(3,2);
           stmt.setInt(4,2023);
            stmt.executeUpdate();

            // Insert a new record into the "manufacturing" table, referencing the new user
            stmt = conn.prepareStatement("INSERT INTO manufacturing (makeup_id, ingredients,productcost,manufacturingcost) VALUES (?, ?,?,?)");
            stmt.setInt(1, getLastInsertId(conn));
            stmt.setString(2, "glycerine");
            stmt.setInt(3,25);
            stmt.setInt(4,15);
            stmt.executeUpdate();

            System.out.println("Insert completed successfully.");
        } catch (SQLException ex) {

            System.out.println("Record insert failed.");
            ex.printStackTrace();
        }
        // Close the connection
        conn.close();
    }

    // Helper method to get the ID of the last inserted record
    private static int getLastInsertId(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
        rs.next();
        int id = rs.getInt(1);
        rs.close();
        stmt.close();
        return id;
    }
}