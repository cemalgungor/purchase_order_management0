package com.cemal.purchase_order_menagement.service;

import com.cemal.purchase_order_menagement.Dto.OrderDto;
import com.cemal.purchase_order_menagement.entity.Customer;
import com.cemal.purchase_order_menagement.entity.Order;
import com.cemal.purchase_order_menagement.repository.ICustomerRepo;
import com.cemal.purchase_order_menagement.repository.IOrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements  IOrderService {
    private final IOrderRepo orderRepo;
    private final CustomerServiceImpl customerService;

    public OrderServiceImpl(IOrderRepo orderRepo, ICustomerRepo customerRepo, CustomerServiceImpl customerService) {
        this.orderRepo = orderRepo;
        this.customerService = customerService;

    }

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        Customer customer1=customerService.getOneCustomer(order.getCustomer_id().getId());
        order.setCustomer_id(order.getCustomer_id());
        order.setOrderName(order.getOrderName());
        order.setCustomer_id(customer1);
        order.getCustomer_id().setName(customer1.getName());
        order.setCustomer_id(customer1);
        order.getCustomer_id().setOrderAuthority(customer1.getOrderAuthority());
        return orderRepo.save(order);
    }

    @Override
    public Order updateCustomer(Long id, Order order) {
        Order order1=orderRepo.getOne(order.getId());
        order1.setCustomer_id(order.getCustomer_id());
        order1.setOrderName(order.getOrderName());
        Customer customer1=customerService.getOneCustomer(order.getCustomer_id().getId());
        if(customer1.getOrderAuthority().equals("HAS")){
            return orderRepo.save(order1);
        }
        return null;
    }

    @Override
    public Boolean deleteByOrderId(Long id) {

        orderRepo.deleteById(id);
        if(orderRepo.findById(id).equals(id)) {
            return false;
        }
        return true;
    }

    @Override
    public List<Order> getAllOrder() {

        return orderRepo.findAll();
    }
}
