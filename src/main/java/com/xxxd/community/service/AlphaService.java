package com.xxxd.community.service;

import com.xxxd.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    public String find(){
        return alphaDao.select();
    }
}
