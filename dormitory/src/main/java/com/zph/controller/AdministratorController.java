package com.zph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.Administrator;
import com.zph.service.AdministratorService;

@Controller
@RequestMapping("")
public class AdministratorController {
	@Autowired
	AdministratorService administratorService;
	
	@RequestMapping("login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("homepage")
	public ModelAndView check(Administrator administrator) {
		Administrator admin = administratorService.getByName(administrator.getUsername());
		ModelAndView mav = new ModelAndView("redirect:login");
		if(admin != null) {
			if(admin.getPassword().equals(administrator.getPassword())) {
				mav = new ModelAndView("homepage");
				mav.addObject("username",admin.getUsername());
			}
		}else if(null == admin) {
			mav = new ModelAndView("redirect:login");
			//mav.addObject("msg","用户或密码错误");
		}
		return mav;
	}
	
	@RequestMapping("listAdmin")
	public ModelAndView listAdmin() {
		ModelAndView mav = new ModelAndView();
		List<Administrator> administrators = administratorService.list();
		mav.addObject("admins",administrators);
		mav.setViewName("listAdmin");
		return mav;
	}
	
	@RequestMapping("addAdmin")
	public ModelAndView addAdmin(Administrator administrator) {
		ModelAndView mav = new ModelAndView();
		if(administrator.getUsername() == null) {
			mav.setViewName("addAdmin");
		}else {
			administratorService.add(administrator);
			mav.setViewName("redirect:listAdmin");
		}
		return mav;
	}
	
	@RequestMapping("deleteAdmin")
	public ModelAndView deleteAdmin(Administrator administrator) {
		ModelAndView mav = new ModelAndView();
		administratorService.delete(administrator.getId());
		mav.setViewName("redirect:listAdmin");
		return mav;
	}
	
	@RequestMapping("editAdmin")
	public ModelAndView editAdmin(Administrator administrator) {
		ModelAndView mav = new ModelAndView();
		if(administrator.getUsername() == null&&administrator.getPassword() == null) {
			Administrator a = administratorService.get(administrator.getId());
			mav.addObject("a",a);
			mav.setViewName("editAdmin");
		}else {
			administratorService.update(administrator);
			mav.setViewName("redirect:listAdmin");
		}
		return mav;
	}
}
