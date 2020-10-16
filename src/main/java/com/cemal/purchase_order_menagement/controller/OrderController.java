package com.cemal.purchase_order_menagement.controller;



import com.cemal.purchase_order_menagement.Dto.OrderDto;
import com.cemal.purchase_order_menagement.entity.Order;
import com.cemal.purchase_order_menagement.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrder(){
        List<Order> order = orderService.getAllOrder();
        return ResponseEntity.ok(order);
    }
    @PostMapping("/addOrder")
    public  ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order order1=orderService.saveOrder(order);
             return ResponseEntity.ok(order1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(orderService.deleteByOrderId(id));
    }
}
