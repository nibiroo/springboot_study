package io.github.nibiroo.estruturaearquitetura.todos.controller;

import io.github.nibiroo.estruturaearquitetura.todos.entity.TodoEntity;
import io.github.nibiroo.estruturaearquitetura.todos.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity saveTodo (@RequestBody TodoEntity todoEntity) {
        return todoService.salvar(todoEntity);
    }
}
