package com.billing_engine.BillingApplication.model.dto;

import com.billing_engine.BillingApplication.model.entity.Tenant;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsageEventDTO {
    private long tenantId;
    private String eventType;
    private long units;
    private  String idempotencyKey;
}
