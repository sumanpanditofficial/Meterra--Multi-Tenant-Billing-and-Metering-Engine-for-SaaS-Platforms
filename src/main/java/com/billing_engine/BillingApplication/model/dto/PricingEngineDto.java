package com.billing_engine.BillingApplication.model.dto;

import lombok.Data;

@Data
public class PricingEngineDto {
    Long tenantId;
    String pricingType;
    Long units;
}
