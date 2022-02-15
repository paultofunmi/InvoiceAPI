package com.project.invoice.persistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "invoices")
public class Invoice {

    private static final String COL_ID = "id";
    private static final String COL_INVOICE_ID = "invoice_id";
    private static final String COL_TAX = "tax";
    private static final String COL_SUB_TOTAL = "sub_total";
    private static final String COL_TOTAL = "total";
    private static final String COL_CREATION_DATETIME = "creation_datetime";
    private static final String COL_DUE_DATE = "due_date";
    private static final String COL_UPDATE_DATETIME = "update_datetime";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COL_ID)
    private Long id;

    @Column(name = COL_INVOICE_ID, nullable = false)
    private String invoiceNumber;

    @Column(name = COL_DUE_DATE, nullable = false)
    private LocalDateTime dueDate;

    @Column(name = COL_TAX)
    private BigDecimal tax;

    @Column(name = COL_SUB_TOTAL, nullable = false)
    private BigDecimal subTotal;

    @Column(name = COL_TOTAL, nullable = false)
    private BigDecimal total;

    @Column(name = COL_CREATION_DATETIME, nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @Column(name = COL_UPDATE_DATETIME)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
