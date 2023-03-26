package com.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.controller.dao.StudentRepository;
import com.web.controller.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping("/")
	public String run() {
		System.out.println("OK");
		return "home.jsp";
	}
	
	@PostMapping(path="/student/add", consumes= {"application/json"})
	public Student addStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	
////	for only showing data in xml format
//	@RequestMapping(path="/students", produces={"application/xml"})
	@GetMapping("/students")
	@ResponseBody
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
		
	}
	
	@GetMapping("/student/{sid}")
	@ResponseBody
	public Optional<Student> getStudentById(@PathVariable("sid") int sid) {
		
		System.out.println(sid);
//		
//		ModelAndView mv = new ModelAndView("view.jsp");
//		
//		Student student = studentRepository.findById(sid).orElse(new Student());
//		
//		mv.addObject(student);
//		
//		System.out.println(student);
//		
//		return mv;
		
//		System.out.println(studentRepository.findByTech(tech));
//
//		System.out.println(studentRepository.findBySidGreaterThan(1));
//		
//		System.out.println(studentRepository.findByTechSorted("React"));
		
		return studentRepository.findById(sid);
	}
	
	@DeleteMapping("/student/{sid}")
	public String deleteStudent(@PathVariable("sid") int sid) {
		Student student = studentRepository.getReferenceById(sid);
		
		studentRepository.delete(student);
		
		return "Data is deleted";
	}
	
	@PutMapping(path="/student/update", consumes= {"application/json"})
	public Student saveOrUpdateStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	
}