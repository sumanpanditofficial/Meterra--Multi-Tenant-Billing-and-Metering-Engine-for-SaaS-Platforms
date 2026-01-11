package com.billing_engine.BillingApplication.repository;

import com.billing_engine.BillingApplication.model.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
