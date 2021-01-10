package com.mxd.service.impl;


import com.mxd.bean.Blog;
import com.mxd.dao.RequestHistoryDao;
import com.mxd.service.RequestHistoryService;

import java.util.ArrayList;

public class RequestHistoryServiceImpl implements RequestHistoryService {

    private RequestHistoryDao requestHistoryDao = new RequestHistoryDao();

    @Override
    public ArrayList<Blog> requetHistory(int userId) {
        return requestHistoryDao.requetHistory(userId);
    }
}
