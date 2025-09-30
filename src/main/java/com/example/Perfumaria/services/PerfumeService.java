package com.example.Perfumaria.services;

import com.example.Perfumaria.models.Perfume;
import com.example.Perfumaria.repository.PerfumeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;

    public PerfumeService(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    public List<Perfume> buscarTodos() {
        return perfumeRepository.findAll();
    }

    public Perfume criar(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public List<Perfume> buscarPorMarca(Long Id) {
        return perfumeRepository.findByMarcaId(Id);
    }

    public Perfume atualizar(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public void deletar(Long id) {
        perfumeRepository.deleteById(id);
    }
}
