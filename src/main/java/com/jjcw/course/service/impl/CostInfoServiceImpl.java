package com.jjcw.course.service.impl;

import com.jjcw.course.bean.CostInfo;
import com.jjcw.course.dao.ICostInfoDao;
import com.jjcw.course.service.ICostInfoService;
import com.jjcw.course.utils.Comm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CostInfoServiceImpl implements ICostInfoService {

	@Autowired
	private ICostInfoDao costdao;

	public void add(CostInfo info) {
		costdao.add(info);

	}

	@Transactional(readOnly = true)
	public List<CostInfo> list(CostInfo info) {
		condition(info);
		return costdao.list(info);
	}

	@Transactional(readOnly = true)
	public long getcount(CostInfo info) {
		condition(info);
		return costdao.getcount(info);
	}

	public void condition(CostInfo info) {
		if (info != null) {
			if (info.getCostName() != null && !info.getCostName().equals("")) {
				info.setCostName("%" + info.getCostName() + "%");
			}
		}

	}

	public CostInfo getInfo(CostInfo info) {
		// TODO Auto-generated method stub
		return costdao.getCostInfo(info);
	}

	public void update(CostInfo info) {
		costdao.update(info);
		
	}

	public void delete(Integer[] costIds) {
		for(Integer costId:costIds){
			CostInfo info = new CostInfo();
			info.setCostId(costId);
			info.setCostFlag(Comm.MARK_NO);
			costdao.update(info);
		}
		
	}

}
