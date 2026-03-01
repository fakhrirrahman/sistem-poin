package com.development.sistempoin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "pelanggan_id")
    private Pelanggan pelanggan;
    @Column(name = "total_belanja", nullable = false)
    private Integer totalBelanja;
    @Column(name = "total_poin", nullable = false)
    private Integer totalPoin;
    @Column(name = "jenis_transaksi")
    private String jenisTransaksi;
    @Column(name = "created_at", nullable = false, updatable = false)
    private String createdAt;
}
