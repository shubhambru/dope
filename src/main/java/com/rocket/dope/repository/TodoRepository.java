package com.rocket.dope.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rocket.dope.model.TodoDTO;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO , String> {

    
}
