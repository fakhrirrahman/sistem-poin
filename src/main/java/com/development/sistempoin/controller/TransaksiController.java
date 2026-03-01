package com.development.sistempoin.controller;

import com.development.sistempoin.dto.ApiResponse;
import com.development.sistempoin.entity.Pelanggan;
import com.development.sistempoin.entity.Transaksi;
import com.development.sistempoin.service.TransaksiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    public final TransaksiService transaksiService;

    public TransaksiController(TransaksiService transaksiService){
        this.transaksiService = transaksiService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Transaksi>>> get() {
        List<Transaksi> data = transaksiService.get();
        return ResponseEntity.ok(new ApiResponse<>(200, "Data transaksi berhasil diambil", data));
    }


}
