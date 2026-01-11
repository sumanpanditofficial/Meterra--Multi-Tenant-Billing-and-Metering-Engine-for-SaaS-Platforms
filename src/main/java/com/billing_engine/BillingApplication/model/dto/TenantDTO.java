package com.billing_engine.BillingApplication.model.dto;

import lombok.Data;

@Data
public class TenantDTO {
    private String name;
    private String currency;
    private String timeZone;
    private int billingDay;
}
