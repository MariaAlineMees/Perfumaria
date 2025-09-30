package com.example.Perfumaria.services;

import com.example.Perfumaria.models.Marca;
import com.example.Perfumaria.repository.MarcaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    public Marca criar(Marca marca){
        return marcaRepository.save(marca);
    }
}
