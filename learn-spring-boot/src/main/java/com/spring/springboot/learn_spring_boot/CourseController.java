package com.spring.springboot.learn_spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retriveAllCourses(){
        return Arrays.asList(
                new Course(1L,"Learn Aws","Anurag"),
                new Course(2L,"Learn Devops","Anurag"),
                new Course(3L,"Learn New","Anurag"),
                new Course(4L,"Learn New","Anurag")
        );
    }
}
