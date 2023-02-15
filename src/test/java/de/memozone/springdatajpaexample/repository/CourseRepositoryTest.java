package de.memozone.springdatajpaexample.repository;

import de.memozone.springdatajpaexample.entity.Course;
import de.memozone.springdatajpaexample.entity.CourseMaterial;
import de.memozone.springdatajpaexample.entity.Student;
import de.memozone.springdatajpaexample.entity.Teacher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;


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

        Teacher teacher = Teacher.builder()
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

    @Test
    public void findAllPagination() {

        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);

        List<Course> courses =
                courseRepository
                        .findAll(firstPageWithThreeRecords)
                        .getContent();
        long totalElements = courseRepository
                .findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository
                .findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("courses = " + courses);
    }


    @Test
    public void findAllSorting() {

        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));


        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());


        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0, 2, Sort
                        .by("title")
                        .descending()
                        .and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);

    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository
                .findByTitleContaining("Rechner", firstPageTenRecords)
                .getContent();

        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Klaus")
                .lastName("Kriegel")
                .emailId("kriegel@inf.fu-berlin.de")
                .build();

        Student student = Student.builder()
                .firstName("Abuzer")
                .lastName("Firat")
                .emailId("firat@web.de")
                .build();


        Course course = Course.builder()
                .title("Mathe für Informatiker")
                .credit(8)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }


}