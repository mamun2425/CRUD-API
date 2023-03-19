package com.example.crud.subject;

import com.example.crud.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "subjects")
public class Subject {


    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinTable(
            name = "enrolled_Student",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")

    )
    private Set<Student> enrolledStudents= new HashSet<>();


    private String name;


    public Subject(String name) {
        this.name = name;
    }

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
}
