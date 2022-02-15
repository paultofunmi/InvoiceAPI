package com.project.invoice.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query(value = "SELECT COUNT(*) FROM invoices", nativeQuery = true)
    long count();

    @Query(value = "SELECT COALESCE(SUM(total), 0) FROM invoices", nativeQuery = true)
    BigDecimal totalInvoiceAmount();
}
