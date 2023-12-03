package com.example.ProjetoPooWelson.repository;

import com.example.ProjetoPooWelson.model.Busca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuscaRepository extends JpaRepository<Busca, Long> {

}