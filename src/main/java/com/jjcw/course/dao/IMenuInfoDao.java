package com.jjcw.course.dao;


import com.jjcw.course.bean.MenuInfo;

import java.util.List;

/**
 * 
 * <p>Title:IMenuInfoDao </p>
 * <p>Description:菜单管理的数据访问接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IMenuInfoDao {

	/**
	 * 查询菜单信息
	 * @param menu
	 * @return
	 */
	public List<MenuInfo> list(MenuInfo menu);
	
	/**
	 * 根据条件查询菜单信息
	 * @param info
	 * @return
	 */
	public MenuInfo getInfo(MenuInfo info);
	
	/**
	 * 添加菜单信息
	 * @param info 菜单信息
	 * @return
	 */
	public int add(MenuInfo info);
	
	/**
	 * 修改菜单信息
	 * @param info
	 * @return
	 */
	public int update(MenuInfo info);
	
	/**
	 * 根据编号删除菜单信息
	 * @param info
	 * @return
	 */
	public int delete(MenuInfo info);
	
	/**
	 * 根据菜单父级编号查询菜单信息
	 * @param parentMenuId
	 * @return
	 */
	public List<MenuInfo> getMenuList(Integer parentMenuId);
}
