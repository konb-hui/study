package com.zph.service;

import java.util.List;

import com.zph.pojo.Administrator;

public interface AdministratorService {
	Administrator get(int id);
	Administrator getByName(String username);
	List<Administrator> list();
	void add(Administrator administrator);
	void delete(int id);
	void update(Administrator administrator);
}
