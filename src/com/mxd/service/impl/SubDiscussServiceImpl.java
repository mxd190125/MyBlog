package com.mxd.service.impl;

import com.mxd.dao.SubDiscussDao;
import com.mxd.service.SubDiscussService;


public class SubDiscussServiceImpl implements SubDiscussService {
    private SubDiscussDao subDiscussDao = new SubDiscussDao();

    @Override
    public int subDiscuss(String content, int blogId, int discusserId) {
        return subDiscussDao.subDiscuss(content, blogId, discusserId);
    }
}
