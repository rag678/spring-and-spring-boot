package com.spring.framework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("dependency injection completed");
    }

    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Clean Up completed");
    }
}

@Component
class SomeDependency{

    public void getReady() {
        System.out.println("some logic using some Dependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }
}
