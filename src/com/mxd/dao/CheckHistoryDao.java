package com.mxd.dao;


import com.mxd.bean.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckHistoryDao extends BaseDao{
    private RequestBlogDao blogDao = new RequestBlogDao();

    public Blog checkHistory(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        Blog blog = null;

        try {
            String sql = "SELECT b.id AS id , b.bloger AS bloger , u.userName AS blogerName , b.title AS title , b.content AS content , " +
                                "b.images AS images , b.goodNum AS goodNum , b.subTime AS subTime " +
                                "FROM blog b INNER JOIN `user` u ON b.bloger = u.id WHERE b.id = ?;";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , blogId);
            set = statement.executeQuery();
            while (set.next()) {
                blog = new Blog();
                blog.setId(set.getInt(1));
                blog.setBloger(set.getInt(2));
                blog.setBlogerName(set.getString(3));
                blog.setTitle(set.getString(4));
                blog.setContent(set.getString(5));
                blog.setImages(set.getString(6));
                blog.setGoodNum(set.getInt(7));
                blog.setSubTime(set.getString(8));
                blog.setDiscusses(blogDao.getDiscusses(blogId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement , set);
        }
        return blog;
    }

}
