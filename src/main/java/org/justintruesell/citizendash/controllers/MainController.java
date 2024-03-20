package org.justintruesell.citizendash.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/index")
    public String addCurrentLists(Model model){
        String[] lists = new String[] {"shopping", "Organize Party", "Job Search"};
        model.addAttribute("existingLists",lists);
        return "index";
    }
}
