package org.justintruesell.citizendash.controllers;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.justintruesell.citizendash.dto.UserDTO;
import org.justintruesell.citizendash.models.User;
import org.justintruesell.citizendash.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
@Controller
@Slf4j
public class UserController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    private UserServiceImpl userDetailsService;

    @Autowired
    public UserController(UserServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //when user taps root, it will send them to the login page
    @GetMapping("/")
    private String redirectToLogin()
    {
        return "redirect:/login";
    }


    @GetMapping("/sign-up")
    public String signUp(Model model)
    {
        model.addAttribute("userDto", new UserDTO());
        return "sign-up";
    }

    @PostMapping("/signup-process")
    public String signupProcess(@Valid @ModelAttribute ("userDto") UserDTO userDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            log.warn("Wrong attempt");
            return "sign-up";
        }
        userDetailsService.creat(userDTO);
        return "confirmation";
    }

    /**
     * In order to make code more readable  it is good practice to
     * use special DTOs for login It also makes controllers
     * less dependent from entities and separate validation from
     * jpa functionality
     */
    @GetMapping("/login")
    public String getLoginPage()
    {
        log.info("Login page displayed");
        return "login";
    }
    @RequestMapping("/logout")
    public String getLogoutPage(){
        log.info("Logout page displayed");
        return "logout";
    }
    @RequestMapping("/viewAdminPage")
    public String getAdminPage(Model model){

        model.addAttribute("allUsers", userDetailsService.getAllUsers());
        model.addAttribute("user", new User());
        log.info("Admin page displayed");
        return "/adminPage";
    }
    /**
                 _           _         _____
        /\      | |         (_)       |  __ \
       /  \   __| |_ __ ___  _ _ __   | |__) |_ _  __ _  ___
      / /\ \ / _` | '_ ` _ \| | '_ \  |  ___/ _` |/ _` |/ _ \
     / ____ \ (_| | | | | | | | | | | | |  | (_| | (_| |  __/
    /_/    \_\__,_|_| |_| |_|_|_| |_| |_|   \__,_|\__, |\___|
                                                  __/ |
                                                  |___/
 */
    @PostMapping("/addNewUser")
    public String addNewUser(@ModelAttribute("user")User user){
        userDetailsService.saveUser(user);
        return "redirect:/viewAdminPage";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("userId") Long id){
        //remove selected employee
        userDetailsService.deleteUserById(id);
        return "redirect:/viewAdminPage";
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
    @RequestMapping("/home")
    public String getHome()
    {
        log.info("home page displayed");
        return "index";
    } */

}