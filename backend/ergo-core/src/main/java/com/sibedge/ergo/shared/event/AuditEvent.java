package com.sibedge.ergo.shared.event;

import java.time.LocalDateTime;

import lombok.Value;

/**
 * Describes a system audit event.
 */
@Value(staticConstructor = "of")
public class AuditEvent implements Event {
    String key;
    String payload;
    LocalDateTime timestemp;
}
