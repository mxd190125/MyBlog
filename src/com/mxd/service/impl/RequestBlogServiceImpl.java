package com.mxd.service.impl;


import com.mxd.bean.Blog;
import com.mxd.dao.RequestBlogDao;
import com.mxd.service.RequestBlogService;

import java.util.ArrayList;

public class RequestBlogServiceImpl implements RequestBlogService {

    private RequestBlogDao requestBlogDao = new RequestBlogDao();
    @Override
    public ArrayList<Blog> requestBlog() {
        return requestBlogDao.requestBlog();
    }
}
