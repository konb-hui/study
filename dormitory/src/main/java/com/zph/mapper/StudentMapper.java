package com.zph.mapper;

import java.util.HashMap;
import java.util.List;

import com.zph.pojo.Student;
import com.zph.util.Page;

public interface StudentMapper {
	
	public List<Student> list(HashMap<String, Object> map);
	
	public int total();
	
	public int add(Student student);
	
	public int delete(int id);
	
	public int update(Student student);
	
	public Student get(int id);
}
