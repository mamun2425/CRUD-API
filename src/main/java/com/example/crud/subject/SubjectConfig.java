package com.example.crud.subject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.FEBRUARY;

@Configuration
public class SubjectConfig {

    @Bean
    CommandLineRunner runner(SubjectRepository repository){
        return args -> {
            Subject bangla = new Subject(
                    1L,
                    "Bangla"

            );
            Subject english = new Subject(
                    2L,
                    "English"

            );
            Subject math = new Subject(
                    3L,
                    "Math"

            );


            repository.saveAll(
                    List.of(bangla, english, math)
            );


        } ;

    }
}



