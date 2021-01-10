package com.mxd.dao;


import com.mxd.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestAllUserDao extends BaseDao{

    public ArrayList<User> requestAllUser(){
        ArrayList<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        try {
            String sql = "SELECT * FROM `user` WHERE role = 'user'";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            set = statement.executeQuery();
            while (set.next()) {
                User user = new User();
                user.setId(set.getInt(1));
                user.setUserName(set.getString(2));
                user.setPassWord(set.getString(3));
                user.setRegisterTime(set.getString(4));
                user.setRole(set.getString(5));
                user.setEmail(set.getString(6));
                user.setPhotoUrl(set.getString(7));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement ,set);
        }
        return users;
    }

}
