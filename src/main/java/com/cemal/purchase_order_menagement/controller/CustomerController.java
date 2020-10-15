package com.cemal.purchase_order_menagement.controller;


import com.cemal.purchase_order_menagement.entity.Customer;
import com.cemal.purchase_order_menagement.service.ICustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    private final ICustomerService customerService ;

    public CustomerController(ICustomerService customerService) {

        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllTasks() {
        List<Customer> customer = customerService.getAllCustomer();
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@Validated @RequestBody Customer customer) {
        Customer customer1 = customerService.saveCustomer(customer);
        return ResponseEntity.ok(customer1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean>  deleteCustomer(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@Validated   @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }
}
