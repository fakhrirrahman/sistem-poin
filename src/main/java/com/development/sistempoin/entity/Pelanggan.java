package com.development.sistempoin.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "pelanggan")
@Data
public class Pelanggan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nama;
    @Column(name = "nomor_hp", nullable = false, unique = true)
    private String nomorHp;
    @Column(name = "total_poin", nullable = false, updatable = false)
    private Integer totalPoin;
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private String createdAt;

    public void setTotalPoin(Integer totalPoin) {
        if (this.totalPoin == null) {
            this.totalPoin = 0;
        }
        this.totalPoin += totalPoin;
    }
}
