package com.zph.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zph.mapper.StaffMapper;
import com.zph.pojo.Staff;
import com.zph.service.StaffService;
import com.zph.util.Page;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Override
	public List<Staff> list(Page page) {
		// TODO Auto-generated method stub
		return staffMapper.list(page);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return staffMapper.total();
	}

	@Override
	public void add(Staff staff) {
		// TODO Auto-generated method stub
		staffMapper.add(staff);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		staffMapper.delete(id);
	}

	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		staffMapper.update(staff);
	}

	@Override
	public Staff get(int id) {
		// TODO Auto-generated method stub
		return staffMapper.get(id);
	}

	@Override
	public List<Staff> listByDoid(int doid) {
		// TODO Auto-generated method stub
		return staffMapper.listByDoid(doid);
	}

}
