package com.mxd.service.impl;

import com.mxd.bean.Blog;
import com.mxd.dao.DeleteUserDao;
import com.mxd.dao.RequestHistoryDao;
import com.mxd.service.DeleteHistoryService;
import com.mxd.service.DeleteUserService;

import java.util.ArrayList;


public class DeleteUserServiceImpl implements DeleteUserService {
    private RequestHistoryDao requestHistoryDao = new RequestHistoryDao();
    private DeleteUserDao deleteUserDao = new DeleteUserDao();
    private DeleteHistoryService deleteHistoryService = new DeleteHistoryServiceImpl();

    @Override
    public int deleteUser(int userId) {
        // 先获取该用户下的所有博客
        ArrayList<Blog> blogs = requestHistoryDao.requetHistory(userId);
        // 再删除所有博客和其下的所有评论
        int i = deleteUserDao.deleteUser(userId);
        if (blogs != null && blogs.size() != 0){
            for (Blog blog : blogs) {
                deleteHistoryService.deleteHistory(blog.getId());
            }
        }
        return i;
    }
}
