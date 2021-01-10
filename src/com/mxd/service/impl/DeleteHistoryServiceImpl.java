package com.mxd.service.impl;


import com.mxd.dao.DeleteHistoryDao;
import com.mxd.service.DeleteHistoryService;

public class DeleteHistoryServiceImpl implements DeleteHistoryService {
    private DeleteHistoryDao deleteHistoryDao = new DeleteHistoryDao();

    @Override
    public int deleteHistory(int blogId) {
        int i = deleteHistoryDao.deleteHistory(blogId);
        // 有可能此博客下没有评论，所以 j 不用判断
        int j = deleteHistoryDao.deleteDiscuss(blogId);
        return i;
    }
}
