/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andre.pembayaran.service;
import com.andre.pembayaran.entity.Pembayaran;
import com.andre.pembayaran.repository.PembayaranRepository;
import com.andre.pembayaran.vo.Order;
import com.andre.pembayaran.vo.Produk;
import com.andre.pembayaran.vo.ResponseTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author andreferdinan
 */
@Service
public class PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;
     @Autowired
    private RestTemplate restTemplate;
    
    public List<Pembayaran> getAll() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran getPembayaran(Long id){
        return pembayaranRepository.findById(id).get();
    }
    
    @Transactional
    public void insert(Pembayaran pembayaran){
        pembayaranRepository.save(pembayaran);
    }
    public Pembayaran getPembayaranById(Long id) {
        return pembayaranRepository.findById(id).get();
    }
    
     public List<ResponseTemplate> getPembayaranWithOrderkById(Long id){
        List<ResponseTemplate> responseList = new ArrayList<>();
        Pembayaran pembayaran = getPembayaranById(id);
         Order order = restTemplate.getForObject("http://localhost:9002/api/v1/order/" 
                + pembayaran.getOrder_Id(), Order.class);  
        Produk produk = restTemplate.getForObject("http://localhost:9001/api/v1/produk/"
                + pembayaran.getOrder_Id(),Produk.class);
        ResponseTemplate vo = new ResponseTemplate();
        vo.setOrder(order);
        vo.setProduk(produk);
        vo.setPembayaran(pembayaran);
        responseList.add(vo);
        return responseList;
    }
   
    public boolean deletePembayaran(Long id) {
        if (pembayaranRepository.existsById(id)) {
            pembayaranRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    @Transactional
    public void update(Long pembayaranId, String mode_pembayaran, int ref_number, String tgl_bayar, String status, double total) {
        Pembayaran pembayaran = pembayaranRepository.findById(pembayaranId)
                .orElseThrow(() -> new IllegalStateException("pembayaran tidak ada"));
        if (mode_pembayaran != null && !mode_pembayaran.isEmpty()) {
            pembayaran.setMode_pembayaran(mode_pembayaran);
        }
        if (ref_number > 0 && !Objects.equals(pembayaran.getRef_number(), ref_number)) {
            pembayaran.setRef_number(ref_number);
        }
        if (tgl_bayar != null && !tgl_bayar.isEmpty() && !Objects.equals(pembayaran.getTgl_pembayaran(), tgl_bayar)) {
            pembayaran.setTgl_pembayaran(tgl_bayar);
        }
        if (status != null && !status.isEmpty() && !Objects.equals(pembayaran.getStatus(), status)) {
            pembayaran.setStatus(status);
        }
        if (total > 0) {
            pembayaran.setTotal(total);
        }
    }
}
