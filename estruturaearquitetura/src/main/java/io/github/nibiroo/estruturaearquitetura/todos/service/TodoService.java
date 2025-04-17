package io.github.nibiroo.estruturaearquitetura.todos.service;

import io.github.nibiroo.estruturaearquitetura.todos.entity.TodoEntity;
import io.github.nibiroo.estruturaearquitetura.todos.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoEntity salvar (TodoEntity novoTodo) {
        return todoRepository.save(novoTodo);
    }

    @PutMapping("{id}")
    public void atualizarStatus (@PathVariable("id") Integer id, @RequestBody TodoEntity todoEntity) {
        todoEntity.setId(id);

        todoRepository.save(todoEntity);
    }

    @GetMapping("{id}")
    public Optional<TodoEntity> buscarPorId (@PathVariable Integer id) {
        return todoRepository.findById(id);
    }
}
