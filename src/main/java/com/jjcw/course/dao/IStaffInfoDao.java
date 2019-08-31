package com.jjcw.course.dao;

import com.jjcw.course.bean.StaffInfo;

import java.util.List;

/**
 * @Description 员工管理的数据访问接口
 * @Author:liuxiaodong
 * @Date 2019/8/9 10:32
 * @Company jjcw
 */
public interface IStaffInfoDao {
    /**
     * @Description TODO
     * @params [staffInfo]
     * @return void
     * @Author liuxiaodong
     * @Date 2019/8/9 10:16
     */
    public int add(StaffInfo staffInfo);

    /**
     * @Description 根据条件查询用户信息
     * @params [staffInfo]
     * @return com.jjcw.course.bean.StaffInfo
     * @Author liuxiaodong
     * @Date 2019/8/9 10:27
     */
    public StaffInfo getStaff(StaffInfo staffInfo);

    /**
     * @Description 根据条件查询多条用户
     * @params [staffInfo]
     * @return java.util.List<com.jjcw.course.bean.StaffInfo>
     * @Author liuxiaodong
     * @Date 2019/8/9 10:29
     */
    public List<StaffInfo> getStaffList(StaffInfo staffInfo);

    /**
     * @Description 根据账户密码查询用户信息
     * @params [staffInfo]
     * @return com.jjcw.course.bean.StaffInfo
     * @Author liuxiaodong
     * @Date 2019/8/9 10:41
     */
    public StaffInfo login(StaffInfo info);

    /**
     * 获取总记录数
     * @param info
     * @return
     */
    public long getcount(StaffInfo info);

    public int update(StaffInfo staff);
}
