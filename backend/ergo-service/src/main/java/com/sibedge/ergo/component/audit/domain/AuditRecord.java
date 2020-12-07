package com.sibedge.ergo.component.audit.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sibedge.ergo.shared.type.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Persistent view for an audit record.
 */
@Getter
@Setter
@Entity
@Table(name = "audit_event")
@NoArgsConstructor
@AllArgsConstructor(staticName = "unregistered")
public class AuditRecord extends BaseEntity {

    @NotNull
    @Size(min = 1, max = 20)
    private String key;

    @NotNull
    @Size(min = 1, max = 1000)
    private String details;

}

