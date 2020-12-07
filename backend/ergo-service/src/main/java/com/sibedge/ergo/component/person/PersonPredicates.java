package com.sibedge.ergo.component.person;

import java.time.LocalDate;

import com.sibedge.ergo.shared.type.Gender;

import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

import static com.sibedge.ergo.component.person.domain.QPerson.person;

/**
 *
 */
@UtilityClass
class PersonPredicates {

    public Predicate hasPersonalId(String personalId) {
        return personalId != null ? person.personalId.like(personalId) : null;
    }

    public Predicate hasFirstName(String firstName) {
        return firstName != null ? person.firstName.like(firstName) : null;
    }

    public Predicate hasLastName(String lastName) {
        return lastName != null ? person.lastName.like(lastName) : null;
    }

    public Predicate hasGender(Gender gender) {
        return gender != null ? person.gender.eq(gender) : null;
    }

    public Predicate hasDateOfBirthAfrer(LocalDate from) {
        return from != null ? person.dateOfBirth.goe(from) : null;
    }

    public Predicate hasDateOfBirthBefore(LocalDate to) {
        return to != null ? person.dateOfBirth.loe(to) : null;
    }

}
