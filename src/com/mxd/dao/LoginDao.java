package com.mxd.dao;


import com.mxd.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends BaseDao{

    public User getUser(String username , String password){
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        String sql = "SELECT * FROM `user` WHERE userName = ? AND `passWord` = ?;";
        connection = getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1 , username);
            statement.setString(2 , password);
            set = statement.executeQuery();
            while (set.next()) {
                user = new User();
                user.setId(set.getInt(1));
                user.setUserName(set.getString(2));
                user.setPassWord(set.getString(3));
                user.setRegisterTime(set.getString(4));
                user.setRole(set.getString(5));
                user.setEmail(set.getString(6));
                user.setPhotoUrl(set.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement , set);
        }

        return user;
    }
}
