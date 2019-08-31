package com.jjcw.course.controller;

import com.jjcw.course.bean.RoleInfo;
import com.jjcw.course.bean.StaffInfo;
import com.jjcw.course.service.IRoleInfoService;
import com.jjcw.course.service.IStaffInfoService;
import com.jjcw.course.utils.Comm;
import com.jjcw.course.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 16:32
 * @Company jjcw
 */
@Controller
@RequestMapping("/staff/")
public class StaffController extends Page {
    @Autowired
    private IStaffInfoService staffInfoService;

    // 角色管理的业务逻辑
    @Autowired
    private IRoleInfoService roleservice;
    /**
     * 查询用户信息
     *
     * @return
     */
    @RequestMapping("list.do")
    public String list(StaffInfo info, Model model, HttpServletRequest request) {

        if(info==null){
            info = new StaffInfo();
        }
        info.setStaffTag(Comm.MARK_YES);
        //分页信息
        this.initPage(request);
        //起始记录
        info.setStart(this.getPageNo());
        //每页显示记录数
        info.setLength(PAGE_NUM_BIG);
//        System.out.println("查到的用户信息"+staffInfoService.getStaffList(info).size());
        model.addAttribute("list", staffInfoService.getStaffList(info));
        //总记录数
        model.addAttribute("total", staffInfoService.getcount(info));

        return "staff/staff_list";
    }
    /**
     * @Description 加载添加页面
     * @params
     * @return
     * @Author liuxiaodong
     * @Date 2019/8/10 15:06
    */
    @RequestMapping("loaded.do")
    public String loaded(Model model){
        RoleInfo info=new RoleInfo();
        info.setStart(-1);
        List<RoleInfo> list = roleservice.list(info);
        model.addAttribute("list",list);
        return "staff/staff_add";
    }
    /**
     * 添加用户信息
     *
     * @return
     */
    @RequestMapping("add.do")
    public String add(StaffInfo staff, Model model, HttpServletRequest request) {
        try {
            if (staff == null) {
                staff = new StaffInfo();
            }
            staff.setStaffTag(Comm.MARK_YES);
            RoleInfo roleInfo=new RoleInfo();
            roleInfo.setRoleId(staff.getRoleId());
            staff.setRoleName(roleservice.getInfo(roleInfo).getRoleName());
            System.out.println("当前角色名"+staff.getRoleName());
            staffInfoService.add(staff);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "用户添加失败");
        }

        return list(null,model,request);
    }
    /**
     * 验证账号是否存在
     *
     * @param staff
     * @return
     */
    @RequestMapping("check.do")
    public @ResponseBody
    String check(StaffInfo staff) {
        StaffInfo userinfo = staffInfoService.getStaffInfo(staff);
        if (userinfo != null) {
            return "账号已经存在，请从新输入!";
        } else {
            return "恭喜您，账号可以使用";
        }
    }
    /**
     * 加载修改页面
     *
     * @return
     */
    @RequestMapping("loadupdate.do")
    public String loadupdate(StaffInfo staff, Model model) {
        //用户信息
        StaffInfo staffinfo = staffInfoService.getStaffInfo(staff);
        model.addAttribute("staffinfo", staffinfo);

        //角色信息
        RoleInfo info = new RoleInfo();
        info.setStart(-1);
        List<RoleInfo> list = roleservice.list(info);
        model.addAttribute("list", list);
        return "staff/staff_update";
    }
    /**
     * 修改用户信息
     * @param staff
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("update.do")
    public String update(StaffInfo staff, Model model, HttpServletRequest request){

        try {

            staffInfoService.update(staff);


        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "用户修改失败");
        }

        return list(null,model,request);
    }

    /**
     * 删除用户信息
     * @param staffId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("delete.do")
    public String delete(Integer[] staffId, Model model, HttpServletRequest request){

        try {
            staffInfoService.delete(staffId);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "用户删除失败");
        }

        return list(null,model,request);
    }

    /**
     * 查看用户信息
     *
     * @return
     */
    @RequestMapping("showstaff.do")
    public String showuser(StaffInfo user, Model model) {
        StaffInfo userinfo = staffInfoService.getStaffInfo(user);
        model.addAttribute("staffinfo", userinfo);

        return "staff/staff_show";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");//格式根据个人需求进行设定
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，日期可以为空，false:不能为空值
    }
}
