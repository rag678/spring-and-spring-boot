package com.spring.framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1: Launch a Spring Context
        var applicationContext =
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // 2: Configure the things that we want to manage
        //BY HelloWorldConfiguration Class - @Configuration
        // name - @Bean
        System.out.println(applicationContext.getBean("name"));
        System.out.println(applicationContext.getBean("age"));
        System.out.println(applicationContext.getBean("person"));
        System.out.println(applicationContext.getBean("person2MethodCall")); // creating Bean with other Bean
        System.out.println(applicationContext.getBean("person3Parameters"));
        System.out.println(applicationContext.getBean("person5Qualifier"));
        System.out.println(applicationContext.getBean("address2"));
        System.out.println(applicationContext.getBean(Address.class));      // handle by making bean private
//        for (String definitionName : applicationContext.getBeanDefinitionNames()) {
//            System.out.println(definitionName);
//        }


        // used to list all beans manage by spring
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        //if multiple beans match that exception  throw
    }
}
