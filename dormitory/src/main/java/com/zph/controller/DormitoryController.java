package com.zph.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;
import com.zph.service.DormitoryService;
import com.zph.util.Page;

@Controller
@RequestMapping("")
public class DormitoryController {
	
	@Autowired
	DormitoryService dormitoryService;
	
	@RequestMapping("listDormitory")
	public ModelAndView addDormitory(DormitoryBuilding db,Page page) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bid", db.getId());
		List<Dormitory> dormitories1 = dormitoryService.getByBuilding(map);
		int total = dormitoryService.totalOfPart(db.getId());
		page.calculateLast(total);
		if(dormitories1.size() == 0) {
			DormitoryBuilding dormitoryBuilding = dormitoryService.getDb(db.getId());
			if(dormitoryBuilding != null) {
				int surplus = dormitoryBuilding.getSurplusRoom();
				int layerRoomNumber = dormitoryBuilding.getLayerRoomNumber();
				Dormitory dormitory = new Dormitory();
				if(dormitoryBuilding.getType() == 2) dormitory.setSurplusBed(1);
				else dormitory.setSurplusBed(4);
				dormitory.setBid(dormitoryBuilding.getId());
				if(dormitoryBuilding.getAreaNumber() == 1) {
					for(int i = 0;i < surplus;i++) {
						int a = i / layerRoomNumber + 1;
						int b = i % layerRoomNumber + 1;
						if(b < 10) dormitory.setName(a  + "0" + b);
						else dormitory.setName(a + "" + b);
						dormitoryService.add(dormitory);
					}
				}else {
					surplus = surplus / 2;
					for(int i = 0;i < surplus;i++) {
						int a = i / layerRoomNumber + 1;
						int b = i % layerRoomNumber + 1;
						if(b < 10) dormitory.setName("A" + a  + "0" + b);
						else dormitory.setName("A" + a + "" + b);
						dormitoryService.add(dormitory);
					}
					for(int i = 0;i < surplus;i++) {
						int a = i / layerRoomNumber + 1;
						int b = i % layerRoomNumber + 1;
						if(b < 10) dormitory.setName("B" + a  + "0" + b);
						else dormitory.setName("B" + a + "" + b);
						dormitoryService.add(dormitory);
					}
				}
			}
		}
		if(page.getStart() < 0) page.setStart(0);
		else if(page.getStart() >= total) page.setStart(page.getLast());
		map.put("start", page.getStart());
		map.put("count", page.getCount());
		List<Dormitory> dormitories = dormitoryService.getByBuilding(map);
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("ds", dormitories);
		map2.put("bid", db.getId());
		mav.addAllObjects(map2);
		mav.setViewName("listDormitory");
		return mav;
	}
	
	@RequestMapping("deleteDormitory")
	public ModelAndView deleteByBuilding(int bid) {
		ModelAndView mav = new ModelAndView();
		dormitoryService.deleteByBuilding(bid);
		mav.setViewName("redirect:building");
		return mav;
	}
	
	@RequestMapping("selectDormitory")
	public ModelAndView selectDormitory(int sid,int bid,HttpSession session,Page page,Integer flag) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bid", bid);
		int total = 0;
		if(flag == null) flag = (Integer) session.getAttribute("flags");
		if(flag != null) {
			if(flag == 0)
				total = dormitoryService.listForStudent(map).size();
			else if(flag == 1) 
				total = dormitoryService.listForStaff(map).size();
			session.setAttribute("flags", flag);
		}
		page.calculateLast(total);
		if(page.getStart() < 0) page.setStart(0);
		else if(page.getStart() >= total) page.setStart(page.getLast());
		map.put("start", page.getStart());
		map.put("count", page.getCount());
		List<Dormitory> ds = new ArrayList<>();
		if(flag == 0)
			ds = dormitoryService.listForStudent(map);
		else
			ds = dormitoryService.listForStaff(map);
		session.setAttribute("ds", ds);
		session.setAttribute("bid", bid);
		session.setAttribute("sid", sid);
		session.setAttribute("page", page);
		if(flag == 0)
		mav.setViewName("redirect:selectForStudent");
		else if(flag == 1)
			mav.setViewName("redirect:selectForStaff");
		return mav;
	}
	
	@RequestMapping("updateDormitorySurplusBed")
	public ModelAndView updateDormitorySurplusBed(int id,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Dormitory dormitory = dormitoryService.getById(id);
		dormitory.setSurplusBed(dormitory.getSurplusBed()-1);
		dormitoryService.update(dormitory);
		int flag = (int) session.getAttribute("flag");
		if(dormitory.getSurplusBed() == 0) {
			mav.setViewName("redirect:updateBuildingSurplusRoom?id=" + dormitory.getBid());
		}else {
			if(flag == 0)
				mav.setViewName("redirect:/student/listStudent");
			else if(flag == 1)
				mav.setViewName("redirect:/staff/listStaff");
			session.invalidate();
		}
		return mav;
	}
	
	@RequestMapping("changeDormitory")
	public ModelAndView changeDormitory(int sid,int bid,HttpSession session,Page page,Integer flag) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bid", bid);
		int total = 0;
		if(flag == null) flag = (Integer) session.getAttribute("flags");
		if(flag != null) {
			if(flag == 0)
				total = dormitoryService.listForStudent(map).size();
			else if(flag == 1) 
				total = dormitoryService.listForStaff(map).size();
			session.setAttribute("flags", flag);
		}
		page.calculateLast(total);
		if(page.getStart() < 0) page.setStart(0);
		else if(page.getStart() >= total) page.setStart(page.getLast());
		map.put("start", page.getStart());
		map.put("count", page.getCount());
		List<Dormitory> ds = new ArrayList<>();
		if(flag == 0)
			ds = dormitoryService.getForStudent(map);
		else
			ds = dormitoryService.getForStaff(map);
		session.setAttribute("ds", ds);
		session.setAttribute("bid", bid);
		session.setAttribute("sid", sid);
		session.setAttribute("page", page);
		if(flag == 0)
		mav.setViewName("redirect:updateDormitoryForStudent");
		else if(flag == 1)
			mav.setViewName("redirect:updateDormitoryForStaff");
		return mav;
	}
}
