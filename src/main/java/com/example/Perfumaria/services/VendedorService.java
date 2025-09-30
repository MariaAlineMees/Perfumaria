package com.example.Perfumaria.services;

import com.example.Perfumaria.models.Vendedor;
import com.example.Perfumaria.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public List<Vendedor> buscarTodos() {
        return vendedorRepository.findAll();
    }

    public Vendedor buscarPorId(Long id) {
        return vendedorRepository.findById(id).orElse(null);
    }
    
    public List<Vendedor> buscarPorLoja(Long lojaId) {
        return vendedorRepository.findByLojaId(lojaId);
    }

    public Vendedor salvar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
}
