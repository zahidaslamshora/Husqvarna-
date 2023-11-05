package com.Husqvarna.assignment;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Husqvarna.assignment.dao.CoursesRepository;
import com.Husqvarna.assignment.entity.Courses;
import com.Husqvarna.assignment.service.CoursesServices;

@SpringBootTest
public class CoursesServiceTest {

    @Autowired
    private CoursesServices coursesService;

    @MockBean
    private CoursesRepository coursesRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testCreateCourse() {
        Courses courseToSave = new Courses();
        courseToSave.setCourseName("Sample Course");
        courseToSave.setCourseId(1);

        Mockito.when(coursesRepository.save(courseToSave)).thenReturn(courseToSave);

        Courses createdCourse = coursesService.createCourse(courseToSave);

        assertEquals("Sample Course", createdCourse.getCourseName());
        assertEquals(1, createdCourse.getCourseId());
    }
}