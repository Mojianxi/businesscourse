package com.jjcw.course.dao;


import com.jjcw.course.bean.CostInfo;
import com.jjcw.course.bean.SalaryInfo;

import java.util.List;

/**
 * 
 * <p>Title:ICostInfoDAO </p>
 * <p>Description:费用管理的数据访问接口</p>
 * <p>Company:jjcw</p>
 * @author liuxiaodong
 * @version 1.0
 */
public interface ISalaryInfoDao {

	/**
	 * 添加薪资发放记录
	 * @param info 发放记录
	 * @return 返回影响的行数
	 */
	public int add(SalaryInfo info);

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
