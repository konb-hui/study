package com.zph.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zph.mapper.StudentMapper;
import com.zph.pojo.Student;
import com.zph.service.StudentService;
import com.zph.util.Page;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public int total() {
		// TODO Auto-generated method stub
		return studentMapper.total();
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentMapper.add(student);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		studentMapper.delete(id);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentMapper.update(student);
	}

	@Override
	public Student get(int id) {
		// TODO Auto-generated method stub
		return studentMapper.get(id);
	}

	@Override
	public List<Student> list(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return studentMapper.list(map);
	}

}
