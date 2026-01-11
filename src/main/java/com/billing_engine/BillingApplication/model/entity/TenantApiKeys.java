package com.billing_engine.BillingApplication.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tenant_api_keys")
public class TenantApiKeys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name= "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(nullable = false)
    private String api_key_hash;

    @Column(nullable = false)
    private LocalDateTime created_at = LocalDateTime.now();


}
