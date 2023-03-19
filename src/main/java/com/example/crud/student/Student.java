package com.example.crud.student;

import com.example.crud.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name  = "students")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )


    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"

    )

    private Long id;



    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")


    private Set<Subject> subjects = new HashSet<>();



    @Column(name = "Student_Name")
    private String name;
    @Column(name = "Age")
    @Transient
    private Integer age;
    @Column(name = "Email" )
    private String email;

    @Column(name = "DateOfBirth")
    private LocalDate dob;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   String email) {
        this.name = name;

        this.email = email;
    }

    public Student(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }







//    Getter & setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id + "\r\n" +
                ", name='" + name + '\'' + "\r\n" +
                ", age=" + age + "\r\n" +
                ", email='" + email + '\'' + "\r\n" +
                ", dob=" + dob + "\r\n" +
                '}';
    }
}