package com.example.demo.dao;

import com.example.demo.entity.Personne;
import com.example.demo.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository
        extends JpaRepository<Stage, Integer> {

}
