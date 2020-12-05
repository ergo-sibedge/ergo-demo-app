package com.sibedge.ergo.component.audit;

import com.sibedge.ergo.component.audit.domain.AuditRecord;
import com.sibedge.ergo.shared.event.AuditEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Component
@RequiredArgsConstructor
class RegisterAuditEventUserCaseImpl implements RegisterAuditEventUserCase {

    private final AuditRecordRepository auditRecordRepository;

    @Override
    @Transactional
    public void execute(AuditEvent event) {
        var unregisteredEvent = AuditRecord.unregistered(event.getKey(), event.getPayload());
        auditRecordRepository.save(unregisteredEvent);
    }
}
