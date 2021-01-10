package com.mxd.service.impl;


import com.mxd.bean.Blog;
import com.mxd.dao.SubBlogDao;
import com.mxd.service.SubBlogService;

public class SubBlogServiceImpl implements SubBlogService {

    private SubBlogDao subBlogDao = new SubBlogDao();

    @Override
    public int insertBlog(Blog blog) {
        return subBlogDao.insertBlog(blog);
    }
}
