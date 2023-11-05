package com.Husqvarna.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Husqvarna.assignment.entity.Allocate;
@Repository
public interface StudentCourseAllocationRepository extends JpaRepository<Allocate, Integer>{

}
