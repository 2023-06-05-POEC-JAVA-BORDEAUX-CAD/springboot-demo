package com.example.demo.controller;

import com.example.demo.business.Personne;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnnuaireController {

    @GetMapping("hello")
    public String sayHello(){
        return "Coucou";
    }

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){

        Personne p = new Personne("Jean", "Rodriguez");
        Personne p2 = new Personne("Marie", "Dupont");

        List<Personne> personnes = new ArrayList<>();
        personnes.add(p);
        personnes.add(p2);

        return personnes;
    }
}
