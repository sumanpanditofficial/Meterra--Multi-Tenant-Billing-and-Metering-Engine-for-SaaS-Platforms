package com.billing_engine.BillingApplication.service;

import com.billing_engine.BillingApplication.model.dto.PricingRuleDTO;
import com.billing_engine.BillingApplication.model.entity.PricingRule;
import com.billing_engine.BillingApplication.model.entity.Tenant;
import com.billing_engine.BillingApplication.repository.PricingRuleRepository;
import com.billing_engine.BillingApplication.repository.TenantRepository;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class PricingRuleService {

    private final PricingRuleRepository pricingRuleRepository;
    private final ObjectMapper objectMapper;
    private final TenantRepository tenantRepository;

    PricingRuleService(PricingRuleRepository pricingRuleRepository,TenantRepository tenantRepository, ObjectMapper objectMapper){
        this.pricingRuleRepository = pricingRuleRepository;
        this.objectMapper = objectMapper;
        this.tenantRepository = tenantRepository;
    }



    public PricingRule createRule(PricingRuleDTO pricingRuleDTO){
        PricingRule pricingRule = new PricingRule();
        Tenant tenant = tenantRepository.findById(pricingRuleDTO.getTenantId())
                .orElseThrow(()-> new IllegalArgumentException("No Tenants exist with this "+pricingRuleDTO.getTenantId()+" Id"));

        pricingRule.setTenant(tenant);
        pricingRule.setPricingType(pricingRuleDTO.getPricingType());
        pricingRule.setConfigJson(
                objectMapper.writeValueAsString(pricingRuleDTO.getConfigJson())
        );

        return pricingRuleRepository.save(pricingRule);

    }



}
