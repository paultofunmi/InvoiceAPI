package com.project.invoice.controller.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public final class ApiInvoiceResponse {

    private String invoiceNumber;

    private LocalDateTime dueDate;

    private BigDecimal tax;

    private BigDecimal subTotal;

    private BigDecimal total;

    private LocalDateTime creationDateTime;
}
