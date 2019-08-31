package com.jjcw.course.service.impl;

import com.jjcw.course.bean.RoleMenuInfo;
import com.jjcw.course.dao.IAnthorityDao;
import com.jjcw.course.service.IAnthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/8/9 15:16
 * @Company jjcw
 */
@Service
@Transactional
public class AnthorityServiceImpl implements IAnthorityService {
    @Autowired
    private IAnthorityDao andao;
    @Override
    public void add(Integer roleId, Integer[] menuIds) {
        //先删除
        andao.delete(roleId);
        //后添加
        for (Integer menuId : menuIds) {
            RoleMenuInfo info = new RoleMenuInfo();
            info.setRoleId(roleId);
            info.setMenuId(menuId);
            andao.add(info);
        }
    }

    @Override
    public List<RoleMenuInfo> list(RoleMenuInfo info) {
        return andao.list(info);
    }

    @Override
    public List<Map> getMenuList(Integer roleId) {
        return andao.getMenuList(roleId);
    }
}
