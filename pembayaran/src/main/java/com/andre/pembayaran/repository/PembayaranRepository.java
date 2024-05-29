/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andre.pembayaran.repository;

import com.andre.pembayaran.entity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andreferdinan
 */
@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Long> {
}
