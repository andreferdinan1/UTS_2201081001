/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andre.produk.controller;
import com.andre.produk.entity.Produk;
import com.andre.produk.service.ProdukService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andreferdinan
 */
@RestController
@RequestMapping("api/v1/produk")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping
    public List<Produk> getAll() {
        return produkService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Produk getProduk(@PathVariable("id") Long id){
        return produkService.getProduk(id);
    }

    @PostMapping
    public void insertProduk(@RequestBody Produk produk) {
        produkService.insert(produk);
    }
    
    @PutMapping(path = "{id}")
    public void updateProduk(@PathVariable ("id") Long id,
            @RequestParam(required = false) String kode,
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) String satuan
                  
    ){
        produkService.update(id, kode, nama, satuan);
    }
    
    @DeleteMapping(path = "{id}")
    public void deleteProduk(@PathVariable("id") Long id) {
        produkService.deleteProduk(id);
    }

    
    
}
