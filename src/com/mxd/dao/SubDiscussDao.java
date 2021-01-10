package com.mxd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubDiscussDao extends BaseDao{

    public int subDiscuss(String content , int blogId , int discusserId){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO discuss (content , subTime  , blogId , discusser) VALUES(? , NOW() , ? , ?)";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1 , content);
            statement.setInt(2 , blogId);
            statement.setInt(3 , discusserId);
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
