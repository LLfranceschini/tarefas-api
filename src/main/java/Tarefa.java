package com.exemplo.tarefas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataEntrega;
    private String responsavel;

    // getters e setters
}
