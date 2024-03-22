package org.justintruesell.citizendash.controllers;

import org.justintruesell.citizendash.models.Todo;
import org.justintruesell.citizendash.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private TodoServiceImpl todoServiceImpl;
    @RequestMapping("/home")
    public String addCurrentLists(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        System.out.println("New Method:" + currentUserName);
        List<Todo> lists = todoServiceImpl.loadByOwner(currentUserName);
        System.out.println(lists);
        model.addAttribute("existingLists",lists);
        log.info("home page displayed");
        return "index";
    }
}
