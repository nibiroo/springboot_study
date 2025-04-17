package io.github.nibiroo.estruturaearquitetura.todos.validation;

import io.github.nibiroo.estruturaearquitetura.todos.entity.TodoEntity;
import io.github.nibiroo.estruturaearquitetura.todos.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void validar (TodoEntity todoEntity) {
        if (existeTodoComDescricao(todoEntity.getDescricao())) {
            throw new IllegalArgumentException("Já existe um TODO com esta descrição!");
        }
    }

    private boolean existeTodoComDescricao (String descricao) {
        return todoRepository.existsByDescricao(descricao);
    }
}
