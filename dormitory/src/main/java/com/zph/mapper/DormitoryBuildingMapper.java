package com.zph.mapper;

import java.util.List;

import com.zph.pojo.DormitoryBuilding;

public interface DormitoryBuildingMapper {
	
	public int add(DormitoryBuilding dormitoryBuilding);
	
	public void delete(int id);
	
	public DormitoryBuilding get(int id);
	
	public int update(DormitoryBuilding dormitoryBuilding);
	
	public List<DormitoryBuilding> list();
}
