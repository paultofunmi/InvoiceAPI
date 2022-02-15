package com.project.invoice.controller.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public final class ApiInvoiceItem {

    private BigDecimal amount;
    private BigDecimal quantity;
}
