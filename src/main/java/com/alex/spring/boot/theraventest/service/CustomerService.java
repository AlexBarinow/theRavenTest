package com.alex.spring.boot.theraventest.service;

import com.alex.spring.boot.theraventest.entity.Customer;
import com.alex.spring.boot.theraventest.entity.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<CustomerDTO> getAllCustomersDTO();


    public Customer saveCustomer(Customer customer);

    public CustomerDTO getCustomerByIdDTO(long id);

    void deleteCustomer(long id);

    public Customer getCustomerById(long id);





}
