package com.project.invoice.controller.dto;

import lombok.Getter;
import java.util.List;

@Getter
public final class ApiInvoiceRequest {

    private int customerId;
    private String invoiceTitle;
    private String currency;
    private int dueDate;

    private List<ApiInvoiceItem> items;
}
