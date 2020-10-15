package com.cemal.purchase_order_menagement.service;

import com.cemal.purchase_order_menagement.entity.Order;

import java.util.List;

public interface IOrderService {
    Order saveOrder(Long customer_id,Order order);
    Order updateCustomer(Long customer_id,Order order);
    Boolean deleteCustomer(Long id);
    List<Order> getAllOrder();
}
