package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

import java.util.Date;

/**
 * @Description 报销申请信息
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:25
 */
public class CostExpenses extends BaseBean {
    //报销单编号
    private int expenseId;
    //员工编号
    private int staffId;
    //报销人姓名
    private String staffName;
    //报销名称(原因)
    private String expenseName;
    //报销原因详细描述
    private String expenseDesc;
    //报销时间
    private Date expenseTime;
    //报销状态
    private int expenseState;
    //报销金额
    private double expenseTotal;

    public int getExpenseId() {
        return expenseId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseDesc() {
        return expenseDesc;
    }

    public void setExpenseDesc(String expenseDesc) {
        this.expenseDesc = expenseDesc;
    }

    public Date getExpenseTime() {
        return expenseTime;
    }

    public void setExpenseTime(Date expenseTime) {
        this.expenseTime = expenseTime;
    }

    public int getExpenseState() {
        return expenseState;
    }

    public void setExpenseState(int expenseState) {
        this.expenseState = expenseState;
    }

    public double getExpenseTotal() {
        return expenseTotal;
    }

    public void setExpenseTotal(double expenseTotal) {
        this.expenseTotal = expenseTotal;
    }

    @Override
    public String toString() {
        return "CostExpenses{" +
                "expense_id=" + expenseId +
                ", staffId=" + staffId +
                ", expenseName='" + expenseName + '\'' +
                ", expenseDesc='" + expenseDesc + '\'' +
                ", expenseTime=" + expenseTime +
                ", expenseState=" + expenseState +
                ", expenseTotal=" + expenseTotal +
                '}';
    }
}
