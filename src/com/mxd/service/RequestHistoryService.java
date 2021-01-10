package com.mxd.service;

import com.mxd.bean.Blog;

import java.util.ArrayList;

public interface RequestHistoryService {
    public ArrayList<Blog> requetHistory(int userId);
}
