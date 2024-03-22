package ie.atu.standard;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {
        // MySQL database connection details
        String url = "jdbc:mysql://localhost:3306/week8";
        String username = "root";
        String password = "password";

        // SQL statement

        String selectSQL = "SELECT u.brand, u.product,u.item_no,u.year_to_expire, e.ingredients,e.productcost,e.manufacturingcost " +
                "FROM makeup u " +
                "JOIN manufacturing e ON u.id = e.makeup_id";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String product = resultSet.getString("product");
                Integer item_no =resultSet.getInt("item_no");
                Integer year =resultSet.getInt("year_to_expire");
                String ingredients = resultSet.getString("ingredients");
                Integer productcost = resultSet.getInt("productcost");
                Integer manufacturingcost = resultSet.getInt("manufacturingcost");


                System.out.println("Brand: " + brand + ", Product: " + product + ", Item number: " + item_no +
                        "Year to expire: " + year + ", main ingredient: " + ingredients + ", Cost of product: " + productcost  + ", Cost of manufacturing: " + manufacturingcost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
