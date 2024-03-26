package org.justintruesell.citizendash.controllers;

import org.justintruesell.citizendash.dto.TodoDTO;
import org.justintruesell.citizendash.models.Todo;
import org.justintruesell.citizendash.models.User;
import org.justintruesell.citizendash.repositories.TodoRepository;
import org.justintruesell.citizendash.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
public class MainController {

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    /**
     * __  __       _         _____            _
     * |  \/  |     (_)       |  __ \          | |
     * | \  / | __ _ _ _ __   | |  | | __ _ ___| |__
     * | |\/| |/ _` | | '_ \  | |  | |/ _` / __| '_ \
     * | |  | | (_| | | | | | | |__| | (_| \__ \ | | |
     * |_|  |_|\__,_|_|_| |_| |_____/ \__,_|___/_| |_|
     * The following code contains code to handle that of the Main Dashboard
     *
     * @param model
     * @return
     */
    @RequestMapping("/home")
    public String addCurrentLists(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        System.out.println("New Method:" + currentUserName);
        List<Todo> lists = todoServiceImpl.loadByOwner(currentUserName);
        //System.out.println(lists);
        model.addAttribute("existingLists", lists);
        log.info("home page displayed");
        return "index";
    }
    /**
     *
     ______           _
     |  ____|         | |
     | |__   _ __   __| |
     |  __| | '_ \ / _` |
     | |____| | | | (_| |
     |______|_| |_|\__,_|*/

    /**
     * _______        _         _____            _
     * |__   __|      | |       |  __ \          | |
     *    | | ___   __| | ___   | |  | | __ _ ___| |__
     *    | |/ _ \ / _` |/ _ \  | |  | |/ _` / __| '_ \
     *    | | (_) | (_| | (_) | | |__| | (_| \__ \ | | |
     *    |_|\___/ \__,_|\___/  |_____/ \__,_|___/_| |_|
     * The following section is to handle requests and posts for the ToDo Dashbaord View
     *
     * @param model
     * @return
     */

    //Show a list of todos for current user
    @RequestMapping("/showUserTodos")
    public String showTodoDashboard(Model model) {
        //create todo for updating in method outside method
        model.addAttribute("aTodo",new Todo());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        List<Todo> todos = todoServiceImpl.loadByOwner(currentUserName);
        model.addAttribute("thisUsersTodos", todos);
        return "todoDash";
    }
    @PostMapping("/saveNewTodo")
    public String saveNewTodo(@ModelAttribute("todo") Todo todo){
        //save the todo
        todoServiceImpl.save(todo);
        //redirect to see updated / added todo
        return "redirect:showUserTodos";
    }
    @GetMapping("/updateTodoOutside")
    public String updateTodoOutside(@RequestParam("todoId") Long todoId, Model model){
        //get the todo from service class
        Optional<Todo> todo = todoServiceImpl.findWithId(todoId);
        //set the correct todo that were working on so we have the data to correct and not correct
        model.addAttribute("todo",todo);
        //send the changed data
        return"addNewTodo";
    }
    @GetMapping("/addNewTodo")
    public String addNewTodo(Model model){
        Todo todo =new Todo();

        model.addAttribute("todo", todo);

        return "addNewTodo";
    }
    @GetMapping("/deleteTodoOutside")
    public String deleteTodoOutside(@RequestParam("todoId")Long id){

        todoServiceImpl.deleteById(id);
        return "redirect:showUserTodos";
    }
/**
 *
 ______           _
 |  ____|         | |
 | |__   _ __   __| |
 |  __| | '_ \ / _` |
 | |____| | | | (_| |
 |______|_| |_|\__,_|*/

}