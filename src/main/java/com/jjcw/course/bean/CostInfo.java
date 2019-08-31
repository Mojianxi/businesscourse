package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

/**
 * @Description 费用信息管理
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:29
 */
public class CostInfo extends BaseBean {
    //费用信息编号
    private int costId;
    //费用名称
    private String costName;
    //费用描述
    private String costDesc;
    //费用标识.数据库假删除用
    private int costFlag;

    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostDesc() {
        return costDesc;
    }

    public void setCostDesc(String costDesc) {
        this.costDesc = costDesc;
    }

    public int getCostFlag() {
        return costFlag;
    }

    public void setCostFlag(int cost_flag) {
        this.costFlag = cost_flag;
    }

    @Override
    public String toString() {
        return "CostInfo{" +
                "costId=" + costId +
                ", costName='" + costName + '\'' +
                ", costDesc='" + costDesc + '\'' +
                ", cost_flag=" + costFlag +
                '}';
    }
}
