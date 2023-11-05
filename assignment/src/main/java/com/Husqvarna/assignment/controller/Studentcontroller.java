package com.Husqvarna.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Husqvarna.assignment.entity.Student;
import com.Husqvarna.assignment.service.StudentServices;

@RestController
@RequestMapping(value="student")
public class Studentcontroller {
	
	@Autowired
	private StudentServices studentService;
	
	@PostMapping("/register-student")
	//@Operation(summary = "This Api Registers Student to the website providing his details")
	public Student addStudent(@RequestBody Student Student) {
		return studentService.createStudent(Student);
	}
	
	@GetMapping("/get-Student")
	//@Operation(summary = "This Api provides details of all the students")
	public List<Student> getStudent() {
		return studentService.findAllstudents();
	}
	
	@DeleteMapping("/delete-student/{name}")
	//@Operation(summary = "This Api deletes one Student using name")
	public String deleteStudent(@PathVariable("name") String name) {
		return studentService.deleteStudentbyName(name);
	}
	

}
