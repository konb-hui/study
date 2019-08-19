package com.zph.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.DormitoryBuilding;
import com.zph.service.DormitoryBuildingService;

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
		mav.setViewName("redirect:/building");
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
}
