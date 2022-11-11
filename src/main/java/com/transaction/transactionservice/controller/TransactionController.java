
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

   /* public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }*/
    /*List of total transaction*/
    @GetMapping("accounts/{accountId}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable String accountId, @RequestParam(defaultValue = "0") Integer page,
                                                                @RequestParam(defaultValue = "10") Integer pageSize) {
        List<TransactionDto> transactionDtoResponse = transactionService.getTransactions();
        return new ResponseEntity<List<TransactionDto>>(transactionDtoResponse, HttpStatus.OK);
    }

    /*List of transaction using transaction ID*/
    @GetMapping("accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<TransactionDto> getTransactionDetails(@PathVariable String accountId, @PathVariable String transactionId) {
        TransactionDto transactionDtoResponse = transactionService.getTransactionById(transactionId);
        return new ResponseEntity<TransactionDto>(transactionDtoResponse, HttpStatus.OK);
    }

    /*delete transaction based on transaction id*/
    @DeleteMapping("accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable String accountId,@PathVariable String transactionId) {
        String result = transactionService.deleteTransaction(transactionId);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    /*create transaction*/
    @PostMapping("accounts/{accountId}/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable String accountId, @RequestBody TransactionDto transactionDto) {
        System.out.println("-----create Transaction 1-----");
        TransactionDto transactionDtoResponse = transactionService.createTransaction(transactionDto);
        System.out.println("-----create Transaction 2-----");
        return new ResponseEntity<TransactionDto>(transactionDtoResponse, HttpStatus.OK);
    }
}