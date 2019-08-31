package com.jjcw.course.controller;

import com.jjcw.course.bean.ClassidInfo;
import com.jjcw.course.bean.CourseInfo;
import com.jjcw.course.bean.CustomerInfo;
import com.jjcw.course.dao.ICustomerDao;
import com.jjcw.course.service.IClassInfoService;
import com.jjcw.course.service.ICustomerService;
import com.jjcw.course.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/13 19:24
 * @Company jjcw
 */
@Controller
@RequestMapping("/class/")
public class ClassInfoController extends Page {
    @Autowired
    private IClassInfoService classInfoService;
    @Autowired
    private ICustomerService customerService;
    /**
     * 查询班级信息
     *
     * @return
     */
    @RequestMapping("list.do")
    public String list(ClassidInfo info, Model model, HttpServletRequest request) {

        if(info==null){
            info = new ClassidInfo();
        }
//        info.setStaffTag(Comm.MARK_YES);
        //分页信息
        this.initPage(request);
        //起始记录
        info.setStart(this.getPageNo());
        //每页显示记录数
        info.setLength(PAGE_NUM_BIG);
//        System.out.println("查到的用户信息"+staffInfoService.getStaffList(info).size());
        model.addAttribute("list", classInfoService.list(info));
        //总记录数
        model.addAttribute("total", classInfoService.getcount(info));

        return "classinfo/classinfo_list";
    }

    //查询班级所有学员
    @RequestMapping("showclass_list.do")
    public String listCustomer(ClassidInfo info, Model model, HttpServletRequest request){
        ClassidInfo classidInfo = classInfoService.getClassidInfo(info);
        System.out.println("班级信息"+info.getClassId());
//        CustomerInfo customerInfo=new CustomerInfo();
        //分页信息
//        this.initPage(request);
//        //起始记录
//        customerInfo.setStart(this.getPageNo());
//        //每页显示记录数
//        customerInfo.setLength(PAGE_NUM_BIG);
//        System.out.println("获取到得学员信息"+customerService.listCustomer(classidInfo).get(0).getCustomerName());
        model.addAttribute("classidInfo",classidInfo);
        List<CustomerInfo> infoList = customerService.listCustomer(classidInfo);
//        infoList.get(0).setStart(this.getPageNo());
//        infoList.get(0).setLength(PAGE_NUM_BIG);
        model.addAttribute("list",infoList);
//        model.addAttribute("total", classInfoService.getClassidInfo(info));
        return "classinfo/showclass_list";
    }
}
