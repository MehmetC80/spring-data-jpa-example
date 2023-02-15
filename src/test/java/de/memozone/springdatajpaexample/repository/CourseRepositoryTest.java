package de.memozone.springdatajpaexample.repository;

import de.memozone.springdatajpaexample.entity.Course;
import de.memozone.springdatajpaexample.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses() {

        List<Course> courseList = courseRepository.findAll();

        System.out.println("courses = " + courseList);

    }


    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher=Teacher.builder()
                .firstName("Helmut")
                .lastName("Alt")
                .emailId("alt@inf.fu-berlin.de")
                .build();

        Course course = Course.builder()
                .title("Hoehere Algorithmik")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

}