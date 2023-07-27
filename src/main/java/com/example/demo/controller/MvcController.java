package com.example.demo.controller;

import com.example.demo.business.Annuaire;
import com.example.demo.entity.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MvcController {

    @Autowired
    Annuaire annuaire;

    @GetMapping("hello")
    public String sayHello(@RequestParam String nom, Model model){

        model.addAttribute("nom", nom);
        model.addAttribute("age", 19);
        System.out.println(nom);

        List<Personne> personnes = annuaire.getPersonnes();
        model.addAttribute("personnes", personnes);

        return "hello.html";
    }

    @PostMapping("personnes")
    public String createPersonne(Personne newPersonne, Model model){
        System.out.println(newPersonne);

        annuaire.addPersonne(newPersonne);


        model.addAttribute("nom", "Toto");
        model.addAttribute("age", 19);


        List<Personne> personnes = annuaire.getPersonnes();
        model.addAttribute("personnes", personnes);
        return "hello";
    }
}
