package com.example.ProjetoPooWelson.service;

import com.example.ProjetoPooWelson.model.Busca;
import com.example.ProjetoPooWelson.repository.BuscaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaService {
    @Autowired
    BuscaRepository buscaRepository;

    public Busca salvar(Busca busca) {
        return buscaRepository.save(busca);
    }

    public List<Busca> buscarTodos() {
        return buscaRepository.findAll();
    }
}