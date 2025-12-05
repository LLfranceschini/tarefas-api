package com.example.tarefas.tarefas_api.repository;

import com.example.tarefas.tarefas_api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}

