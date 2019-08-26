package com.zph.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zph.mapper.DormitoryMapper;
import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;
import com.zph.service.DormitoryService;
import com.zph.util.Page;

@Service
public class DormitoryServiceImpl implements DormitoryService {
	
	@Autowired
	private DormitoryMapper dormitoryMapper;
	
	@Override
	public void add(Dormitory dormitory) {
		// TODO Auto-generated method stub
		dormitoryMapper.add(dormitory);
	}

	@Override
	public DormitoryBuilding getDb(int id) {
		// TODO Auto-generated method stub
		return dormitoryMapper.getDb(id);
	}

	@Override
	public List<Dormitory> getByBuilding(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return dormitoryMapper.getByBuilding(map);
	}

	@Override
	public void deleteByBuilding(int bid) {
		// TODO Auto-generated method stub
		dormitoryMapper.deleteByBuilding(bid);
	}

	@Override
	public int totalOfPart(int bid) {
		// TODO Auto-generated method stub
		return dormitoryMapper.totalOfPart(bid);
	}

	@Override
	public List<Dormitory> listForStudent(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return dormitoryMapper.listForStudent(map);
	}

	@Override
	public Dormitory getById(int id) {
		// TODO Auto-generated method stub
		return dormitoryMapper.getById(id);
	}

	@Override
	public void update(Dormitory dormitory) {
		// TODO Auto-generated method stub
		dormitoryMapper.update(dormitory);
	}

	@Override
	public List<Dormitory> listForStaff(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return dormitoryMapper.listForStaff(map);
	}

	@Override
	public List<Dormitory> getForStaff(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return dormitoryMapper.getForStaff(map);
	}

	@Override
	public List<Dormitory> getForStudent(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return dormitoryMapper.getForStudent(map);
	}

}
