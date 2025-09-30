package com.example.Perfumaria.controllers;

import com.example.Perfumaria.models.Marca;
import com.example.Perfumaria.models.Perfume;
import com.example.Perfumaria.services.MarcaService;
import com.example.Perfumaria.services.PerfumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfumes")
public class PerfumeController {
    private final PerfumeService perfumeService;

    public PerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }


    @GetMapping
    public ResponseEntity<List<Perfume>> buscarTodas() {
        return ResponseEntity.ok(perfumeService.buscarTodos());
    }

    @GetMapping("/marca/{Id}")
    public ResponseEntity<List<Perfume>> buscarPorMarca(@PathVariable Long Id) {
        return ResponseEntity.ok(perfumeService.buscarPorMarca(Id));
    }

    @PostMapping
    public ResponseEntity<Perfume> criar(@RequestBody Perfume perfume) {
        return ResponseEntity.ok(perfumeService.criar(perfume));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfume> atualizar(@PathVariable Long id, @RequestBody Perfume perfume) {
        perfume.setId(id);
        Perfume perfumeAtualizado = perfumeService.atualizar(perfume);
        return ResponseEntity.ok(perfumeAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        perfumeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


