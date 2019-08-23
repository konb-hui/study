package com.zph.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zph.mapper.DormitoryBuildingMapper;
import com.zph.pojo.DormitoryBuilding;
import com.zph.service.DormitoryBuildingService;

@Service
public class DormitoryBuildingServiceImpl implements DormitoryBuildingService {
	
	@Autowired
	private DormitoryBuildingMapper dormitoryBuildingMapper;
	@Override
	public List<DormitoryBuilding> list() {
		// TODO Auto-generated method stub
		return dormitoryBuildingMapper.list();
	}
	@Override
	public void add(DormitoryBuilding dormitoryBuilding) {
		// TODO Auto-generated method stub
		dormitoryBuildingMapper.add(dormitoryBuilding);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dormitoryBuildingMapper.delete(id);
	}
	@Override
	public DormitoryBuilding get(int id) {
		// TODO Auto-generated method stub
		DormitoryBuilding dormitoryBuilding = dormitoryBuildingMapper.get(id);
		return dormitoryBuilding;
	}
	@Override
	public void update(DormitoryBuilding dormitoryBuilding) {
		// TODO Auto-generated method stub
		dormitoryBuildingMapper.update(dormitoryBuilding);
	}
	@Override
	public List<DormitoryBuilding> list(DormitoryBuilding dormitoryBuilding) {
		// TODO Auto-generated method stub
		return dormitoryBuildingMapper.list(dormitoryBuilding);
	}
	

}
