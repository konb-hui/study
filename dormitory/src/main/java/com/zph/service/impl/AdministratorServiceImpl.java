package com.zph.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zph.mapper.AdministratorMapper;
import com.zph.pojo.Administrator;
import com.zph.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	@Autowired
	private AdministratorMapper administratorMapper;
	
	@Override
	public Administrator get(int id) {
		// TODO Auto-generated method stub
		return administratorMapper.get(id);
	}

	@Override
	public Administrator getByName(String username) {
		// TODO Auto-generated method stub
		return administratorMapper.getByName(username);
	}

	@Override
	public List<Administrator> list() {
		// TODO Auto-generated method stub
		return administratorMapper.list();
	}

	@Override
	public void add(Administrator administrator) {
		// TODO Auto-generated method stub
		administratorMapper.add(administrator);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		administratorMapper.delete(id);
	}

	@Override
	public void update(Administrator administrator) {
		// TODO Auto-generated method stub
		administratorMapper.update(administrator);
	}

}
