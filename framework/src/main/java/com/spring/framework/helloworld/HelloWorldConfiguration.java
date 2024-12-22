package com.spring.framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminating verbosity in creating Java Beans
// public accessor Method , constructor
// hashCode,toString created explicitly
// In record , introduce in JDK 16

record Person (String name,Integer age,Address address){ }
record Address (String firstLine,String city){ }

// Configure the Changes that we want spring to manage
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Anurag";
    }
    @Bean
    public Integer age(){
        return 15;
    }
    @Bean
    public Person person(){
        return new Person("Deepak",12,new Address("old Road","Bengaluru"));
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(),address());
    }

    @Bean
    public Person person3Parameters(String name,int age,Address address3){          // name,age,address
        return new Person(name,age,address3);
    }
    @Bean
    public Person person4Parameters(String name,int age,Address address){          // name,age,address
        return new Person(name,age,address);
    }

    @Bean
    public Person person5Qualifier(String name,int age,@Qualifier("address4Qualifier") Address address){          // name,age,address
        return new Person(name,age,address);
    }

    @Bean(name = "address2")        // Bean name
    @Primary                        // manage when more bean by same name
    public Address address(){
        return new Address("new rd","Delhi");
    }

    @Bean(name = "address4")        // Bean name
    @Qualifier("address4Qualifier")                        // manage when more bean by same name
    public Address address4(){
        return new Address("new oldd","Delhi");
    }

    @Bean(name = "address3")        // Bean name
    public Address address3(){
        return new Address("new ","Hyderabad");
    }
//     @Bean
//    public Address address2(){
//        return new Address("street road","Mumbai");
//    }
}
