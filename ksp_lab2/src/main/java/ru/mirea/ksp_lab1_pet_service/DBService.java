package ru.mirea.ksp_lab1_pet_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    DBService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    void init(){
        // init db инициализация базы данных
        //если создалась то не создавать заново
        jdbcTemplate.execute("CREATE TABLE Item(id int,String name, String type, int count)");
        //наполняем базу тоже тут
    }
}
