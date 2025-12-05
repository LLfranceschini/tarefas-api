package com.example.tarefas.tarefas_api.controller;

import com.example.tarefas.tarefas_api.model.Tarefa;
import com.example.tarefas.tarefas_api.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repo;

    public TarefaController(TarefaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa t) {
        Tarefa salvo = repo.save(t);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa t) {
        return repo.findById(id).map(existing -> {
            existing.setNome(t.getNome());
            existing.setDataEntrega(t.getDataEntrega());
            existing.setResponsavel(t.getResponsavel());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return repo.findById(id).map(r -> {
            repo.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
