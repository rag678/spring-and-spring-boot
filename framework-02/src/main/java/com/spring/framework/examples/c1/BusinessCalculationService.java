package com.spring.framework.examples.c1;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    private DataService dataService;

    public BusinessCalculationService(DataService dataService){
        this.dataService = dataService;
    }
    public int findMax(){
        return Arrays.stream(dataService.retrievData()).max().orElse(0);
    }
}
