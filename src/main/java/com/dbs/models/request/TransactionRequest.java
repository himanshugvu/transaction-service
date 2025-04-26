package com.dbs.models.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TransactionRequest {
    @NotNull(message = "Account number is required")
    @Digits(integer = 14, fraction = 0, message = "Account number must contain only digits")
    @Pattern(regexp = "^\\d{13,14}$", message = "Account number must be 13 or 14 digits")
    private String accountNumber;

    @NotNull(message = "Product code is required")
    @Pattern(regexp = "^(010|011|020|021|022|025)$", message = "Product code must be one of: 010, 011, 020, 021, 022, 025")
    private String productCode;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private Double amount;

    @NotNull(message = "Transaction type is required")
    @Pattern(regexp = "^[CD]$", message = "Transaction type must be either 'C' for Credit or 'D' for Debit")
    private String transactionType;
}
