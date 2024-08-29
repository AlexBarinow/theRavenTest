package com.alex.spring.boot.theraventest.entity;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDTO {

    private Long id;

    @Size(min = 2, max = 50)
    private String name;

    @Size(min = 6, max = 14)
    @Pattern(regexp = "^\\+\\d+$", message = "please put the + as the first symbol and rest should be digits")
    private String phone;

    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public CustomerDTO CustomerToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setName(customer.getName());
        return customerDTO;
    }
}
