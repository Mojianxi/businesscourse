package com.jjcw.course.controller;

import com.jjcw.course.bean.AuditHistory;
import com.jjcw.course.bean.CostExpenses;
import com.jjcw.course.bean.CostInfo;
import com.jjcw.course.bean.StaffInfo;
import com.jjcw.course.service.ICostInfoService;
import com.jjcw.course.service.IExpenseService;
import com.jjcw.course.utils.Comm;
import com.jjcw.course.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/12 16:40
 * @Company jjcw
 */
@Controller
@RequestMapping("/expense/")
public class ExpenseController extends Page {
    /**
     * 费用管理的业务逻辑接口
     */
    @Autowired
    private ICostInfoService costservice;

    /**
     * 报销管理的业务逻辑接口
     */
    @Autowired
    private IExpenseService expservice;

    /**
     * 加载报销单
     *
     * @return
     */
    @RequestMapping("loadadd.do")
    public String loadadd(Model model) {

        // 费用信息
        CostInfo info = new CostInfo();
        info.setCostFlag(Comm.MARK_YES);
        info.setStart(-1);

        // 查询所有的费用信息
        List<CostInfo> list = costservice.list(info);
        model.addAttribute("list", list);

        return "expense/expense_add";
    }

    /**
     * 填写报销单
     *
     * @return
     */
    @RequestMapping("add.do")
    public String add(HttpSession session, CostExpenses ea, Integer[] costId, Double[] expenseDetailsSmount,
                      Model model) {

        // 获取当前登陆用户信息
        StaffInfo user = (StaffInfo) session.getAttribute("staff");

        if (ea != null) {
            ea.setStaffId(user.getStaffId());
            // 经理审核
            ea.setExpenseState(Comm.EXPPENSE_STATE_ONE);
        }

        try {
            expservice.add(ea, costId, expenseDetailsSmount);
            model.addAttribute("errorinfo", "报销单提交成功，请等待审核");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "报销单提交失败");
        }

        return loadadd(model);
    }

    /**
     * 加载部门经理审核页面
     *
     * @return
     */
    @RequestMapping("loadAuditManager.do")
    public String loadAuditManager(CostExpenses ea, Model model, HttpServletRequest request) {

        if (ea == null) {
            ea = new CostExpenses();
        }
        ea.setExpenseState(Comm.EXPPENSE_STATE_ONE);
        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(PAGE_NUM_BIG);
        model.addAttribute("list", expservice.list(ea));
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));

        return "expense/expense_audit_manager";
    }

    /**
     * 加载具体审核页面
     *
     * @return
     */
    @RequestMapping("loadManager.do")
    public String loadManager(CostExpenses ea, Model model) {

        // 报销单信息
        CostExpenses exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);

        model.addAttribute("exp", exp);
        model.addAttribute("list", list);

        return "expense/expense_manager";
    }

    /**
     * 经理审核
     *
     * @param ah
     *            审核系你想
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("auditManager.do")
    public String auditManager(AuditHistory ah, Model model, HttpServletRequest request, HttpSession session) {
        // 获取当前登陆用户信息
        StaffInfo user = (StaffInfo) session.getAttribute("staff");

        if (ah != null) {
            ah.setStaffId(user.getStaffId());
        }

        try {
            expservice.auditManager(ah);
            model.addAttribute("errorinfo", "报销单审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "报销单审核失败");
        }

        return loadAuditManager(null, model, request);
    }

    /**
     * 加载部门财务审核页面
     *
     * @return
     */
    @RequestMapping("loadAuditFinance.do")
    public String loadAuditFinance(CostExpenses ea, Model model, HttpServletRequest request) {

        if (ea == null) {
            ea = new CostExpenses();
        }
        ea.setExpenseState(Comm.EXPPENSE_STATE_TWO);
        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(PAGE_NUM_BIG);
        model.addAttribute("list", expservice.list(ea));
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));

        return "expense/expense_audit_finance";
    }

    /**
     * 加载具体财务审核页面
     *
     * @return
     */
    @RequestMapping("loadFinance.do")
    public String loadFinance(CostExpenses ea, Model model) {

        // 报销单信息
        CostExpenses exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        // 审核历史记录信息
        List<Map> historyList = expservice.getAuditHistoryList(ea);
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        model.addAttribute("historyList", historyList);

        return "expense/expense_finance";
    }

    /**
     * 财务审核
     *
     * @param ah
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("auditFinance.do")
    public String auditFinance(AuditHistory ah, Model model, HttpServletRequest request, HttpSession session) {

        // 获取当前登陆用户信息
        StaffInfo user = (StaffInfo) session.getAttribute("staff");

        if (ah != null) {
            ah.setStaffId(user.getStaffId());
        }

        try {
            expservice.auditFinance(ah);
            model.addAttribute("errorinfo", "报销单审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "报销单审核失败");
        }

        return loadAuditFinance(null, model, request);
    }

    /**
     * 查看我的报销单
     *
     * @return
     */
    @RequestMapping("mylist.do")
    public String mylist(CostExpenses ea, Model model, HttpServletRequest request, HttpSession session) {

        if (ea == null) {
            ea = new CostExpenses();
        }
        StaffInfo user = (StaffInfo) session.getAttribute("staff");
        ea.setStaffId(user.getStaffId());
        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(PAGE_NUM_BIG);
        model.addAttribute("list", expservice.list(ea));
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));

        return "expense/expense_mylist";
    }

    /**
     * 查看报销单明细
     *
     * @return
     */
    @RequestMapping("myshow.do")
    public String myshow(CostExpenses ea, Model model) {

        // 报销单信息
        CostExpenses exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        // 审核历史记录信息
        List<Map> historyList = expservice.getAuditHistoryList(ea);
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        model.addAttribute("historyList", historyList);
        return "expense/expense_myshow";
    }

    /**
     * 加载报销单修改页面
     *
     * @return
     */
    @RequestMapping("loadupdate.do")
    public String loadupdate(CostExpenses ea, Model model) {
        // 报销单信息
        CostExpenses exp = expservice.getExpenseAccount(ea);
        model.addAttribute("exp", exp);

        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        model.addAttribute("list", list);

        // 费用信息
        CostInfo info = new CostInfo();
        info.setCostFlag(Comm.MARK_YES);
        info.setStart(-1);

        // 查询所有的费用信息
        List<CostInfo> costlist = costservice.list(info);
        model.addAttribute("costlist", costlist);

        return "expense/expense_update";
    }

    /**
     * 重新提交报销单
     * @param request
     * @param session
     * @param ea
     * @param costId
     * @param expenseDetailsSmount
     * @param model
     * @return
     */
    @RequestMapping("update.do")
    public String update(HttpServletRequest request,HttpSession session, CostExpenses ea, Integer[] costId, Double[] expenseDetailsSmount,
                         Model model) {

        // 获取当前登陆用户信息
        StaffInfo user = (StaffInfo) session.getAttribute("user");

        if (ea != null) {
            ea.setStaffId(user.getStaffId());
            // 经理审核
            ea.setExpenseState(Comm.EXPPENSE_STATE_ONE);
        }

        try {
            expservice.update(ea, costId, expenseDetailsSmount);
            model.addAttribute("errorinfo", "报销单重新提交成功，请等待审核");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "报销单提交失败");
        }

        return mylist(null,model,request,session);
    }

    /**
     * 报销查询
     *
     * @return
     */
    @RequestMapping("list.do")
    public String list(CostExpenses ea, Model model, HttpServletRequest request) {

        if (ea == null) {
            ea = new CostExpenses();
        }

        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(PAGE_NUM_BIG);
        model.addAttribute("list", expservice.list(ea));
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));

        return "expense/expense_list";
    }

    /**
     * 查看报销单明细
     *
     * @return
     */
    @RequestMapping("show.do")
    public String show(CostExpenses ea, Model model) {

        // 报销单信息
        CostExpenses exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        // 审核历史记录信息
        List<Map> historyList = expservice.getAuditHistoryList(ea);
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        model.addAttribute("historyList", historyList);

        return "expense/expense_show";
    }

    /**
     * 我的审核
     *
     * @return
     */
    @RequestMapping("myauditlist.do")
    public String myauditlist(HttpServletRequest request,CostExpenses ea,HttpSession session,Model model) {


        if (ea == null) {
            ea = new CostExpenses();
        }

        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(PAGE_NUM_BIG);

        //获取当前用户登录信息
        StaffInfo user= (StaffInfo) session.getAttribute("staff");

        ea.setStaffId(user.getStaffId());
        List<CostExpenses> list = expservice.getLit(ea);
        model.addAttribute("list", list);
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));

        return "expense/expense_myauditlist";
    }

    /**
     * 查看报销单明细
     * @return
     */
    @RequestMapping("myauditshow.do")
    public String myauditshow(CostExpenses ea, Model model){
        // 报销单信息
        CostExpenses exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        // 审核历史记录信息
        List<Map> historyList = expservice.getAuditHistoryList(ea);
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        model.addAttribute("historyList", historyList);
        return "expense/expense_myauditshow";
    }

    /**
     * 时间属性的编辑器
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
