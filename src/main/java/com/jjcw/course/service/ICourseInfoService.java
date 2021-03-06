package com.jjcw.course.service;

import com.jjcw.course.bean.CourseInfo;
import com.jjcw.course.bean.StaffInfo;

import java.util.List;

public interface ICourseInfoService {
    public List<CourseInfo> getCourseList();

    /**
     * 根据条件查询课程信息
     * @param info 查询条件
     * @return
     */
    public List<CourseInfo> list(CourseInfo info);

    public long getcount();

    public void add(CourseInfo course);

    public CourseInfo getcourseInfo(CourseInfo course);

    void delete(Integer[] courseId);

    void update(CourseInfo course);
}
