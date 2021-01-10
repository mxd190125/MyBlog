package com.mxd.dao;


import com.mxd.bean.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubBlogDao extends BaseDao{

    public int insertBlog(Blog blog){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO blog (bloger , title , content , images , goodNum , subTime) VALUES(? , ? , ? , ? , ? , NOW())";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , blog.getBloger());
            statement.setString(2 , blog.getTitle());
            statement.setString(3, blog.getContent());
            statement.setString(4 , blog.getImages());
            statement.setInt(5 , blog.getGoodNum());
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
