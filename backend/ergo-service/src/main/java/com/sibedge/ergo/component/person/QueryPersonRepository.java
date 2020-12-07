package com.sibedge.ergo.component.person;

import com.sibedge.ergo.component.person.domain.Person;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

;

@org.springframework.stereotype.Repository
@Transactional(readOnly = true)
interface QueryPersonRepository extends Repository<Person, Long>, QuerydslPredicateExecutor<Person> {
}
