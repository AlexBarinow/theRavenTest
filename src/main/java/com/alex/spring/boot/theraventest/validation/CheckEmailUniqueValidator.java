package com.alex.spring.boot.theraventest.validation;

import com.alex.spring.boot.theraventest.dao.CustomerRepository;
import com.alex.spring.boot.theraventest.service.CustomerService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckEmailUniqueValidator implements ConstraintValidator<CheckEmailUnique, String> {

    private String email;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void initialize(CheckEmailUnique checkEmailUnique) {
        ConstraintValidator.super.initialize(checkEmailUnique);
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

       return !customerRepository.existsByEmail(value);

    }


}
