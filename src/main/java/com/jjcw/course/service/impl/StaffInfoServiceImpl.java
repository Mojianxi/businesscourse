package com.jjcw.course.service.impl;

import com.jjcw.course.bean.StaffInfo;
import com.jjcw.course.dao.IStaffInfoDao;
import com.jjcw.course.service.IStaffInfoService;
import com.jjcw.course.utils.Comm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 10:31
 * @Company jjcw
 */
@Service
@Transactional
public class StaffInfoServiceImpl implements IStaffInfoService {
    @Autowired
    private IStaffInfoDao staffInfoDao;
    @Override
    public void add(StaffInfo staffInfo) {
        staffInfoDao.add(staffInfo);
    }

    @Override
    public StaffInfo getStaffInfo(StaffInfo staffInfo) {
        return staffInfoDao.getStaff(staffInfo);
    }

    @Override
    public List<StaffInfo> getStaffList(StaffInfo staffInfo) {
        condition(staffInfo);
        return staffInfoDao.getStaffList(staffInfo);
    }

    @Override
    public StaffInfo isLogin(StaffInfo staffInfo) {
        return staffInfoDao.login(staffInfo);
    }

    @Override
    public long getcount(StaffInfo info) {
        condition(info);
        return staffInfoDao.getcount(info);
    }

    @Override
    public void update(StaffInfo staff) {
        staffInfoDao.update(staff);
    }

    @Override
    public void delete(Integer[] staffId) {

        for(Integer id:staffId){
            StaffInfo info = new StaffInfo();
            info.setStaffId(id);
            info.setStaffTag(Comm.MARK_NO);

            staffInfoDao.update(info);

        }
    }

    /**
     * 查询条件
     *
     * @param user
     */
    public void condition(StaffInfo user) {
        if (user != null) {
            if (user.getStaffName() != null && !user.getStaffName().equals("")) {
                user.setStaffName("%"+user.getStaffName()+"%");
            }

        }
    }
}
