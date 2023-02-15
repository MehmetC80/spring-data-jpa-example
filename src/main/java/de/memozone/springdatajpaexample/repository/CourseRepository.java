package de.memozone.springdatajpaexample.repository;

import de.memozone.springdatajpaexample.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
