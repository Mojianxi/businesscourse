package com.jjcw.course.bean;

/**
 * @Description 菜单信息
 * @Author:liuxiaodong
 * @Date 2019/8/9 9:54
 */
public class MenuInfo {
    //菜单编号
    private int menuId;
    //父级菜单编号
    private int parentMenuId;

    /**
     * 父级菜单名称
     */
    private String parentName;
    //菜单名称
    private String menuName;
    //菜单地址
    private String menuUrl;

    public int getMenuId() {
        return menuId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String prentName) {
        this.parentName = prentName;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(int parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "menuId=" + menuId +
                ", parentMenuId=" + parentMenuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }
}
