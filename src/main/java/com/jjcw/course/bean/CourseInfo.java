package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

/**
 * @Description 课程信息
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:32
 */
public class CourseInfo extends BaseBean {
    //课程编号
    private int courseId;
    //课程名称
    private String courseName;
    //课程价格
    private double coursePrice;
    //课程描述
    private String courseDesc;
    //课程详情图片
    private String coursePic;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int course_id) {
        this.courseId = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "course_id=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", coursePrice=" + coursePrice +
                ", courseDesc='" + courseDesc + '\'' +
                ", coursePic='" + coursePic + '\'' +
                '}';
    }
}
