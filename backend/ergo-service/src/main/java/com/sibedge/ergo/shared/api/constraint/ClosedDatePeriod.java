package com.sibedge.ergo.shared.api.constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ClosedDatePeriodValidator.class)
public @interface ClosedDatePeriod {

    /**
     * An attribute name of the lower end of period.
     *
     * @return attribute name
     */
    String start();

    /**
     * An attribute name of the upper end of period.
     *
     * @return attribute name
     */
    String end();

    String message() default "{com.sibedge.ergo.validator.costraints.ClosedDatePeriod.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
