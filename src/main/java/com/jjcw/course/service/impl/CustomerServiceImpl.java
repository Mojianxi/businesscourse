package com.jjcw.course.service.impl;

import com.jjcw.course.bean.ClassidInfo;
import com.jjcw.course.bean.CustomerInfo;
import com.jjcw.course.bean.CustomerStaffCourse;
import com.jjcw.course.dao.ICustomerCourseStaffDao;
import com.jjcw.course.dao.ICustomerDao;
import com.jjcw.course.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/13 10:17
 * @Company jjcw
 */
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerDao customerDao;
    @Autowired
    private ICustomerCourseStaffDao customerCourseStaffDao;
    @Override
    public List<CustomerInfo> list(CustomerInfo info) {
        condition(info);
        return customerDao.list(info);
    }

    @Override
    public List<CustomerInfo> listCustomer(ClassidInfo info) {
        System.out.println("班级信息aa"+info.getClassId());
        return customerDao.listCustomer(info);
    }

    @Override
    public long getcount(CustomerInfo info) {
        return customerDao.getcount(info);
    }

    @Override
    public long getClasscount(ClassidInfo info) {
        return customerDao.getClasscount(info);
    }

    @Override
    public CustomerInfo getCustomer(CustomerInfo info) {
        return customerDao.getCustomer(info);
    }

    @Override
    public List<CustomerStaffCourse> listRelev(CustomerInfo info) {
        return customerCourseStaffDao.list(info);
    }

    @Override
    public List<CustomerInfo> listStaffCustomer(int staffId) {
        return customerDao.listStaffCustomer(staffId);
    }


    /**
     * 查询条件
     *
     * @param info
     */
    public void condition(CustomerInfo info) {
        if (info != null) {
            if (info.getCustomerName() != null && !info.getCustomerName().equals("")) {
                info.setCustomerName("%"+info.getCustomerName()+"%");
            }

        }
    }
}
