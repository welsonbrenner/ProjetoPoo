package com.example.ProjetoPooWelson.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Busca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    Cidade cidade;
}
