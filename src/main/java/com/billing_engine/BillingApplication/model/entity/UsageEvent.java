package com.billing_engine.BillingApplication.model.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="usage_events")
public class UsageEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tenant_id", nullable = false, foreignKey = @ForeignKey(name = "fk_usage_events_tenant"))
    private Tenant tenant;

    @Column(name = "event_type", nullable = false, length = 50)
    private String eventType;

    @Column(name = "units", nullable = false)
    private long units;

    @Column(name = "event_timestamp", nullable = false)
    private LocalDateTime eventTimestamp;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "idempotency_key", nullable = false, length = 100)
    private String idempotencyKey;


}
