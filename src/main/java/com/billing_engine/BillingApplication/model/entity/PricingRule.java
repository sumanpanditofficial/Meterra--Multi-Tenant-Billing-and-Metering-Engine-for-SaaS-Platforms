package com.billing_engine.BillingApplication.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.repository.cdi.Eager;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pricing_rules")
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pricing_rules"))
    private Tenant tenant;

    @Column(name = "pricing_type", nullable = false, length = 100)
    private String pricingType;

    @Column(name = "config_json", nullable = false, columnDefinition = "TEXT")
    private String configJson;

    @Column(name = "effective_from", nullable = false)
    private LocalDateTime effectiveFrom = LocalDateTime.now();

    @Column(name = "active")
    private boolean active = true;

}
