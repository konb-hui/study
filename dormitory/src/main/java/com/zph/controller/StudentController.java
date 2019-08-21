package com.zph.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

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
	public ModelAndView listStudent(Page page,Student student,Integer flag,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int total = studentService.total();
		page.calculateLast(total);
		if(page.getStart() < 0) page.setStart(0);
		else if(page.getStart() >= total) page.setStart(page.getLast());
		HashMap<String , Object> map = new HashMap<>();
		map.put("start", page.getStart());
		map.put("count", page.getCount());
		map.put("last", page.getLast());
		if(flag!=null&&flag==1) {
			map.put("name", student.getName());
			map.put("className", student.getClassName());
			map.put("grade", student.getGrade());
			map.put("sex", student.getSex());
			map.put("doid", student.getDoid());
			session.setAttribute("map",map);
		}else if(flag!=null&&flag==2) {
			map = (HashMap<String, Object>) session.getAttribute("map");
			map.remove("start");
			map.remove("count");
			List<Student> s = studentService.list(map);
			total = s.size();
			page.calculateLast(total);
			map.put("start", page.getStart());
			map.put("count", page.getCount());
			map.put("last",page.getLast());
		}
		List<Student> students = studentService.list(map);
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
	
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(Student student) {
		ModelAndView mav = new ModelAndView();
		studentService.delete(student.getId());
		mav.setViewName("redirect:/student/listStudent");
		return mav;
	}
	
	@RequestMapping("test")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		Student student = new Student();
		Random r = new Random();
		for(int i = 0;i < 165;i++) {
			student.setName("学生" + i);
			int a = r.nextInt(4);
			if(a == 0) student.setClassName("一班");
			else if(a == 1) student.setClassName("二班");
			else if(a == 2) student.setClassName("三班");
			else if(a == 3) student.setClassName("四班");	
			int b = r.nextInt(3);
			if(b == 0) student.setGrade("高一");
			else if(b == 1) student.setGrade("高二");
			else if(b == 2) student.setGrade("高三");
			int c = r.nextInt(2);
			if(c == 0) student.setSex("男");
			else if(c == 1) student.setSex("女");
			studentService.add(student);
			}
		mav.setViewName("redirect:/student/listStudent");
		return mav;
	}
	
	@RequestMapping("editStudent")
	public ModelAndView editStudent(Student student) {
		ModelAndView mav = new ModelAndView();
		Student s = studentService.get(student.getId());
		mav.addObject("student",s);
		mav.setViewName("editStudent");
		return mav;
	}
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(Student student) {
		ModelAndView mav = new ModelAndView();
		studentService.update(student);
		mav.setViewName("redirect:/student/listStudent");
		return mav;
	}
}
