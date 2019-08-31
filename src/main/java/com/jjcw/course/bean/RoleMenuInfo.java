package com.jjcw.course.bean;

/**
 * @Description 角色菜单关联信息
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:58
 */
public class RoleMenuInfo {
    //角色菜单关联编号
    private int roleMenuId;
    //菜单编号
    private int menuId;
    //角色编号
    private int roleId;

    public int getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(int roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleMenuInfo{" +
                "roleMenuId=" + roleMenuId +
                ", menuId=" + menuId +
                ", roleId=" + roleId +
                '}';
    }
}
