package com.example.ProjetoPooWelson.controller;

import com.example.ProjetoPooWelson.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ProjetoPooWelson.repository.CidadeRepository;
import com.example.ProjetoPooWelson.service.CidadeService;

import java.util.List;
import java.util.Optional;

// CidadeController
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/pageable/all")
    public Page<Cidade> getCidade(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return cidadeRepository.findAll(pageRequest);
    }

    @PostMapping()
    public ResponseEntity<Cidade> salvarCidade(@RequestBody Cidade cidade) {
        Cidade response = cidadeService.salvar(cidade);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<Cidade>> buscarTodos() {
        List<Cidade> response = cidadeService.buscarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Long id) {
        Optional<Cidade> response = cidadeService.buscarPorId(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<Cidade>> buscarPorNome(@PathVariable String nome) {
        List<Cidade> response = cidadeService.buscarPorNome(nome);
        if (response != null && !response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping()
    public ResponseEntity<Cidade> update(@RequestBody Cidade cidade) {
        if (!cidadeService.buscarPorId(cidade.getId()).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cidadeService.atualizar(cidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return cidadeService.deleteById(id);
    }
}

