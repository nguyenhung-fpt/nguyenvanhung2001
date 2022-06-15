package com.example.nguyenvanhung_t2009a.dao;

import com.example.nguyenvanhung_t2009a.model.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Phonedao {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/phone";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";

    private static final String INSERT_PHONE_SQL = "INSERT INTO phonedao" + "  (name, brand, price, description) VALUES " + " (?, ?, ?, ?)";
    private static final String SELECT_ALL_PHONES = "select * from phonedao";

    public Phonedao() {
    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertPhone(Phone phone) throws SQLException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHONE_SQL)) {
                preparedStatement.setString(1, phone.getName());
                preparedStatement.setString(2, phone.getBrand());
                preparedStatement.setString(3, phone.getPrice());
                preparedStatement.setString(4, phone.getDescription());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List< Phone > selectAllPhones() {
        List< Phone > phones = new ArrayList< >();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PHONES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                String price = rs.getString("price");
                String description = rs.getString("description");
                phones.add(new Phone(id, name, brand, price, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phones;
    }
}
