package com.zph.service;

import com.zph.pojo.Administrator;

public interface AdministratorService {
	Administrator get(int id);
	Administrator getByName(String username);
}
