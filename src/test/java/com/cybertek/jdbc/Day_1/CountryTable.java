package com.cybertek.jdbc.Day_1;

import java.sql.*;

public class CountryTable {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection connection = DriverManager.getConnection(connectionStr, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select*from countries");


        while (resultSet.next() == true) {
            System.out.print(resultSet.getString(1) + " "
                    + resultSet.getString(2) + " "
                    + resultSet.getString(3));
        }
        resultSet.previous();
    }
}
