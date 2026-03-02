package com.development.sistempoin.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "reward")
@Data
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_reward", nullable = false)
    private String namaReward;

    @Column(name = "poin_dibutuhkan", nullable = false)
    private Integer poinDibutuhkan;

    @Column(name = "stok", nullable = false)
    private Integer stok;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private String createdAt;


}
