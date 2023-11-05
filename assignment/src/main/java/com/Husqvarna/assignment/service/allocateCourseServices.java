package com.Husqvarna.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Husqvarna.assignment.dao.StudentCourseAllocationRepository;
import com.Husqvarna.assignment.dao.StudentRepository;
import com.Husqvarna.assignment.entity.Allocate;
import com.Husqvarna.assignment.entity.Courses;
import com.Husqvarna.assignment.entity.Student;
import com.Husqvarna.assignment.exception.StudentsNotFoundException;

@Service
public class allocateCourseServices {
	
	 @Autowired
	    private StudentCourseAllocationRepository allocationRepository;
	 @Autowired
		private StudentRepository studentsRepo;

	    public Allocate allocateStudentToCourse(Student student, Courses course) {
	        Allocate allocation = new Allocate();
	        allocation.setStudent(student);
	        allocation.setCourse(course);
	        return allocationRepository.save(allocation);
	    }
	    
	    public List<Student> getAllStudentsWithSelectedCourses() {
	    	 try {
	             List<Student> students = new ArrayList<>();
	             Student student;
	             List<Allocate> allocateList = allocationRepository.findAll();

	             for (Allocate allocate : allocateList) {
	                 student = allocate.getStudent();
	                 students.add(student);
	             }

	             if (students.isEmpty()) {
	                 throw new StudentsNotFoundException("No students with selected courses found.");
	             }

	             return students;
	         } catch (Exception e) {
	      
	             throw new StudentsNotFoundException("An error occurred while fetching students with selected courses.");
	         }
	     }
	  
}
