package org.justintruesell.citizendash.services;

import org.justintruesell.citizendash.models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface TodoService {
    public List<Todo> loadByOwner(String email);

    public Todo findByTitle(String title);

}
