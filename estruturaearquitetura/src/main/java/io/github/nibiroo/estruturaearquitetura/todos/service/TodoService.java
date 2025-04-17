package io.github.nibiroo.estruturaearquitetura.todos.service;

import io.github.nibiroo.estruturaearquitetura.todos.MailSender;
import io.github.nibiroo.estruturaearquitetura.todos.entity.TodoEntity;
import io.github.nibiroo.estruturaearquitetura.todos.repository.TodoRepository;
import io.github.nibiroo.estruturaearquitetura.todos.validation.TodoValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    private TodoValidator todoValidator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator todoValidator, MailSender mailSender) {
        this.todoRepository = todoRepository;
        this.todoValidator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar (TodoEntity novoTodo) {
        todoValidator.validar(novoTodo);
        return todoRepository.save(novoTodo);
    }

    @PutMapping("{id}")
    public void atualizarStatus (@PathVariable("id") Integer id, @RequestBody TodoEntity todoEntity) {
        todoEntity.setId(id);

        todoRepository.save(todoEntity);
        String status = todoEntity.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        mailSender.enviar("Todo " + todoEntity.getDescricao() + "foi atualizado para " + status);
    }

    @GetMapping("{id}")
    public Optional<TodoEntity> buscarPorId (@PathVariable Integer id) {
        return todoRepository.findById(id);
    }
}
