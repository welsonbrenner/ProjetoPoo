package com.example.ProjetoPooWelson.service;

import com.example.ProjetoPooWelson.model.Cidade;
import com.example.ProjetoPooWelson.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade) {
        cidade.setAtivo(true);
        return cidadeRepository.save(cidade);
    }

    public List<Cidade> buscarTodos() {
        List<Cidade> cidades = cidadeRepository.findAll();
        return cidades.stream().filter(Cidade::getAtivo).collect(Collectors.toList());
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return cidadeRepository.findById(id);
    }

    public Cidade atualizar(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public List<Cidade> buscarPorNome(String nome) {
        return cidadeRepository.findByNomeAndAtivo(nome, true);
    }

    public ResponseEntity<?> deleteById(Long id) {
        Optional<Cidade> response = buscarPorId(id);

        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        response.get().setAtivo(false);

        return ResponseEntity.ok(cidadeRepository.save(response.get()));
    }
}
