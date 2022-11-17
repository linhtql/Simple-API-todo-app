package com.tql.model.converter;

import com.tql.model.entity.TodoEntity;
import com.tql.model.payload.TodoDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoConverter {

    public TodoDTO toDto(TodoEntity entity) {

        TodoDTO dto = new TodoDTO();
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setDone(entity.getDone());

        return dto;
    }

    public TodoEntity toEntity(TodoDTO dto) {

        TodoEntity entity = new TodoEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDone(dto.getDone());

        return entity;
    }

    public TodoEntity toEntity(TodoEntity entity, TodoDTO dto) {

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDone(dto.getDone());

        return entity;
    }
}
