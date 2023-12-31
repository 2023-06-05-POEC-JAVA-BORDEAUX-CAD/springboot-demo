package com.example.demo.controller;

import com.example.demo.business.Annuaire;
import com.example.demo.entity.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Personne> getPersonne(@PathVariable("id") Integer id){
        Optional<Personne> optional = annuaire.getPersonne(id);

        if(optional.isPresent()){
            Personne personne = optional.get();
            return ResponseEntity.ok(personne);
        }
        else {//if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("personnes/{id}")
    public ResponseEntity putPersonne(@PathVariable("id") Integer id, @RequestBody Personne personne){

        if(!id.equals(personne.getId())){
            return ResponseEntity.badRequest().build();
        }

        if(annuaire.getPersonne(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        annuaire.editPersonne(id, personne);
        return ResponseEntity.ok().build();
    }

}
