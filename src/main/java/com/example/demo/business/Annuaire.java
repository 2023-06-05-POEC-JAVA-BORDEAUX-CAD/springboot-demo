package com.example.demo.business;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Annuaire {

    private List<Personne> personnes = new ArrayList<>();

    public void addPersonne(Personne personne){
        personnes.add(personne);
    }

    public List<Personne> getPersonnes(){
        return personnes;
    }
}
