package com.example.demo.business;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.entity.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Annuaire {

    @Autowired
    PersonneRepository personneRepository;

    private int nextId = 0;

    private List<Personne> personnes = new ArrayList<>();

    public void addPersonne(Personne personne){
        nextId++;
        personne.setId(nextId);
        personnes.add(personne);
    }

    public List<Personne> getPersonnes(){

        return personneRepository.findAll();
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


    public Optional<Personne> getPersonne(Integer id){
        for (Personne personne : personnes){
            if(id.equals(personne.getId())){
                return Optional.of(personne);
            }
        }
        return Optional.empty();
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
