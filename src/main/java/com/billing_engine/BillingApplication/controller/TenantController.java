package com.billing_engine.BillingApplication.controller;

import com.billing_engine.BillingApplication.model.dto.TenantDTO;
import com.billing_engine.BillingApplication.model.entity.Tenant;
import com.billing_engine.BillingApplication.service.TenantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService){
        this.tenantService = tenantService;
    }

    @PostMapping("/createtenant")
    public Tenant createTenant(@RequestBody TenantDTO dto){
        return tenantService.CreateTenant(dto);
    }

    @GetMapping("/find/{id}")
    public Tenant returnTenant(@PathVariable long id){
        return tenantService.GiveTenant(id);
    }
}
