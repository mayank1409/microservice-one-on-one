package io.letsrunit.studentservice.controller;

import io.letsrunit.studentservice.entity.Student;
import io.letsrunit.studentservice.feignclient.Address;
import io.letsrunit.studentservice.resilisency.CommonService;
import io.letsrunit.studentservice.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/students")
public class StudentController {

    private final IStudentService studentService;
    private final CommonService commonService;

    public StudentController(IStudentService studentService, CommonService commonService) {
        this.studentService = studentService;
        this.commonService = commonService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        ResponseEntity<Student> studentResponseEntity = new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
        return studentResponseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Student studentById = studentService.getStudentById(id);
        Address addressByStudentId = commonService.getAddressByStudentId(id);
        studentById.setAddress(addressByStudentId);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

}
