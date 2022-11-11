
package com.transaction.transactionservice.controller;

import com.transaction.transactionservice.dto.TransactionDto;
import com.transaction.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
   @Autowired
    TransactionService transactionService;

    /*List of transaction using transaction ID*/
    @GetMapping("accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<TransactionDto> getTransactionDetails(@PathVariable String accountId, @PathVariable String transactionId) {
        TransactionDto transactionDtoResponse = transactionService.getTransactionById(transactionId);
        return new ResponseEntity<TransactionDto>(transactionDtoResponse, HttpStatus.OK);
}