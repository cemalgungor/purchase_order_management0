package com.cemal.purchase_order_menagement.controller;



import com.cemal.purchase_order_menagement.entity.Order;
import com.cemal.purchase_order_menagement.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/addOrder")
    public ResponseEntity<List<Order>> getAllOrder(){
        List<Order> order = orderService.getAllOrder();
        return ResponseEntity.ok(order);
    }
    @PostMapping("/addOrder/{customer_id}")
    public  ResponseEntity<Order> addOrder(@PathVariable(value = "customer_id", required = true) Long id, @PathVariable(value = "order", required = true) Order order){
        Order order1=orderService.saveOrder(id,order);
             return ResponseEntity.ok(order1);
    }
}
