package com.Husqvarna.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Husqvarna.assignment.entity.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<com.Husqvarna.assignment.entity.Courses, Integer> {
@Modifying
@Query("delete from Courses c where c.courseName=?1")
void deleteUserByName(String courseName);

public List<Courses> findByCourseName(String courseName);
	
}
