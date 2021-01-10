package com.mxd.service.impl;


import com.mxd.bean.User;
import com.mxd.dao.LoginDao;
import com.mxd.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao = new LoginDao();

    @Override
    public User getUser(String username, String password) {
        return loginDao.getUser(username, password);
    }
}
