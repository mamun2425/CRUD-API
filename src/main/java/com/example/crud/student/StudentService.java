package com.example.crud.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional= studentRepository.
                findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken. student is already in list");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("Students with ID:" + studentId + " does not exists");
        }
        else studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student= studentRepository.
                findById(studentId).orElseThrow(() -> new
                        IllegalStateException("Students with ID:" + studentId + " does not exists"));


        if(name!=null && name.length()>0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email !=null && email.length()>0 && !Objects.equals(student.getEmail(), email )){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email is taken");

            }
            student.setEmail(email);
        }



    }

    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).get();
    }
}

