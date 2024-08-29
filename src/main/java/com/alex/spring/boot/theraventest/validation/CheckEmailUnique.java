package com.alex.spring.boot.theraventest.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailUniqueValidator.class)
public @interface CheckEmailUnique {


    public String message() default "email should be unique";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
