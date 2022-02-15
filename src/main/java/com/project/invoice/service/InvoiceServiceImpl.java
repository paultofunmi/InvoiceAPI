package com.project.invoice.service;


import com.project.invoice.controller.dto.ApiInvoiceItem;
import com.project.invoice.controller.dto.ApiInvoiceRequest;
import com.project.invoice.controller.dto.ApiInvoiceResponseStats;
import com.project.invoice.persistence.Invoice;
import com.project.invoice.persistence.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static final BigDecimal SALES_TAX = BigDecimal.valueOf(0.30);

    private final InvoiceRepository invoiceRepository;

    public ApiInvoiceResponseStats getInvoices() {

        return ApiInvoiceResponseStats.builder()
                .invoiceTotalAmount(invoiceRepository.totalInvoiceAmount())
                .totalCount(invoiceRepository.count())
                .build();
    }

    @Transactional
    public Invoice createInvoices(final ApiInvoiceRequest invoiceRequest) {

        validRequest(invoiceRequest);
        BigDecimal subTotal = BigDecimal.ZERO;
        for(ApiInvoiceItem item : invoiceRequest.getItems()) {

            subTotal = subTotal.add(item.getAmount().multiply(item.getQuantity()));
        }

        final BigDecimal tax = subTotal.multiply(SALES_TAX);
        final BigDecimal total = subTotal.add(tax);
        final LocalDateTime dueDate = LocalDate.now().atStartOfDay().plusDays(invoiceRequest.getDueDate());

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(UUID.randomUUID().toString());
        invoice.setDueDate(dueDate);
        invoice.setSubTotal(subTotal);
        invoice.setTax(tax);
        invoice.setTotal(total);

        return invoiceRepository.save(invoice);
    }

    private void validRequest(final ApiInvoiceRequest invoiceRequest) {

        if(invoiceRequest.getItems() == null && invoiceRequest.getItems().size() == 0)  {

            throw new RuntimeException("Invoice Items cannot be empty");
        }
    }

}
