package com.billing_engine.BillingApplication.repository;

import com.billing_engine.BillingApplication.model.entity.UsageEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageEventRepository extends JpaRepository<UsageEvent, Long>{

    boolean existsByTenantIdAndIdempotencyKey(long TenantId, String idempotencyKey);
}
