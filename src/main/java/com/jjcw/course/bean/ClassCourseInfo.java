package com.jjcw.course.bean;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:17
 */
public class ClassCourseInfo {
    //班级课程关联编号
    private int cciId;
    //班级编号
    private int classId;
    //客户id
    private int customerId;
    //课程编号
    private int courseId;

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getCciId() {
        return cciId;
    }

    public void setCciId(int cciId) {
        this.cciId = cciId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "ClassCourseInfo{" +
                "cciId=" + cciId +
                ", classId=" + classId +
                ", courseId=" + courseId +
                '}';
    }
}
