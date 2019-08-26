package com.zph.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zph.pojo.Dormitory;
import com.zph.pojo.DormitoryBuilding;
import com.zph.pojo.Student;
import com.zph.service.DormitoryBuildingService;
import com.zph.service.DormitoryService;
import com.zph.service.StudentService;
import com.zph.util.Page;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	DormitoryService dormitoryService;
	
	@Autowired
	DormitoryBuildingService dormitoryBuildingService;
	
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
			if(session.getAttribute("map") != null)
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
		HashMap<String, Object> m = new HashMap<>();
		m.put("students", students);
		m.put("map", map);
		mav.addAllObjects(m);
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
	
//	@RequestMapping("test")
//	public ModelAndView test() {
//		ModelAndView mav = new ModelAndView();
//		Student student = new Student();
//		Random r = new Random();
//		for(int i = 0;i < 165;i++) {
//			student.setName("学生" + i);
//			int a = r.nextInt(4);
//			if(a == 0) student.setClassName("一班");
//			else if(a == 1) student.setClassName("二班");
//			else if(a == 2) student.setClassName("三班");
//			else if(a == 3) student.setClassName("四班");	
//			int b = r.nextInt(3);
//			if(b == 0) student.setGrade("高一");
//			else if(b == 1) student.setGrade("高二");
//			else if(b == 2) student.setGrade("高三");
//			int c = r.nextInt(2);
//			if(c == 0) student.setSex("男");
//			else if(c == 1) student.setSex("女");
//			studentService.add(student);
//			}
//		mav.setViewName("redirect:/student/listStudent");
//		return mav;
//	}
	
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
	
	@RequestMapping("addDormitoryForStudent")
	public ModelAndView addDormitoryForStudent(int id,int doid,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Student student = studentService.get(id);
		student.setDoid(doid);
		studentService.update(student);
		mav.setViewName("redirect:/updateDormitorySurplusBed?id=" + doid);
		session.setAttribute("flag", 0);
		return mav;
	}
	
	@RequestMapping("listStudentInDormitory")
	public ModelAndView listStudentInDormitory(int doid) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = studentService.listByDoid(doid);
		mav.addObject("students",students);
		mav.setViewName("listStudentByDoid");
		return mav;
	}
	
	@RequestMapping("updateDormitoryForStudent")
	public ModelAndView updateDormitoryForStudent(int id,int doid,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Student student = studentService.get(id);
		Dormitory dormitory1 = dormitoryService.getById(student.getDoid());
		if(dormitory1.getSurplusBed() == 0) {
			dormitory1.setSurplusBed(1);
			dormitoryService.update(dormitory1);
			DormitoryBuilding dormitoryBuilding = dormitoryBuildingService.get(dormitory1.getBid());
			dormitoryBuilding.setSurplusRoom(dormitoryBuilding.getSurplusRoom() + 1);
			dormitoryBuildingService.update(dormitoryBuilding);
		}else {
			dormitory1.setSurplusBed(dormitory1.getSurplusBed() + 1);
			dormitoryService.update(dormitory1);
		}
		student.setDoid(doid);
		Dormitory dormitory2 = dormitoryService.getById(doid);
		dormitory2.setSurplusBed(dormitory2.getSurplusBed() - 1);
		dormitoryService.update(dormitory2);
		if(dormitory2.getSurplusBed() == 0) {
			DormitoryBuilding dormitoryBuilding = dormitoryBuildingService.get(dormitory1.getBid());
			dormitoryBuilding.setSurplusRoom(dormitoryBuilding.getSurplusRoom() - 1);
			dormitoryBuildingService.update(dormitoryBuilding);
		}
		studentService.update(student);
		mav.setViewName("redirect:listStudent");
		session.invalidate();
		return mav;
	}
	
	@RequestMapping("changeDormitoryForStudent")
	public ModelAndView changeDormitoryForStudent(int id,int sid,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Student student1 = studentService.get(id);
		Student student2 = studentService.get(sid);
		Integer doid = student1.getDoid();
		student1.setDoid(student2.getDoid());
		student2.setDoid(doid);
		studentService.update(student1);
		studentService.update(student2);
		mav.setViewName("redirect:listStudent");
		session.invalidate();
		return mav;
	}
	
}
