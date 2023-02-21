package com.rocket.dope.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rocket.dope.model.TodoDTO;
import com.rocket.dope.repository.TodoRepository;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository repository;

    public ResponseEntity<?> getAllTodos(){
        try {
            return new ResponseEntity<List<TodoDTO>>(repository.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error fetching data",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    public ResponseEntity<?> createTodo(TodoDTO todoDTO){
        if(todoDTO==null){
            return new ResponseEntity<String>("No body in request",HttpStatus.BAD_REQUEST);
        }
        try {
            repository.save(todoDTO);
            return new ResponseEntity<TodoDTO>(todoDTO,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteTodo(String todoId){
        try {
            if(repository.existsById(todoId)){
                repository.deleteById(todoId);
                return new ResponseEntity<String>(todoId,HttpStatus.OK);
            }
            return new ResponseEntity<String>("No todo exists for this id",HttpStatus.BAD_REQUEST);
            
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateTodo(TodoDTO todoDTO) {
        try {
            if(todoDTO==null){
                return new ResponseEntity<String>("No body in request",HttpStatus.BAD_REQUEST);
            }
            if(repository.existsById(todoDTO.getId())){
                TodoDTO todo = repository.findById(todoDTO.getId()).get();
                todo.setDescription(todoDTO.getDescription());
                todo.setCompleted(todoDTO.getIsCompleted());
                repository.save(todo);
                return new ResponseEntity<String>("Updated",HttpStatus.OK);
            }
            return new ResponseEntity<String>("No todo exists for this id",HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
        }
    }
}
