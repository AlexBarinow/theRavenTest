package com.alex.spring.boot.theraventest.dao;

import com.alex.spring.boot.theraventest.entity.Customer;
import com.alex.spring.boot.theraventest.entity.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT new com.alex.spring.boot.theraventest.entity.CustomerDTO(c.id, c.name, c.email, c.phone) FROM Customer c WHERE c.id = :id")
    CustomerDTO findCustomerById(Long id);

    @Query("SELECT c FROM Customer c WHERE c.id = :id")
    Customer findCustomerByIdFull(@Param("id") Long id);

    @Query("SELECT new com.alex.spring.boot.theraventest.entity.CustomerDTO(c.id, c.name, c.email, c.phone) FROM Customer c")
    List<CustomerDTO> findAllCustomers();

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email = :email")
    boolean existsByEmail(@Param("email") String email);


    @Query("SELECT new com.alex.spring.boot.theraventest.entity.CustomerDTO(c.id, c.name, c.email, c.phone) FROM Customer c WHERE c.is_active = true")
    List<CustomerDTO> findAllActiveCustomers();



}
