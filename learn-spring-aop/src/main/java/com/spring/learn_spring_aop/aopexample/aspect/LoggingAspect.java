package com.spring.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //Pointcut - When ?
    //execution(* PACKAGE.*.*(..))
    //execution(* com.spring.learn_spring_aop.aopexample.business.*.*(..))
    @Before("com.spring.learn_spring_aop.aopexample.aspect.CommonPointCutConfig.allDataPackageConfigUsingBean()")
    public void LogMethodCallBeforeExecution(JoinPoint joinPoint){
        // Logic - what ?
        logger.info("Before Aspect -{} is called with argument : {} ",joinPoint,joinPoint.getArgs());
    }

    @After("com.spring.learn_spring_aop.aopexample.aspect.CommonPointCutConfig.businessPackageConfig()")
    public void LogMethodCallAfterExecution(JoinPoint joinPoint){
        // Logic - what ?
        logger.info("After Aspect -{} has Executed",joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.spring.learn_spring_aop.aopexample.aspect.CommonPointCutConfig.businessAndDataPackageConfig()",
            throwing = "execption"
    )
    public void LogMethodCallAfterExeption(JoinPoint joinPoint,Exception execption){
        logger.info("AfterThrowing Aspect -{} has thrown an exception : {}",joinPoint,execption);
    }


    @AfterReturning(
            pointcut = "com.spring.learn_spring_aop.aopexample.aspect.CommonPointCutConfig.dataPackageConfig()",
            returning = "resultValue"
    )
    public void LogMethodCallAfterSuccesfullExecution(JoinPoint joinPoint,Object resultValue){
        logger.info("AfterReturning Aspect -{} has returned : {}",joinPoint,resultValue);
    }
}
