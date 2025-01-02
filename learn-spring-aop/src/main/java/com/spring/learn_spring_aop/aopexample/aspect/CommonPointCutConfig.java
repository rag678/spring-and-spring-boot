package com.spring.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.spring.learn_spring_aop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig(){}

    @Pointcut("execution(* com.spring.learn_spring_aop.aopexample.business.*.*(..))")
    public void businessPackageConfig(){}

    @Pointcut("execution(* com.spring.learn_spring_aop.aopexample.data.*.*(..))")
    public void dataPackageConfig(){}


    @Pointcut("bean(*Service*)")
    public void allDataPackageConfigUsingBean(){}

    @Pointcut("@annotation(com.spring.learn_spring_aop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation(){}
}
