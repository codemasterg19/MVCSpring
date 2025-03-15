package com.proyecto.nucleo1_app.controllers;

import com.proyecto.nucleo1_app.models.Torneo;
import com.proyecto.nucleo1_app.services.CategoryService;
import com.proyecto.nucleo1_app.services.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.Collectors;

@Controller
public class TorneoController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    TorneoService torneoService;

    @GetMapping("/addTorneo")
    public String getFormTorneo(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("torneo", new Torneo());
        return "torneo/add-torneo";

    }

    @PostMapping("/addTorneo")
    public String addTorneo(@ModelAttribute Torneo torneo){
        torneoService.saveTorneo(torneo);
            return "redirect:/";
            }

    @GetMapping("/")
    public String home(Model model, Authentication authentication){
        String role=authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(","));
        model.addAttribute("role", role);
        model.addAttribute("torneos", torneoService.getallTorneos());
        return "torneo/home";
     }

    @GetMapping("/torneo/edit/{id}")
    public String getFormEditTorneo(@PathVariable Long id, Model model){
        Torneo torneo = torneoService.getTorneoById(id).orElseThrow();
        model.addAttribute("torneo", torneo);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "torneo/add-torneo";
    }

    @PostMapping("/torneo/edit/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute Torneo torneo){
        torneo.setId(id);
        torneoService.saveTorneo(torneo);
        return "redirect:/";
    }

    @PostMapping("/torneo/delete/{id}")
    public String deleteTorneo(@PathVariable Long id){
        torneoService.deleteTorneo(id);
        return "redirect:/";
    }
}
