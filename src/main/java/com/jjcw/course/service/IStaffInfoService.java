package com.jjcw.course.service;

import com.jjcw.course.bean.StaffInfo;

import java.util.List;

public interface IStaffInfoService {
    /**
     * @Description TODO
     * @params [staffInfo]
     * @return void
     * @Author liuxiaodong
     * @Date 2019/8/9 10:16
     */
    public void add(StaffInfo staffInfo);

    /**
     * @Description 根据条件查询用户信息
     * @params [staffInfo]
     * @return com.jjcw.course.bean.StaffInfo
     * @Author liuxiaodong
     * @Date 2019/8/9 10:27
     */
    public StaffInfo getStaffInfo(StaffInfo staffInfo);

    /**
     * @Description 根据条件查询用户角色信息
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
    public StaffInfo isLogin(StaffInfo staffInfo);

    /**
     * 获取总记录数
     * @param info
     * @return
     */
    public long getcount(StaffInfo info);

    /**
     * 修改用户信息
     * @param staff
     */
    public void update(StaffInfo staff);

    public void delete(Integer[] staffId);
}
