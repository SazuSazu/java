package com.example.toDoList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoListDAO {
    private final JdbcTemplate jdbcTemplate;

    public ToDoListDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ToDoListModel> findAll() {
        String sql = "SELECT * FROM ToDoList";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ToDoListModel toDoListModel = new ToDoListModel();
            toDoListModel.setTaskName(rs.getString(1));
            toDoListModel.setTaskDesc(rs.getString(2));
            toDoListModel.setStatus(rs.getString(3));
            return toDoListModel;
        });
    }

}
