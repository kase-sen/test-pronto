package com.pronto.library.entity;

import config.EntityAuditListener;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * The type Auditable base entity.
 */
@EntityListeners(EntityAuditListener.class)
@NoArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
public abstract class AuditableBaseEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 50, nullable = false, unique = true)
    private String displayId;
    @CreatedDate
    private OffsetDateTime createdTs;
    @LastModifiedDate
    private OffsetDateTime modifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;

    /**
     * Initialize display id.
     */
    @PrePersist
    public void initializeDisplayId() {
        if (displayId == null) {
            displayId = UUID.randomUUID().toString();
        }
    }
}
