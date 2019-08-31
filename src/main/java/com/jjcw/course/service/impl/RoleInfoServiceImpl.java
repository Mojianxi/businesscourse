package com.jjcw.course.service.impl;

import com.jjcw.course.bean.RoleInfo;
import com.jjcw.course.dao.IRoleInfoDao;
import com.jjcw.course.service.IRoleInfoService;
import com.jjcw.course.utils.Comm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * <p>Title:RoleInfoServiceImpl </p>
 * <p>Description:角色管理业务逻辑的实现类</p>
 * <p>Company:jjcw</p>
 * 
 * @author liuxiaodong
 * @version 1.0
 */
@Service
@Transactional
public class RoleInfoServiceImpl implements IRoleInfoService {

	@Autowired
	private IRoleInfoDao roledao;

	public void add(RoleInfo info) {
		roledao.add(info);

	}

	public List<RoleInfo> list(RoleInfo info) {
		condition(info);
		// TODO Auto-generated method stub
		return roledao.list(info);
	}

	public long getcount(RoleInfo info) {
		condition(info);
		return roledao.getcount(info);
	}
	
	/**
	 * 查询条件
	 * @param info
	 */
	public void condition(RoleInfo info){
		if (info != null) {
			info.setRoleFlag(Comm.MARK_YES);
			if (info.getRoleName() != null && !info.getRoleName().equals("")) {
				info.setRoleName("%"+info.getRoleName()+"%");	
			}

		}
	}

	public RoleInfo getInfo(RoleInfo info) {
		// TODO Auto-generated method stub
		return roledao.getInfo(info);
	}

	public void update(RoleInfo info) {
		roledao.update(info);
		
	}

	public void delete(Integer[] roleId) {
		for(Integer id:roleId){
			RoleInfo info = new RoleInfo();
			info.setRoleId(id);
			//修改无效标示
			info.setRoleFlag(Comm.MARK_NO);
			
			//其实删除做的是修改
			roledao.update(info);
		}
		
	}

}
