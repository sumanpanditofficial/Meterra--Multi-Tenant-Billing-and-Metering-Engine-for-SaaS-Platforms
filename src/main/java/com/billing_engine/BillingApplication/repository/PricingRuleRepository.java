package com.billing_engine.BillingApplication.repository;

import com.billing_engine.BillingApplication.model.entity.PricingRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricingRuleRepository extends JpaRepository<PricingRule, Long> {

        PricingRule findByTenantIdAndActiveTrue(Long tenantId, String pricingType);

}
