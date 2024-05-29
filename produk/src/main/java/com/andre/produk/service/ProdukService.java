/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andre.produk.service;

import com.andre.produk.entity.Produk;
import com.andre.produk.repository.ProdukRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andreferdinan
 */
@Service
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;
    
    public List<Produk>getAll(){
        return produkRepository.findAll();
    }
    
    public Produk getProduk(Long id){
        return produkRepository.findById(id).get();
    }
    
    @Transactional
    public void insert(Produk produk){
        produkRepository.save(produk);
    }
    
    @jakarta.transaction.Transactional
    public void update(Long produkId, String kode, String nama, String satuan) {
        
        Produk produk = produkRepository.findById(produkId).orElseThrow(() 
                -> new IllegalStateException("produk tidak ada"));
        if (kode != null) {
            produk.setKode(kode);
        }
        if (nama != null && nama.length() > 0 
                && !Objects.equals(produk.getNama(), nama)) {
            produk.setNama(nama);
        }
        if (satuan != null && satuan.length() > 0 
                && !Objects.equals(produk.getSatuan(), satuan)) {
            produk.setSatuan(satuan);
        }

    }
    
    public void deleteProduk(Long id) {
        produkRepository.deleteById(id);
}

}

