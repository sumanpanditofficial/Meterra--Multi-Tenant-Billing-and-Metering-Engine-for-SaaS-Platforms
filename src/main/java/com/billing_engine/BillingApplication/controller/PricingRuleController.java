package com.billing_engine.BillingApplication.controller;

import com.billing_engine.BillingApplication.model.dto.PricingRuleDTO;
import com.billing_engine.BillingApplication.model.entity.PricingRule;
import com.billing_engine.BillingApplication.service.PricingRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingRuleController {

    private final PricingRuleService pricingRuleService;

    PricingRuleController(PricingRuleService pricingRuleService){
        this.pricingRuleService = pricingRuleService;
    }

    @PostMapping("/createpricingrule")
    public ResponseEntity<PricingRule> createRule(@RequestBody PricingRuleDTO pricingRuleDTO){
        PricingRule rule = pricingRuleService.createRule(pricingRuleDTO);
        if(rule == null){
            throw new IllegalArgumentException("Failed to save the pricing rules");
        }
        return ResponseEntity.ok(rule);
    }

}
