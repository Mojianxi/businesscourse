package com.jjcw.course.service;

import com.jjcw.course.bean.RoleMenuInfo;

import java.util.List;
import java.util.Map;

/**
 * @Description 权限管理业务接口
 * @Author liuxiaodong
 * @Date 2019/8/9 15:14
*/
public interface IAnthorityService {
    /**
     * 添加
     * @param roleId
     * @param menuIds
     */
    public void add(Integer roleId,Integer[] menuIds);

    /**
     * 根据角色编号查询已经选择的菜单编号
     * @param info
     * @return
     */
    public List<RoleMenuInfo> list(RoleMenuInfo info);

    /**
     * 根据角色编号查询菜单信息
     * @param roleId
     * @return
     */
    public List<Map> getMenuList(Integer roleId);
}
