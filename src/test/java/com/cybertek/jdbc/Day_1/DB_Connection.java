package com.cybertek.jdbc.Day_1;

import java.sql.*;

public class DB_Connection {
    public static void main(String[] args) throws SQLException {


        //Connection-->Statement-->Resultset
        // Driver manager is used to get the connection
        // The IP address is the IP address of EC2 instance that have Oracle database
        // This is mine , so yours will your EC2 instance IP
        // This is known as connection string or url
        // it has few part
        // "jdbc:   making jdbc connection , always start with this
        // oracle:  the database vendor (RDBMS) name we are trying to connect
        // thin:    1 type of oracle driver we are using ( downloaded using pom dependency)
        // @52.71.242.164: IP address of your database server
        // 1521:    port number of your database server ,  usually 1521 for oracle , 3306 for MySql Database
        // XE  :   SID name  unique identifier for the database we are connecting
        //  In a nutshell , see it as a full address of your database you can use to make connection
        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr";
        String password = "hr";

        //JDBC ship with JDK and has a lot of pre written codes to work with database
        //Everything we do below comes from java .sql package
        // creating connection object using DriverManager's static method Connection ;
        Connection connection = DriverManager.getConnection(connectionStr, username, password);

        // creating statement object using the connection we have establish
        Statement statement = connection.createStatement();

        //ResultSet  object is what  we use to store the actual result we get from query
        ResultSet resultSet = statement.executeQuery("select*from regions");

        //ResultSet comes with a cursor used to navigate between rows
        //initially  the cursor  is at before first location (right before the first row)
        //in order to come to the first row we need to move the cursor
        // next() method is used to move the cursor and return the result as boolean


        resultSet.next();// currently  we are at the very first row
        // getting the column data  we use multiple get methods available in ResultSet
        //  print out region id and region name  , both as String
        System.out.println("first column value using index: --> " +  resultSet.getString(1)   );
        System.out.println("first column value using column_name: --> " +  resultSet.getString("REGION_ID")   );
        // printing out second column data
        System.out.println("second column value using index: --> " +resultSet.getString(2) ) ;
        System.out.println("second column value using column_name: --> " + resultSet.getString("REGION_NAME") ) ;
        // try to move to next row and get second row data as a task

        System.out.println("first column value using index: --> " +  resultSet.getString(1)   );
        System.out.println("first column value using column_name: --> " +  resultSet.getString("REGION_ID")   );
        // printing out second column data
        System.out.println("second column value using index: --> " +resultSet.getString(2) ) ;
        System.out.println("second column value using column_name: --> " + resultSet.getString("REGION_NAME") ) ;
        resultSet.next();
        System.out.println("THE END ");

    }

}
