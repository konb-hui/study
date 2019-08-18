package com.zph.service;

import java.util.List;

import com.zph.pojo.DormitoryBuilding;

public interface DormitoryBuildingService {
	
	List<DormitoryBuilding> list();
	
	void add(DormitoryBuilding dormitoryBuilding);
}
