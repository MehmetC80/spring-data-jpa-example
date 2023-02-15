package de.memozone.springdatajpaexample.repository;

import de.memozone.springdatajpaexample.entity.Course;
import de.memozone.springdatajpaexample.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course01 = Course.builder()
                .title("Rechnerstruckturen")
                .credit(6)
                .build();

        Course course02 = Course.builder()
                .title("Rechnerarchitektur")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Jochen")
                .lastName("Schiller")
                .emailId("schiller@gmail.com")
               // .courses(List.of(course01, course02))
                .build();

        teacherRepository.save(teacher);
    }


}