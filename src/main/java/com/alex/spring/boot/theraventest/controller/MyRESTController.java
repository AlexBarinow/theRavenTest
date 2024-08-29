package com.alex.spring.boot.theraventest.controller;


import com.alex.spring.boot.theraventest.entity.Customer;
import com.alex.spring.boot.theraventest.entity.CustomerDTO;
import com.alex.spring.boot.theraventest.entity.CustomerDTOEntry;
import com.alex.spring.boot.theraventest.exceptionHanding.NoSuchCustomerException;
import com.alex.spring.boot.theraventest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class MyRESTController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/customers")
    public List<CustomerDTO> getCustomers() {
        return customerService.getAllCustomersDTO();
    }


    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {

        CustomerDTO customerDTO = customerService.getCustomerByIdDTO(id);

        if (customerDTO == null || !customerService.getCustomerById(id).isIs_active()) {
            throw new NoSuchCustomerException("Customer with id " + id + " not found or marked as inactive");
        }

        return customerDTO;
    }


    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTOEntry customerDTOEntry) {


        Customer customer = customerDTOEntry.convertToCustomer();
        customerService.saveCustomer(customer);
        CustomerDTO customerDTO = new CustomerDTO().CustomerToCustomerDTO(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO);


    }



    @PutMapping("/customers")
    public CustomerDTO updateCustomers(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.getCustomerById(customerDTO.getId());

        customer.setUpdated(System.currentTimeMillis());
        //customer.setEmail(customerDTO.getEmail());  according to the requirements of the task email should not be editable
        customer.setPhone(customerDTO.getPhone());
        customer.setName(customerDTO.getName());

        customerService.saveCustomer(customer);

        CustomerDTO customerDTO1 = new CustomerDTO().CustomerToCustomerDTO(customer);
        return customerDTO1;


    }


    @DeleteMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        customer.setIs_active(false);
        customerService.saveCustomer(customer);

        return ResponseEntity.ok(new CustomerDTO().CustomerToCustomerDTO(customer));
    }

}
