package com.zph.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;
import com.zph.service.DormitoryService;

@Controller
@RequestMapping("")
public class DormitoryController {
	
	@Autowired
	DormitoryService dormitoryService;
	
	@RequestMapping("listDormitory")
	public ModelAndView addDormitory(DormitoryBuilding db) {
		ModelAndView mav = new ModelAndView();
		List<Dormitory> dormitories = dormitoryService.getByBuilding(db.getId());
		if(dormitories.size() == 0) {
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

		mav.setViewName("redirect:/building");
		return mav;
	}
	
}
