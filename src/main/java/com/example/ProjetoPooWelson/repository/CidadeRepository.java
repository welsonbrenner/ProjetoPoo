package com.example.ProjetoPooWelson.repository;

import com.example.ProjetoPooWelson.model.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByNomeAndAtivo(String nome, Boolean status);
    public Page<Cidade> findAll(Pageable pageable);
}

