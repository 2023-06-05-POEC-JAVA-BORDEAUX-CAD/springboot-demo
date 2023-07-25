package com.example.demo.dao;

import com.example.demo.business.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository
        extends JpaRepository<Personne, Integer> {

        public List<Personne> findAllByPrenom(String prenom);
}
