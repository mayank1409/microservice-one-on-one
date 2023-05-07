package io.letsrunit.studentservice.service.impl;

import io.letsrunit.studentservice.entity.Student;
import io.letsrunit.studentservice.repository.IStudentRepository;
import io.letsrunit.studentservice.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {

        Student studentByEmailAddress = studentRepository.findByEmailAddress(student.getEmailAddress());

        if (Objects.nonNull(studentByEmailAddress)) {
            throw new RuntimeException("Duplicate Email Address found " + student.getEmailAddress());
        }

        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            throw new RuntimeException("Invalid identifier " + id);
        }

        return optionalStudent.get();
    }
}
