package com.spring.springboot.restful_web_services.todo.repository;

import java.util.List;

import com.spring.springboot.restful_web_services.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	List<Todo> findByUsername(String username);

}
