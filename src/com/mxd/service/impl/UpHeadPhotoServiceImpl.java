package com.mxd.service.impl;

import com.mxd.dao.UpHeadPhotoDao;
import com.mxd.service.UpHeadPhotoService;


public class UpHeadPhotoServiceImpl implements UpHeadPhotoService {
    private UpHeadPhotoDao upHeadPhotoDao = new UpHeadPhotoDao();

    @Override
    public int uploadHeadPhoto(int userId, String photoUrl) {
        return upHeadPhotoDao.uploadHeadPhoto(userId, photoUrl);
    }
}
