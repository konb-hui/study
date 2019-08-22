package com.zph.mapper;

import java.util.List;

import com.zph.pojo.Staff;
import com.zph.util.Page;

public interface StaffMapper {
	
	public List<Staff> list(Page page);
	
	public int total();
	
	public int add(Staff staff);
	
	public int delete(int id);
	
	public int update(Staff staff);
	
	public Staff get(int id);
}
