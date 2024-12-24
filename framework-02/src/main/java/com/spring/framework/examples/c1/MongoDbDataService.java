package com.spring.framework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MongoDbDataService implements DataService{
    @Override
    public int[] retrievData() {
        return new int[]{1,2,3,4,5,6,7};
    }
}
