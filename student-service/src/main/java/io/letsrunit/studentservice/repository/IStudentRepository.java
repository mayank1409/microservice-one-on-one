package io.letsrunit.studentservice.repository;

import io.letsrunit.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    Student findByEmailAddress(String emailAddress);
}
