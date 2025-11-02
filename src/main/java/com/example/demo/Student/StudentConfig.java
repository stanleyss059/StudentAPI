package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository ) {
        return args -> {
            Student mariam = new Student(
                    "Mariam Jamal",
                    "mariam.jamal@gmail.com",
                     LocalDate.of(2000, Month.JANUARY, 5)
            );
            Student stanleySam = new Student(
                    "Stanley Sam",
                    "stanleysam059@gmail.com",
                     LocalDate.of(2004, Month.AUGUST, 25)
            );
            repository.saveAll(
                    List.of(mariam, stanleySam)
            );
        };
        }
    };

