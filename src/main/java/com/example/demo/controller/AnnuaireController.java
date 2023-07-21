package com.example.demo.controller;

import com.example.demo.business.Personne;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnuaireController {

    @GetMapping("hello")
    public String sayHello(){
        return "Coucou";
    }

    @GetMapping("personnes")
    public Personne getPersonnes(){

        Personne p = new Personne("Jean", "Rodriguez");
        return p;
    }
}
