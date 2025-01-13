package com.in28minutes.rest.webservices.restfulwebservices.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListTest {

    @Test
    void simpleTest(){
        List listMock = mock(List.class);
//        listMock.size() >= 3
        when(listMock.size()).thenReturn(3);
        assertEquals(3,listMock.size());

    }

    @Test
    void multipleReturn(){
        List listMock = mock(List.class);
//        listMock.size() >= 3
        when(listMock.size()).thenReturn(1).thenReturn(2).thenReturn(3);
        assertEquals(1,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());

    }

    @Test
    void specificParameters(){
        List listMock = mock(List.class);
//        listMock.size() >= 3
        when(listMock.get(0)).thenReturn("something").thenReturn(2);
        assertEquals("something",listMock.get(0));
        assertEquals(null,listMock.get(1));
    }
    @Test
    void genericParameters(){
        List listMock = mock(List.class);
//        listMock.size() >= 3
        when(listMock.get(Mockito.anyInt())).thenReturn("someOtherString");
        assertEquals("someOtherString",listMock.get(0));
        assertEquals("someOtherString",listMock.get(1));
    }

}
