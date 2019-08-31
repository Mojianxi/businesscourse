package com.jjcw.course.service;

import com.jjcw.course.bean.ClassidInfo;
import com.jjcw.course.bean.CustomerInfo;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/13 19:43
 * @Company jjcw
 */
public interface IClassInfoService {
    public List<ClassidInfo> list(ClassidInfo info);
    /**
     * 获取总记录数
     * @param info
     * @return
     */
    public long getcount(ClassidInfo info);

    public ClassidInfo getClassidInfo(ClassidInfo info);
}
