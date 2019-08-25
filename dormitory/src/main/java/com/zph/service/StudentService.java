package com.zph.service;

import java.util.HashMap;
import java.util.List;

import com.zph.pojo.Student;
import com.zph.util.Page;

public interface StudentService {
	
	List<Student> list(HashMap<String, Object> map);
	
	int total();
	
	void add(Student student);
	
	void delete(int id);
	
	void update(Student student);
	
	Student get(int id);
	
	List<Student> listByDoid(int doid);
}
