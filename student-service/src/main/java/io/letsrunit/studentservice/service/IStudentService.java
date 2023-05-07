package io.letsrunit.studentservice.service;

import io.letsrunit.studentservice.entity.Student;

public interface IStudentService {

    Student saveStudent(Student student);

    Student getStudentById(long id);
}
