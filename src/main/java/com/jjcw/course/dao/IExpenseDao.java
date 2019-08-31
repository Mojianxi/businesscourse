package com.jjcw.course.dao;

import com.jjcw.course.bean.AuditHistory;
import com.jjcw.course.bean.CostExpenses;
import com.jjcw.course.bean.ExpenseDetail;

import java.util.List;
import java.util.Map;

public interface IExpenseDao {

    /**
     * 添加报销单
     * @param ea 报销单
     * @return 返回影响的行数
     */
    public int addExpense(CostExpenses ea);

    /**
     * 添加报销明细
     * @param ed 报销明细
     * @return 返回影响的行数
     */
    public int addExpenseDetails(ExpenseDetail ed);

    /**
     * 根据条件查询报销单信息
     * @param ea 查询条件
     * @return
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
     * 添加审核历史记录
     * @param ah 历史记录信息
     * @return
     */
    public int addAuditHistory(AuditHistory ah);

    /**
     * 修改报销单
     * @param ea
     * @return
     */
    public int updateExpenseAccount(CostExpenses ea);

    /**
     * 根据报销单查询审核历史记录信息
     * @param ah
     * @return
     */
    public List<Map> getAuditHistoryList(CostExpenses ea);


    /**
     * 根据编号删除报销单明细
     * @param expenseId
     * @return
     */
    public int deleteExpenseDetails(Integer expenseId);

    /**
     * 根据审核人查询报销单信息
     * @param userId 用户编号
     * @return
     */
    public List<CostExpenses>  getList(CostExpenses ea);

    /**
     * 获取总记录数
     * @param ea
     * @return
     */
    public Long getCountLong(CostExpenses ea);
}
