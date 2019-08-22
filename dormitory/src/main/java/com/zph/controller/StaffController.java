package com.zph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.Staff;
import com.zph.service.StaffService;
import com.zph.util.Page;

@Controller
@RequestMapping("staff")
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
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
}
