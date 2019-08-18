package com.zph.controller;

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
}
