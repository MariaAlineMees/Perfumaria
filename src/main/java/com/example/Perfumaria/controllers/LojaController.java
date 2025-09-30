package com.example.Perfumaria.controllers;

import com.example.Perfumaria.models.Loja;
import com.example.Perfumaria.services.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {
    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @GetMapping
    public ResponseEntity<List<Loja>> buscarTodas() {
        return ResponseEntity.ok(lojaService.buscarTodas());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Loja> buscarPorId(@PathVariable Long id) {
        Loja loja = lojaService.buscarPorId(id);
        return loja != null ? ResponseEntity.ok(loja) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Loja> criar(@RequestBody Loja loja) {
        return ResponseEntity.ok(lojaService.salvar(loja));
    }
}
