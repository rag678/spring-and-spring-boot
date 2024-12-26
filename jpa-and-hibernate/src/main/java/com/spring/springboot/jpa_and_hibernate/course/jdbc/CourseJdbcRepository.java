package com.spring.springboot.jpa_and_hibernate.course.jdbc;

import com.spring.springboot.jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate ;

    private static String INSERT_QUERY =
            """
                   Insert into Course(id,name,author)
                    values (?,?,?)
                  """;

    private static String DELETE_QUERY =
            """
                 DELETE FROM Course Where id = ?
            """;

    private static String SELECT_QUERY =
            """
                 SELECT * FROM Course Where id = ?
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course selectById(long id){
        // map resultSet to Bean => Row Mapper
        return  springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
    }
}
