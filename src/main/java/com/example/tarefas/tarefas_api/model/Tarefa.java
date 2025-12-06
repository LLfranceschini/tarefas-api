package com.example.tarefas.tarefas_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataEntrega;

    private String responsavel;

    public Tarefa() {}

    // id
    @JsonIgnore
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // nome
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // dataEntrega
    public LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }

    // responsavel
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}
