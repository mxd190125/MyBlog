package com.mxd.service.impl;


import com.mxd.dao.ModifyPasswordDao;
import com.mxd.service.ModifyPasswordService;

public class ModifyPasswordServiceImpl implements ModifyPasswordService {
    private ModifyPasswordDao modifyPasswordDao = new ModifyPasswordDao();

    @Override
    public int modifyPassword(int userId, String newPassword) {
        return modifyPasswordDao.modifyPassword(userId, newPassword);
    }
}
