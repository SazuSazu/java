package com.example.toDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoListController {

    private final ToDoListDAO dao;

    public ToDoListController(ToDoListDAO repository) {
        this.dao = repository;
    }

    @GetMapping
    public ResponseEntity<List<ToDoListModel>> getAllToDoList() {
            List<ToDoListModel> todos = dao.findAll();
            return ResponseEntity.ok(todos);
    }


    //Add new
    @PostMapping
    public ResponseEntity<ToDoListModel> addToDo(@RequestBody ToDoListModel toDoListModel) {

        ToDoListModel createToDoList = dao.createToDoList(toDoListModel);

        if(createToDoList != null){
            return ResponseEntity.status(201).body(createToDoList);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    //Update Status based on ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestParam String status) {
        return null;
    }

    //Delete data based on ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Integer id) {
        return null;
    }

}
