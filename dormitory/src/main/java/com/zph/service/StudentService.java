package com.zph.service;

import java.util.List;

import com.zph.pojo.Student;
import com.zph.util.Page;

public interface StudentService {
	
	List<Student> list(Page page);
	
	int total();
	
	void add(Student student);
}
