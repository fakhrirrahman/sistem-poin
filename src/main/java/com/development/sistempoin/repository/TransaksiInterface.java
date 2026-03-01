package com.development.sistempoin.repository;

import com.development.sistempoin.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiInterface extends JpaRepository<Transaksi, Long> {
}
