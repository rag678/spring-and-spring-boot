package com.spring.framework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
    ;
}
@Component
@Lazy
class ClassB{
    private ClassA classA;
    public ClassB(ClassA classA){
        // Business Logic
        System.out.println("something Inialize");
        this.classA = classA;
    }
    public boolean doSomething(){
        System.out.println("Lazy Initialization completed");
        return false;
    }
}

@Configuration
@ComponentScan
public class LazyInitialixationLauncherApplication {
    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext(LazyInitialixationLauncherApplication.class)){
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("Initialization of Context Completed");
            System.out.println(context.getBean(ClassB.class).doSomething());

        }

    }
}
