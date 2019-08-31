package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

import java.util.Date;

/**
 * @Description 薪资发放信息
 * @Author:liuxiaodong
 * @Date 2019/8/9 10:00
 *
 */
public class SalaryInfo extends BaseBean {
    //薪资发放编号
    private int salaryId;
    //员工编号
    private int staffId;
    //员工姓名
    private String staffName;
    //发放日期
    private Date salaryDate;
    //发放基本薪资
    private double salaryBasic;
    //发放业绩
    private double meritPay;
    //发放提成
    private double royaltyPay;

    public double getMeritPay() {
        return meritPay;
    }

    public void setMeritPay(double meritPay) {
        this.meritPay = meritPay;
    }

    public double getRoyaltyPay() {
        return royaltyPay;
    }

    public void setRoyaltyPay(double royaltyPay) {
        this.royaltyPay = royaltyPay;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    public double getSalaryBasic() {
        return salaryBasic;
    }

    public void setSalaryBasic(double salaryBasic) {
        this.salaryBasic = salaryBasic;
    }

    @Override
    public String toString() {
        return "SalaryInfo{" +
                "salaryId=" + salaryId +
                ", staffId=" + staffId +
                ", salaryDate=" + salaryDate +
                ", salaryBasic=" + salaryBasic +
                '}';
    }
}
