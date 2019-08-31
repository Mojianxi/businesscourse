package com.jjcw.course.service.impl;

import com.jjcw.course.bean.ClassidInfo;
import com.jjcw.course.bean.CustomerInfo;
import com.jjcw.course.dao.IClassInfoDao;
import com.jjcw.course.service.IClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/13 19:44
 * @Company jjcw
 */
@Service
@Transactional
public class ClassInfoServiceImpl implements IClassInfoService {
    @Autowired
    private IClassInfoDao classInfoDao;
    @Override
    public List<ClassidInfo> list(ClassidInfo info) {
        return classInfoDao.list(info);
    }

    @Override
    public long getcount(ClassidInfo info) {
        return classInfoDao.getcount(info);
    }

    @Override
    public ClassidInfo getClassidInfo(ClassidInfo info) {
        return classInfoDao.getClassidInfo(info);
    }
}
