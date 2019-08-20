package com.zph.mapper;

import java.util.HashMap;
import java.util.List;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;
import com.zph.util.Page;

public interface DormitoryMapper {

		public int add(Dormitory dormitory);
		
		public DormitoryBuilding getDb(int id);
		
		public List<Dormitory> getByBuilding(HashMap<String, Integer> map);
		
		public int deleteByBuilding(int bid);
		
		public int totalOfPart(int bid);
}
