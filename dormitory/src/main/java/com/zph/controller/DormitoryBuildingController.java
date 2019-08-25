package com.zph.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;
import com.zph.pojo.Staff;
import com.zph.pojo.Student;
import com.zph.service.DormitoryBuildingService;
import com.zph.util.Page;

@Controller
@RequestMapping("")
public class DormitoryBuildingController {
	
	@Autowired
	DormitoryBuildingService dormitoryBuildingService;
	
	@RequestMapping("building")
	public ModelAndView list() {
		List<DormitoryBuilding> dbs = dormitoryBuildingService.list();
		ModelAndView mav = new ModelAndView("building");
		mav.addObject("dbs",dbs);
		return mav;
	}
	
	@RequestMapping("addBuilding")
	public ModelAndView jumpAddBuilding() {
		return new ModelAndView("addBuilding");
	}
	
	@RequestMapping("add")
	public ModelAndView addBuilding(DormitoryBuilding dormitoryBuilding) {
		ModelAndView mav = new ModelAndView();
		List<DormitoryBuilding> dbs = dormitoryBuildingService.list();
		if(dbs != null) {
			for(DormitoryBuilding db:dbs) {
				if(db.getName().equals(dormitoryBuilding.getName())) mav.setViewName("addBuilding");
			}
		}
		dormitoryBuildingService.add(dormitoryBuilding);
		mav.setViewName("redirect:/building");
		return mav;
	}
	
	@RequestMapping("deleteBuilding")
	public ModelAndView deleteBuilding(DormitoryBuilding dormitoryBuilding) {
		ModelAndView mav = new ModelAndView();
		dormitoryBuildingService.delete(dormitoryBuilding.getId());
		int bid = dormitoryBuilding.getId();
		mav.setViewName("redirect:deleteDormitory?bid=" + bid);
		return mav;
	}
	
	@RequestMapping("editBuilding")
	public ModelAndView editBuilding(DormitoryBuilding dormitoryBuilding) {
		ModelAndView mav = new ModelAndView();
		DormitoryBuilding db = dormitoryBuildingService.get(dormitoryBuilding.getId());
		mav.addObject("db",db);
		mav.setViewName("editBuilding");
		return mav;
	}
	
	@RequestMapping("updateBuilding")
	public ModelAndView updateBuilding(DormitoryBuilding dormitoryBuilding) {
		ModelAndView mav = new ModelAndView();
		dormitoryBuildingService.update(dormitoryBuilding);
		mav.setViewName("redirect:/building");
		return mav;
	}
	@RequestMapping("/addStudent")
	public ModelAndView addStudent() {
		return new ModelAndView("addStudent");
	}
	
	@RequestMapping("selectForStudent")
	public ModelAndView selectForStudent(Student student,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		DormitoryBuilding d = new DormitoryBuilding();
		if(student.getSex() != null) {
			if(student.getSex().equals("男"))
				d.setType(0);
			else 
				d.setType(1);
		}
		List<DormitoryBuilding> dormitoryBuildings = dormitoryBuildingService.list(d);
		if(student.getSex() != null) session.setAttribute("dbs",dormitoryBuildings);
		Page p = (Page) session.getAttribute("page");
		if(p!=null) mav.addObject("page",p);
		mav.setViewName("selectDormitory");
		return mav;
	}
	
	@RequestMapping("selectForStaff")
	public ModelAndView selectForStaff(Staff staff,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		DormitoryBuilding d = new DormitoryBuilding();
		if(staff.getSex() != null)
			d.setType(2);
		List<DormitoryBuilding> dormitoryBuildings = dormitoryBuildingService.list(d);
		if(staff.getSex() != null) session.setAttribute("dbs",dormitoryBuildings);
		Page p = (Page) session.getAttribute("page");
		if(p!=null) mav.addObject("page",p);
		mav.setViewName("selectDormitory");
		return mav;
	}
	
	@RequestMapping("updateBuildingSurplusRoom")
	public ModelAndView updateBuildingSurplusRoom(int id,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Integer DBid = (Integer) session.getAttribute("DBid");
		DormitoryBuilding db = dormitoryBuildingService.get(id);
		db.setSurplusRoom(db.getSurplusRoom() - 1);
		dormitoryBuildingService.update(db);
		int flag = (int) session.getAttribute("flag");
		if(flag == 0)
		mav.setViewName("redirect:/student/listStudent");
		else if(flag == 1)
			mav.setViewName("redirect:/staff/listStaff");
		session.invalidate();
		return mav;
	}
}
