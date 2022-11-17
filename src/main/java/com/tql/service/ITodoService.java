package com.tql.service;

import com.tql.model.payload.TodoDTO;

import java.util.List;

public interface ITodoService {
    List<TodoDTO> getAll();
    TodoDTO getById(Long id);
    TodoDTO save(TodoDTO todoDTO);
    void deleteById(Long id);
}
