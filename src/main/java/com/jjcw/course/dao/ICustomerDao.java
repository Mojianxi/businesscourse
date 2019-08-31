package com.jjcw.course.dao;

import com.jjcw.course.bean.ClassidInfo;
import com.jjcw.course.bean.CustomerInfo;
import com.jjcw.course.bean.StaffInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/13 10:18
 * @Company jjcw
 */
public interface ICustomerDao {
    public List<CustomerInfo> list(CustomerInfo info);
    /**
     * 获取总记录数
     * @param info
     * @return
     */
    public long getcount(CustomerInfo info);
    public long getClasscount(ClassidInfo info);

    public CustomerInfo getCustomer(CustomerInfo info);

    public List<CustomerInfo> listCustomer(ClassidInfo info);

    List<CustomerInfo> listStaffCustomer(@Param("staffId") Integer staffId);
}
