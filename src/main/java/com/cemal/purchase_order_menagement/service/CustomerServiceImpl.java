package com.cemal.purchase_order_menagement.service;

import com.cemal.purchase_order_menagement.entity.Customer;
import com.cemal.purchase_order_menagement.entity.OrderAuthority;
import com.cemal.purchase_order_menagement.entity.Product;
import com.cemal.purchase_order_menagement.repository.ICustomerRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  ICustomerService {
    private final ICustomerRepo customerRepo;

    public CustomerServiceImpl(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        customer.setName(customer.getName());
        customer.setOrder_id(customer.getOrder_id());
        if(customer.getOrderAuthority().equals(OrderAuthority.HAS)) {
            customer.setOrderAuthority(OrderAuthority.HAS);
        }
        customer.setOrderAuthority(OrderAuthority.HAS_NOT);

        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customer1=customerRepo.getOne(customer.getId());
        customer.setOrder_id(customer.getOrder_id());
        customer1.setName(customer.getName());
        customer1.setId(customer.getId());
        customer.setOrderAuthority(customer.getOrderAuthority());
        return null;
    }

    @Override
    public Boolean deleteCustomer(Long id) {

        customerRepo.deleteById(id);
        Optional<Customer> getCustomer= customerRepo.findById(id);
        if (!getCustomer.isPresent()) {
            return false;
        }
        return true;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }
}
