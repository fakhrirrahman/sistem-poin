package com.development.sistempoin.repository;

import com.development.sistempoin.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
    Optional<Pelanggan> findByNomorHp(String nomorHp);
}
