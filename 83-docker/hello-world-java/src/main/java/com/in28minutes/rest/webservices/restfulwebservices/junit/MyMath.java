package com.in28minutes.rest.webservices.restfulwebservices.junit;

public class MyMath {

    public int caluculateSum(int[] numbers){
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }
}
