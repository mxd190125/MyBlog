package com.mxd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteHistoryDao extends BaseDao{

    public int deleteHistory(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "DELETE FROM blog WHERE id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , blogId);
            int i = statement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement);
        }
        return 0;
    }

    public int deleteDiscuss(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "DELETE FROM discuss WHERE blogId = ?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , blogId);
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
