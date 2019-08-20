package com.zph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.Student;
import com.zph.service.StudentService;
import com.zph.util.Page;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("listStudent")
	public ModelAndView listStudent(Page page) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = studentService.list(page);
		int total = studentService.total();
		page.calculateLast(total);
		if(page.getStart() < 0) page.setStart(0);
		else if(page.getStart() >= total) page.setStart(page.getLast());
		mav.addObject("students",students);
		mav.setViewName("listStudent");
		return mav;
	}
	
	@RequestMapping("addStudent")
	public ModelAndView addStudent(Student student) {
		ModelAndView mav = new ModelAndView();
		studentService.add(student);
		mav.setViewName("redirect:/student/listStudent");
		return mav;
	}
}
