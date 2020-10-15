package com.cemal.purchase_order_menagement.controller;

import com.cemal.purchase_order_menagement.entity.Customer;
import com.cemal.purchase_order_menagement.entity.Product;
import com.cemal.purchase_order_menagement.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllTasks() {
        List<Product> product = productService.getAllProduct();
        return ResponseEntity.ok(product);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addCustomer(@Validated @RequestBody Product product) {
        Product product1 = productService.saveProduct(product);
        return ResponseEntity.ok(product1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean>  deleteProduct(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(productService.deleteProduct(id));
    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@Validated   @RequestBody Product product)
            {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

}
