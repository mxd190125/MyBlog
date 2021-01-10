package com.mxd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBlogStatusDao extends BaseDao{

    /**
     * 修改置顶状态
     * @param blogId
     * @param status
     * @return
     */
    public int updateTopStatus(int blogId , int status){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE blog SET isTop = ? WHERE id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , status);
            statement.setInt(2 , blogId);
            int i = statement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement);
        }
        return 0;
    }

    /**
     * 修改“精华”状态
     * @param blogId
     * @param status
     * @return
     */
    public int updateGoodStatus(int blogId , int status){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE blog SET isGood = ? WHERE id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , status);
            statement.setInt(2 , blogId);
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
