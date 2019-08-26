package com.zph.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;
import com.zph.pojo.Staff;
import com.zph.service.DormitoryBuildingService;
import com.zph.service.DormitoryService;
import com.zph.service.StaffService;
import com.zph.util.Page;

@Controller
@RequestMapping("staff")
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@Autowired
	DormitoryService dormitoryService;
	
	@Autowired
	DormitoryBuildingService dormitoryBuildingService;
	
	@RequestMapping("listStaff")
	public ModelAndView listStaff(Page page) {
		ModelAndView mav = new ModelAndView();
		int total = staffService.total();
		page.calculateLast(total);
		if(page.getStart() < 0) page.setStart(0);
		else if(page.getStart() >= total) page.setStart(page.getLast());
		List<Staff> staffs = staffService.list(page);
		mav.addObject("staffs",staffs);
		mav.setViewName("listStaff");
		return mav;
	}
	
	@RequestMapping("addStaff")
	public ModelAndView addStaff() {
		return new ModelAndView("addStaff");
	}
	
	@RequestMapping("add")
	public ModelAndView add(Staff staff) {
		ModelAndView mav = new ModelAndView();
		if(staff != null)
			staffService.add(staff);
		mav.setViewName("redirect:listStaff");
		return mav;
	}
	
	@RequestMapping("deleteStaff")
	public ModelAndView deleteStaff(Staff staff) {
		ModelAndView mav = new ModelAndView();
		Staff s = staffService.get(staff.getId());
		if(s.getDoid() != -1) {
			Dormitory d = dormitoryService.getById(s.getDoid());
			DormitoryBuilding dormitoryBuilding = dormitoryBuildingService.get(d.getBid());
			d.setSurplusBed(1);
			dormitoryBuilding.setSurplusRoom(dormitoryBuilding.getSurplusRoom() + 1);
			dormitoryService.update(d);
			dormitoryBuildingService.update(dormitoryBuilding);
		}
		staffService.delete(staff.getId());
		mav.setViewName("redirect:listStaff");
		return mav;
	}
	
	@RequestMapping("editStaff")
	public ModelAndView editStaff(Staff staff) {
		ModelAndView mav = new ModelAndView();
		Staff s = staffService.get(staff.getId());
		mav.addObject("s",s);
		mav.setViewName("editStaff");
		return mav;
	}
	
	@RequestMapping("update")
	public ModelAndView updateStaff(Staff staff) {
		ModelAndView mav = new ModelAndView();
		if(staff != null)
			staffService.update(staff);
		mav.setViewName("redirect:listStaff");
		return mav;
	}
	
	@RequestMapping("addDormitoryForStaff")
	public ModelAndView addDormitoryForStaff(int id,int doid,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Staff staff = staffService.get(id);
		staff.setDoid(doid);
		staffService.update(staff);
		mav.setViewName("redirect:/updateDormitorySurplusBed?id=" + doid);
		session.setAttribute("flag", 1);
		return mav;
	}
	
	@RequestMapping("updateDormitoryForStaff")
	public ModelAndView updateDormitoryForStaff(int id,int doid,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Staff staff = staffService.get(id);
		Dormitory dormitory1 = dormitoryService.getById(staff.getDoid());
		dormitory1.setSurplusBed(1);
		dormitoryService.update(dormitory1);
		DormitoryBuilding dormitoryBuilding1 = dormitoryBuildingService.get(dormitory1.getBid());
		dormitoryBuilding1.setSurplusRoom(dormitoryBuilding1.getSurplusRoom() + 1);
		dormitoryBuildingService.update(dormitoryBuilding1);
		staff.setDoid(doid);
		staffService.update(staff);
		Dormitory dormitory2 = dormitoryService.getById(doid);
		dormitory2.setSurplusBed(0);
		dormitoryService.update(dormitory2);
		DormitoryBuilding dormitoryBuilding2 = dormitoryBuildingService.get(dormitory2.getBid());
		dormitoryBuilding2.setSurplusRoom(dormitoryBuilding2.getSurplusRoom() - 1);
		dormitoryBuildingService.update(dormitoryBuilding2);
		session.invalidate();
		mav.setViewName("redirect:listStaff");
		return mav;
	}
	
	@RequestMapping("changeDormitoryForStaff")
	public ModelAndView changeDormitoryForStaff(int id,int sid,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Staff staff1 = staffService.get(id);
		Staff staff2 = staffService.get(sid);
		int doid = staff1.getDoid();
		staff1.setDoid(staff2.getDoid());
		staff2.setDoid(doid);
		staffService.update(staff1);
		staffService.update(staff2);
		session.invalidate();
		mav.setViewName("redirect:listStaff");
		return mav;
	}
}
