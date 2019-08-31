package com.jjcw.course.controller;

import com.jjcw.course.bean.CourseInfo;
import com.jjcw.course.bean.CustomerInfo;
import com.jjcw.course.bean.CustomerStaffCourse;
import com.jjcw.course.bean.StaffInfo;
import com.jjcw.course.service.ICustomerService;
import com.jjcw.course.utils.Page;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/13 9:35
 * @Company jjcw
 */
@Controller
@RequestMapping("/customer/")
public class CustomerController extends Page {
    @Autowired
    private ICustomerService customerService;
    /**
     * 查询课程信息
     *
     * @return
     */
    @RequestMapping("list.do")
    public String list(CustomerInfo info, Model model, HttpServletRequest request) {

        if(info==null){
            info = new CustomerInfo();
        }
//        info.setStaffTag(Comm.MARK_YES);
        //分页信息
        this.initPage(request);
        //起始记录
        info.setStart(this.getPageNo());
        //每页显示记录数
        info.setLength(PAGE_NUM_BIG);
//        System.out.println("查到的用户信息"+staffInfoService.getStaffList(info).size());
        model.addAttribute("list", customerService.list(info));
        //总记录数
        model.addAttribute("total", customerService.getcount(info));

        return "customer/customer_list";
    }


    /**
     * 查看用户信息
     *
     * @return
     */
    @RequestMapping("showcustomer.do")
    public String showuser(CustomerInfo info, Model model) {
        CustomerInfo customer = customerService.getCustomer(info);
        System.out.println("传递客户"+customer.getCustomerName());
        model.addAttribute("customer", customer);
        //获取客户课程员工关联信息
        List<CustomerStaffCourse> customerStaffCourses = customerService.listRelev(info);
        model.addAttribute("list", customerStaffCourses);
        return "customer/customer_show";
    }
    @RequestMapping("loadeditrelev.do")
    public String loadeditrelev(CustomerStaffCourse customerStaffCourse){

        return "customer/edit_order";
    }
    @RequestMapping("mycustomerlist.do")
    public String showmycustomers(Model model, HttpSession session){
        StaffInfo staffInfo= (StaffInfo) session.getAttribute("staff");
        List<CustomerInfo> listStaffCustomer = customerService.listStaffCustomer(staffInfo.getStaffId());
//        System.out.println("查询到的客户"+listStaffCustomer.get(0).getCustomerName());
        model.addAttribute("list",listStaffCustomer);
        return "customer/mycustomer_list";
    }
}
