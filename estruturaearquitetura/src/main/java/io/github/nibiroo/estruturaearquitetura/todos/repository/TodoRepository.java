package io.github.nibiroo.estruturaearquitetura.todos.repository;

import io.github.nibiroo.estruturaearquitetura.todos.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao (String descricao);
}
