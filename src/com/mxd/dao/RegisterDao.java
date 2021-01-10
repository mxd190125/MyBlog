package com.mxd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao extends BaseDao{
    public int registerUser(String username , String password , String email){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO `user` (userName , passWord , registerTime , role , email , photourl)\n" +
                    "VALUES(? , ? , NOW() , 'user' , ? , 'MyBlog/static/images/icon/default-head.png');";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1 , username);
            statement.setString(2 , password);
            statement.setString(3 , email);
            int i = statement.executeUpdate();
            if (i>=1){
                return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement);
        }
        return 0;
    }
}
