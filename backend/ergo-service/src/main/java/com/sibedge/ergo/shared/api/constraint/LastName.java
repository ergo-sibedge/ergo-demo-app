package com.sibedge.ergo.shared.api.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 */
@Size(min = 2, max = 100)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { })
@Documented
public @interface LastName {
    String message() default "{com.sibedge.ergo.validator.costraints.PersonLastName.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
