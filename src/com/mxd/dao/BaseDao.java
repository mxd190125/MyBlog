package com.mxd.dao;


import java.sql.*;

public class BaseDao {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://121.196.145.152:3306/myblog?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT"; // Linux
//    private static String url="jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";     // Windows
    private static String username="root";
    private static String password="你的密码";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void release(Connection connection , Statement statement , ResultSet resultSet){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (statement!=null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection!=null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void release(Connection connection , Statement statement){
        try {
            if (statement!=null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection!=null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
