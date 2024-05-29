/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andre.OrderService.Controller;

import com.andre.OrderService.entity.Order;
import com.andre.OrderService.service.OrderService;
import com.andre.OrderService.vo.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author andreferdinan
 */
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping(path = "{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }
    
    @GetMapping(path = "/produk/{id}")
    public List<ResponseTemplate> getOrderWithProdukById(@PathVariable("id") Long id) {
        return orderService.getOrderWithProdukById(id);
    }
    
    @PutMapping(path = "{id}")
    public void updateOrder(@PathVariable ("id") Long id,
            @RequestParam(required = false) int jumlah,
            @RequestParam(required = false) String tangggal,
            @RequestParam(required = false) String status
            
            
    ){
        orderService.update(id, jumlah, tangggal, status);
    }
    
    @PostMapping
    public void insertOrder(@RequestBody Order order) {
        orderService.insert(order);
    }
    
    @DeleteMapping(path = "{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteorder(id);
    }
}
