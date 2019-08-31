package com.jjcw.course.service;

import com.jjcw.course.bean.AuditHistory;
import com.jjcw.course.bean.CostExpenses;

import java.util.List;
import java.util.Map;

public interface IExpenseService {
    /**
     * 添加报销单
     * @param ea 报销单
     * @param costId 报销的费用
     * @param expenseDetailsSmount 报销的金额
     */
    public void add(CostExpenses ea, Integer[] costId, Double[] expenseDetailsSmount);

    /**
     * 修改报销单
     * @param ea 报销单
     * @param costId 报销的费用
     * @param expenseDetailsSmount 报销的金额
     */
    public void update(CostExpenses ea,Integer[] costId,Double[] expenseDetailsSmount);

    /**
     * 根据条件查询报销单信息
     * @param ea 查询条件
     * @return 返回未审核的报销单
     */
    public List<CostExpenses> list(CostExpenses ea);

    /**
     * 查询总记录数
     * @param ea
     * @return
     */
    public long getcount(CostExpenses ea);

    /**
     * 根据编号查询报销单
     * @param ea 查询条件
     * @return 返回单个报销单信息
     */
    public CostExpenses getExpenseAccount(CostExpenses ea);

    /**
     * 根据报销单编号查询报销明细
     * @param ea 查询条件
     * @return 返回报销的明细
     */
    public List<Map> getExpenseDetailsList(CostExpenses ea);

    /**
     * 经理审核
     * @param ah
     */
    public void auditManager(AuditHistory ah);

    /**
     * 财务审核
     * @param ah
     */
    public void auditFinance(AuditHistory ah);

    /**
     * 根据报销单编号查询审核历史记录信息
     * @param
     * @return
     */
    public List<Map> getAuditHistoryList(CostExpenses ea);

    /**
     * 根据审核人查询报销单信息
     * @param
     * @return
     */
    public List<CostExpenses>  getLit(CostExpenses ea);

    /**
     * 获取总记录数
     * @param ea
     * @return
     */
    public Long getCountLong(CostExpenses ea);
}
