package com.example.crud.subject;


import com.example.crud.student.Student;
import com.example.crud.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subject")
public class SubjectController {


    private final SubjectService subjectService;
    private final StudentService studentService;
    @Autowired
    public SubjectController(SubjectService subjectService, StudentService studentService) {
        this.subjectService = subjectService;
        this.studentService = studentService;
    }


    @GetMapping()
    public List<Subject> getSubjects(){
        return subjectService.getSubjects();
    }

    @PostMapping
    public void registerNewSubject(@RequestBody Subject subject) {
        subjectService.addNewSubject(subject);
        System.out.println(subject);
    }
    @PutMapping(path= "/{subjectId}/student/{studentId}")
    Subject enrolledStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ){
        Subject subject = subjectService.getSubject(subjectId);
        Student student = studentService.getStudent(studentId);
        subject.enrollStudent(student);

        return subjectService.update(subject);


    }









}
