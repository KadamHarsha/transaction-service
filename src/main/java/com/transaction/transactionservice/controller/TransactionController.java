
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

    /*List of total transaction*/
    @GetMapping("accounts/{accountId}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable String accountId, @RequestParam(defaultValue = "0") Integer page,
                                                                @RequestParam(defaultValue = "10") Integer pageSize) {
        List<TransactionDto> transactionDtoResponse = transactionService.getTransactions();
        return new ResponseEntity<List<TransactionDto>>(transactionDtoResponse, HttpStatus.OK);
    }
}