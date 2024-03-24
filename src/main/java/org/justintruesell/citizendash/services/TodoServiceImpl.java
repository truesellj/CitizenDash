package org.justintruesell.citizendash.services;


import jakarta.persistence.Basic;
import lombok.extern.slf4j.Slf4j;
import org.justintruesell.citizendash.models.Todo;
import org.justintruesell.citizendash.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

//    public ArrayList<Todo> loadUserTodos(String email){
//        ArrayList<Todo> todos = todoRepo.findTodosByEmail(email);
//        return todos;
//    }
    //gets full list of todoLists stored in database by current LOGGEDIN user
    public List<Todo> loadByOwner(String email){
        List<Todo> currentTodos = todoRepository.findByOwner(email);
        System.out.println(currentTodos);
        return currentTodos;
    };

    @Transactional
    public Todo findByTitle(String title){return todoRepository.findByTitle(title);}
    public Todo save(Todo todo){return todoRepository.save(todo);}
}
