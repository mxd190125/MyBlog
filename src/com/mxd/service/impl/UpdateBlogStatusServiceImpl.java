package com.mxd.service.impl;

import com.mxd.dao.UpdateBlogStatusDao;
import com.mxd.service.UpdateBlogStatusService;


public class UpdateBlogStatusServiceImpl implements UpdateBlogStatusService {
    private UpdateBlogStatusDao updateBlogStatusDao = new UpdateBlogStatusDao();

    @Override
    public int UpdateBlogStatus(String type , int blogId, int status) {
        int i = 0;
        if (type.equals("top")){
            i = updateBlogStatusDao.updateTopStatus(blogId , status);
        }else if (type.equals("good")){
            i = updateBlogStatusDao.updateGoodStatus(blogId, status);
        }
        return i;
    }
}
