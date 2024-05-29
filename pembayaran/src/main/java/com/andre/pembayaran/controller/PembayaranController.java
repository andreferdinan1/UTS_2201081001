/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andre.pembayaran.controller;

import com.andre.pembayaran.entity.Pembayaran;
import com.andre.pembayaran.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.andre.pembayaran.vo.ResponseTemplate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author andreferdinan
 */
@RestController
@RequestMapping("api/v1/pembayaran")
public class PembayaranController {
    @Autowired
    private PembayaranService pembayaranService;
    
   @GetMapping
    public List<Pembayaran> getAll() {
        return pembayaranService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Pembayaran getPembayaran(@PathVariable("id") Long id){
        return pembayaranService.getPembayaran(id);
    }

    @PostMapping
    public void insertPembayaran(@RequestBody Pembayaran pembayaran) {
        pembayaranService.insert(pembayaran);
    } 
     @GetMapping(path = "/order/produk/{id}")
    public List<ResponseTemplate>getPembayaranWithOrderkById(@PathVariable("id") Long id) {
        return pembayaranService.getPembayaranWithOrderkById(id);
    }
    
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deletePembayaran(@PathVariable("id") Long id) {
        boolean deleted = pembayaranService.deletePembayaran(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
    @PutMapping(path = "{id}")
    public void updatePembayaran(@PathVariable("id") Long id,
                                 @RequestParam(required = false) String mode_pembayaran,
                                 @RequestParam(required = false) Integer ref_number,
                                 @RequestParam(required = false) String tgl_bayar,
                                 @RequestParam(required = false) String status,
                                 @RequestParam(required = false) Double total) {
        pembayaranService.update(id, mode_pembayaran, ref_number, tgl_bayar, status, total);
    }
    
}
