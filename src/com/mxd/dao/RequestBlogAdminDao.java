package com.mxd.dao;


import com.mxd.bean.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestBlogAdminDao extends BaseDao{

    public ArrayList<Blog> requestBlog(){
        ArrayList<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT b.id AS id, b.bloger AS bloger, u.userName AS blogerName , u.photoUrl AS blogerPhotoUrl , " +
                    "b.title AS title, b.content AS content, b.images AS images, b.goodNum AS goodNum, b.subTime AS subTime , b.isTop AS isTop , b.isGood AS isGood " +
                    "FROM blog b INNER JOIN `user` u ON u.id = b.bloger ORDER BY b.isTop DESC ,b.subTime DESC";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            set = statement.executeQuery();
            while (set.next()) {
                Blog blog = new Blog();
                blog.setId(set.getInt(1));
                blog.setBloger(set.getInt(2));
                blog.setBlogerName(set.getString(3));
                blog.setBlogerPhotoUrl(set.getString(4));
                blog.setTitle(set.getString(5));
                blog.setContent(set.getString(6));
                blog.setImages(set.getString(7));
                blog.setGoodNum(set.getInt(8));
                blog.setSubTime(set.getString(9));
                blog.setIsTop(set.getInt(10));
                blog.setIsGood(set.getInt(11));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement , set);
        }
        return blogs.size() != 0 ? blogs : null;
    }
}
