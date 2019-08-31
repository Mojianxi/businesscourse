package com.jjcw.course.dao;


import com.jjcw.course.bean.CostInfo;

import java.util.List;

/**
 * 
 * <p>Title:ICostInfoDAO </p>
 * <p>Description:费用管理的数据访问接口</p>
 * <p>Company:jjcw</p>
 * @author liuxiaodong
 * @version 1.0
 */
public interface ICostInfoDao {

	/**
	 * 添加费用信息
	 * @param info 费用信息
	 * @return 返回影响的行数
	 */
	public int add(CostInfo info);
	
	/**
	 * 根据条件查询费用信息
	 * @param info 查询添加
	 * @return 多个费用信息
	 */
	public List<CostInfo> list(CostInfo info);
	
	/**
	 * 查询总记录数
	 * @param info 查询条件
	 * @return 返回总的记录数
	 */
	public long getcount(CostInfo info);
	
	/**
	 * 根据编号查询费用信息
	 * @param info 查询条件
	 * @return 返回单个费用信息
	 */
	public CostInfo getCostInfo(CostInfo info);
	
	/**
	 * 修改费用信息
	 * @param info 费用信息
	 * @return 返回影响的行数
	 */
	public int update(CostInfo info);
	
	
}
