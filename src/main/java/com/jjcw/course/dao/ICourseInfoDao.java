package com.jjcw.course.dao;

import com.jjcw.course.bean.CourseInfo;

import java.util.List;

public interface ICourseInfoDao {
    public List<CourseInfo> getCourseList();

    /**
     * 根据条件查询课程信息
     * @param info 查询条件
     * @return
     */
    public List<CourseInfo> list(CourseInfo info);
    public long getcount();

    public void add(CourseInfo course);

    public CourseInfo getCourse(CourseInfo course);
}
