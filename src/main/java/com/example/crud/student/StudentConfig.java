package com.example.crud.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mamun = new Student(
                    "Mamun",
                    "mamun@gmail.com",
                    LocalDate.of(1999, FEBRUARY, 2)

            );
            Student sadnan = new Student(
                            "Sadnan",
                            "sadnan@gmail.com",
                            LocalDate.of(1999, FEBRUARY, 3)

            );
            Student zulkar = new Student(
                            "Zulkar",
                            "zulkar@gmail.com",
                            LocalDate.of(1999, FEBRUARY, 4)

            );
            repository.saveAll(
                    List.of(mamun, sadnan, zulkar)
            );


        } ;

    }

}





