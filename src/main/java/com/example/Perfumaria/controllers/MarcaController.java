package com.example.Perfumaria.controllers;


import com.example.Perfumaria.models.Marca;
import com.example.Perfumaria.services.MarcaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> buscarTodas() {
        return ResponseEntity.ok(marcaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Marca> criar(@RequestBody Marca marca) {
        return ResponseEntity.ok(marcaService.criar(marca));
    }
}
