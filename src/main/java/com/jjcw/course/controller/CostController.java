package com.jjcw.course.controller;

import com.jjcw.course.bean.CostInfo;
import com.jjcw.course.service.ICostInfoService;
import com.jjcw.course.utils.Comm;
import com.jjcw.course.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 费用管理的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cost/")
public class CostController extends Page {
	
	/**
	 * 费用管理的业务逻辑接口
	 */
	@Autowired
	private ICostInfoService costservice;
	
	/**
	 * 查询费用信息
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(CostInfo info, Model model, HttpServletRequest request){
		
		if(info==null){
			info = new CostInfo();
		}
		info.setCostFlag(Comm.MARK_YES);
		//分页信息
		this.initPage(request);
		//起始记录
		info.setStart(this.getPageNo());
		//每页显示记录数
		info.setLength(PAGE_NUM_BIG);
		model.addAttribute("list", costservice.list(info));
		//总记录数
		model.addAttribute("total", costservice.getcount(info));
		model.addAttribute("info", info);
		return "cost/cost_list";
	}
	
	/**
	 * 加载费用添加页面
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(){
		return "cost/cost_add";
	}
	
	/**
	 * 添加费用信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(CostInfo info,Model model, HttpServletRequest request){
		
		try {
			if(info!=null){
				//设置标示
				info.setCostFlag(Comm.MARK_YES);
			}
			costservice.add(info);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo", "费用信息添加失败");
		}
		
		return list(null,model,request);
	}
	
	/**
	 * 加载费用修改页面
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(CostInfo info,Model model){
		
		model.addAttribute("cost", costservice.getInfo(info));
		
		return "cost/cost_update";
	}
	
	/**
	 * 修改费用信息
	 * @param info
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(CostInfo info,Model model, HttpServletRequest request){
		
		try {
			costservice.update(info);
			model.addAttribute("errorinfo", "费用信息修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo", "费用信息修改失败");
		}
		
		
		return list(null,model,request);
	}
	
	/**
	 * 根据编号删除信息（假删除）
	 * @param costId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer[] costId,Model model, HttpServletRequest request){
		
		try {
			costservice.delete(costId);
			model.addAttribute("errorinfo", "费用信息删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo", "费用信息删除失败");
		}
		
		
		return list(null,model,request);
	}

}
