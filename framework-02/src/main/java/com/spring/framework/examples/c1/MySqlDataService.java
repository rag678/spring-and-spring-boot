package com.spring.framework.examples.c1;

import org.springframework.stereotype.Component;

@Component
public class MySqlDataService implements DataService{
    @Override
    public int[] retrievData() {
        return new int[]{11,12,13,14,15,16,17};
    }
}
