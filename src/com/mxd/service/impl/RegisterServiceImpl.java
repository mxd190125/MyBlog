package com.mxd.service.impl;


import com.mxd.dao.RegisterDao;
import com.mxd.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
    private RegisterDao registerDao = new RegisterDao();


    @Override
    public int registerUser(String username, String password , String email) {
        return registerDao.registerUser(username , password ,email);
    }
}
