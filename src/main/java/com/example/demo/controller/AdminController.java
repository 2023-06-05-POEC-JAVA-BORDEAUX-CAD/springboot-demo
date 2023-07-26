package com.example.demo.controller;

import com.example.demo.business.Annuaire;
import com.example.demo.entity.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    Annuaire annuaire;

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){
        return annuaire.getPersonnes();
    }
}
