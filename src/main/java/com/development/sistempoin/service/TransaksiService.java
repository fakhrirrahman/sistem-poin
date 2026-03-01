package com.development.sistempoin.service;

import com.development.sistempoin.entity.Pelanggan;
import com.development.sistempoin.entity.Transaksi;
import com.development.sistempoin.repository.TransaksiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaksiService {
    private final TransaksiRepository transaksiRepository;

    public TransaksiService(TransaksiRepository transaksiRepository) {
        this.transaksiRepository = transaksiRepository;
    }

    public List<Transaksi> get() {
        return transaksiRepository.findAll();
    }

    public void create(Transaksi transaksi) {
        transaksiRepository.save(transaksi);
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
