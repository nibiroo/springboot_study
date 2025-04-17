package io.github.nibiroo.estruturaearquitetura.todos.controller;

import io.github.nibiroo.estruturaearquitetura.todos.entity.TodoEntity;
import io.github.nibiroo.estruturaearquitetura.todos.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity saveTodo (@RequestBody TodoEntity todoEntity) {
        try {
            return todoService.salvar(todoEntity);
        } catch (IllegalArgumentException e) {
            var mensagemErro = e.getMessage();

            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }
    }
}
