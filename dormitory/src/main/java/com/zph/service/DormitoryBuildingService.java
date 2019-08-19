package com.zph.service;

import java.util.List;

import com.zph.pojo.DormitoryBuilding;

public interface DormitoryBuildingService {
	
	List<DormitoryBuilding> list();
	
	void add(DormitoryBuilding dormitoryBuilding);
	
	void delete(int id);
	
	DormitoryBuilding get(int id);
	
	void update(DormitoryBuilding dormitoryBuilding);
}
