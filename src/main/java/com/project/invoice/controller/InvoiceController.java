package com.project.invoice.controller;

import com.project.invoice.controller.converters.InvoiceConverter;
import com.project.invoice.controller.dto.ApiInvoiceRequest;
import com.project.invoice.controller.dto.ApiInvoiceResponse;
import com.project.invoice.controller.dto.ApiInvoiceResponseStats;
import com.project.invoice.service.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(value="Simple Invoice API", description="Operations pertaining to invoices")
@RequestMapping("/api/v1")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("invoices")
    @ApiOperation(value = "Get all invoices")
    public ResponseEntity<ApiInvoiceResponseStats> getInvoices() {

        return ResponseEntity.ok(
                invoiceService.getInvoices()
        );
    }

    @PostMapping("invoices")
    @ApiOperation(value = "Create an invoice")
    public ResponseEntity<ApiInvoiceResponse> createInvoice(@RequestBody final ApiInvoiceRequest APIInvoiceRequest) {

        final ApiInvoiceResponse response = InvoiceConverter.invoiceToInvoiceResponse(
                invoiceService.createInvoices(APIInvoiceRequest)
        );

        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
