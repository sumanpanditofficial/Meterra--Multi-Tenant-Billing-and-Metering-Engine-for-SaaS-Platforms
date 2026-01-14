package com.billing_engine.BillingApplication.controller;

import com.billing_engine.BillingApplication.model.dto.UsageEventDTO;
import com.billing_engine.BillingApplication.model.dto.UsageEventResponseDto;
import com.billing_engine.BillingApplication.model.entity.UsageEvent;
import com.billing_engine.BillingApplication.repository.UsageEventRepository;
import com.billing_engine.BillingApplication.service.UsageEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsageEventController {

    private final UsageEventService usageEventService;

    public UsageEventController(UsageEventService usageEventService){
        this.usageEventService = usageEventService;
    }

    @PostMapping("/sendusage")
    public ResponseEntity<UsageEventResponseDto> setUsage(@RequestBody UsageEventDTO usageEventDTO){
        UsageEventResponseDto response = usageEventService.usageEventCreation(usageEventDTO);
        if(response==null){
            throw new RuntimeException("Usage creation of tenant failed");

        }
        return ResponseEntity.ok(response);
    }
}
