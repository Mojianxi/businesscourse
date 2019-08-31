package com.jjcw.course.dao;

import com.jjcw.course.bean.RoleMenuInfo;

import java.util.List;
import java.util.Map;

public interface IAnthorityDao {
    /**
     * 添加角色权限关系信息
     * @param info
     * @return
     */
    public int add(RoleMenuInfo info);

    /**
     * 根据条件查询已选择的菜单
     * @param info
     * @return
     */
    public List<RoleMenuInfo> list(RoleMenuInfo info);

    /**
     * 根据角色编号删除信息
     * @param roleId
     * @return
     */
    public int delete(Integer roleId);

    /**
     * 根据角色编号查询菜单信息
     * @param roleId
     * @return
     */
    public List<Map> getMenuList(Integer roleId);
}
