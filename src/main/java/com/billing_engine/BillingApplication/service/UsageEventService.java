package com.billing_engine.BillingApplication.service;

import com.billing_engine.BillingApplication.model.dto.UsageEventDTO;
import com.billing_engine.BillingApplication.model.dto.UsageEventResponseDto;
import com.billing_engine.BillingApplication.model.entity.Tenant;
import com.billing_engine.BillingApplication.model.entity.UsageEvent;
import com.billing_engine.BillingApplication.repository.TenantRepository;
import com.billing_engine.BillingApplication.repository.UsageEventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsageEventService {
    private final UsageEventRepository usageEventRepository;
    private final TenantRepository tenantRepository;

    public UsageEventService(UsageEventRepository usageEventRepository, TenantRepository tenantRepository){
        this.usageEventRepository = usageEventRepository;
        this.tenantRepository = tenantRepository;
    }

    @Transactional
    public UsageEventResponseDto usageEventCreation(UsageEventDTO usageEventDTO){
        UsageEvent usageEvent = new UsageEvent();
        Tenant tenant = tenantRepository.findById(usageEventDTO.getTenantId())
                .orElseThrow(()-> new IllegalArgumentException("Tenant not found in the database, please enter the correct tenant ID"));

        if(usageEventRepository.existsByTenantIdAndIdempotencyKey(usageEventDTO.getTenantId(), usageEventDTO.getIdempotencyKey())){
            throw new IllegalArgumentException("Duplicate event, This event has already been processed");
        }

        usageEvent.setTenant(tenant);
        usageEvent.setUnits(usageEventDTO.getUnits());
        usageEvent.setEventType(usageEventDTO.getEventType());
        usageEvent.setIdempotencyKey(usageEventDTO.getIdempotencyKey());
        UsageEvent saved = usageEventRepository.save(usageEvent);
        return responseReturn(saved);

    }

    public UsageEventResponseDto responseReturn(UsageEvent saved) {
        UsageEventResponseDto usageEventResponseDto = new UsageEventResponseDto();
        usageEventResponseDto.setId(saved.getId());
        usageEventResponseDto.setCreatedAt(saved.getCreatedAt());
        usageEventResponseDto.setStatus("Saved");
        return usageEventResponseDto;
    }
}
