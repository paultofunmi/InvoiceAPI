package com.project.invoice.controller.converters;

import com.project.invoice.controller.dto.ApiInvoiceResponse;
import com.project.invoice.persistence.Invoice;

public final class InvoiceConverter {

    public static ApiInvoiceResponse invoiceToInvoiceResponse(final Invoice invoice) {

        return ApiInvoiceResponse.builder()
                .invoiceNumber(invoice.getInvoiceNumber())
                .subTotal(invoice.getSubTotal())
                .tax(invoice.getTax())
                .dueDate(invoice.getDueDate())
                .total(invoice.getTotal())
                .creationDateTime(invoice.getCreationDateTime())
                .build();
    }
}
