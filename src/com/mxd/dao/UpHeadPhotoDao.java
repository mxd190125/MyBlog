package com.mxd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpHeadPhotoDao extends BaseDao{

    public int uploadHeadPhoto(int userId , String photoUrl){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE `user` SET photoUrl = ? WHERE id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1 , photoUrl);
            statement.setInt(2 , userId);
            int i = statement.executeUpdate();
            if (i>0){
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
