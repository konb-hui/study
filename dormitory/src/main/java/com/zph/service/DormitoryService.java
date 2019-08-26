package com.zph.service;

import java.util.HashMap;
import java.util.List;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;
import com.zph.util.Page;

public interface DormitoryService {
	
	void add(Dormitory dormitory);
	
	DormitoryBuilding getDb(int id);
	
	List<Dormitory> getByBuilding(HashMap<String, Integer> map);
	
	void deleteByBuilding(int bid);
	
	int totalOfPart(int bid);
	
	List<Dormitory> listForStudent(HashMap<String, Integer> map);
	
	Dormitory getById(int id);
	
	void update(Dormitory dormitory);
	
	List<Dormitory> listForStaff(HashMap<String, Integer> map);
	
	List<Dormitory> getForStaff(HashMap<String, Integer> map);
	
	List<Dormitory> getForStudent(HashMap<String, Integer> map);
}
