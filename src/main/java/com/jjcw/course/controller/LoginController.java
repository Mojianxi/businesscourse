package com.jjcw.course.controller;

import com.jjcw.course.bean.StaffInfo;
import com.jjcw.course.service.IAnthorityService;
import com.jjcw.course.service.IStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 11:40
 * @Company jjcw
 */
@Controller
public class LoginController {
    @Autowired
    private IStaffInfoService staffInfoService;
    /**
     * 权限管理的业务逻辑接口
     */
    @Autowired
    private IAnthorityService anservice;
    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("login.do")
    public String login(StaffInfo staff, HttpSession session, Model model) {
        System.out.println("当前用户信息开始测试");
        StaffInfo staffInfo = staffInfoService.isLogin(staff);
        if (staffInfo != null) {
            // 把当前用户存放到session中
            session.setAttribute("staff", staffInfo);
            System.out.println("当前用户信息"+staffInfo);

            // 查询用户对应的菜单信息
            List<Map> list = anservice.getMenuList(staffInfo.getRoleId());
            System.out.println("当前用户信息菜单"+list.get(0));
            session.setAttribute("menulist", list);
            return "main/index";
        }
        return "redirect:login.jsp";
    }
    @RequestMapping("bootm.do")
    public String bootm(Model model, HttpSession session) {

        return "main/bootm";
    }

    /**
     * 加载当前登录用户的个人信息
     * @return
     */
    @RequestMapping("staff.do")
    public String loaduser(){

        return "main/staff_info";
    }
}
