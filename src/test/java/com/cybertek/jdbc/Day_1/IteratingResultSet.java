package com.cybertek.jdbc.Day_1;

import java.sql.*;

public class IteratingResultSet {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection connection = DriverManager.getConnection(connectionStr, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select*from regions");

        resultSet.next();
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));


        resultSet.next();
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));

        while(resultSet.next()==true){
            System.out.println(resultSet.getString("region_id")
                    +" "+ resultSet.getString("Region_name"));
        }
//        resultSet.next();
//        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
//        System.out.println(resultSet.next());
//        resultSet.next();
//        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
//        System.out.println(resultSet.next());
    }
}
