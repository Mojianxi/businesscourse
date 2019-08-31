package com.jjcw.course.controller;

import com.jjcw.course.bean.CourseInfo;
import com.jjcw.course.bean.RoleInfo;
import com.jjcw.course.bean.StaffInfo;
import com.jjcw.course.service.ICourseInfoService;
import com.jjcw.course.service.IStaffInfoService;
import com.jjcw.course.utils.Comm;
import com.jjcw.course.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 20:34
 * @Company jjcw
 */
@Controller
@RequestMapping("/course/")
public class CourseController extends Page {
    @Autowired
    private ICourseInfoService courseInfoService;
    /**
     * 查询课程信息
     *
     * @return
     */
    @RequestMapping("list.do")
    public String list(CourseInfo info, Model model, HttpServletRequest request) {

        if(info==null){
            info = new CourseInfo();
        }
//        info.setStaffTag(Comm.MARK_YES);
        //分页信息
        this.initPage(request);
        //起始记录
        info.setStart(this.getPageNo());
        //每页显示记录数
        info.setLength(PAGE_NUM_BIG);
//        System.out.println("查到的用户信息"+staffInfoService.getStaffList(info).size());
        model.addAttribute("list", courseInfoService.getCourseList());
        //总记录数
        model.addAttribute("total", courseInfoService.getcount());

        return "course/course_list";
    }

    /**
     * 加载添加页面
     *
     * @return
     */
    @RequestMapping("loadadd.do")
    public String loadadd(Model model) {

        CourseInfo info = new CourseInfo();
        info.setStart(-1);

        List<CourseInfo> list = courseInfoService.list(info);

        model.addAttribute("list", list);

        return "course/course_add";
    }

    /**
     * 添加用户信息
     *
     * @return
     */
    @RequestMapping("add.do")
    public String add(CourseInfo course, Model model, HttpServletRequest request) {

        try {
            if (course == null) {
                course = new CourseInfo();
            }

//            course.setc(Comm.MARK_YES);

            courseInfoService.add(course);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "用户添加失败");
        }

        return list(null,model,request);
    }
    /**
     * 验证账号是否存在
     *
     * @param course
     * @return
     */
    @RequestMapping("check.do")
    public @ResponseBody
    String check(CourseInfo course) {
        CourseInfo courseInfo= courseInfoService.getcourseInfo(course);
        if (course != null) {
            return "课程已经存在，请从新输入!";
        } else {
            return "账户添加成功";
        }
    }
    /**
     * 加载修改页面
     *
     * @return
     */
    @RequestMapping("loadupdate.do")
    public String loadupdate(CourseInfo course, Model model) {
        //课程信息
        CourseInfo courseInfo= courseInfoService.getcourseInfo(course);
        model.addAttribute("courseinfo", courseInfo);

        //角色信息
//        RoleInfo info = new RoleInfo();
//        info.setStart(-1);
//        List<RoleInfo> list = roleservice.list(info);
//        model.addAttribute("list", list);

        return "course/course_edit";
    }


    /**
     * 修改课程信息
     * @param course
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("update.do")
    public String update(CourseInfo course, Model model, HttpServletRequest request){
        try {
            courseInfoService.update(course);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "课程修改失败");
        }

        return list(null,model,request);
    }

    /**
     * 删除用户信息
     * @param courseId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("delete.do")
    public String delete(Integer[] courseId, Model model, HttpServletRequest request){
        try {
            courseInfoService.delete(courseId);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorinfo", "用户删除失败");
        }
        return list(null,model,request);
    }
}
