package com.example.Perfumaria.controllers;

import com.example.Perfumaria.models.Perfume;
import com.example.Perfumaria.models.Vendedor;
import com.example.Perfumaria.services.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> buscarTodos() {
        return ResponseEntity.ok(vendedorService.buscarTodos());
    }

    @GetMapping("/loja/{lojaId}")
    public ResponseEntity<List<Vendedor>> buscarPorLoja(@PathVariable Long lojaId) {
        return ResponseEntity.ok(vendedorService.buscarPorLoja(lojaId));
    }

    @GetMapping("/{id}")
    public Vendedor buscarPorId(@PathVariable Long id) {
        return vendedorService.buscarPorId(id);
    }
    @PostMapping
    public ResponseEntity<Vendedor> criar(@RequestBody Vendedor vendedor) {
        return ResponseEntity.ok(vendedorService.salvar(vendedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> atualizar(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        vendedor.setId(id);
        Vendedor vendedorAtualizado = vendedorService.atualizar(vendedor);
        return ResponseEntity.ok(vendedorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vendedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
