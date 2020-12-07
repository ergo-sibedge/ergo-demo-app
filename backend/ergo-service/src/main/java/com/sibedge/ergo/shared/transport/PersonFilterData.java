package com.sibedge.ergo.shared.transport;

import java.time.LocalDate;

import com.sibedge.ergo.constraint.ClosedDatePeriod;
import com.sibedge.ergo.constraint.DateOfBirth;
import com.sibedge.ergo.constraint.FirstName;
import com.sibedge.ergo.constraint.LastName;
import com.sibedge.ergo.constraint.PersonalId;
import com.sibedge.ergo.shared.data.Gender;
import com.sibedge.ergo.util.Constants;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Describes a form filter representation with criteria.
 */
@Data
@ClosedDatePeriod(start = "fromDateOfBirth", end = "toDateOfBirth")
public class PersonFilterData {

    @PersonalId
    private String personalId;

    @FirstName
    private String firstName;

    @LastName
    private String lastName;

    private Gender gender;

    @DateOfBirth
    @DateTimeFormat(pattern = Constants.DATE_FORMAT_PATTERN)
    private LocalDate fromDateOfBirth;

    @DateOfBirth
    @DateTimeFormat(pattern = Constants.DATE_FORMAT_PATTERN)
    private LocalDate toDateOfBirth;
}
