/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.andre.OrderService.repository;

import com.andre.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author andreferdinan
 */
@Repository 
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
