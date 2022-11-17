package com.tql.controller;

import com.tql.model.payload.ResponseObject;
import com.tql.model.payload.TodoDTO;
import com.tql.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @GetMapping("/todos")
    public List<TodoDTO> getAllTodo() {

        List<TodoDTO> response = todoService.getAll();

        return response;
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable(name = "id") Long id) {

        TodoDTO response = todoService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query todo successfully!", response));
    }

    @PostMapping("/todo")
    public ResponseEntity<ResponseObject> create(@RequestBody TodoDTO todoDTO) {

        TodoDTO response = todoService.save(todoDTO);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "create todo successfully!", response));
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable(name = "id") Long id, @RequestBody TodoDTO todoDTO) {

        todoDTO.setId(id);
        TodoDTO response = todoService.save(todoDTO);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update todo successfully!", response));
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable(name = "id") Long id) {

        todoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "delete todo successfully!", ""));
    }
}
