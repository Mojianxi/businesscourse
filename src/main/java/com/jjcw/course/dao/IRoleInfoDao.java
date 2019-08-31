package com.jjcw.course.dao;


import com.jjcw.course.bean.RoleInfo;

import java.util.List;

/**
 * 
 * <p>Title:RoleInfoDAO </p>
 * <p>Description:角色管理的数据访问接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IRoleInfoDao {

	/**
	 * 添加角色
	 * @param info
	 * @return
	 */
	public int add(RoleInfo info);
	
	/**
	 * 修改角色
	 * @param info
	 * @return
	 */
	public int update(RoleInfo info);
	
	/**
	 * 根据条件查询角色信息
	 * @param info 查询条件
	 * @return
	 */
	public List<RoleInfo> list(RoleInfo info);
	
	/**
	 * 获取总记录数
	 * @param info
	 * @return
	 */
	public long getcount(RoleInfo info);
	
	/**
	 * 根据条件查询角色信息
	 * @param info 查询条件
	 * @return
	 */
	public RoleInfo getInfo(RoleInfo info);
	
}
