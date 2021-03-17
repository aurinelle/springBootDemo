package com.example.springBootDemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.MARCH;

@Configuration
public class StudentConfig{

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student aurinelle = new Student(
                    1L,
                    "aurinelle",
                    "Aurinelle@yahoo.co.uk",
                    LocalDate.of(1988, MARCH, 18),
                    32);

            Student lesley = new Student(
                    "lesley",
                    "lesley@yahoo.co.uk",
                    LocalDate.of(1985, MARCH, 19),
                    32);

            repository.saveAll(List.of(aurinelle));
        };
    }
}