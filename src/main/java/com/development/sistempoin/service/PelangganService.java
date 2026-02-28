package com.development.sistempoin.service;

import com.development.sistempoin.entity.Pelanggan;
import com.development.sistempoin.repository.PelangganRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PelangganService {
    private  final PelangganRepository pelangganRepository;

    public PelangganService(PelangganRepository pelangganRepository) {
        this.pelangganRepository = pelangganRepository;
     }

     public List<Pelanggan> get() {
        return pelangganRepository.findAll();
     }
     public Pelanggan create(Pelanggan pelanggan){
        return pelangganRepository.save(pelanggan);
     }

     public Pelanggan update(Long id, Pelanggan pelanggan){
        Pelanggan existingPelanggan = pelangganRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelanggan tidak ditemukan"));
        existingPelanggan.setNama(pelanggan.getNama());
        existingPelanggan.setNomorHp(pelanggan.getNomorHp());
        return pelangganRepository.save(existingPelanggan);
     }

     public Pelanggan delete(Long id){
        Pelanggan existingPelanggan = pelangganRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelanggan tidak ditemukan"));
        pelangganRepository.delete(existingPelanggan);
        return existingPelanggan;
     }

}
