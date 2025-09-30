package com.example.Perfumaria.services;

import com.example.Perfumaria.models.Loja;
import com.example.Perfumaria.repository.LojaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LojaService {
    private final LojaRepository lojaRepository;

    public LojaService(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public List<Loja> buscarTodas() {
        return lojaRepository.findAll();
    }

    public Loja salvar(Loja loja) {
        return lojaRepository.save(loja);
    }
    
    public Loja buscarPorId(Long id) {
        return lojaRepository.findById(id).orElse(null);
    }
}
