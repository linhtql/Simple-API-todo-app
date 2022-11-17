package com.tql.service.impl;

import com.tql.exception.ResourceNotFoundException;
import com.tql.model.converter.TodoConverter;
import com.tql.model.payload.TodoDTO;
import com.tql.model.entity.TodoEntity;
import com.tql.repository.TodoRepository;
import com.tql.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoConverter converter;


    @Override
    public List<TodoDTO> getAll() {
        List<TodoEntity> todoEntities = todoRepository.findAll();
        List<TodoDTO> response = new ArrayList<>();

        for(TodoEntity entity : todoEntities) {
            response.add(converter.toDto(entity));
        }
        return response;
    }

    @Override
    public TodoDTO getById(Long id) {
        TodoEntity entity = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));
        return converter.toDto(entity);
    }

    @Override
    public TodoDTO save(TodoDTO todoDTO) {

        TodoEntity todoEntity;

        if(todoDTO.getId() == null) {
            // create
            todoEntity = converter.toEntity(todoDTO);
        } else {
            // update
            TodoEntity oldTodo = todoRepository.findById(todoDTO.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", todoDTO.getId()));
            todoEntity = converter.toEntity(oldTodo, todoDTO);
        }

        TodoEntity newTodo = todoRepository.save(todoEntity);
        TodoDTO response = converter.toDto(newTodo);

        return response;
    }

    @Override
    public void deleteById(Long id) {

        TodoEntity todoRemove = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));

        todoRepository.delete(todoRemove);
    }
}
