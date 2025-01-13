package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.business.DataService;
import com.in28minutes.rest.webservices.restfulwebservices.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImpleStubTest {

    @Test
    void findTheGreatestFromAllData_basic(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(25,result);
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25,15,5};
    }
}
