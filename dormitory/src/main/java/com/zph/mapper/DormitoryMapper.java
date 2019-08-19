package com.zph.mapper;

import java.util.List;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;

public interface DormitoryMapper {

		public int add(Dormitory dormitory);
		
		public DormitoryBuilding getDb(int id);
		
		public List<Dormitory> getByBuilding(int bid);
}
