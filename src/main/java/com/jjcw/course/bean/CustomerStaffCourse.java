package com.jjcw.course.bean;

import java.util.Date;

/**
 * @Description 客户员工课程关联信息
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:43
 */
public class CustomerStaffCourse {
    //客户员工课程关联编号
    private int cscId;
    //客户编号
    private int customerId;
    //客户姓名
    private String customerName;
    //课程编号
    private int courseId;
    //课程姓名
    private String courseName;
    //课程价格
    private double coursePrice;
    //员工编号
    private int staffId;
    //员工姓名
    private String staffName;
    //关联类型
    private int relevType;
    //关联状态
    private int relevState;
    //付款金额
    private double payMoney;
    //付款时间
    private Date payTime;

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getCscId() {
        return cscId;
    }

    public void setCscId(int cscId) {
        this.cscId = cscId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getRelevType() {
        return relevType;
    }

    public void setRelevType(int relevType) {
        this.relevType = relevType;
    }

    public int getRelevState() {
        return relevState;
    }

    public void setRelevState(int relevState) {
        this.relevState = relevState;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "CustomerStaffCourse{" +
                "cscId=" + cscId +
                ", customerId=" + customerId +
                ", courseId=" + courseId +
                ", staffId=" + staffId +
                ", relevType=" + relevType +
                ", relevState=" + relevState +
                ", payMoney=" + payMoney +
                ", payTime=" + payTime +
                '}';
    }
}
