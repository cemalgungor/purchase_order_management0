package com.cemal.purchase_order_menagement.service;

import com.cemal.purchase_order_menagement.entity.Customer;


import java.util.List;

public interface ICustomerService {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Boolean deleteCustomer(Long id);
    Customer getOneCustomer(Long id);
    List<Customer> getAllCustomer();
}
