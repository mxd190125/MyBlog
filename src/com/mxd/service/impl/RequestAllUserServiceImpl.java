package com.mxd.service.impl;


import com.mxd.bean.User;
import com.mxd.dao.RequestAllUserDao;
import com.mxd.service.RequestAllUserService;

import java.util.ArrayList;

public class RequestAllUserServiceImpl implements RequestAllUserService {

    private RequestAllUserDao requestAllUserDao = new RequestAllUserDao();

    @Override
    public ArrayList<User> requestAllUser() {
        return requestAllUserDao.requestAllUser();
    }
}
