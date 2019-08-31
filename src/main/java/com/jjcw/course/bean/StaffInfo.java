package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

import java.util.Date;

public class StaffInfo extends BaseBean {
    //员工编号
    private int staffId;
    //角色编号
    private int roleId;
    //员工姓名
    private String staffName;
    //员工性别
    private String staffSex;
    //员工年龄
    private int staffAge;
    //员工账户
    private String staffAccount;
    //员工密码
    private String staffPass;
    //员工电话
    private String staffPhone;
    //员工微信
    private String staffWechat;
    //员工基本薪资
    private String staffSalary;
    //员工生日
    private Date staffBirthday;
    //员工标识
    private int staffTag;
    //用户角色名称
    private String roleName;
    public int getStaffId() {
        return staffId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public int getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(int staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

    public String getStaffPass() {
        return staffPass;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffWechat() {
        return staffWechat;
    }

    public void setStaffWechat(String staffWechat) {
        this.staffWechat = staffWechat;
    }

    public String getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(String staffSalary) {
        this.staffSalary = staffSalary;
    }

    public Date getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(Date staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public int getStaffTag() {
        return staffTag;
    }

    public void setStaffTag(int staffTag) {
        this.staffTag = staffTag;
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
                "staffId=" + staffId +
                ", roleId=" + roleId +
                ", staffName='" + staffName + '\'' +
                ", staffSex='" + staffSex + '\'' +
                ", staffAge=" + staffAge +
                ", staffAccount='" + staffAccount + '\'' +
                ", staffPass='" + staffPass + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffWechat='" + staffWechat + '\'' +
                ", staffSalary='" + staffSalary + '\'' +
                ", staffBirthday=" + staffBirthday +
                ", staffTag=" + staffTag +
                '}';
    }
}
