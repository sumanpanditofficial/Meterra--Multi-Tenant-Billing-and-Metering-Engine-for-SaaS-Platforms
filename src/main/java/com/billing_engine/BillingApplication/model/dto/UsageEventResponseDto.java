package com.billing_engine.BillingApplication.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsageEventResponseDto {
    private long id;
    private LocalDateTime createdAt;
    private String status;
}
