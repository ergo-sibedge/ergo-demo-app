package com.sibedge.ergo.component.audit;

import com.sibedge.ergo.component.audit.domain.AuditRecord;
import com.sibedge.ergo.component.person.domain.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AuditRecordRepository extends CrudRepository<AuditRecord, Long> {
}
