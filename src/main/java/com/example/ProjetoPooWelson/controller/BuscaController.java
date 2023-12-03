package com.example.ProjetoPooWelson.controller;


import com.example.ProjetoPooWelson.model.Busca;
import com.example.ProjetoPooWelson.service.BuscaService;
import com.example.ProjetoPooWelson.model.Busca;
import com.example.ProjetoPooWelson.service.BuscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/busca")
public class BuscaController {
    @Autowired
    BuscaService buscaService;

    @PostMapping()
    public ResponseEntity<Busca> salvarBusca(@RequestBody Busca busca){

        Busca response = buscaService.salvar(busca);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<Busca>> buscarTodos(){

        List<Busca> response = buscaService.buscarTodos();
        return ResponseEntity.ok(response);
    }
}
