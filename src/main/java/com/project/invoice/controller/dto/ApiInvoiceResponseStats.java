package com.project.invoice.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public final class ApiInvoiceResponseStats {

    private long totalCount;
    private BigDecimal invoiceTotalAmount;
}
