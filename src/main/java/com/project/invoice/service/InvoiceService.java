package com.project.invoice.service;

import com.project.invoice.controller.dto.ApiInvoiceRequest;
import com.project.invoice.controller.dto.ApiInvoiceResponseStats;
import com.project.invoice.persistence.Invoice;

public interface InvoiceService {

    ApiInvoiceResponseStats getInvoices();

    Invoice createInvoices(final ApiInvoiceRequest invoice);

}
