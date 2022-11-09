
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

    /*delete transaction based on transaction id*/
    @DeleteMapping("accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable String accountId,@PathVariable String transactionId) {
        String result = transactionService.deleteTransaction(transactionId);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}