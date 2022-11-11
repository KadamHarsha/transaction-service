
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

       /*create transaction*/
    @PostMapping("accounts/{accountId}/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable String accountId, @RequestBody TransactionDto transactionDto) {
        System.out.println("-----create Transaction 1-----");
        TransactionDto transactionDtoResponse = transactionService.createTransaction(transactionDto);
        System.out.println("-----create Transaction 2-----");
        return new ResponseEntity<TransactionDto>(transactionDtoResponse, HttpStatus.OK);
    }
}