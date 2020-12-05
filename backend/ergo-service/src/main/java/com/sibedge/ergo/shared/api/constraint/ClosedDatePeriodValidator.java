package com.sibedge.ergo.shared.api.constraint;

import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

/**
 *
 */
@Slf4j
public class ClosedDatePeriodValidator implements ConstraintValidator<ClosedDatePeriod, Object> {
    private String startAttributeName;
    private String endAttributeName;

    @Override
    public void initialize(ClosedDatePeriod constraintAnnotation) {
        startAttributeName = constraintAnnotation.start();
        endAttributeName = constraintAnnotation.end();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
            LocalDate startDate = (LocalDate) beanWrapper.getPropertyValue(startAttributeName);
            LocalDate endDate = (LocalDate) beanWrapper.getPropertyValue(endAttributeName);
            return startDate == null || endDate == null || !startDate.isAfter(endDate);
        } catch (Exception cause) {
            log.warn("Unexpected ", cause);
            return false;
        }
    }

}
