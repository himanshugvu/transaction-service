package com.dbs.controller;

import com.dbs.models.request.TransactionRequest;
import com.dbs.models.response.TransactionResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @PostMapping("/transactions")
    public ResponseEntity<?> processTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        TransactionResponse transactionResponse = new TransactionResponse();
        BeanUtils.copyProperties(transactionRequest,transactionResponse);
        transactionResponse.setTransactionId(UUID.randomUUID().toString());
        return ResponseEntity.ok(transactionResponse);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Service is healthy");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}

