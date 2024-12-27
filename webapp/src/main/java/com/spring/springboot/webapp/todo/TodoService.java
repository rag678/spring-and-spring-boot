package com.spring.springboot.webapp.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1,"anurag","learn Aws", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2,"deepak","Desops Aws", LocalDate.now().plusYears(4),false));
        todos.add(new Todo(3,"Rohan","Spring", LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }
}
