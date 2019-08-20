package com.zph.service.impl;

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
	public List<Student> list(Page page) {
		// TODO Auto-generated method stub
		return studentMapper.list(page);
	}

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

}
