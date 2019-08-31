package com.jjcw.course.service.impl;

import com.jjcw.course.bean.AuditHistory;
import com.jjcw.course.bean.CostExpenses;
import com.jjcw.course.bean.ExpenseDetail;
import com.jjcw.course.dao.IExpenseDao;
import com.jjcw.course.service.IExpenseService;
import com.jjcw.course.utils.Comm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/12 16:47
 * @Company jjcw
 */
@Service
@Transactional
public class ExpenseServiceImpl implements IExpenseService {
    /**
     * 报销管理的数据访问接口
     */
    @Autowired
    private IExpenseDao expdao;

    public void add(CostExpenses ea, Integer[] costId, Double[] expenseDetailsSmount) {

        // 添加报销单
        expdao.addExpense(ea);

        for (int i = 0; i < costId.length; i++) {
            ExpenseDetail ed = new ExpenseDetail();
            // 获取报销单的编号
            ed.setExpenseId(ea.getExpenseId());
            ed.setCostId(costId[i]);
            ed.setExpenseMoney(expenseDetailsSmount[i]);

            expdao.addExpenseDetails(ed);
        }

    }

    public void update(CostExpenses ea, Integer[] costId, Double[] expenseDetailsSmount) {


        // 添加报销单
        expdao.updateExpenseAccount(ea);

        //先删除以前明细，在重新添加新的明细
        expdao.deleteExpenseDetails(ea.getExpenseId());

        for (int i = 0; i < costId.length; i++) {
            ExpenseDetail ed = new ExpenseDetail();
            // 获取报销单的编号
            ed.setExpenseId(ea.getExpenseId());
            ed.setCostId(costId[i]);
            ed.setExpenseMoney(expenseDetailsSmount[i]);

            expdao.addExpenseDetails(ed);
        }

    }

    public List<CostExpenses> list(CostExpenses ea) {
        condition(ea);
        return expdao.list(ea);
    }

    public long getcount(CostExpenses ea) {
        condition(ea);
        return expdao.getcount(ea);
    }

    /**
     * 查询条件
     *
     * @param ea
     */
    public void condition(CostExpenses ea) {

        if (ea != null) {
            if (ea.getStaffName() != null && !ea.getStaffName().equals("")) {

                ea.setStaffName("%" + ea.getStaffName() + "%");
            }

        }

    }

    public CostExpenses getExpenseAccount(CostExpenses ea) {
        // TODO Auto-generated method stub
        return expdao.getExpenseAccount(ea);
    }

    public List<Map> getExpenseDetailsList(CostExpenses ea) {
        // TODO Auto-generated method stub
        return expdao.getExpenseDetailsList(ea);
    }

    public void auditManager(AuditHistory ah) {

        // 订单对象
        CostExpenses ea = new CostExpenses();
        ea.setExpenseId(ah.getExpenseId());

        // 经理审核不通过
        if (Comm.EXPPENSE_STATE_REONE==ah.getAuditState()) {
            ea.setExpenseState(Comm.EXPPENSE_STATE_ZERO);
            // 作废
        } else if (Comm.EXPPENSE_STATE_DELETE==ah.getAuditState()) {
            ea.setExpenseState(Comm.EXPPENSE_STATE_DELETE);
        } else {
            // 审核通过
            ea.setExpenseState(ah.getAuditState());
        }
        // 修改报销单
        expdao.updateExpenseAccount(ea);
        // 添加历史记录
        expdao.addAuditHistory(ah);
    }

    public List<Map> getAuditHistoryList(CostExpenses ea) {

        return expdao.getAuditHistoryList(ea);
    }

    public void auditFinance(AuditHistory ah) {

        // 订单对象
        CostExpenses ea = new CostExpenses();
        ea.setExpenseId(ah.getExpenseId());

        // 财务审核不通过
        if (Comm.EXPPENSE_STATE_RETWO==ah.getAuditState()) {
            ea.setExpenseState(Comm.EXPPENSE_STATE_ZERO);
            // 作废
        } else if (Comm.EXPPENSE_STATE_DELETE==ah.getAuditState()) {
            ea.setExpenseState(Comm.EXPPENSE_STATE_DELETE);
        } else {
            // 审核通过
            ea.setExpenseState(ah.getAuditState());
        }
        // 修改报销单
        expdao.updateExpenseAccount(ea);
        // 添加历史记录
        expdao.addAuditHistory(ah);
    }

    public List<CostExpenses> getLit(CostExpenses ea) {

        if(ea!=null){
            if(ea.getStaffName()!=null && !ea.getStaffName().equals("") ){
                ea.setStaffName("%"+ea.getStaffName()+"%");
            }

        }

        return expdao.getList(ea);
    }

    public Long getCountLong(CostExpenses ea) {
        if(ea!=null){
            if(ea.getStaffName()!=null && !ea.getStaffName().equals("") ){
                ea.setStaffName("%"+ea.getStaffName()+"%");
            }

        }
        return expdao.getCountLong(ea);
    }
}
