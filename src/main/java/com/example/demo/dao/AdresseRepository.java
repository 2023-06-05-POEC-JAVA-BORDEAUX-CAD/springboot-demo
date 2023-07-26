package com.example.demo.dao;

import com.example.demo.entity.Adresse;
import com.example.demo.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepository
        extends JpaRepository<Adresse, Integer> {

}
