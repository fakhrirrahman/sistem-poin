package com.development.sistempoin.controller;

import com.development.sistempoin.dto.ApiResponse;
import com.development.sistempoin.dto.TransaksiRequest;
import com.development.sistempoin.entity.Pelanggan;
import com.development.sistempoin.entity.Transaksi;
import com.development.sistempoin.service.TransaksiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ApiResponse<Transaksi>> create(@RequestBody TransaksiRequest request) {
        Transaksi data = transaksiService.create(request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Transaksi berhasil dibuat", data));
    }
}
