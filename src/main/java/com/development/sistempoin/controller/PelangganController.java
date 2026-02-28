package com.development.sistempoin.controller;

import com.development.sistempoin.dto.ApiResponse;
import com.development.sistempoin.entity.Pelanggan;
import com.development.sistempoin.service.PelangganService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pelanggan")
public class PelangganController {
    private final PelangganService pelangganService;

    public PelangganController(PelangganService pelangganService) {
        this.pelangganService = pelangganService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Pelanggan>>> get() {
        List<Pelanggan> data = pelangganService.get();
        return ResponseEntity.ok(new ApiResponse<>(200, "Data pelanggan berhasil diambil", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Pelanggan>> create(@RequestBody Pelanggan pelanggan) {
        Pelanggan data = pelangganService.create(pelanggan);
        return ResponseEntity.ok(new ApiResponse<>(200, "Pelanggan berhasil dibuat", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Pelanggan>> update(@PathVariable Long id, @RequestBody Pelanggan pelanggan) {
        Pelanggan data = pelangganService.update(id, pelanggan);
        return ResponseEntity.ok(new ApiResponse<>(200, "Pelanggan berhasil diupdate", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Pelanggan>> delete(@PathVariable Long id) {
        Pelanggan data = pelangganService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Pelanggan berhasil dihapus", data));
    }

}
