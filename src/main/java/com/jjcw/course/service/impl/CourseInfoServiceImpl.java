package com.jjcw.course.service.impl;

import com.jjcw.course.bean.CourseInfo;
import com.jjcw.course.bean.StaffInfo;
import com.jjcw.course.dao.ICourseInfoDao;
import com.jjcw.course.service.ICourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 20:39
 * @Company jjcw
 */
@Service
@Transactional
public class CourseInfoServiceImpl implements ICourseInfoService {
    @Autowired
    private ICourseInfoDao courseInfoDao;
    @Override
    public List<CourseInfo> getCourseList() {
        return courseInfoDao.getCourseList();
    }

    @Override
    public List<CourseInfo> list(CourseInfo info) {
        condition(info);
        return courseInfoDao.list(info);
    }

    /**
     * 查询条件
     *
     * @param course
     */
    public void condition(CourseInfo course) {
        if (course != null) {
            if (course.getCourseName() != null && !course.getCourseName().equals("")) {
                course.setCourseName("%"+course.getCourseName()+"%");
            }
        }
    }
    @Override
    public long getcount() {
        return courseInfoDao.getcount();
    }

    @Override
    public void add(CourseInfo course) {
        courseInfoDao.add(course);
    }

    @Override
    public CourseInfo getcourseInfo(CourseInfo course) {
        return courseInfoDao.getCourse(course);
    }

    @Override
    public void delete(Integer[] courseId) {

    }

    @Override
    public void update(CourseInfo course) {

    }

}
