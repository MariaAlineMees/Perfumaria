package com.example.Perfumaria.repository;

import com.example.Perfumaria.models.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    List<Perfume> findByMarcaId(Long Id);
}
