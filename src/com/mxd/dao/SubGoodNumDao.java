package com.mxd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubGoodNumDao extends BaseDao{

    public int SubGoodNum(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE blog SET goodNum = goodNum + 1 WHERE id=?";
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
