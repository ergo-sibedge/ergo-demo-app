package com.sibedge.ergo.shared.transport;

import java.time.LocalDate;

import com.sibedge.ergo.shared.type.Gender;

import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
public class PersonData {
    private String personalId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
}
