package com.zph.mapper;

import java.util.List;

import com.zph.pojo.Student;
import com.zph.util.Page;

public interface StudentMapper {
	
	public List<Student> list(Page page);
	
	public int total();
	
	public int add(Student student);
}
