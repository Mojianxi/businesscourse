package com.jjcw.course.service;


import com.jjcw.course.bean.CostInfo;

import java.util.List;

/**
 * 
 * <p>Title:ICostInfoService </p>
 * <p>Description:费用管理的业务逻辑接口</p>
 * <p>Company:jjcw</p>
 * @author liuxiaodong
 * @version 1.0
 */
public interface ICostInfoService {

	/**
	 * 添加费用信息
	 * @param info 费用信息
	 */
	public void add(CostInfo info);
	
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
	 * @param info
	 * @return
	 */
	public CostInfo getInfo(CostInfo info);
	
	/**
	 * 修改费用信息
	 * @param info 费用信息
	 */
	public void update(CostInfo info);
	
	/**
	 * 删除费用信息
	 * @param costIds
	 */
	public void delete(Integer[] costIds);
	
}
