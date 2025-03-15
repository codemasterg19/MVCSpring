package com.proyecto.nucleo1_app.controllers;

import com.proyecto.nucleo1_app.models.User;
import com.proyecto.nucleo1_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/register")
    public String getFormRegister(Model model, Authentication authentication) {
        if(authentication!= null && authentication.isAuthenticated()) {
            return "redirect:/";
        }
        model.addAttribute("user", new User());
        return "auth/register";
    }


    @PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute User user) {
        try {
            this.service.save(user);
            return new RedirectView("/login");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new RedirectView("register?duplicate");
        }
    }
}
