package com.rocket.dope.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class TodoDTO {
    
    @Id
    private String id;

    private String description;

    private boolean isCompleted;
    
    private Date createdAt;

    TodoDTO(){
        this.isCompleted = false;
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsCompleted(){
        return isCompleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
