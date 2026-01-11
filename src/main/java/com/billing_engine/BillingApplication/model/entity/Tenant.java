package com.billing_engine.BillingApplication.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false)
    private String timezone;

    @Column(nullable = false)
    private Integer billing_day;

    @Column(nullable = false)
    private String status = "Active";

    @Column(nullable = false)
    private LocalDateTime created_at = LocalDateTime.now();

}
