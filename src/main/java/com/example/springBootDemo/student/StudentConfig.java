package com.example.springBootDemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.MARCH;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student aurinelle = new Student(
                    "aurinelle",
                    "Aurinelle@yahoo.co.uk",
                    LocalDate.of(1988, MARCH, 18));

            Student lesley = new Student(
                    "lesley",
                    "lesley@yahoo.co.uk",
                    LocalDate.of(1985, MARCH, 19));

            studentRepository.saveAll(List.of(aurinelle, lesley));
        };
    }


}
