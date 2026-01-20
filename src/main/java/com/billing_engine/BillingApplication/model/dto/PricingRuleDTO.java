package com.billing_engine.BillingApplication.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class PricingRuleDTO {
    private Long tenantId;
    private String pricingType;
    private Map<String, Object> configJson;
}
