package com.mxd.service.impl;


import com.mxd.bean.Blog;
import com.mxd.dao.CheckHistoryDao;
import com.mxd.service.CheckHistoryService;

public class CheckHistoryServiceImpl implements CheckHistoryService {
    private CheckHistoryDao checkHistoryDao = new CheckHistoryDao();

    @Override
    public Blog checkHistory(int blogId) {
        return checkHistoryDao.checkHistory(blogId);
    }
}
