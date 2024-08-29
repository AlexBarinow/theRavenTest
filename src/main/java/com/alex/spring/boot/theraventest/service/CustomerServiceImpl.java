package com.alex.spring.boot.theraventest.service;

import com.alex.spring.boot.theraventest.dao.CustomerRepository;
import com.alex.spring.boot.theraventest.entity.Customer;
import com.alex.spring.boot.theraventest.entity.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomersDTO() {
        return customerRepository.findAllActiveCustomers();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customerRepository.save(customer);

        return customer;

    }


    @Override
    public CustomerDTO getCustomerByIdDTO(long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Customer getCustomerById(long id) {

        return customerRepository.findCustomerByIdFull(id);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
