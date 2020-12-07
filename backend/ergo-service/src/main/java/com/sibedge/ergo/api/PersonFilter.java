package com.sibedge.ergo.api;

import java.time.LocalDate;

import com.sibedge.ergo.shared.api.constraint.PersonalId;
import com.sibedge.ergo.shared.type.Gender;
import com.sibedge.ergo.util.Constants;
import com.sibedge.ergo.shared.api.constraint.ClosedDatePeriod;
import com.sibedge.ergo.shared.api.constraint.DateOfBirth;
import com.sibedge.ergo.shared.api.constraint.FirstName;
import com.sibedge.ergo.shared.api.constraint.LastName;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ClosedDatePeriod(start = "fromDateOfBirth", end = "toDateOfBirth")
public class PersonFilter {

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
