package com.development.sistempoin.dto;

import lombok.Data;

@Data
public class TransaksiRequest {
    private Long pelangganId;
    private Double totalBelanja;
    private Integer poinDidapat;
    private String jenisTransaksi;
}