package com.example.demo.controller;

import com.example.demo.business.Annuaire;
import com.example.demo.business.Personne;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class AnnuaireController {

    @Autowired
    Annuaire annuaire;

    @GetMapping("hello")
    public String sayHello(){
        return "Coucou";
    }

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){
/*
        Personne p = new Personne("Jean", "Rodriguez");
        Personne p2 = new Personne("Marie", "Dupont");

        List<Personne> personnes = new ArrayList<>();
        personnes.add(p);
        personnes.add(p2);

        return personnes;*/

        return annuaire.getPersonnes();
    }


    @PostMapping("personnes")
    public void postPersonne(@RequestBody Personne newPersonne){
        System.out.println(newPersonne);

        annuaire.addPersonne(newPersonne);
    }

    @DeleteMapping("personnes/{id}")
    public void deletePersonne(@PathVariable("id") Integer id){
            annuaire.deletePersonne(id);
    }


    @GetMapping("personnes/{id}")
    public Personne getPersonne(@PathVariable("id") Integer id){
        return annuaire.getPersonne(id);
    }

    @PutMapping("personnes/{id}")
    public void putPersonne(@PathVariable("id") Integer id, @RequestBody Personne personne){
        annuaire.editPersonne(id, personne);
    }

}
