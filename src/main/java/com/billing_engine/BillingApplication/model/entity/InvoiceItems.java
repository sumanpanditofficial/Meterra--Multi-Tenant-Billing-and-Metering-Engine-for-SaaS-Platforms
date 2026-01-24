package com.billing_engine.BillingApplication.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "invoice_items")
public class InvoiceItems {
}
