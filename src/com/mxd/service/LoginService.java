package com.mxd.service;

import com.mxd.bean.User;

public interface LoginService {
    public User getUser(String username , String password);
}
