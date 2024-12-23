package com.spring.framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;


// Business Class
@Component
class YourBusinessClass{                // Field Based Dependency Injection
    Dependency1 dependency1;
    Dependency2 dependency2;

    // Constructor Based Dependency Injection
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    // Setter Dependency Injection
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Inject Dependency 1");
//        this.dependency1 = dependency1;
//    }
//
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }

    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}
// Dependency Injection 1
@Component
class Dependency1{

}
// Dependency Injection 2
@Component
class Dependency2{

}

@Configuration
@ComponentScan("package com.spring.framework.examples.a1")
public class DepInjectionLauncherApplication {
    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class).toString());
        }

    }
}
