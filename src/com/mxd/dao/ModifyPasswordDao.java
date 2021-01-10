package com.mxd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyPasswordDao extends BaseDao{

    public int modifyPassword(int userId , String newPassword){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE `user` SET `passWord` = ? WHERE id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1 , newPassword);
            statement.setInt(2 , userId);
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
