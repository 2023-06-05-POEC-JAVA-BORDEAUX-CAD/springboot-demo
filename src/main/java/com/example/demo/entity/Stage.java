package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  titre;
    private LocalDateTime date;


    @ManyToMany
    private List<Personne> stagiaires = new ArrayList<>();


    public Stage() {
    }

    public Stage(String titre, LocalDateTime date) {
        this.titre = titre;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void addStagiaire(Personne newStagiaire){
        stagiaires.add(newStagiaire);
    }
}
