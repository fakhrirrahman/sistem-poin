package com.development.sistempoin.service;

import com.development.sistempoin.dto.TransaksiRequest;
import com.development.sistempoin.entity.Pelanggan;
import com.development.sistempoin.entity.Transaksi;
import com.development.sistempoin.repository.PelangganRepository;
import com.development.sistempoin.repository.TransaksiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    private final TransaksiRepository transaksiRepository;
    private final PelangganRepository pelangganRepository;

    public TransaksiService(TransaksiRepository transaksiRepository, PelangganRepository pelangganRepository, PelangganRepository pelangganRepository1) {
        this.transaksiRepository = transaksiRepository;
        this.pelangganRepository = pelangganRepository1;
    }

    public List<Transaksi> get() {
        return transaksiRepository.findAll();
    }

    public Transaksi create(TransaksiRequest request) {
        Pelanggan pelanggan = pelangganRepository.findById(request.getPelangganId())
                .orElseThrow(() -> new RuntimeException("Pelanggan tidak ditemukan"));
        Transaksi transaksi = new Transaksi();
        transaksi.setPelanggan(pelanggan);
        transaksi.setTotalBelanja(request.getTotalBelanja());
        transaksi.setPoinDidapat(request.getPoinDidapat());
        transaksi.setJenisTransaksi(request.getJenisTransaksi());
        return transaksiRepository.save(transaksi);
    }

    public void update(Long id, Transaksi transaksi) {
        Transaksi existingTransaksi = transaksiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaksi tidak ditemukan"));
        existingTransaksi.setPelanggan(transaksi.getPelanggan());
        existingTransaksi.setTotalBelanja(transaksi.getTotalBelanja());
        existingTransaksi.setPoinDidapat(transaksi.getPoinDidapat());
        existingTransaksi.setJenisTransaksi(transaksi.getJenisTransaksi());
        transaksiRepository.save(existingTransaksi);
    }

    public void delete(Long id) {
        Transaksi existingTransaksi = transaksiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaksi tidak ditemukan"));
        transaksiRepository.delete(existingTransaksi);
    }
}
