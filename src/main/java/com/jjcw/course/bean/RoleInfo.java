package com.jjcw.course.bean;

import com.jjcw.course.utils.BaseBean;

/**
 * @Description 角色信息
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:56
 */
public class RoleInfo extends BaseBean {
    //角色编号
    private int roleId;
    //角色名称
    private String roleName;
    //角色描述
    private String roleDesc;
    //角色标识
    private int roleFlag;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public int getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(int roleFlag) {
        this.roleFlag = roleFlag;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleFlag=" + roleFlag +
                '}';
    }
}
