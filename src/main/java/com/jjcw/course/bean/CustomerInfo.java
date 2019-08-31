package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

/**
 * @Description 客户信息
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:34
 */
public class CustomerInfo extends BaseBean {
    //客户编号
    private int customerId;
    //客户姓名
    private String customerName;
    //客户性别
    private String customerSex;
    //客户职务
    private String customerDuty;
    //客户公司
    private String customerCompany;
    //客户地址
    private String customerLocation;
    //客户电话
    private String customerPhone;
    //客户微信
    private String customerWechat;
    //付款课程
    private int payCourseNum;
    //意向课程
    private int purposeCourseNum;
    //到账金额
    private double payMoney;

    public int getPayCourseNum() {
        return payCourseNum;
    }

    public void setPayCourseNum(int payCourseNum) {
        this.payCourseNum = payCourseNum;
    }

    public int getPurposeCourseNum() {
        return purposeCourseNum;
    }

    public void setPurposeCourseNum(int purposeCourseNum) {
        this.purposeCourseNum = purposeCourseNum;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerDuty() {
        return customerDuty;
    }

    public void setCustomerDuty(String customerDuty) {
        this.customerDuty = customerDuty;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerWechat() {
        return customerWechat;
    }

    public void setCustomerWechat(String customerWechat) {
        this.customerWechat = customerWechat;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSex='" + customerSex + '\'' +
                ", customerDuty='" + customerDuty + '\'' +
                ", customerCompany='" + customerCompany + '\'' +
                ", customerLocation='" + customerLocation + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerWechat='" + customerWechat + '\'' +
                '}';
    }
}
