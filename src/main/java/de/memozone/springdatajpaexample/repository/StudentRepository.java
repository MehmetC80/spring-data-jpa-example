package de.memozone.springdatajpaexample.repository;

import de.memozone.springdatajpaexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastNme);

    //JPQL Query Based on the class that means all based on Student.class
    @Query(" select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL Query
    @Query(" select s.firstName from Student s where s.emailId= ?1")
    String getStudentFirstNameByEmailAddress(String emailId);


}
