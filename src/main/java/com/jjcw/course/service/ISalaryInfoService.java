package com.jjcw.course.service;

import com.jjcw.course.bean.CostInfo;
import com.jjcw.course.bean.SalaryInfo;

import java.io.InputStream;
import java.util.List;

public interface ISalaryInfoService {
    /**
     * 添加薪资发放信息
     * @param info 薪资方法
     */
    public void add(SalaryInfo info);

    /**
     * 导入数据
     * @param is
     */
    public void addAll(InputStream is)throws Exception ;

    /**
     * 查询所有的薪资
     * @param info 查询条件
     * @return
     */
    public List<SalaryInfo> list(SalaryInfo info);

    /**
     * 返回总记录数
     * @param info
     * @return
     */
    public Long getcount(SalaryInfo info);
}
