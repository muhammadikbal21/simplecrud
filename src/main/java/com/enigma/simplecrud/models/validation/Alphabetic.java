package com.enigma.simplecrud.models.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AlphabeticValidator.class)
@Documented
public @interface Alphabetic {

    String message() default "{Alphabetic}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
