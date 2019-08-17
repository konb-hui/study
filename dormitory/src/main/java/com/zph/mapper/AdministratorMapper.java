package com.zph.mapper;

import java.util.List;

import com.zph.pojo.Administrator;

public interface AdministratorMapper {
	
	public int add(Administrator administrator);
	
	public void delete(int id);
	
	public Administrator get(int id);
	
	public Administrator getByName(String username);
	
	public int update(Administrator administrator);
	
	public List<Administrator> list();
}
