package com.jjcw.course.controller;

import com.jjcw.course.bean.SalaryInfo;
import com.jjcw.course.bean.StaffInfo;
import com.jjcw.course.service.ISalaryInfoService;
import com.jjcw.course.service.IStaffInfoService;
import com.jjcw.course.utils.Comm;
import com.jjcw.course.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/12 14:20
 * @Company jjcw
 */
@Controller
@RequestMapping("/salary/")
public class SalaryController extends Page {
    /**
     * 用户管理的service
     */
    @Autowired
    private IStaffInfoService staffInfoService;

    /**
     * 薪资管理的service
     */
    @Autowired
    private ISalaryInfoService salaryInfoService;

    /**
     * 加载薪资发放页面
     *
     * @return
     */
    @RequestMapping("loadadd.do")
    public String loadadd(Model model) {

        StaffInfo staff = new StaffInfo();
        staff.setStaffTag(Comm.MARK_YES);
        staff.setStart(-1);

        // 查询所有用户信息（企业员工信息）
        List<StaffInfo> userlist = staffInfoService.getStaffList(staff);
        model.addAttribute("userlist", userlist);

        return "salary/salary_add";
    }

    /**
     * 添加薪资发放信息
     *
     * @param info
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("add.do")
    public String add(SalaryInfo info, Model model, HttpSession session) {

        try {

            // 获取当前用户登录信息
	/*		UserInfo user = (UserInfo) session.getAttribute("user");
			if (sp != null) {
				sp.setUserId(user.getUserId());
			}*/

            salaryInfoService.add(info);
            model.addAttribute("errorinfo", "薪资发放成功！");
        } catch (Exception e) {
            model.addAttribute("errorinfo", "薪资发放失败！");
        }

        return loadadd(model);
    }

    /**
     * 查询薪资发放信息
     *
     * @param info
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("list.do")
    public String list(SalaryInfo info, HttpServletRequest request, Model model) {

        if(info == null){
            info= new SalaryInfo();
        }
        // 分页信息
        this.initPage(request);
        // 起始记录
        info.setStart(this.getPageNo());
        // 每页显示记录数
        info.setLength(PAGE_NUM_BIG);
        model.addAttribute("list", salaryInfoService.list(info));
        // 总记录数
        model.addAttribute("total", salaryInfoService.getcount(info));
        model.addAttribute("salaryInfo", info);

        return "salary/salary_list";
    }

    /**
     * 导入Excel中数据
     * @param
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("impexcel.do")
    public String impExcel(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, Model model){

        //上传地址
		/*String path = request.getSession().getServletContext().getRealPath("\\upload\\");
		System.out.println(path);
		System.out.println(file.getSize());

		String filename = file.getOriginalFilename();

		File targerfile = new File(path,new Date()+filename);*/

        try {
            //上传文件
            //file.transferTo(targerfile);
            System.out.println(file.getSize());
            salaryInfoService.addAll(file.getInputStream());
            model.addAttribute("errorinfo", "导入成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "导入失败");
        }
        return list(null,request,model);
    }

    /**
     * 时间属性的编辑器
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
