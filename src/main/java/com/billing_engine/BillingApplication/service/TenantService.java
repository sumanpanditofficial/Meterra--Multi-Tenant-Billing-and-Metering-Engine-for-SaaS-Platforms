package com.billing_engine.BillingApplication.service;

import com.billing_engine.BillingApplication.model.dto.TenantDTO;
import com.billing_engine.BillingApplication.model.entity.Tenant;
import com.billing_engine.BillingApplication.model.entity.TenantApiKeys;
import com.billing_engine.BillingApplication.repository.TenantApiKeyRepository;
import com.billing_engine.BillingApplication.repository.TenantRepository;
import org.hibernate.annotations.TargetEmbeddable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final TenantApiKeyRepository tenantApiKeyRepository;

    public TenantService(TenantRepository tenantRepository, TenantApiKeyRepository tenantApiKeyRepository) {
        this.tenantRepository = tenantRepository;
        this.tenantApiKeyRepository = tenantApiKeyRepository;
    }


    public Tenant CreateTenant(TenantDTO dto) {
        Tenant tenant = new Tenant();
        tenant.setName(dto.getName());
        tenant.setCurrency(dto.getCurrency());
        tenant.setTimezone(dto.getTimeZone());
        tenant.setBilling_day(dto.getBillingDay());
        tenantRepository.save(tenant);

        String apiKey = UUID.randomUUID().toString();
        TenantApiKeys tenantApiKeys = new TenantApiKeys();
        tenantApiKeys.setTenant(tenant);
        tenantApiKeys.setApi_key_hash(apiKey);
        tenantApiKeyRepository.save(tenantApiKeys);

        System.out.println("Generated api key: " + apiKey);
        return tenant;
    }

    public Tenant GiveTenant(long id){
         return tenantRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Tenant now found with this id: "+ id +" not found"));

    }


}
