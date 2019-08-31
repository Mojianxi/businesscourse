package com.jjcw.course.service;

import com.jjcw.course.bean.MenuInfo;

import java.util.List;

/**
 * @Description TODO
 * @Author liuxiaodong
 * @Date 2019/8/10 8:50
*/
public interface IMenuInfoService {

	/**
	 * 查询所有的菜单信息
	 * @param info
	 * @return
	 */
	public List<MenuInfo> list(MenuInfo info);
	
	/**
	 * 根据条件查询菜单信息
	 * @param info
	 * @return
	 */
	public MenuInfo getInfo(MenuInfo info);
	
	/**
	 * 添加菜单信息
	 * @param info
	 */
	public void add(MenuInfo info);
	
	/**
	 * 修改菜单信息
	 * @param info
	 */
	public void update(MenuInfo info);
	
	/**
	 * 根据编号删除菜单信息
	 * @return
	 */
	public void delete(MenuInfo info);
	
	/**
	 * 根据菜单父级编号查询菜单信息
	 * @param prentMenuId
	 * @return
	 */
	public List<MenuInfo> getMenuList(Integer prentMenuId);
	
}
