package com.app.sajana.service;


import com.app.sajana.dto.Todo;
import com.app.sajana.exception.InvalidDataException;
import com.app.sajana.exception.RecordNotFoundException;
import com.app.sajana.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;


@Service
public class TodoService {
    @Autowired
    TodoRepository repository;

    public Todo add(Todo record) throws ParseException {
        if (record.getTitle() == null || record.getTitle().trim().isEmpty()) {
            throw new InvalidDataException("Title not found");
        }
        record.setCreateDate(new SimpleDateFormat("dd/MM/yyyy").parse(record.getCreateDate().toString()));
        record.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(record.getEndDate().toString()));

        return repository.insert(record);
    }

    /*   status  done = 1, pending = 0 */
    public Todo update(Todo todo) {
        Todo object = repository.findByTodoId(todo.getTodoId());
        if (object == null) {
            throw new RecordNotFoundException(object.getTodoId());
        } else if (todo.getActiveStatus() == 0) {
            throw new InvalidDataException("invalid todo status" + todo.getActiveStatus());
        }
        return repository.save(todo);
    }


    public Todo deleteById(int id) {
        Todo delete = repository.findByTodoId(id);
        if (delete == null) {
            throw new RecordNotFoundException(id);
        }
        repository.deleteById(id);
        return delete;
    }


    public List<Todo> getTodos() {
        return repository.findAll();
    }
}
