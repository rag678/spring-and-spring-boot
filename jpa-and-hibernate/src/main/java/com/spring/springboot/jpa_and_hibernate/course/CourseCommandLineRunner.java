package com.spring.springboot.jpa_and_hibernate.course;

import com.spring.springboot.jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.spring.springboot.jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"Learn Aws","Anurag"));
        repository.save(new Course(2,"Learn Devops","Anurag"));
        repository.save(new Course(3,"Learn Java","Anurag"));
        repository.save(new Course(4,"Learn Spring","Anurag"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(4L));
        System.out.println(repository.findAll());
        System.out.println(repository.findByAuthor("Anurag"));
    }
}
