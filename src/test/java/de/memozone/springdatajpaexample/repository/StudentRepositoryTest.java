package de.memozone.springdatajpaexample.repository;

import de.memozone.springdatajpaexample.entity.Guardian;
import de.memozone.springdatajpaexample.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder().emailId("memo@web.de")
                .firstName("mehmet")
                .lastName("memoli")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianDetails() {

        Guardian guardian = Guardian.builder()
                .email("esponda@gmail.com")
                .name("Esponda Gabriella")
                .mobile("0176241723")
                .build();

        Student student = Student.builder()
                .firstName("Mehmet")
                .lastName("memoli")
                .emailId("memo2@web.de")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }


    @Test
    public void getAllStudent() {

        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList = " + studentList);
    }


    @Test
    public void printStudentByFirstName() {

        List<Student> students = studentRepository.findByFirstName("Mehmet");
        System.out.println("students = " + students);

    }

    @Test
    public void printStudentByFirstNameContainingString() {

        List<Student> students = studentRepository.findByFirstNameContaining("ehmet");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnLastNameNotNull() {

        List<Student> students=studentRepository.findByLastNameNotNull();
        System.out.println("students =" +students);

    }

    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students=studentRepository.findByGuardianName("Esponda");
        System.out.println("students = "+students);
    }


    @Test
    public void printGetStudentByEmailAddress(){

        Student student= studentRepository.getStudentByEmailAddress("memo@web.de");
        System.out.println("student = "+ student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName=studentRepository.getStudentFirstNameByEmailAddress("memo@web.de");
        System.out.println("student = "+ firstName);

    }


}