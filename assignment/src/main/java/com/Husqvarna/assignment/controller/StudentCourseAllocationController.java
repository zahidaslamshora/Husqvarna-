package com.Husqvarna.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Husqvarna.assignment.entity.Allocate;
import com.Husqvarna.assignment.entity.Courses;
import com.Husqvarna.assignment.entity.Student;
import com.Husqvarna.assignment.service.CoursesServices;
import com.Husqvarna.assignment.service.StudentServices;
import com.Husqvarna.assignment.service.allocateCourseServices;

@RestController
@RequestMapping("allocation")
public class StudentCourseAllocationController {
	 @Autowired
	    private allocateCourseServices allocationService;
	 @Autowired
	 StudentServices studentServices;
	 @Autowired
	 CoursesServices courseServices;
	    @PostMapping("/allocate")
	  //  @Operation(summary = "This Api Allocate Student  With Selected Course save it to DB ")
	    public ResponseEntity<Allocate> allocateStudentToCourse(
	        @RequestParam int studentId,
	        @RequestParam int courseId
	    ) {
	        Student student = studentServices.getStudentById(studentId);
	        Courses course = courseServices.getCourseById(courseId);

	        if (student == null || course == null) {
	            return new ResponseEntity<>(new Allocate(), HttpStatus.NOT_FOUND);
	        }

	        Allocate allocation=allocationService.allocateStudentToCourse(student, course);
	        return new ResponseEntity<>(allocation, HttpStatus.OK);
	    }
	    
	    @PutMapping("/update-allocated-course")
	//    @Operation(summary = "This Api Update Courses for one Student ")
	    public ResponseEntity<Allocate> updateAllocatedCourse(
	        @RequestParam int studentId,
	        @RequestParam int courseId
	    ) {
	        Student student = studentServices.getStudentById(studentId);
	        Courses course = courseServices.getCourseById(courseId);

	        if (student == null || course == null) {
	            return new ResponseEntity<>(new Allocate(), HttpStatus.NOT_FOUND);
	        }

	        Allocate allocation=allocationService.allocateStudentToCourse(student, course);
	        return new ResponseEntity<>(allocation, HttpStatus.OK);
	    }
	    
	    @GetMapping("/with-courses")
	//    @Operation(summary = "This Restful service to Get all Students with selected Courses")
	    public ResponseEntity<List<String>> getAllStudentsWithSelectedCourses() {
	        List<Student> students = allocationService.getAllStudentsWithSelectedCourses();
	        ArrayList<String> studentsLst =new ArrayList<>();
	        for(Student s:students) {
	        	studentsLst.add(s.getName());	        }
	        
	        return new ResponseEntity<>(studentsLst, HttpStatus.OK);
	    }
	}
