package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.business.DataService;
import com.in28minutes.rest.webservices.restfulwebservices.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SomeBusinessImpleMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void findTheGreatestFromAllData_basic(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,15,5});
        assertEquals(25, someBusiness.findTheGreatestFromAllData());
    }
    @Test
    void findTheGreatestFromAllData_oneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});

        assertEquals(35, someBusiness.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_Empty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        assertEquals(Integer.MIN_VALUE, someBusiness.findTheGreatestFromAllData());
    }
}

class DataServiceStub1 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25,15,5};
    }
}
