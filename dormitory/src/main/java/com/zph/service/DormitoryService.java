package com.zph.service;

import java.util.List;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;

public interface DormitoryService {
	
	void add(Dormitory dormitory);
	
	DormitoryBuilding getDb(int id);
	
	List<Dormitory> getByBuilding(int bid);
}
