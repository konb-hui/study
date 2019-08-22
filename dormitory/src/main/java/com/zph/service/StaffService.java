package com.zph.service;

import java.util.List;

import com.zph.pojo.Staff;
import com.zph.util.Page;

public interface StaffService {
	
	List<Staff> list(Page page);
	
	int total();
	
	void add(Staff staff);
	
	void delete(int id);
	
	void update(Staff staff);
	
	Staff get(int id);
}
