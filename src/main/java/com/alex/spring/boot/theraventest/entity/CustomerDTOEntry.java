package com.alex.spring.boot.theraventest.entity;


import com.alex.spring.boot.theraventest.validation.CheckEmailUnique;
import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class CustomerDTOEntry {


    @Size(min = 2, max = 50)
    private String name;
    @Size(min = 6, max = 14)
    @Pattern(regexp = "^\\+\\d+$", message = "please put the + as the first symbold and rest should be digits")
    private String phone;
    @CheckEmailUnique
    @Email(message = "make sure you've entered an email in an appropriate format")
    @Size(min = 2, max = 100, message = "Should be 2-100 symbols long")
    private String email;


    public CustomerDTOEntry() {

    }

    public CustomerDTOEntry(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerDTOEntry{" +
                "full_name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String full_name) {
        this.name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer convertToCustomer() {
        Customer customer = new Customer();
        Long timeStamp = System.currentTimeMillis();
        customer.setName(this.getName());
        customer.setEmail(this.getEmail());
        customer.setPhone(this.getPhone());
        customer.setCreated(timeStamp);
        customer.setUpdated(timeStamp);
        customer.setIs_active(true);
        return customer;
    }
}
