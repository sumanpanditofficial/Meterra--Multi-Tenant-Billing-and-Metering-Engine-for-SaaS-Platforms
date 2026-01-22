package com.billing_engine.BillingApplication.service;

import com.billing_engine.BillingApplication.model.entity.PricingRule;
import com.billing_engine.BillingApplication.repository.PricingRuleRepository;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class PricingEngineService {
    private final PricingRuleRepository pricingRuleRepository;
    private final ObjectMapper objectMapper;

    PricingEngineService(PricingRuleRepository pricingRuleRepository, ObjectMapper objectMapper){
        this.pricingRuleRepository = pricingRuleRepository;
        this.objectMapper = objectMapper;
    }

    public BigDecimal calculateCost(Long tenantId, String pricingType, Long units){

        PricingRule rule = pricingRuleRepository.findByTenantIdAndPricingTypeAndActiveTrue(tenantId, pricingType);
        if(rule==null){
            throw new IllegalArgumentException("Tenant Id with: "+tenantId+" .There is no active pricing rule for this tenant");
        }

        Map<String, Object> config;

        try {
            config = objectMapper.readValue(rule.getConfigJson(),
                    new TypeReference<Map<String, Object>>() {
                    }
            );
        }
        catch (Exception e){
            throw new RuntimeException("Invalid pricing config json type",e );
        }

        BigDecimal total = BigDecimal.ZERO;

        if(config.containsKey("ratePerUnit")){
            BigDecimal rate = new BigDecimal(config.get("ratePerUnit").toString());
            total = rate.multiply(BigDecimal.valueOf(units));
        }

        if(config.containsKey("baseCharge")){
            BigDecimal base = new BigDecimal(config.get("baseCharge").toString());
            total = total.add(base);
        }

        return total;



    }


}
