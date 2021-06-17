package com.app.sajana;

import com.app.sajana.dto.Todo;
import com.app.sajana.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.BooleanSupplier;

@SpringBootTest
class SajanaApplicationTests {

    @Autowired
    TodoRepository repository;


    @Test
    public void creatTodoTest() throws ParseException {
        Todo todo = new Todo();
        todo.setTodoId(10);
        todo.setTitle("test title");
        todo.setDescription("test descrip");
        todo.setActiveStatus(0);
        todo.setCreateDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2015"));
        todo.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2016"));
        repository.save(todo);
        Assertions.assertNotNull(repository.findByTodoId(10));
    }

    @Test
    public void testTodo() {
        Todo todo = repository.findByTodoId(10);
        Assertions.assertEquals("test title", todo.getTitle());
    }

    @Test
    public void changeTodo() {
        Todo todo = repository.findByTodoId(10);
        todo.setActiveStatus(1);
        repository.save(todo);
        Assertions.assertNotEquals(0, repository.findByTodoId(10).getActiveStatus());
    }

    @Test
    public void delete(){
        repository.deleteById(10);
        Assertions.assertTrue((BooleanSupplier) repository.findByTodoId(10));
    }

}


