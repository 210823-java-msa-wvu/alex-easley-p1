package dev.easley.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil cu = null;
    private static Properties props;


    private ConnectionUtil() {
        props = new Properties();

        InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");
        try {
            props.load(dbProps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static synchronized ConnectionUtil getConnectionUtil() {

        if (cu == null) {

            cu = new ConnectionUtil();
        }

        return cu;
    }


    public Connection getConnection() {

        Connection Conn = null;
        try {
            Class.forName(props.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        try {
            Conn = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Conn;
    }


    public static void main(String[] args) {

        Connection connection = getConnectionUtil().getConnection();

       if (connection != null) {
           System.out.println("Connection successful");
       } else {
           System.out.println("Something went wrong...");
       }

   }

}
