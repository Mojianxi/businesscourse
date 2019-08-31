package com.jjcw.course.service.impl;

import com.jjcw.course.bean.MenuInfo;
import com.jjcw.course.dao.IMenuInfoDao;
import com.jjcw.course.service.IMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuInfoServiceImpl implements IMenuInfoService {

	@Autowired
	private IMenuInfoDao menudao;
	
	public List<MenuInfo> list(MenuInfo info) {
		// TODO Auto-generated method stub
		return menudao.list(info);
	}

	public MenuInfo getInfo(MenuInfo info) {
		// TODO Auto-generated method stub
		return menudao.getInfo(info);
	}

	public void add(MenuInfo info) {
		menudao.add(info);
		
	}

	public void update(MenuInfo info) {
		menudao.update(info);
		
	}

	public void delete(MenuInfo info) {
		menudao.delete(info);
	}

	public List<MenuInfo> getMenuList(Integer prentMenuId) {
		// TODO Auto-generated method stub
		return menudao.getMenuList(prentMenuId);
	}

}
