package com.billing_engine.BillingApplication.repository;

import com.billing_engine.BillingApplication.model.entity.TenantApiKeys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantApiKeyRepository extends JpaRepository<TenantApiKeys, Long> {
}
