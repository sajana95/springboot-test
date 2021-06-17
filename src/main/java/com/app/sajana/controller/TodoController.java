package com.app.sajana.controller;


import com.app.sajana.dto.Todo;
import com.app.sajana.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<Todo> addNewRecord(@RequestBody Todo todo) throws ParseException {
        Todo addedRecord = todoService.add(todo);
        return ResponseEntity.ok(addedRecord);
    }

    @PutMapping("/todoDone")
    public ResponseEntity<Todo> updateRecord(@RequestBody Todo todo) {
        Todo updateRecord = todoService.update(todo);
        return ResponseEntity.ok(updateRecord);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteById(@RequestParam int id) {
        todoService.deleteById(id);
        return ResponseEntity.ok("Record deleted successfully");
    }

    @GetMapping("/todoList")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.getTodos());
    }

}
