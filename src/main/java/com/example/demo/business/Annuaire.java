package com.example.demo.business;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class Annuaire {

    private int nextId = 0;

    private List<Personne> personnes = new ArrayList<>();

    public void addPersonne(Personne personne){
        nextId++;
        personne.setId(nextId);
        personnes.add(personne);
    }

    public List<Personne> getPersonnes(){
        return personnes;
    }

    public void deletePersonne(int id){

        /*
        for(Personne personne : personnes){
            if(personne.getId() == id){
                personnes.remove(personne);
                //break;
                //return;
            }
        }
        */


        int index = 0;
        while (index < personnes.size() && personnes.get(index).getId() != id){
            index++;
        }
        if(index < personnes.size()){
            personnes.remove(index);
        }
    }


    public Personne getPersonne(Integer id){
        for (Personne personne : personnes){
            if(id.equals(personne.getId())){
                return personne;
            }
        }
        return null;
    }

    public void editPersonne(Integer id, Personne personne) {
        int index = 0;
        while (index < personnes.size()){
            if(id.equals(personnes.get(index).getId())){
                personnes.set(index, personne);
            }
            index++;
        }
    }
}
