package com.spring.learn_spring_aop.aopexample.data;

import com.spring.learn_spring_aop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {
    @TrackTime
    public int[] retrieveData(){
        return new int[]{132,223,321,233,111};
    }
}
