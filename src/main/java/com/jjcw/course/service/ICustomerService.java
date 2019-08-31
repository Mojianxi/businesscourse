package com.jjcw.course.service;

import com.jjcw.course.bean.*;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/13 10:05
 * @Company jjcw
 */
public interface ICustomerService {
    /**
     * 查询所有客户
     * @param info 查询条件
     * @return
     */
    public List<CustomerInfo> list(CustomerInfo info);
    public List<CustomerInfo> listCustomer(ClassidInfo info);
    /**
     * 获取总记录数
     * @param info
     * @return
     */
    public long getcount(CustomerInfo info);
    public long getClasscount(ClassidInfo info);

    CustomerInfo getCustomer(CustomerInfo info);
    public List<CustomerStaffCourse> listRelev(CustomerInfo info);

    List<CustomerInfo> listStaffCustomer(int staffId);
}
