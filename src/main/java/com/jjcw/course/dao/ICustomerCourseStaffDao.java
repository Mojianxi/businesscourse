package com.jjcw.course.dao;

import com.jjcw.course.bean.CustomerInfo;
import com.jjcw.course.bean.CustomerStaffCourse;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/13 14:58
 * @Company jjcw
 */
public interface ICustomerCourseStaffDao {
    public List<CustomerStaffCourse> list(CustomerInfo info);
}
