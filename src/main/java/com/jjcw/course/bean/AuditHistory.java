package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

import java.util.Date;

public class AuditHistory  {
    //审核记录id
    private int auditId;
    //报销单编号
    private int expenseId;
    //员工id
    private int staffId;
    //审核时间
    private Date auditTime;
    //审核状态
    private int auditState;
    //审核描述
    private String auditDesc;

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public int getExpenseId() {
        return expenseId;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    @Override
    public String toString() {
        return "AuditHistory{" +
                "auditId=" + auditId +
                ", expenseId=" + expenseId +
                ", staffId=" + staffId +
                ", auditTime=" + auditTime +
                ", auditState=" + auditState +
                ", auditDesc='" + auditDesc + '\'' +
                '}';
    }
}
