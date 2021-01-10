package com.mxd.service.impl;


import com.mxd.bean.Blog;
import com.mxd.dao.RequestBlogAdminDao;
import com.mxd.service.RequestBlogAdminService;

import java.util.ArrayList;

public class RequestBlogAdminServiceImpl implements RequestBlogAdminService {
    private RequestBlogAdminDao requestBlogAdminDao = new RequestBlogAdminDao();

    @Override
    public ArrayList<Blog> requestBlog() {
        return requestBlogAdminDao.requestBlog();
    }
}
