package com.jjcw.course.bean;

/**
 * @Description 报销明细(报销与费用关系信息)
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:50
 */
public class ExpenseDetail {
    //报销明细编号
    private int expenseDetailId;
    //报销编号
    private int expenseId;
    //费用编号
    private int costId;
    //报销金额
    private double expenseMoney;

    public int getExpenseDetailId() {
        return expenseDetailId;
    }

    public void setExpenseDetailId(int expenseDetailId) {
        this.expenseDetailId = expenseDetailId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    public double getExpenseMoney() {
        return expenseMoney;
    }

    public void setExpenseMoney(double expenseMoney) {
        this.expenseMoney = expenseMoney;
    }

    @Override
    public String toString() {
        return "ExpenseDetail{" +
                "expenseDetailId=" + expenseDetailId +
                ", expenseId=" + expenseId +
                ", costId=" + costId +
                ", expenseMoney=" + expenseMoney +
                '}';
    }
}
