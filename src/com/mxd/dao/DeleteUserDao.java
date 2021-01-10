package com.mxd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserDao extends BaseDao{

    public int deleteUser(int userId){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "DELETE FROM `user` WHERE id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , userId);
            int i = statement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement);
        }
        return 0;
    }

}
