package com.billing_engine.BillingApplication.repository;

import com.billing_engine.BillingApplication.model.entity.PricingRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRuleRepository extends JpaRepository<PricingRule, Long> {

        PricingRule findByTenantIdAndPricingTypeAndActiveTrue(Long tenantId, String pricingType);

        Boolean existsByTenantIdAndPricingTypeAndActiveTrue(Long tenantId, String pricingType);
}
