package com.cemal.purchase_order_menagement.service;

import com.cemal.purchase_order_menagement.entity.Customer;
import com.cemal.purchase_order_menagement.entity.Order;
import com.cemal.purchase_order_menagement.repository.ICustomerRepo;
import com.cemal.purchase_order_menagement.repository.IOrderRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements  IOrderService {
    private final IOrderRepo orderRepo;
    private final ICustomerRepo customerRepo;

    public OrderServiceImpl(IOrderRepo orderRepo, ICustomerRepo customerRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    @Transactional
    public Order saveOrder(Long id, Order order) {
        order.setCustomer_id(order.getCustomer_id());
        order.setOrderName(order.getOrderName());
        Customer customer1=customerRepo.getOne(order.getCustomer_id().getId());
        if(customer1.getOrderAuthority().equals("HAS")){
            return orderRepo.save(order);
        }
            return null;
    }

    @Override
    public Order updateCustomer(Long id, Order order) {
        Order order1=orderRepo.getOne(order.getId());
        order1.setCustomer_id(order.getCustomer_id());
        order1.setOrderName(order.getOrderName());
        Customer customer1=customerRepo.getOne(order.getCustomer_id().getId());
        if(customer1.getOrderAuthority().equals("HAS")){
            return orderRepo.save(order1);
        }
        return null;
    }

    @Override
    public Boolean deleteCustomer(Long id) {

        orderRepo.deleteById(id);
        Optional<Order> getOrder= orderRepo.findById(id);
        if (!getOrder.isPresent()) {
            return false;
        }
        return true;
    }

    @Override
    public List<Order> getAllOrder() {

        return orderRepo.findAll();
    }
}
