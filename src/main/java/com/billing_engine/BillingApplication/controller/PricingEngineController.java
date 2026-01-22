package com.billing_engine.BillingApplication.controller;

import com.billing_engine.BillingApplication.model.dto.PricingEngineDto;
import com.billing_engine.BillingApplication.service.PricingEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PricingEngineController {
    private final PricingEngineService pricingEngineService;

    PricingEngineController(PricingEngineService pricingEngineService){
        this.pricingEngineService = pricingEngineService;
    }

    @PostMapping("/calculatecost")
    public BigDecimal calculatingTotalCost(@RequestBody PricingEngineDto pricingEngineDto){
        return pricingEngineService.calculateCost(pricingEngineDto.getTenantId(), pricingEngineDto.getPricingType(), pricingEngineDto.getUnits());
    }


}
