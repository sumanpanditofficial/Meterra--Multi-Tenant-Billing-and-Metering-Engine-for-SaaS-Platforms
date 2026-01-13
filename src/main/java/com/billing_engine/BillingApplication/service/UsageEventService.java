package com.billing_engine.BillingApplication.service;

import com.billing_engine.BillingApplication.model.dto.UsageEventDTO;
import com.billing_engine.BillingApplication.model.entity.UsageEvent;
import com.billing_engine.BillingApplication.repository.UsageEventRepository;
import org.springframework.stereotype.Service;

@Service
public class UsageEventService {
    private final UsageEventRepository usageEventRepository;

    public UsageEventService(UsageEventRepository usageEventRepository){
        this.usageEventRepository = usageEventRepository;
    }

    public void usageEventManagement(UsageEventDTO usageEventDTO){
        UsageEvent usageEvent = new UsageEvent();


    }






}
