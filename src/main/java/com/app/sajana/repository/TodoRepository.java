package com.app.sajana.repository;

import com.app.sajana.dto.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodoRepository extends MongoRepository<Todo, Integer> {
    public Todo findByTodoId (Integer id);
}
