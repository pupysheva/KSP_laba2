package ru.mirea.ksp_lab1_pet_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ItemDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> getAll() {
        return (List<Item>) jdbcTemplate.query("select * from item", new Extractor());

    }
}

class Extractor implements ResultSetExtractor<Item>{

    @Override
    public Item extractData(ResultSet rs) throws SQLException, DataAccessException {
        return new Item(rs.getInt("id"), rs.getString("name"), rs.getString("type"),rs.getInt("count"));
    }
}
