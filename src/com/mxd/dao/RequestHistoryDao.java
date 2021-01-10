package com.mxd.dao;


import com.mxd.bean.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestHistoryDao extends BaseDao{

    public ArrayList<Blog> requetHistory(int userId){
        ArrayList<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT id , bloger , title , subTime FROM blog WHERE bloger = ? ORDER BY subTime DESC";
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1 , userId);
            set = statement.executeQuery();
            while (set.next()) {
                Blog blog = new Blog();
                blog.setId(set.getInt(1));
                blog.setBloger(set.getInt(2));
                blog.setTitle(set.getString(3));
                blog.setSubTime(set.getString(4));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release(connection , statement , set);
        }
        return blogs.size() !=0 ?blogs : null;
    }
}
