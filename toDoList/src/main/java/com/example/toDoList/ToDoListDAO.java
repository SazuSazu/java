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

    ////// NO ID IS RETURNED

    public ToDoListModel createToDoList(ToDoListModel model) {

        String sql = "INSERT INTO ToDoList (task_name, task_desc, status) VALUES (?, ?, ?)";
    
        int rowsAffected = jdbcTemplate.update(sql, model.getTaskName(), model.getTaskDesc(), model.getStatus());
    
        if (rowsAffected > 0) {
            return model;
        } else {
            return null;
        }
    }

    //////////// IF NEED TO RETURN THE ID AFTER BEING CREATED (POST)//////////////

    // public ToDoListModel createToDoList(ToDoListModel model){

    //     String sql = "INSERT INTO ToDoList (task_name, task_desc, status) VALUES (?, ?, ?)";

    //     KeyHolder keyHolder = new GeneratedKeyHolder();
    
    //     int rowsAffected = jdbcTemplate.update(connection -> {
    //         PreparedStatement ps = connection.prepareStatement(sql, new String[]{"no"});
    //         ps.setString(1, model.getTaskName());
    //         ps.setString(2, model.getTaskDesc());
    //         ps.setString(3, model.getStatus());
    //         return ps;
    //     }, keyHolder);

    //     if (rowsAffected > 0) {
    //         // Retrieve the generated 'no' and set it in the model
    //         model.setNo(keyHolder.getKey().intValue());
    //         return model;
    //     } else {
    //         return null;
    //     }

    // }

}
