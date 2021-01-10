package com.mxd.service.impl;


import com.mxd.dao.SubGoodNumDao;
import com.mxd.service.SubGoodNumService;

public class SubGoodNumServiceImpl implements SubGoodNumService {
    private SubGoodNumDao subGoodNumDao = new SubGoodNumDao();

    @Override
    public int SubGoodNum(int blogId) {
        return subGoodNumDao.SubGoodNum(blogId);
    }
}
